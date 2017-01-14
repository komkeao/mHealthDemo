package kku.tangprasert.komkeao.mhealthdemo.manager;

import kku.tangprasert.komkeao.mhealthdemo.dao.LoginDao;
import kku.tangprasert.komkeao.mhealthdemo.dao.StatusDao;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by MainUser on 8/1/2560.
 */

public interface SaveDataService  {
    @FormUrlEncoded
    @POST("ckd/operate.php")
    Call<StatusDao> add(@Field("pid") String pid,@Field("bw") String bodyWeight,
                        @Field("sbp") String sbp
            , @Field("dbp") String dbp
            , @Field("urine") String urine
            , @Field("uf") String uf);


}
