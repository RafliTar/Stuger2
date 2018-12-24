package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn;
    EditText etLoginEmail, etLoginPassword;
    TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        etLoginEmail = (EditText)findViewById(R.id.etLoginEmail);
        etLoginPassword = (EditText)findViewById(R.id.etLoginPassword);
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);

        SpannableString content = new SpannableString("Sign Up");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tvSignUp.setText(content);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpStepOneActivity.class);
                startActivity(intent);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etLoginEmail.getText().toString();
                String password = etLoginPassword.getText().toString();

                if(email.equals("admin") && password.equals("admin")){
                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    if(isEmail(email) && password.length()>0){
                        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this, "Check your email & password again", Toast.LENGTH_SHORT).show();
                    }
                }
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
