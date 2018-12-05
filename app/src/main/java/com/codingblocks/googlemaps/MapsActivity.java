package com.codingblocks.googlemaps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng dwarka = new LatLng(28.5921, 77.0460);

        MarkerOptions markerOptions = new MarkerOptions().title("Dwarka").position(dwarka);

        mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(dwarka));



        LatLng delhi = new LatLng(28.70, 77.106);

        MarkerOptions markerOptions1 = new MarkerOptions().title("Delhi").position(delhi);

        mMap.addMarker(markerOptions1);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi));



        LatLng mathura = new LatLng(27.4941, 77.670);

        MarkerOptions markerOptions2 = new MarkerOptions().title("mathura").position(mathura);

        mMap.addMarker(markerOptions2);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(mathura));



        LatLng aligarh = new LatLng(27.89, 78.08);

        MarkerOptions markerOptions3 = new MarkerOptions().title("Aligarh").position(aligarh);

        mMap.addMarker(markerOptions3);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(aligarh));

        UiSettings uiSettings = mMap.getUiSettings();

        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.add(new LatLng(28.70, 77.106),
                new LatLng(28.5921, 77.0460),
                new LatLng(27.4941, 77.670),
                new LatLng(27.89, 78.08));

        mMap.addPolygon(polygonOptions);
              if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        uiSettings.setCompassEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setTiltGesturesEnabled(true);
        uiSettings.setRotateGesturesEnabled(true);

        uiSettings.setMyLocationButtonEnabled(true);

//        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(dwarka, 0, 0, 0)));
    }
}
