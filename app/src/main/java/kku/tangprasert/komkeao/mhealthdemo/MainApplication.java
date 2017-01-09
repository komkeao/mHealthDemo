package kku.tangprasert.komkeao.mhealthdemo;

import android.app.Application;
import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by MainUser on 8/1/2560.
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        Contextor.getInstance().init(getApplicationContext());
        super.onCreate();
    }
}
