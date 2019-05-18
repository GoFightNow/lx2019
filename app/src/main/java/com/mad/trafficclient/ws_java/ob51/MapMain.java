package com.mad.trafficclient.ws_java.ob51;


import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.mad.trafficclient.R;

/**
 * Created by Go_Fight_Now on 2019/5/17 15:36
 */
public class MapMain extends Activity implements View.OnClickListener {
    private AMap aMap;
    private ImageView ob51_back;
    private TextView ob51_right_1;
    private TextView ob51_right_2;
    private TextView ob51_right_3;
    private TextView ob51_right_4;
    private MapView ob51_map;
    private TextView ob51_text_info;
    private TextView ob51_daohang;
    private TextView ob51_yejing;
    private TextView ob51_biaozhun;
    private TextView ob51_weixing;
    private TextView ob51_jiaotong;
    private LinearLayout ob51_shitu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ob51_main);
        initView();
        ob51_map.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = ob51_map.getMap();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        ob51_map.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        ob51_map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        ob51_map.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        ob51_map.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        ob51_map.onLowMemory();
    }

    private void initView() {
        ob51_back = (ImageView) findViewById(R.id.ob51_back);
        ob51_right_1 = (TextView) findViewById(R.id.ob51_right_1);
        ob51_right_2 = (TextView) findViewById(R.id.ob51_right_2);
        ob51_right_3 = (TextView) findViewById(R.id.ob51_right_3);
        ob51_right_4 = (TextView) findViewById(R.id.ob51_right_4);
        ob51_map = (MapView) findViewById(R.id.ob51_map);
        ob51_text_info = (TextView) findViewById(R.id.ob51_text_info);

        ob51_back.setOnClickListener(this);
        ob51_right_1.setOnClickListener(this);
        ob51_right_2.setOnClickListener(this);
        ob51_right_3.setOnClickListener(this);
        ob51_right_4.setOnClickListener(this);
        ob51_daohang = (TextView) findViewById(R.id.ob51_daohang);
        ob51_daohang.setOnClickListener(this);
        ob51_yejing = (TextView) findViewById(R.id.ob51_yejing);
        ob51_yejing.setOnClickListener(this);
        ob51_biaozhun = (TextView) findViewById(R.id.ob51_biaozhun);
        ob51_biaozhun.setOnClickListener(this);
        ob51_weixing = (TextView) findViewById(R.id.ob51_weixing);
        ob51_weixing.setOnClickListener(this);
        ob51_jiaotong = (TextView) findViewById(R.id.ob51_jiaotong);
        ob51_jiaotong.setOnClickListener(this);
        ob51_shitu = (LinearLayout) findViewById(R.id.ob51_shitu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ob51_back:
                finish();
                break;
            case R.id.ob51_right_1:
                Toast.makeText(this, "功能1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ob51_right_2:
                Toast.makeText(this, "图层", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, ob51_shitu.getVisibility()+"", Toast.LENGTH_SHORT).show();
                if (ob51_shitu.getVisibility() == View.VISIBLE) {
                    ob51_shitu.setVisibility(View.INVISIBLE);
                } else if (ob51_shitu.getVisibility() == View.INVISIBLE) {
                    ob51_shitu.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.ob51_right_3:
                Toast.makeText(this, "标指", Toast.LENGTH_SHORT).show();

                LatLng latLng1 = new LatLng(39.906901,116.397972);
                LatLng latLng2 = new LatLng(39.5040579764,116.4990421601);
                final Marker marker1 = aMap.addMarker(new MarkerOptions().position(latLng1).title("1号小车").snippet("北京故宫").icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.plus))));
                final Marker marker2 = aMap.addMarker(new MarkerOptions().position(latLng2).title("2号小车").snippet("北京不知道是哪"));

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(new LatLng(39.70542 , 119.5568));
                markerOptions.title("3号小车").snippet("这个就更不知道在哪了");
                markerOptions.draggable(false);
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.add2)));
                markerOptions.setFlat(true);
                aMap.addMarker(markerOptions);
                ob51_text_info.setText("1、2、3、4号小车地图标记已完成");
                break;
            case R.id.ob51_right_4:
                Toast.makeText(this, "功能4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ob51_daohang:
                Toast.makeText(this, "导航视图", Toast.LENGTH_SHORT).show();
                aMap.setMapType(AMap.MAP_TYPE_NAVI);
                break;
            case R.id.ob51_yejing:
                Toast.makeText(this, "夜景视图", Toast.LENGTH_SHORT).show();
                aMap.setMapType(AMap.MAP_TYPE_NIGHT);
                break;
            case R.id.ob51_biaozhun:
                Toast.makeText(this, "标准视图", Toast.LENGTH_SHORT).show();
                aMap.setMapType(AMap.MAP_TYPE_NORMAL);
                break;
            case R.id.ob51_weixing:
                Toast.makeText(this, "卫星视图", Toast.LENGTH_SHORT).show();
                aMap.setMapType(AMap.MAP_TYPE_SATELLITE);// 设置卫星地图模式，aMap是地图控制器对象。
                break;
            case R.id.ob51_jiaotong:
                Toast.makeText(this, "交通视图", Toast.LENGTH_SHORT).show();
                //显示实时路况图层，aMap是地图控制器对象。
                if (aMap.isTrafficEnabled()){
                    aMap.setTrafficEnabled(false);
                } else {
                    aMap.setTrafficEnabled(true);
                }
                break;
        }
    }
}
