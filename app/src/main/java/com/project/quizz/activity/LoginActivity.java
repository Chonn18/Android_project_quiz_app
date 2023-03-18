package com.project.quizz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.project.quizz.R;

public class LoginActivity extends AppCompatActivity {
    private AppCompatButton btnLoginFace, btnLogin;
    private EditText edtLoginUser, edtLoginPass;
    private TextView btnFogotPass;
    private CheckBox cbRememberPass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initControll();

    }

    private void initView() {
        btnLogin = findViewById(R.id.btn_login);
        btnLoginFace = findViewById(R.id.btn_loginface);
        btnFogotPass = findViewById(R.id.btn_fogotpass);
        edtLoginPass = findViewById(R.id.edt_loginpassword);
        edtLoginUser = findViewById(R.id.edt_loginuser);
        cbRememberPass = findViewById(R.id.cb_rememberpass);
    }

    private void initControll() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String user,pass;
        user = edtLoginUser.getText().toString();
        pass = edtLoginPass.getText().toString();
        if(TextUtils.isEmpty(user)){
            Toast.makeText(this,"Vui lòng nhập email!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Vui lòng nhập password!!!",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                 if(task.isSuccessful()){
                     Toast.makeText(getApplicationContext(),"Đăng nhập thành công!!!",Toast.LENGTH_SHORT).show();
                     Intent i = new Intent(getApplicationContext(),MainActivity.class);
                     startActivity(i);
                 }
                 else Toast.makeText(getApplicationContext(),"Đăng nhập không thành công!!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
