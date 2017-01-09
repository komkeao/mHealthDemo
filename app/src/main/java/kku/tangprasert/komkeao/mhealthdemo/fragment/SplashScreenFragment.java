package kku.tangprasert.komkeao.mhealthdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kku.tangprasert.komkeao.mhealthdemo.R;

/**
 * Created by MainUser on 8/1/2560.
 */

public class SplashScreenFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_splash_screen, container,false);
        return rootView;
    }
}
