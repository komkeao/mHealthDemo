package kku.tangprasert.komkeao.mhealthdemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.io.IOException;

import kku.tangprasert.komkeao.mhealthdemo.R;
import kku.tangprasert.komkeao.mhealthdemo.activity.MainActivity;
import kku.tangprasert.komkeao.mhealthdemo.dao.LoginDao;
import kku.tangprasert.komkeao.mhealthdemo.manager.HttpManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class LoginFragment extends Fragment {
    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;

    public LoginFragment() {
        super();
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
///
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        btnLogin = (Button) rootView.findViewById(R.id.btnLogin);
        edtPassword = (EditText) rootView.findViewById(R.id.edtPassword);
        edtUsername = (EditText) rootView.findViewById(R.id.edtUsername);
        btnLogin.setOnClickListener(loginListenear);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }
    View.OnClickListener loginListenear= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Context mContext =Contextor.getInstance().getContext();
           //Toast.makeText(mContext, "",Toast.LENGTH_SHORT).show();
            Call<LoginDao> call = HttpManager.getInstance().getService().addUser(edtUsername.getText().toString(), edtPassword.getText().toString());
            call.enqueue(new Callback<LoginDao>() {
                @Override
                public void onResponse(Call<LoginDao> call, Response<LoginDao> response) {

                    if(response.isSuccessful()){
                        LoginDao dao = response.body();
                        if (dao.getUserId() != 0) {
                            startActivity(new Intent(getActivity(),MainActivity.class));

                        }else {
                            Toast.makeText(mContext,"User or Password Incorrect!",Toast.LENGTH_SHORT).show();
                        }
                        //Toast.makeText(MainActivity.this,dao.getUserEmail(),Toast.LENGTH_SHORT).show();
                    }else {
                        try {
                            Toast.makeText(mContext,response.errorBody().string(),Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<LoginDao> call, Throwable t) {
                    //Toast.makeText(MainActivity.this,t.toString(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(mContext,"Network Error!!+"+t.toString(),Toast.LENGTH_SHORT).show();
                }
            });

        }
    };

}
