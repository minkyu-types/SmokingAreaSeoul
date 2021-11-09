package com.architecture.smokingarea;

import android.app.Activity;
import android.content.SharedPreferences;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        kakaomap.onCreate(savedInstanceState);
    }

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

    // ex: 이미 로그인을 한 사람이라면 로그인 화면이 아닌 메인 화면으로 바로 넘어가기
    //     브로드캐스트리시버 사용
    @Override
    public void onStart() {
        super.onStart();
        kakaomap.onStart();
    }

    // https://kgh940525.tistory.com/entry/Android-%EC%88%98%EB%AA%85%EC%A3%BC%EA%B8%B0%EC%97%90-%EB%94%B0%EB%A5%B8-%EC%83%81%ED%83%9C-%EB%B3%80%ED%99%94
    // 복구시점
    // UI가 사용자에게 보여지는 시점, 계속 동적으로 사용자의 요구사항에 맞는 데이터를 제공
    // 사용자에게 보여질 데이터를 초기화하여 가져오는 로직을 포함
    // 사용자의 정보를 임시저장한 부분도 여기서 복구
    @Override
    public void onResume() {
        super.onResume();
        kakaomap.onResume();

        SharedPreferences pref = this.getActivity().getSharedPreferences("pref", Activity.MODE_PRIVATE);

        if(pref!=null){

        }
    }

    // 중지시점
    // 애니메이션 정지, 메모리 할당 해제, cpu 자원 점유하는 작업 중지, 상호작용 정보 임시저장, 브로드캐스트/센서 핸들 등 배터리 소모 행위 조절절
    @Override
   public void onPause() {
        super.onPause();
        kakaomap.onPause();

        SharedPreferences pref = this.getActivity().getSharedPreferences("pref", Activity.MODE_PRIVATE);
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
    public void onLowMemory() {
        super.onLowMemory();
        kakaomap.onLowMemory();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
    }
}