package com.project.quizz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.project.quizz.R;

public class StartActivity extends AppCompatActivity {

    private TextView btnDBSignUp;
    private AppCompatButton btnDBLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dasboard_sign_up);

        initView();
        initControll();

    }

    private void initView(){
        btnDBSignUp = findViewById(R.id.btn_dbsignup);
        btnDBLogin = findViewById(R.id.btn_dblogin);
    }

    private void initControll(){
        btnDBSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(i);
            }
        });
        btnDBLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

    private void newSignUp() {
        Intent i = new Intent(StartActivity.this, SignUpActivity.class);
        startActivity(i);
    }

    private void newLogin() {
        Intent i = new Intent(StartActivity.this, LoginActivity.class);
        startActivity(i);
    }
}
