package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HasilKuisEko3 extends AppCompatActivity {
    private Button Homebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis_eko3);

            Homebtn = findViewById(R.id.ButtonHome);
            Homebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDashboardActivity();
                }
            });
            TextView hasil = (TextView)findViewById(R.id.hasil);
            TextView nilai = (TextView)findViewById(R.id.nilai);

            hasil.setText("Jawaban Benar :"+Bab3Eko.benar+"\nJawaban Salah :"+Bab3Eko.salah);
            nilai.setText(""+Bab3Eko.hasil);
        }

        private void openDashboardActivity() {
            Intent intent = new Intent(this,DashboardActivity.class);
            startActivity(intent);
    }
}
