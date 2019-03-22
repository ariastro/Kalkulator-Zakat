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

public class ZakatEmasActivity extends AppCompatActivity {

    @BindView(R.id.jml_emas)
    EditText jmlEmas;
    @BindView(R.id.harga_emas)
    EditText hargaEmas;
    @BindView(R.id.nisab_emas)
    EditText nisabEmas;
    @BindView(R.id.jml_zakat_emas)
    EditText jmlZakatEmas;
    @BindView(R.id.btnSubmitEmas)
    Button btnSubmit;
    private boolean isZakat = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_emas);

        ButterKnife.bind(this);

        setTitleBar();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalZakatEmas();
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

    private void isZakatEmas(){
        String jumlEmas = jmlEmas.getText().toString();
        double juml = Double.parseDouble(jumlEmas);
        if (juml < 85.0){
            isZakat = false;
            nisabEmas.setText(R.string.tidak);
        }else {
            isZakat = true;
            nisabEmas.setText(R.string.ya);
        }
    }

    private void totalZakatEmas() {
        if (TextUtils.isEmpty(jmlEmas.getText())) {
            if (TextUtils.isEmpty(hargaEmas.getText())) {
                jmlEmas.setError("Isi jumlah emas terlebih dahulu");
                hargaEmas.setError("Isi harga emas terlebih dahulu");
            } else {
                jmlEmas.setError("Isi jumlah emas terlebih dahulu");
            }
        }else if (TextUtils.isEmpty(hargaEmas.getText())) {
            hargaEmas.setError("Isi harga emas terlebih dahulu");
        }else {
            isZakatEmas();
            if (isZakat) {
                String jumlEmas = jmlEmas.getText().toString();
                double juml = Double.parseDouble(jumlEmas);
                double bayarZakat = juml * 0.025;

                String hrgEmas = hargaEmas.getText().toString();
                int hargaEmasPerGram = Integer.parseInt(hrgEmas);

                int bayarZakatTunai = (int) (hargaEmasPerGram * bayarZakat);

                jmlZakatEmas.setText(String.valueOf(bayarZakat) +" gr emas atau Rp." + bayarZakatTunai + ",-");
            } else {
                jmlZakatEmas.setText("");
            }
        }
    }

}
