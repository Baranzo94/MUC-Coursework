package com.gcu.liam.muccoursework;


import android.annotation.TargetApi;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.FragmentActivity;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
/**
 * Created by Liam on 08/12/2015.
 */
public class laMapActivity extends AppCompatActivity

{
    List<laMapData> mapDataList;
    private Marker[] mapDataMarkerList = new Marker[5];
    private GoogleMap maplunchtime;
    private float markerColours[] = {210.0f, 120.0f, 300.0f, 330.0f, 270.0f};

    private LatLng latLngGlasgowCentre = new LatLng (55.861201, -4.250385);

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override

    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.la_map_view);

        mapDataList = new ArrayList<laMapData>();
        laMapDataDBMgr mapDB = new laMapDataDBMgr(this,"lunchtimeInfo.s3db",null,1);
        try {
            mapDB.dbCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mapDataList = mapDB.allMapData();
        SetUpMap();
        AddMarkers();
        }

    public void SetUpMap()
    {
        maplunchtime = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        if (maplunchtime != null)
        {
            maplunchtime.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngGlasgowCentre, 12));
            maplunchtime.setMyLocationEnabled(true);
            maplunchtime.getUiSettings().setCompassEnabled(true);
            maplunchtime.getUiSettings().setMyLocationButtonEnabled(true);
            maplunchtime.getUiSettings().setRotateGesturesEnabled(true);
        }
    }

    public void AddMarkers()
    {
        MarkerOptions marker;
        laMapData mapData;
        String mrkTitle;
        String mrkText;

        for(int i = 0; i < mapDataList.size(); i++)
        {
            mapData = mapDataList.get(i);
            mrkTitle = mapData.getVenue();
            mrkText = "Lunch Choice";
            marker = SetMarker(mrkTitle, mrkText, new LatLng(mapData.getLatitude(), mapData.getLongitude()), markerColours[i],true);
            mapDataMarkerList[i] = maplunchtime.addMarker(marker);
        }
    }

    public MarkerOptions SetMarker (String title, String snippet, LatLng position, float markerColour, boolean centreAnchor)
    {
        float anchorX;
        float anchorY;

        if (centreAnchor)
        {
            anchorX = 0.5f;
            anchorY = 0.5f;
        }
        else
        {
            anchorX = 0.05f;
            anchorY = 1.0f;
        }

        MarkerOptions marker = new MarkerOptions().title(title).snippet(snippet).icon(BitmapDescriptorFactory.defaultMarker(markerColour)).anchor(anchorX, anchorY).position(position);

        return marker;
    }
}
