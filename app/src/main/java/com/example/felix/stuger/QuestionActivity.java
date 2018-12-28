package com.example.felix.stuger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

public class QuestionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Toolbar toolbar;
    Spinner spJurusan, spMataPelajaran;
    EditText etSubmitQuestion;
    Button btnSubmitQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        spJurusan = findViewById(R.id.sp_jurusan);
        spMataPelajaran = findViewById(R.id.sp_mata_pelajaran);
        etSubmitQuestion = findViewById(R.id.et_submit_question);
        btnSubmitQuestion = findViewById(R.id.btn_submit_question);

        spJurusan.setOnItemSelectedListener(this);
        spMataPelajaran.setOnItemSelectedListener(this);
        etSubmitQuestion.setFocusable(false);

        ArrayAdapter<CharSequence> jurusanAdapter = ArrayAdapter.createFromResource(this, R.array.jurusan, android.R.layout.simple_spinner_item);
        jurusanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> ipaAdapter = ArrayAdapter.createFromResource(this, R.array.mata_pelajaran_ipa, android.R.layout.simple_spinner_item);
        ipaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMataPelajaran.setAdapter(ipaAdapter);

        ArrayAdapter<CharSequence> ipsAdapter = ArrayAdapter.createFromResource(this, R.array.mata_pelajran_ips, android.R.layout.simple_spinner_item);
        ipsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spJurusan.setAdapter(jurusanAdapter);
        spMataPelajaran.setEnabled(false);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()){
            case R.id.sp_jurusan:
                String jurusan = parent.getItemAtPosition(position).toString();

                if(jurusan.equals("IPA")){
                    spMataPelajaran.setEnabled(true);
                    Toast.makeText(getApplicationContext(), jurusan, Toast.LENGTH_SHORT).show();
                }
                else if(jurusan.equals("IPS")){
                    spMataPelajaran.setEnabled(true);
                    Toast.makeText(getApplicationContext(), jurusan, Toast.LENGTH_SHORT).show();
                }
                else{
                    spMataPelajaran.setEnabled(false);
                }

                break;

            case R.id.sp_mata_pelajaran:
                String mataPelajaran = parent.getItemAtPosition(position).toString();

                if(!mataPelajaran.equals("Mata Pelajaran")){
                    etSubmitQuestion.setFocusable(true);
                    etSubmitQuestion.setFocusableInTouchMode(true);
                    Toast.makeText(getApplicationContext(), mataPelajaran, Toast.LENGTH_SHORT).show();
                }
                else{
                    etSubmitQuestion.setFocusable(false);
                    etSubmitQuestion.setFocusableInTouchMode(false);
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
