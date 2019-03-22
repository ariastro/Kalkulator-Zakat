package com.astronout.zakatcalculator.kalkulatorActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.astronout.zakatcalculator.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.astronout.zakatcalculator.MainActivity.ZAKAT_NAME;

public class ZakatPertanianActivity extends AppCompatActivity {

    @BindView(R.id.jml_panen)
    EditText jmlPanen;
    @BindView(R.id.rb_irigasi)
    RadioButton rbIrigasi;
    @BindView(R.id.rb_tadah_hujan)
    RadioButton rbTadahHujan;
    @BindView(R.id.harga_beras_now)
    EditText hargaBeras;
    @BindView(R.id.nisab_pertanian)
    EditText nisabPertanian;
    @BindView(R.id.jml_pertanian)
    EditText jmlPertanian;
    @BindView(R.id.btnSubmitPertanian)
    Button btnSubmit;
    private boolean isZakat = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_pertanian);

        ButterKnife.bind(this);

        setTitleBar();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalZakatPertanian();
            }
        });

    }

    private void setTitleBar(){
        Intent intent = getIntent();
        String name = intent.getStringExtra(ZAKAT_NAME);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(name);
        }
    }

    private void isZakatPertanian(){
        String jumlPanen = jmlPanen.getText().toString();
        int juml = Integer.parseInt(jumlPanen);
        if (juml < 520){
            isZakat = false;
            nisabPertanian.setText(R.string.tidak);
        }else {
            isZakat = true;
            nisabPertanian.setText(R.string.ya);
        }
    }

    private void totalZakatPertanian() {
        if (TextUtils.isEmpty(jmlPanen.getText())) {
            if (TextUtils.isEmpty(hargaBeras.getText())) {
                jmlPanen.setError("Isi jumlah panen terlebih dahulu");
                hargaBeras.setError("Isi harga beras terlebih dahulu");
            }
        }
        else if (TextUtils.isEmpty(hargaBeras.getText())) {
            hargaBeras.setError("Isi harga beras terlebih dahulu");
        } else {
            isZakatPertanian();
            if (isZakat) {
                String jumlPanen = jmlPanen.getText().toString();
                int juml = Integer.parseInt(jumlPanen);

                if (rbIrigasi.isChecked()) {

                    double bayarZakat = juml * 0.05;

                    String hrgBeras = hargaBeras.getText().toString();
                    int hargaBeras = Integer.parseInt(hrgBeras);

                    int bayarZakatTunai = (int) (hargaBeras * bayarZakat);

                    jmlPertanian.setText(String.valueOf(bayarZakat) + " Kg beras atau Rp." + bayarZakatTunai + ",-");
                }else {
                    double bayarZakat = juml * 0.01;

                    String hrgBeras = hargaBeras.getText().toString();
                    int hargaBeras = Integer.parseInt(hrgBeras);

                    int bayarZakatTunai = (int) (hargaBeras * bayarZakat);

                    jmlPertanian.setText(String.valueOf(bayarZakat) + " Kg beras atau Rp." + bayarZakatTunai + ",-");
                }
            } else {
                jmlPertanian.setText("");
            }
        }
    }

}
