package com.architecture.smokingarea;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public abstract class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap googleMap;

    public MapActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }

    protected abstract void initView(Bundle savedInstance);
}
