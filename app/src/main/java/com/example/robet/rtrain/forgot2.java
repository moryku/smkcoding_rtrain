package com.example.robet.rtrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.TextInputEditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class forgot2 extends AppCompatActivity {

    public static String token = "";
    public static String password = "";
    public static String repass = "";
    public static String message = "";

    Intent newAct;
    Loading loading;

    @BindView(R.id.etToken)
    TextInputEditText etToken;
    @BindView(R.id.etPassword)
    TextInputEditText etPassword;
    @BindView(R.id.etRePassword)
    TextInputEditText etRePassword;
    @BindView(R.id.btnBack)
    Button btnBack;
    @BindView(R.id.btnReset)
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot2);
        ButterKnife.bind(this);

        loading = new Loading(this);
    }

    @OnClick({R.id.btnBack, R.id.btnReset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:

                newAct = new Intent(getApplicationContext(), forgot.class);
                startActivity(newAct);

                break;
            case R.id.btnReset:

                token = etToken.getText().toString();
                password = etPassword.getText().toString();
                repass = etRePassword.getText().toString();

                if (token != null) {
                    if (!password.equals("")) {
                        if (!repass.equals("")) {
                            if (password.equals(repass)) {

                                loading.start();
                                RestApi.getData().forgot2User(token, password).enqueue(new Callback<Value>() {
                                    @Override
                                    public void onResponse(Call<Value> call, Response<Value> response) {

                                        loading.stop();
                                        message = response.body().getMessage();
                                        if (message.equals("password anda berhasil di ubah")) {
                                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                                            newAct = new Intent(getApplicationContext(), userLogin.class);
                                            newAct.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                            newAct.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(newAct);
                                        } else {
                                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                                        }

                                    }

                                    @Override
                                    public void onFailure(Call<Value> call, Throwable t) {
                                        loading.stop();
                                        Toast.makeText(getApplicationContext(), "jaringan error", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            } else {
                                Toast.makeText(getApplicationContext(), "password dan retype password anda tidak sama", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "masukkan retype password anda !", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "kolom password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "kolom token tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
