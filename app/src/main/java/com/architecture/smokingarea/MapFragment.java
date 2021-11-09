package com.architecture.smokingarea;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.Map;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    private MapView kakaomap = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mapView = inflater.inflate(R.layout.fragment_map, container, false);

        kakaomap = (MapView) mapView.findViewById(R.id.mapView);
        kakaomap.getMapAsync(this);

        return mapView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(kakaomap!=null){
            kakaomap.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        kakaomap.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        kakaomap.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        kakaomap.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        kakaomap.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        kakaomap.onDestroy();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
    }
}