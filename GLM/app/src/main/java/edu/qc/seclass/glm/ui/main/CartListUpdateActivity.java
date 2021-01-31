package edu.qc.seclass.glm.ui.main;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.bean.UserList;
import edu.qc.seclass.glm.bean.Categories;
import edu.qc.seclass.glm.bean.Item;
import edu.qc.seclass.glm.bean.Product;
import edu.qc.seclass.glm.http.MyObserver;
import edu.qc.seclass.glm.http.RetrofitUtils;
import edu.qc.seclass.glm.http.RxHelper;
import edu.qc.seclass.glm.http.SPManager;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class CartListUpdateActivity extends RxAppCompatActivity {

    private ProductAdapter adapter = new ProductAdapter();
    private String id;
    private UserList item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("Edit/Add list");
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

        id = getIntent().getStringExtra("id");
        if (id == null) {
            //
            item = (UserList) getIntent().getSerializableExtra("item");
        }

        TextView tvSave = findViewById(R.id.tv_save);
        TextView tvAdd = findViewById(R.id.tv_add);
        EditText et_name = findViewById(R.id.et_name);
        if (item != null) {
            et_name.setText(item.getName());
            adapter.setNewData(item.getList());
        } else {
            ArrayList arrayList = new ArrayList<Product>();
           /* for (Product value : BaseApplication.getMap().values()) {
                arrayList.add(value);
            }*/
            adapter.setNewData(arrayList);
        }
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save
                if (et_name.getText().toString().length() < 1) {
                    Toast.makeText(getApplicationContext(), "List name cannot be empty",  Toast.LENGTH_SHORT).show();
                    return;
                }
                String temp = SPManager.getInstance().getString("cart");
                List<UserList> array;
                if (temp != null) {
                    array = new Gson().fromJson(temp, new TypeToken<List<UserList>>() {
                    }.getType());
                } else {
                    array = new ArrayList<>();
                }

                UserList cartProductList = new UserList();
                cartProductList.setName(et_name.getText().toString());
                List<UserList> cartProductLists = new ArrayList<>();
                Boolean flag=false;
                if (id==null){
                    //
                    UserList pTemp=null;
                    for (UserList product : array) {
                        if (item!=null&&product.getName().equals(item.getName())){
                            pTemp=product;
                        }
                    }
                    if (pTemp!=null){
                        array.remove(pTemp);
                    }
                }

                for (UserList pp : array) {
                    if ( pp.getName().equals(cartProductList.getName())) {
                        flag=true;
                    } else {
                        cartProductLists.add(pp);
                    }
                }
                if (flag){
                    Toast.makeText(getApplicationContext(), "Shopping list cannot be duplicate", Toast.LENGTH_SHORT).show();
                    return;
                }
                ArrayList<Item> datas = new ArrayList<>();
                for (Item datum : adapter.getData()) {
                    datas.add(datum);
                }

                cartProductList.setList(datas);
                cartProductLists.add(cartProductList);
                String str = new Gson().toJson(cartProductLists);
                SPManager.getInstance().putString("cart", str);
                Toast.makeText(getApplicationContext(), "Add success", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    private void addProduct() {
        RetrofitUtils.getApiUrl()
                .classifyList("class_1", null, "get")
                .compose(RxHelper.observableIO2Main(CartListUpdateActivity.this))
                .subscribe(new MyObserver<List<Categories>>(CartListUpdateActivity.this, true) {
                    @Override
                    public void onSuccess(List<Categories> demo) {
                        String[] arrayList = new String[demo.size()];
                        for (int i = 0; i < demo.size(); i++) {
                            arrayList[i] = demo.get(i).getName();
                        }
                        if (demo != null) {
                            new XPopup.Builder(CartListUpdateActivity.this)
                                    .asCenterList("Select category", arrayList,
                                            new OnSelectListener() {
                                                @Override
                                                public void onSelect(int position, String text) {
                                                    loadProduct(demo.get(position).getId().toString());
                                                }
                                            })
                                    .show();
                        }
                    }

                    @Override
                    public void onFailure(Throwable e, String errorMsg) {

                    }
                });
    }

    private void loadProduct(String cid) {
        RetrofitUtils.getApiUrl()
                .productList(cid, "get")
                .compose(RxHelper.observableIO2Main(CartListUpdateActivity.this))
                .subscribe(new MyObserver<List<Item>>(CartListUpdateActivity.this, true) {
                    @Override
                    public void onSuccess(List<Item> demo2) {
                        if (demo2 != null) {
                            String[] arrayList2 = new String[demo2.size()];
                            for (int i = 0; i < demo2.size(); i++) {
                                arrayList2[i] = demo2.get(i).getName();
                            }
                            new XPopup.Builder(CartListUpdateActivity.this)
                                    .asCenterList("Select product", arrayList2,
                                            new OnSelectListener() {
                                                @Override
                                                public void onSelect(int position, String text) {
                                                    Item product = demo2.get(position);
                                                    boolean flag = false;
                                                    for (Item product1 : adapter.getData()) {
                                                        if (product1.getId().equals(product.getId())) {
                                                            flag = true;
                                                            product1.addNum();
                                                            adapter.notifyDataSetChanged();
                                                        }
                                                    }
                                                    if (!flag) {
                                                        adapter.addData(product);
                                                    }

                                                }
                                            }).show();
                        }
                    }

                    @Override
                    public void onFailure(Throwable e, String errorMsg) {

                    }
                });
    }


    static class ProductAdapter extends BaseQuickAdapter<Item, BaseViewHolder> {

        public ProductAdapter() {
            super(R.layout.item_product);
        }

        public ProductAdapter(int layoutResId, @org.jetbrains.annotations.Nullable List<Item> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder holder, Item product) {
            holder.setIsRecyclable(false);


            holder.setText(R.id.tv_name, "" + product.getName());
            holder.setText(R.id.tv_date,  product.getItem_quantity()+"");
            ((EditText)holder.getView(R.id.tv_date)).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (charSequence.length()>0){
                        product.setItem_quantity(Integer.valueOf(charSequence.toString()));
                    }

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            holder.getView(R.id.tv_add).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove(holder.getAdapterPosition());
                }
            });
            holder.setVisible(R.id.tv_add, true);
            holder.setVisible(R.id.tv_date, true);
            holder.setVisible(R.id.tv_des, true);
            holder.setText(R.id.tv_add, "Delete");

        }

    }
}