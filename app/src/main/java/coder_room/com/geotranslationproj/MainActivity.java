package coder_room.com.geotranslationproj;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import coder_room.com.geotranslationproj.utils.LatitudeLongitudeUtils;

public class MainActivity extends Activity {

    private TextView tv_longitude;
    private TextView tv_latitude;
    private double latitude=0.0;//纬度
    private double longitude =0.0;//经度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
        initGps();
    }

    private void initGps() {
        // 此处经纬度坐标应由第三方sdk或系统获取
        latitude = 39.7740620000;
        longitude = 117.2554250000;

        showLocation();
    }

    private void initView() {
        tv_longitude = (TextView) findViewById(R.id.tv_longitude);
        tv_latitude = (TextView) findViewById(R.id.tv_latitude);
    }

    private void showLocation(){
        // 显示转换的经纬度
        tv_latitude.setText(LatitudeLongitudeUtils.convertToSexagesimal(this, latitude, LatitudeLongitudeUtils.LATITUDE));
        tv_longitude.setText(LatitudeLongitudeUtils.convertToSexagesimal(this, longitude, LatitudeLongitudeUtils.LONGITUDE));
    }
}
