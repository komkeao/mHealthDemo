package kku.tangprasert.komkeao.mhealthdemo.manager;

import kku.tangprasert.komkeao.mhealthdemo.dao.LoginDao;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by MainUser on 8/1/2560.
 */

public interface ApiService  {
    @FormUrlEncoded
    @POST("checkLogin")
    Call<LoginDao> addUser(@Field("userEmail") String userEmail, @Field("userPassword") String userPassword);
}
