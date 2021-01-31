package edu.qc.seclass.glm.api;

import edu.qc.seclass.glm.bean.BaseResponse;
import edu.qc.seclass.glm.bean.Categories;
import edu.qc.seclass.glm.bean.Item;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    String BaseUrl = "http://www.zhangyueshihaoren.com";
    int DEFAULT_TIME = 20 * 1000;

    /***
     * shopping list
     * @param   class_1
     *
     * @param cid
     * @param  method   add     delete
     * @return
     */
    @POST("shoppinglist/class.php")
    @FormUrlEncoded
    Observable<BaseResponse<String>> classify(@Field("class") String class_1, @Field("name") String name, @Field("cid") String cid, @Field("method") String method);

    /***
     *
     * @param class1
     * @param cid
     * @return
     */
    @POST("shoppinglist/class.php")
    @FormUrlEncoded
    Observable<BaseResponse<List<Categories>>> classifyList(@Field("class") String class1, @Field("cid") String cid, @Field("method") String method);


    @POST("shoppinglist/products.php")
    @FormUrlEncoded
    Observable<BaseResponse<List<Item>>> productList(@Field("cid") String cid, @Field("method") String method);


    @POST("shoppinglist/products.php")
    @FormUrlEncoded
    Observable<BaseResponse<String>> product(@Field("name") String name, @Field("id") String id, @Field("cid") String cid, @Field("method") String method);


}
