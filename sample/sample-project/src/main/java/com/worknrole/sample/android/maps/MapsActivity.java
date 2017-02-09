package com.worknrole.sample.android.maps;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.RawRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.wornrole.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by worknrole on 09/02/17.
 *
 * A Simple usage of the Google Map API
 */
public class MapsActivity extends AppCompatActivity implements
        OnMapReadyCallback, // Callback when the map is ready to be used
        GoogleMap.OnPoiClickListener // Listen to a click on a Point of Interest
{
    /**
     * The Google map
     */
    private GoogleMap mMap;

    /**
     * Use to define the next map style to display
     */
    private boolean enableDefaultStyle = true;

    /**
     * The Activity CoordinatorLayout used to display the Snackbar
     */
    @BindView(R.id.coordinator_layout) CoordinatorLayout mCoordinatorLayout;

    /**
     * The button used to switch between custom and default map style
     */
    @BindView(R.id.maps_switch_style) Button mSwitchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_activty);
        ButterKnife.bind(this);
        initializeMaps();
    }

    /**
     * Create and add a map fragment and register a callback via
     * {@link SupportMapFragment#getMapAsync(OnMapReadyCallback)}
     * to be inform when the map is ready to be used.
     */
    private void initializeMaps() {
        MapFragment mapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map_fragment, mapFragment).commit();
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mSwitchBtn.setVisibility(View.VISIBLE);

        // Set the camera position to the Eiffel Tower
        CameraPosition camPos = new CameraPosition.Builder()
                .target(new LatLng(48.858370, 2.294481)).zoom(13).bearing(0).tilt(0).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camPos));

        // Adding a marker to the Eiffel Tower
        LatLng eiffelTower = new LatLng(48.858370, 2.294481);
        mMap.addMarker(new MarkerOptions().position(eiffelTower).title("Eiffel Tower"));

        mMap.setOnPoiClickListener(this);
    }

    /**
     * Listener on {@link #mSwitchBtn} click
     * It allows to switch between custom and default map style
     */
    @OnClick(R.id.maps_switch_style)
    public void onSwitchStyle() {
        @RawRes int styleRawRes = enableDefaultStyle ? R.raw.maps_style : R.raw.maps_default_style;
        boolean success = mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, styleRawRes));
        if (!success) Log.w("MapDebug", "Style parsing failed.");
        enableDefaultStyle = !enableDefaultStyle;
    }

    @Override
    public void onPoiClick(PointOfInterest pointOfInterest) {
        Snackbar.make(mCoordinatorLayout, "Point of interest: " + pointOfInterest.name, Snackbar.LENGTH_SHORT).show();
    }
}
