package edu.qc.seclass.glm.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.bean.UserList;
import edu.qc.seclass.glm.http.SPManager;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class CartFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private ProductAdapter adapter = new ProductAdapter();

    public static CartFragment newInstance() {
        CartFragment fragment = new CartFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_product, container, false);
        final RecyclerView recyclerView = root.findViewById(R.id.rv_data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter base, @NonNull View view, int position) {
                Intent intent = new Intent(getActivity(), CartListActivity.class);
                intent.putExtra("item", adapter.getItem(position));
                startActivity(intent);
            }
        });


        return root;
    }


    @Override
    public void onResume() {
        super.onResume();
        String temp = SPManager.getInstance().getString("cart");
        List<UserList> array;
        if (temp != null) {
            array = new Gson().fromJson(temp, new TypeToken<List<UserList>>() {
            }.getType());
        } else {
            array = new ArrayList<>();
        }
        adapter.setNewData(array);
    }

    static class ProductAdapter extends BaseQuickAdapter<UserList, BaseViewHolder> {

        public ProductAdapter() {
            super(R.layout.item_product);
        }

        public ProductAdapter(int layoutResId, @Nullable List<UserList> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder holder, UserList product) {
            holder.setText(R.id.tv_name, "" + product.getName());
            holder.setText(R.id.tv_date, "");

            holder.getView(R.id.tv_add).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove(holder.getAdapterPosition());
                    String str = new Gson().toJson(getData());
                    SPManager.getInstance().putString("cart", str);

                }
            });

            holder.getView(R.id.tv_del).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), CartListUpdateActivity.class);
                    intent.putExtra("item", product);
                    getContext().startActivity(intent);

                }
            });
            holder.setVisible(R.id.tv_add, true);
            holder.setVisible(R.id.tv_del, true);
            holder.setText(R.id.tv_add, "Delete");
            holder.setText(R.id.tv_del, "Edit");
        }

    }
}