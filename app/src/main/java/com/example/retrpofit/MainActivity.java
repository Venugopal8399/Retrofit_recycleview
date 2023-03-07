package com.example.retrpofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<POJO> userListResponseData;
    EditText eid, ename, eusername, eemailid;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle_view);
        eid = findViewById(R.id.enter_id);
        ename= findViewById(R.id.enter_name);
        eusername = findViewById(R.id.enter_user_name);
        eemailid = findViewById(R.id.enter_email);
        button = findViewById(R.id.datasubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adduserdata();
            }
        });
        getuserdata();

    }

    private void adduserdata() {
        String sid = eid.getText().toString();
        String sname = ename.getText().toString();
        String susername = eusername.getText().toString();
        String semail = eusername.getText().toString();
        userListResponseData.add(new POJO(sid,sname,susername,semail));
    }

    private void getuserdata() {
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show();
        (Api_interface.getClient().getUsersList()).enqueue(new Callback<List<POJO>>() {
            @Override
            public void onResponse(Call<List<POJO>> call, Response<List<POJO>> response) {
                Log.d("responseGet",response.body().get(0).getUsername());
                progressDialog.dismiss();
                userListResponseData = response.body();
                setData();
            }

            @Override
            public void onFailure(Call<List<POJO>> call, Throwable t) {

            }
        });

    }

    private void setData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        UsersAdapter usersAdapter = new UsersAdapter((List<POJO>) userListResponseData,(Context) MainActivity.this);
        recyclerView.setAdapter(usersAdapter);
    }
}