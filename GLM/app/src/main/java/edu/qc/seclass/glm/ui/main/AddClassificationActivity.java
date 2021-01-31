package edu.qc.seclass.glm.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.http.MyObserver;
import edu.qc.seclass.glm.http.RetrofitUtils;
import edu.qc.seclass.glm.http.RxHelper;


public class AddClassificationActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification_add);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

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
                    Toast.makeText(getApplicationContext(), "Category name cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                RetrofitUtils.getApiUrl()
                        .classify("class_1", et_name.getText().toString(), null, "add")
                        .compose(RxHelper.observableIO2Main(AddClassificationActivity.this))
                        .subscribe(new MyObserver<String>(AddClassificationActivity.this, true) {

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
