package com.architecture.smokingarea;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import net.daum.android.map.MapViewEventListener;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class MainActivity extends Gps {

    public MainActivity(){
    }

    // 참고한 사이트
    // https://blog.naver.com/PostView.nhn?isHttpsRedirect=true&blogId=bgpoilkj&logNo=221972990489
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kakaoMap = new MapView(this);

        mapViewContainer = (ViewGroup) findViewById(R.id.kakaoMap);
        mapViewContainer.addView(kakaoMap);

        kakaoMap.setMapViewEventListener(this);
        kakaoMap.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);

        if(!checkLocationServicesStatus()){
            showDialogForLocationServiceSetting();
        } else {
            checkRunTimePermission();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    // https://kgh940525.tistory.com/entry/Android-%EC%88%98%EB%AA%85%EC%A3%BC%EA%B8%B0%EC%97%90-%EB%94%B0%EB%A5%B8-%EC%83%81%ED%83%9C-%EB%B3%80%ED%99%94
    // 복구시점
    // UI가 사용자에게 보여지는 시점, 계속 동적으로 사용자의 요구사항에 맞는 데이터를 제공
    // 사용자에게 보여질 데이터를 초기화하여 가져오는 로직을 포함
    // 사용자의 정보를 임시저장한 부분도 여기서 복구
    @Override
    protected void onResume() {
        super.onResume();
    }

    // 중지시점
    // 애니메이션 정지, 메모리 할당 해제, cpu 자원 점유하는 작업 중지, 상호작용 정보 임시저장, 브로드캐스트/센서 핸들 등 배터리 소모 행위 조절절
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapViewContainer.removeAllViews();
    }
}