package com.example.gbcalculator;

import android.content.Intent;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initElem();
    }

    private void initElem() {
        Button button_back = findViewById(R.id.button_Back);
        SwitchMaterial switchMaterial1 = findViewById(R.id.switch1);

        Bundle bndSetting = getIntent().getExtras();
        if (bndSetting != null) {
            Settings settings = bndSetting.getParcelable(Settings.V_SETTINGS);
            switchMaterial1.setChecked(settings.isSwitchState());
        }


        switchMaterial1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        button_back.setOnClickListener(v -> {
            Intent resSettings = new Intent();
            Settings settings = new Settings();
            settings.setSwitchState(switchMaterial1.isChecked());
            resSettings.putExtra(Settings.V_SETTINGS, settings);
            setResult(RESULT_OK, resSettings);
            finish();
        });
    }
}