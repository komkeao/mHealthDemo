package kku.tangprasert.komkeao.mhealthdemo.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
                //startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
                //finish();
            }
        },2000);

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
