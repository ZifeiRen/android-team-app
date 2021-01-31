package edu.qc.seclass.glm.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.trello.rxlifecycle2.components.support.RxFragment;

import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.bean.Categories;
import edu.qc.seclass.glm.http.MyObserver;
import edu.qc.seclass.glm.http.RetrofitUtils;
import edu.qc.seclass.glm.http.RxHelper;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ClassificationFragment extends RxFragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private ProductAdapter adapter = new ProductAdapter();

    public static ClassificationFragment newInstance() {
        ClassificationFragment fragment = new ClassificationFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_product, container, false);
        final RecyclerView recyclerView = root.findViewById(R.id.rv_data);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter base, @NonNull View view, int position) {
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                intent.putExtra("id", adapter.getItem(position).getId());
                startActivity(intent);
            }
        });
        adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter a, @NonNull View view, int position) {
                RetrofitUtils.getApiUrl()
                        .classify("class_1", null, adapter.getItem(position).getId().toString(), "delete")
                        .compose(RxHelper.observableIO2Main(ClassificationFragment.this))
                        .subscribe(new MyObserver<String>(getActivity(), true) {
                            @Override
                            public void onSuccess(String demo) {
                                adapter.remove(position);
                            }

                            @Override
                            public void onFailure(Throwable e, String errorMsg) {

                            }
                        });
            }
        });

        return root;
    }


    @Override
    public void onResume() {
        super.onResume();
        RetrofitUtils.getApiUrl()
                .classifyList("class_1", null, "get")
                .compose(RxHelper.observableIO2Main(ClassificationFragment.this))
                .subscribe(new MyObserver<List<Categories>>(getActivity(), true) {
                    @Override
                    public void onSuccess(List<Categories> demo) {
                        if (demo != null) {
                            for (Categories categories : demo) {
                                categories.setCategories_id(categories.getId());
                                categories.setCategories_name(categories.getName());
                            }
                            adapter.setNewData(demo);
                        }
                    }

                    @Override
                    public void onFailure(Throwable e, String errorMsg) {

                    }
                });

    }

    static class ProductAdapter extends BaseQuickAdapter<Categories, BaseViewHolder> {

        public ProductAdapter() {
            super(R.layout.item_product);
            addChildClickViewIds(R.id.tv_add);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder holder, Categories product) {
            holder.setText(R.id.tv_name, "" + product.getName());
           // holder.setText(R.id.tv_date, product.getAddtime());
            holder.setVisible(R.id.tv_add, true);
            holder.setText(R.id.tv_add, "Delete");

        }

    }

}