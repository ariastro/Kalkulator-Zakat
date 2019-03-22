package com.astronout.zakatcalculator;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.astronout.zakatcalculator.kalkulatorActivity.ZakatEmasActivity;
import com.astronout.zakatcalculator.kalkulatorActivity.ZakatFitrahActivity;
import com.astronout.zakatcalculator.kalkulatorActivity.ZakatHewanActivity;
import com.astronout.zakatcalculator.kalkulatorActivity.ZakatPerakActivity;
import com.astronout.zakatcalculator.kalkulatorActivity.ZakatPertanianActivity;
import com.astronout.zakatcalculator.kalkulatorActivity.ZakatRikazActivity;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.zakat_emas)
    ImageView zakatEmas;
    @BindView(R.id.zakat_perak)
    ImageView zakatPerak;
    @BindView(R.id.zakat_fitrah)
    ImageView zakatFitrah;
    @BindView(R.id.zakat_hewan)
    ImageView zakatHewan;
    @BindView(R.id.zakat_rikaz)
    ImageView zakatRikaz;
    @BindView(R.id.zakat_pertanian)
    ImageView zakatPertanian;

    public static String ZAKAT_NAME = "ZAKAT_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        loadImage();

        zakatEmas.setOnClickListener(this);
        zakatFitrah.setOnClickListener(this);
        zakatHewan.setOnClickListener(this);
        zakatPerak.setOnClickListener(this);
        zakatPertanian.setOnClickListener(this);
        zakatRikaz.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zakat_emas:
                Intent zakatEmasIntent = new Intent(this, ZakatEmasActivity.class);
                zakatEmasIntent.putExtra(ZAKAT_NAME, "Zakat Emas");
                startActivity(zakatEmasIntent);
                break;
            case R.id.zakat_fitrah:
                Intent zakatFitrahIntent = new Intent(this, ZakatFitrahActivity.class);
                zakatFitrahIntent.putExtra(ZAKAT_NAME, "Zakat Fitrah");
                startActivity(zakatFitrahIntent);
                break;
            case R.id.zakat_perak:
                Intent zakatPerakIntent = new Intent(this, ZakatPerakActivity.class);
                zakatPerakIntent.putExtra(ZAKAT_NAME, "Zakat Perak");
                startActivity(zakatPerakIntent);
                break;
            case R.id.zakat_hewan:
                Intent zakatHewanIntent = new Intent(this, ZakatHewanActivity.class);
                zakatHewanIntent.putExtra(ZAKAT_NAME, "Zakat Hewan");
                startActivity(zakatHewanIntent);
                break;
            case R.id.zakat_rikaz:
                Intent zakatRikazIntent = new Intent(this, ZakatRikazActivity.class);
                zakatRikazIntent.putExtra(ZAKAT_NAME, "Zakat Rikaz");
                startActivity(zakatRikazIntent);
                break;
            case R.id.zakat_pertanian:
                Intent zakatPertanianIntent = new Intent(this, ZakatPertanianActivity.class);
                zakatPertanianIntent.putExtra(ZAKAT_NAME, "Zakat Pertanian");
                startActivity(zakatPertanianIntent);
                break;
        }
    }

    public void loadImage(){
        Glide.with(this)
                .load(R.drawable.research)
                .into(zakatRikaz);

        Glide.with(this)
                .load(R.drawable.silver)
                .into(zakatPerak);

        Glide.with(this)
                .load(R.drawable.bag)
                .into(zakatFitrah);

        Glide.with(this)
                .load(R.drawable.gold)
                .into(zakatEmas);

        Glide.with(this)
                .load(R.drawable.trees)
                .into(zakatPertanian);

        Glide.with(this)
                .load(R.drawable.cow)
                .into(zakatHewan);
    }

}