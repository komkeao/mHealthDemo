package kku.tangprasert.komkeao.mhealthdemo.activity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import kku.tangprasert.komkeao.mhealthdemo.R;
import kku.tangprasert.komkeao.mhealthdemo.fragment.LoginFragment;
import kku.tangprasert.komkeao.mhealthdemo.fragment.SplashScreenFragment;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer,new SplashScreenFragment(),"SplashScreenActivity")
                    .commit();
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,LoginFragment.newInstance())
                        .commit();
                //startActivity(new Intent(SplashScreenActivity.this,MainActivity2.class));
                //finish();
            }
        },2000);
        Contextor mContext = Contextor.getInstance();
        PendingIntent contentIntent =
                PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.logo_cc)
                        .setContentIntent(contentIntent)
                        .setContentTitle("Body Weight Alert")
                        .setContentText("Tab to Open");

        int mNotificationId = 001;
// Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            SplashScreenFragment splashScreenFragment = (SplashScreenFragment) getSupportFragmentManager().findFragmentByTag("SplashScreenActivity");

        }
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
