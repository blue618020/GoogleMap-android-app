package com.blue.map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                // 맵이 화면에 나타나는 부분
                // 여기에 로직 작성하기

                // 내가 정한 위치로 지도 표시하기 => 위도, 경도값
                LatLng myLocation = new LatLng(37.5429, 126.6772);


                // 지도의 중심을 내가 정한 위치로 세팅하기
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 17));


                // 마커를 만들어서, 지도에 표시하기
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(myLocation).title("연희직업전문학교");  // 연달아서 타이틀도 지정 가능
                googleMap.addMarker(markerOptions).setTag(0); // 화면에 표시


                // 한줄로 한번에 만들수도 있다 (하지만 헷갈림 주의)
                googleMap.addMarker(new MarkerOptions().position(new LatLng(37.5438, 126.6772)).title("마커 2")).setTag(1);;


                MarkerOptions markerOptions1 = new MarkerOptions();
                markerOptions1.position(new LatLng(37.5428, 126.6762)).title("마커 3");
                googleMap.addMarker(markerOptions1).setTag(2);


                // 마커를 클릭했을때, 처리하는 코드
                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(@NonNull Marker marker) {
                        // 마커 코드 맨 뒤에 setTag(); 를 미리 달아두면 편함
                        int tag = (int) marker.getTag();

                        // if 문으로 각각 어떤 활동을 할지 정할 수 있음
//                        if (tag == 0){
//
//                        }else if (tag == 1){
//
//                        }else if (tag ==2){
//
//                        }

                        Toast.makeText(MainActivity.this,
                                marker.getTitle() + "입니다.",
                                Toast.LENGTH_LONG).show();

                        return false;
                    }
                });


                // 지도 타입 설정하기 (일반, 위성 등)
                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); // 위성지도
            }
        });

    }
}