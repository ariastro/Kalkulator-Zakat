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

public class ZakatFitrahActivity extends AppCompatActivity {

    @BindView(R.id.rb_ya)
    RadioButton rbYa;
    @BindView(R.id.rb_tidak)
    RadioButton rbTidak;
    @BindView(R.id.harga_beras)
    EditText hargaBeras;
    @BindView(R.id.jml_fitrah)
    EditText jmlFitrah;
    @BindView(R.id.nisab_fitrah)
    EditText nisabFitrah;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;

    private Boolean isZakat = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_fitrah);

        ButterKnife.bind(this);

        setTitleBar();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

    private void isZakat(){
        if (rbYa.isChecked()){
            isZakat = true;
            nisabFitrah.setText(R.string.ya);
        }else{
            isZakat = false;
            nisabFitrah.setText(R.string.tidak);
        }
    }

    private void totalZakat(){
        if (TextUtils.isEmpty(hargaBeras.getText())){
            hargaBeras.setError("Isi harga beras terlebih dahulu");
        }else {
            isZakat();
            if (isZakat) {
                String valueBeras = hargaBeras.getText().toString();
                int beras = Integer.parseInt(valueBeras);

                int bayarZakat = beras * 3;
                jmlFitrah.setText("3kg Beras atau Rp." + bayarZakat + ",-");
            } else {
                jmlFitrah.setText("");
            }
        }
    }

}
