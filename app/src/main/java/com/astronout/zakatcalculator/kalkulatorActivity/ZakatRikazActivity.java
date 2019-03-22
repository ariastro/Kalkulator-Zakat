package com.astronout.zakatcalculator.kalkulatorActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.astronout.zakatcalculator.R;;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.astronout.zakatcalculator.MainActivity.ZAKAT_NAME;


public class ZakatRikazActivity extends AppCompatActivity {

    @BindView(R.id.jml_temuan)
    EditText jmlTemuan;
    @BindView(R.id.nisab_rikaz)
    EditText nisabRikaz;
    @BindView(R.id.jml_zakat_rikaz)
    EditText jmlZakatRikaz;
    @BindView(R.id.btnSubmitRikaz)
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_rikaz);

        ButterKnife.bind(this);

        setTitleBar();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nisabRikaz.setText(R.string.ya);
                totalZakat();
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

    private void totalZakat(){
        if (TextUtils.isEmpty(jmlTemuan.getText())){
            jmlTemuan.setError("Silahkan isi Jumlah Temuan terlebih dahulu");
        }else {
            String temuan = jmlTemuan.getText().toString();
            int jumlahTemuan = Integer.parseInt(temuan);
            double totalZakat = jumlahTemuan * 0.2;

            jmlZakatRikaz.setText("Rp." + (int) totalZakat + ",-");
        }

    }

}
