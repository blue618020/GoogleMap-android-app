# 구글지도 앱

📝 <b> tistory : </b> https://blue618020.tistory.com/119 , https://blue618020.tistory.com/120 , https://blue618020.tistory.com/121

### 🔍 학습 내용
-  구글맵 API 공식 페이지를 확인하여 사용하기
-  내 위치의 위도, 경도값을 정해서 화면에 표시하기
-  지도 화면에 마커 표시하기
-  지도의 일반,위성 타입 설정하기

### 💻 실습
- 구글맵 공식 홈페이지에 나온 방법을 순서대로 따라해서 설정 마치기
- 기본 틀을 만들고, <b> onMapReady </b> 안에 지도화면에 나타내기 위해 코드 만들기
  
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
                }
            });
        }
    }

-  위도, 경도값 위치를 내가 정한 값으로 입력해주고, 화면의 중심을 내가 정한 위치로 맞추기
 
           // 내가 정한 위치로 지도 표시하기 => 위도, 경도값
           LatLng myLocation = new LatLng(37.5429, 126.6772);
   
           // 지도의 중심을 내가 정한 위치로 세팅하기
           googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 17));

-  마커를 만들어서 지도에 표시하기

          MarkerOptions markerOptions = new MarkerOptions();
          markerOptions.position(myLocation).title("타이틀");  // 연달아서 타이틀도 지정 가능
          googleMap.addMarker(markerOptions).setTag(0); // 화면에 표시

- 마커를 클릭했을때의 어떤 실행할건지도 정할 수 있음. Toast 띄워보기
- 마커를 만들 때, 각각 <b> setTag </b> 를 미리 달아두면 if문으로 지정해서 어떤 활동을 할지 정할 수도 있음

          googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
          @Override
          public boolean onMarkerClick(@NonNull Marker marker) {
              // 마커 코드 맨 뒤에 setTag(); 를 미리 달아두면 편함
              int tag = (int) marker.getTag();
      
              Toast.makeText(MainActivity.this,
              marker.getTitle() + "입니다.",
              Toast.LENGTH_LONG).show();
    
               return false;
          }
     });

-  지도 타입은 <b> 기본값이 일반 지도 </b> 이고, <b> .MAP_TYPE_SATELLITE </b> 으로 따로 지정해주면 <b> 위성 지도 </b>로 설정됨

          googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); // 위성지도
  
