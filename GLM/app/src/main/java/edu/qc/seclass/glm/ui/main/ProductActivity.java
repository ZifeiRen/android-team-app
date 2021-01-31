package edu.qc.seclass.glm.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.bean.Item;
import edu.qc.seclass.glm.http.MyObserver;
import edu.qc.seclass.glm.http.RetrofitUtils;
import edu.qc.seclass.glm.http.RxHelper;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProductActivity extends RxAppCompatActivity {

    private ProductAdapter adapter = new ProductAdapter();
    private int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("Product list");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final RecyclerView recyclerView = findViewById(R.id.rv_data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        id = getIntent().getIntExtra("id",0);

        TextView tvAdd = findViewById(R.id.tv_add);
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductActivity.this, AddProductActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter a, @NonNull View view, int position) {
                RetrofitUtils.getApiUrl()
                        .product(null, adapter.getItem(position).getId().toString(), null, "delete")
                        .compose(RxHelper.observableIO2Main(ProductActivity.this))
                        .subscribe(new MyObserver<String>(ProductActivity.this, true) {
                            @Override
                            public void onSuccess(String demo) {
                                adapter.remove(position);
                                load();
                            }

                            @Override
                            public void onFailure(Throwable e, String errorMsg) {

                            }
                        });
            }
        });

    }

    private void load() {
        RetrofitUtils.getApiUrl()
                .productList(id + "", "get")
                .compose(RxHelper.observableIO2Main(this))
                .subscribe(new MyObserver<List<Item>>(this, true) {
                    @Override
                    public void onSuccess(List<Item> demo) {
                        if (demo != null) {
                            for (Item item : demo) {
                                item.setItem_name(item.getName());
                                item.setItem_id(item.getItem_id());
                            }
                            adapter.setNewData(demo);
                        }
                    }

                    @Override
                    public void onFailure(Throwable e, String errorMsg) {

                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        load();
    }


    static class ProductAdapter extends BaseQuickAdapter<Item, BaseViewHolder> {

        public ProductAdapter() {
            super(R.layout.item_product);
            addChildClickViewIds(R.id.tv_del);
        }

        public ProductAdapter(int layoutResId, @org.jetbrains.annotations.Nullable List<Item> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder holder, Item product) {
            holder.setText(R.id.tv_name, "" + product.getName());
            holder.setText(R.id.tv_date, product.getAddtime());
            holder.getView(R.id.tv_del).setVisibility(View.VISIBLE);

        }

    }
}