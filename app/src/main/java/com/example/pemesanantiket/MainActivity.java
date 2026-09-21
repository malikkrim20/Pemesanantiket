package com.example.pemesanantiket;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int hargaTiket = 25000;

    int jumlahTiket = 1;

    TextView tvJumlah;
    TextView tvTotal;

    Button btnTambah;
    Button btnKurang;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tvJumlah = findViewById(R.id.tvJumlah);
        tvTotal = findViewById(R.id.tvTotal);

        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnReset = findViewById(R.id.btnReset);


        btnTambah.setOnClickListener(v -> {

            jumlahTiket++;

            hitungTotal();
        });

        btnKurang.setOnClickListener(v -> {

            if (jumlahTiket > 1) {

                jumlahTiket--;

                hitungTotal();
            }
        });


        btnReset.setOnClickListener(v -> {

            jumlahTiket = 1;

            hitungTotal();
        });


        hitungTotal();
    }


    private void hitungTotal() {

        int total = hargaTiket * jumlahTiket;

        tvJumlah.setText(String.valueOf(jumlahTiket));

        tvTotal.setText("Rp" + String.format("%,d", total)
                .replace(",", "."));
    }
}