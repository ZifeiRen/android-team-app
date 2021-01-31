package edu.qc.seclass.glm.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import edu.qc.seclass.glm.api.Api;

import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static final String TAG = "RetrofitUtils";
    private static Api mApiUrl;

    /**
     * Singleton mode
     */
    public static Api getApiUrl() {
        if (mApiUrl == null) {
            synchronized (RetrofitUtils.class) {
                if (mApiUrl == null) {
                    mApiUrl = new RetrofitUtils().getRetrofit();
                }
            }
        }
        return mApiUrl;
    }

    private RetrofitUtils() {
    }

    public Api getRetrofit() {
        // initi Retrofit
        Api apiUrl = initRetrofit(initOkHttp()).create(Api.class);
        return apiUrl;
    }

    /**
     * initi Retrofit
     */
    @NonNull
    private Retrofit initRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(Api.BaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * initi okhttp
     */
    @NonNull
    private OkHttpClient initOkHttp() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient().newBuilder()
                .readTimeout(Api.DEFAULT_TIME, TimeUnit.SECONDS)//Set read timeout
                .connectTimeout(Api.DEFAULT_TIME, TimeUnit.SECONDS)//Set request timeout
                .writeTimeout(Api.DEFAULT_TIME, TimeUnit.SECONDS)//Set write timeout
                .addInterceptor(loggingInterceptor)//Add print interceptor
                .retryOnConnectionFailure(true)//There is a setting error to reconnect
                .build();
    }
}