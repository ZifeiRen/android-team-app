package edu.qc.seclass.glm;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import edu.qc.seclass.glm.bean.Product;

import java.util.HashMap;

public class BaseApplication extends Application {

    //Save temporary shopping list
    private static HashMap<String, Product> map = new HashMap();
    public static BaseApplication application;
    ;

    private static void add(Product product) {
        if (map.containsKey(product.getId())) {
            Product temp = map.get(product.getId());
            temp.setNum(temp.getNum() + 1);
        } else {
            map.put(product.getId(), product);
        }
    }

    private static HashMap<String, Product> getMap() {
        return map;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
