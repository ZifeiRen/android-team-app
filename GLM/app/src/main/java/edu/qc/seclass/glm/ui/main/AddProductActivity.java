package edu.qc.seclass.glm.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.http.MyObserver;
import edu.qc.seclass.glm.http.RetrofitUtils;
import edu.qc.seclass.glm.http.RxHelper;


public class AddProductActivity extends RxAppCompatActivity {

    private int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("Add product");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        id = getIntent().getIntExtra("id", 0);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_name = findViewById(R.id.et_name);
                if (et_name.getText().toString().length() < 1) {
                    Toast.makeText(getApplicationContext(), "Product name cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                RetrofitUtils.getApiUrl()
                        .product(et_name.getText().toString(), null, id + "", "add")
                        .compose(RxHelper.observableIO2Main(AddProductActivity.this))
                        .subscribe(new MyObserver<String>(AddProductActivity.this, true) {
                            @Override
                            public void onSuccess(String demo) {
                                Toast.makeText(getApplicationContext(), "Add success", Toast.LENGTH_SHORT).show();
                                finish();
                            }

                            @Override
                            public void onFailure(Throwable e, String errorMsg) {
                                Toast.makeText(getApplicationContext(), "Add fail", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }


}
