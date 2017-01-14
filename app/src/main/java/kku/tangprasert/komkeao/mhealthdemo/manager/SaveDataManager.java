package kku.tangprasert.komkeao.mhealthdemo.manager;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class SaveDataManager {

    private static SaveDataManager instance;

    public static SaveDataManager getInstance() {
        if (instance == null)
            instance = new SaveDataManager();
        return instance;
    }

    private Context mContext;
    private SaveDataService service;

    private SaveDataManager() {
        mContext = Contextor.getInstance().getContext();
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("http://61.19.254.16/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(SaveDataService.class);

    }
    public SaveDataService getService(){
        return service;
    }

}
