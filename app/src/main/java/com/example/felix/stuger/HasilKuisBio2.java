package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HasilKuisBio2 extends AppCompatActivity {
private Button Homebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis_bio2);
        Homebtn = findViewById(R.id.ButtonHome);
        Homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboardActivity();
            }
        });
        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);

        hasil.setText("Jawaban Benar :"+Bab2Bio.benar+"\nJawaban Salah :"+Bab2Bio.salah);
        nilai.setText(""+Bab2Bio.hasil);
    }

    private void openDashboardActivity() {
        Intent intent = new Intent(this,DashboardActivity.class);
        startActivity(intent);
    }
}
