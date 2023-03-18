package com.project.quizz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.project.quizz.R;

public class SignUpActivity extends AppCompatActivity {

    private EditText edtSignName, edtSignPass,edtSignConfirmPass, edtSignUsername;
    private AppCompatButton btnSignup;
    private TextView btnSignLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initView();
        initControll();

    }

    private void initControll() {
        btnSignLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });
    }

    private void initView(){
        edtSignName = findViewById(R.id.edt_signname);
        edtSignPass = findViewById(R.id.edt_signpass);
        edtSignConfirmPass = findViewById(R.id.edt_confirmsignpass);
        edtSignUsername = findViewById(R.id.edt_signusername);
        btnSignup = findViewById(R.id.btn_signup);
        btnSignLogin = findViewById(R.id.btn_signlogin);
    }
}
