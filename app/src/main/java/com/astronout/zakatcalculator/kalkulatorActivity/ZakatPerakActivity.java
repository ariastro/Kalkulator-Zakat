package com.astronout.zakatcalculator.kalkulatorActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.astronout.zakatcalculator.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.astronout.zakatcalculator.MainActivity.ZAKAT_NAME;


public class ZakatPerakActivity extends AppCompatActivity {

    @BindView(R.id.jml_perak)
    EditText jmlPerak;
    @BindView(R.id.harga_perak)
    EditText hargaPerak;
    @BindView(R.id.nisab_perak)
    EditText nisabPerak;
    @BindView(R.id.jml_zakat_perak)
    EditText jmlZakatPerak;
    @BindView(R.id.btnSubmitPerak)
    Button btnSubmit;
    private boolean isZakat = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_perak);

        ButterKnife.bind(this);

        setTitleBar();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalZakatPerak();
            }
        });

    }

    private void setTitleBar() {
        Intent intent = getIntent();
        String name = intent.getStringExtra(ZAKAT_NAME);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(name);
        }
    }

    private void isZakatPerak(){
        String jumlPerak = jmlPerak.getText().toString();
        double juml = Double.parseDouble(jumlPerak);
        if (juml < 589.0){
            isZakat = false;
            nisabPerak.setText(R.string.tidak);
        }else {
            isZakat = true;
            nisabPerak.setText(R.string.ya);
        }
    }

    private void totalZakatPerak() {
        if (TextUtils.isEmpty(jmlPerak.getText())) {
            if (TextUtils.isEmpty(jmlPerak.getText())) {
                jmlPerak.setError("Isi jumlah perak terlebih dahulu");
                hargaPerak.setError("Isi harga perak terlebih dahulu");
            } else {
                jmlPerak.setError("Isi jumlah perak terlebih dahulu");
            }
        }else if (TextUtils.isEmpty(hargaPerak.getText())) {
            hargaPerak.setError("Isi harga perak terlebih dahulu");
        } else {
            isZakatPerak();
            if (isZakat) {
                String jumlPerak = jmlPerak.getText().toString();
                double juml = Double.parseDouble(jumlPerak);
                double bayarZakat = juml * 0.025;

                String hrgPerak = hargaPerak.getText().toString();
                int hargaPerakPerGram = Integer.parseInt(hrgPerak);

                int bayarZakatTunai = (int) (hargaPerakPerGram * bayarZakat);

                jmlZakatPerak.setText(String.valueOf(bayarZakat) + " gr perak atau Rp." + bayarZakatTunai + ",-");
            } else {
                jmlZakatPerak.setText("");
            }
        }
    }
}
