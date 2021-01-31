package edu.qc.seclass.glm.http;

import android.util.Log;

import edu.qc.seclass.glm.bean.BaseResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {
    private static final String TAG = "BaseObserver";

    @Override
    public void onSubscribe(Disposable d) {
        Log.e(TAG, "onSubscribe: ");
    }

    @Override
    public void onNext(BaseResponse<T> response) {
        //Here the basic data is processed uniformly. For example:
        if (response.getCode() == 200) {
            onSuccess(response.getData());
        } else {
            onFailure(null, response.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "Throwable: " + e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.e(TAG, "onComplete: ");
    }

    public abstract void onSuccess(T demo);

    public abstract void onFailure(Throwable e, String errorMsg);
}