package edu.qc.seclass.glm;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;

import android.view.View;


import com.trello.rxlifecycle2.components.support.RxFragmentActivity;
import edu.qc.seclass.glm.ui.main.AddClassificationActivity;
import edu.qc.seclass.glm.ui.main.CartListUpdateActivity;
import edu.qc.seclass.glm.ui.main.SectionsPagerAdapter;

public class MainActivity extends RxFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() == 0) {
                    //Provisional list
                    Intent intent = new Intent(getApplication(), CartListUpdateActivity.class);
                    intent.putExtra("id", "add");
                    startActivity(intent);
                } else {
                    //add category
                    Intent intent = new Intent(getApplicationContext(), AddClassificationActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}