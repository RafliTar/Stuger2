package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpStepOneActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    Button btnNext, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step_one);

        etName = (EditText) findViewById(R.id.etSignUpName);
        etEmail = (EditText) findViewById(R.id.etSignUpEmail);
        etPassword = (EditText) findViewById(R.id.etSignUpPassword);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnBack = (Button) findViewById(R.id.btnSignUpBack);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(name.equals("") || email.equals("") || password.equals("")){
                    Toast.makeText(SignUpStepOneActivity.this, "Fill all the column", Toast.LENGTH_SHORT).show();
                }else if (!isEmail(email)){
                    Toast.makeText(SignUpStepOneActivity.this, "Email format is wrong", Toast.LENGTH_SHORT).show();
                }else if (password.length()<0 || password.length()>20){
                    Toast.makeText(SignUpStepOneActivity.this, "Password length 1-20 char", Toast.LENGTH_SHORT).show();
                }else{
                    //simpen data ke DB atau kirim data ke SignUpStepTwo dulu baru disimpen
                    Intent intent = new Intent(getApplicationContext(), SignUpStepTwoActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public boolean isEmail(String email){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches() == true){
            return true;
        }else{
            return false;
        }
    }
}
