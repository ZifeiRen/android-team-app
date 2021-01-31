package edu.qc.seclass.glm.http;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;

import edu.qc.seclass.glm.BaseApplication;

public class SPManager {
    private static SharedPreferences sp;
    private static Context mContext;
    private static Editor edit;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressLint("CommitPrefEdits")
    private SPManager() {
        mContext = BaseApplication.application;
        sp = mContext.getSharedPreferences("yp", Context.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
        edit = sp.edit();
    }

    public static SPManager getInstance() {
        return new SPManager();
    }

    public void putString(String key, String value) {
        if (edit != null) {
            edit.putString(key, value);
            edit.commit();
        }
    }

    public void putInt(String key, int value) {
        if (edit != null) {
            edit.putInt(key, value);
            edit.commit();
        }
    }

    public void putLong(String key, long value) {
        if (edit != null) {
            edit.putLong(key, value);
            edit.commit();
        }
    }

    public void putFloat(String key, float value) {
        if (edit != null) {
            edit.putFloat(key, value);
            edit.commit();
        }
    }

    public void putBoolean(String key, boolean value) {
        if (edit != null) {
            edit.putBoolean(key, value);
            edit.commit();
        }
    }

    public String getString(String key) {
        if (sp != null) {
            return sp.getString(key, null);
        }
        return null;
    }

    public int getInt(String key) {
        if (sp != null) {
            return sp.getInt(key, 0);
        }
        return 0;
    }

    public long getLong(String key) {
        if (sp != null) {
            return sp.getLong(key, 0);
        }
        return 0;
    }

    public float getFloat(String key) {
        if (sp != null) {
            return sp.getFloat(key, 0.0f);
        }
        return 0.0f;
    }

    public boolean getBoolean(String key) {
        if (sp != null) {
            return sp.getBoolean(key, false);
        }
        return false;
    }

    public SharedPreferences getSharedPreferences() {
        return sp;
    }

}
