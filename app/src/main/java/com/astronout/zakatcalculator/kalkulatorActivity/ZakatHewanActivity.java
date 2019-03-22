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

public class ZakatHewanActivity extends AppCompatActivity {

    @BindView(R.id.rb_kambing)
    RadioButton rbKambing;
    @BindView(R.id.rb_sapi)
    RadioButton rbSapi;
    @BindView(R.id.jml_hewan)
    EditText jmlHewan;
    @BindView(R.id.nisab_hewan)
    EditText nisabHewan;
    @BindView(R.id.jml_zakat_hewan)
    EditText jmlZakatHewan;
    @BindView(R.id.btnSubmitHewan)
    Button btnSubmit;
    private boolean isZakat = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_hewan);

        ButterKnife.bind(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalZakatHewan();
            }
        });

        setTitleBar();

    }

    private void setTitleBar() {
        Intent intent = getIntent();
        String name = intent.getStringExtra(ZAKAT_NAME);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(name);
        }
    }

    private void isZakatHewan() {
        String jumlHewan = jmlHewan.getText().toString();
        int juml = Integer.parseInt(jumlHewan);
        if (rbKambing.isChecked()) {
            if (juml < 40) {
                isZakat = false;
                nisabHewan.setText(R.string.tidak);
            } else {
                isZakat = true;
                nisabHewan.setText(R.string.ya);
            }
        } else {
            if (juml < 30) {
                isZakat = false;
                nisabHewan.setText(R.string.tidak);
            } else {
                isZakat = true;
                nisabHewan.setText(R.string.ya);
            }
        }
    }

    private void totalZakatHewan() {
        if (TextUtils.isEmpty(jmlHewan.getText())) {
            jmlHewan.setError("Isi harga perak terlebih dahulu");
        } else {
            isZakatHewan();
            if (isZakat) {
                String jumlHewan = jmlHewan.getText().toString();
                int juml = Integer.parseInt(jumlHewan);

                if (rbKambing.isChecked()) {

                    int ekor = 3;

                    if (juml <= 120) {
                        jmlZakatHewan.setText("1 ekor");
                    } else if (juml <= 200) {
                        jmlZakatHewan.setText("2 ekor");
                    } else if (juml >= 201 && juml <= 300) {
                        jmlZakatHewan.setText("3 ekor");
                    } else if (juml >= 301 && juml <= 400) {
                        jmlZakatHewan.setText("4 ekor");
                    } else if (juml >= 401 && juml <= 500) {
                        jmlZakatHewan.setText("5 ekor");
                    } else if (juml >= 501 && juml <= 600) {
                        jmlZakatHewan.setText("6 ekor");
                    } else if (juml >= 601 && juml <= 700) {
                        jmlZakatHewan.setText("7 ekor");
                    } else if (juml >= 701 && juml <= 800) {
                        jmlZakatHewan.setText("8 ekor");
                    } else if (juml >= 801 && juml <= 900) {
                        jmlZakatHewan.setText("9 ekor");
                    } else if (juml >= 901 && juml <= 1000) {
                        jmlZakatHewan.setText("10 ekor");
                    } else if (juml >= 1001 && juml <= 1100) {
                        jmlZakatHewan.setText("11 ekor");
                    } else if (juml >= 1101 && juml <= 1200) {
                        jmlZakatHewan.setText("12 ekor");
                    } else if (juml >= 1201 && juml <= 1300) {
                        jmlZakatHewan.setText("13 ekor");
                    } else {
                        jmlZakatHewan.setText("14 ekor");
                    }
                } else {
                    if (juml >= 30 && juml <= 39) {
                        jmlZakatHewan.setText("1 tabi’ (sapi jantan berumur 1 tahun) atau tabi’ah (sapi betina berumur 1 tahun)");
                    } else if (juml >= 40 && juml <= 59) {
                        jmlZakatHewan.setText("1 musinnah (sapi betina berumur 2 tahun)");
                    } else if (juml >= 60 && juml <= 69) {
                        jmlZakatHewan.setText("2 tabi’");
                    } else if (juml >= 70 && juml <= 79) {
                        jmlZakatHewan.setText("1 musinnah dan 1 tabi");
                    } else if (juml >= 80 && juml <= 89) {
                        jmlZakatHewan.setText("2 musinnah’");
                    }else {
                        jmlZakatHewan.setText("3 tabi’");
                    }
                }
            } else {
                jmlZakatHewan.setText("");
            }
        }
    }

}
