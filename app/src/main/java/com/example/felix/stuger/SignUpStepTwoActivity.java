package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignUpStepTwoActivity extends AppCompatActivity {

    String Gender = "";

    EditText etPhoneNumber;
    RadioButton rbMale, rbFemale;
    Button btnSumbit, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step_two);



        etPhoneNumber = (EditText) findViewById(R.id.etSignUpPhoneNumber);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        btnSumbit = (Button) findViewById(R.id.btnSubmitSignUp);
        btnBack = (Button) findViewById(R.id.btnSignUpBack);

        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PhoneNumber = etPhoneNumber.getText().toString();
                if(PhoneNumber.equals("")){
                    Toast.makeText(SignUpStepTwoActivity.this, "Pleas", Toast.LENGTH_SHORT).show();
                }
                else if(Gender.equals("")){
                    Toast.makeText(SignUpStepTwoActivity.this, "Please Select Gender", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpStepOneActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onRBClick(View view){
        boolean Checked = ((RadioButton) view).isChecked();
        if(Checked){
            switch (view.getId()){
                case R.id.rbMale:
                    if (Checked){
                        Gender = "Male";
                    }
                    break;
                case R.id.rbFemale:
                    if (Checked){
                        Gender = "Female";
                    }
            }
        }
    }
}
