package kku.tangprasert.komkeao.mhealthdemo.fragment;

import android.app.ProgressDialog;
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
import kku.tangprasert.komkeao.mhealthdemo.activity.MainActivity2;
import kku.tangprasert.komkeao.mhealthdemo.dao.LoginDao;
import kku.tangprasert.komkeao.mhealthdemo.dao.StatusDao;
import kku.tangprasert.komkeao.mhealthdemo.manager.HttpManager;
import kku.tangprasert.komkeao.mhealthdemo.manager.SaveDataManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class AddFragment extends Fragment {
    EditText edtBodyWeight;
    EditText edtSBP;
    EditText edtDBP;
    EditText edtUrine;
    EditText edtUF;
    Button btnLogin;
    ProgressDialog progress;
    Contextor mContex;

    public AddFragment() {
        super();
    }

    public static AddFragment newInstance() {
        AddFragment fragment = new AddFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    ///
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        edtBodyWeight = (EditText) rootView.findViewById(R.id.body_weight);
        edtDBP = (EditText) rootView.findViewById(R.id.dbp);
        edtSBP = (EditText) rootView.findViewById(R.id.sbp);
        edtUF = (EditText) rootView.findViewById(R.id.uf);
        edtUrine = (EditText) rootView.findViewById(R.id.urine);
        btnLogin = (Button) rootView.findViewById(R.id.btnSubmit);
        btnLogin.setOnClickListener(addListenear);
        mContex = Contextor.getInstance();
        progress = new ProgressDialog(getContext());
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
    View.OnClickListener addListenear = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            progress.setTitle("Loading");
            progress.setMessage("Wait while loading...");
            progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
            progress.show();
// To dismiss the dialog

            final Context mContext =Contextor.getInstance().getContext();
            //Toast.makeText(mContext, "",Toast.LENGTH_SHORT).show();
            Call<StatusDao> call = SaveDataManager.getInstance().getService().add("5",edtBodyWeight.getText().toString(),edtSBP.getText().toString(),edtDBP.getText().toString(),edtUrine.getText().toString(),edtUF.getText().toString());
            call.enqueue(new Callback<StatusDao>() {
                @Override
                public void onResponse(Call<StatusDao> call, Response<StatusDao> response) {
                    progress.dismiss();
                    if(response.isSuccessful()){
                        StatusDao dao = response.body();
                        Toast.makeText(mContext,"Saved!!!"+dao.getStatus(),Toast.LENGTH_SHORT).show();


//                        if (dao.sta() != 0) {
//                            startActivity(new Intent(getActivity(),MainActivity2.class));
//
//                        }else {
//                            Toast.makeText(mContext,"User or Password Incorrect!",Toast.LENGTH_SHORT).show();
//                        }
                        //Toast.makeText(MainActivity2.this,dao.getUserEmail(),Toast.LENGTH_SHORT).show();
                    }else {
                        try {
                            Toast.makeText(mContext,response.errorBody().string(),Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<StatusDao> call, Throwable t) {
                    //Toast.makeText(MainActivity2.this,t.toString(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(mContext,"Network Error!!+"+t.toString(),Toast.LENGTH_SHORT).show();
                }
            });

        }
    };

}
