package com.example.felix.stuger;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HasilKuisSos3 extends AppCompatActivity {
    private Button Homebtn;
    private DrawerLayout drawer;

    Toolbar toolbar;
    TextView toolbarTitle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis_sos2);
        Homebtn = findViewById(R.id.ButtonHome);
        Homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboardActivity();
            }
        });
        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);

        hasil.setText("Jawaban Benar :"+Bab3Sos.benar+"\nJawaban Salah :"+Bab3Sos.salah);
        nilai.setText(""+Bab3Sos.hasil);
    }

    private void openDashboardActivity() {
        Intent intent = new Intent(this,DashboardActivity.class);
        startActivity(intent);
    }
}

