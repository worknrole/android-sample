package com.worknrole.sample.framework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.worknrole.sample.android.maps.MapsActivity;
import com.worknrole.sample.externallibraries.butterknife.ButterKnifeActivity;
import com.worknrole.sample.externallibraries.otto.OttoActivity;
import com.worknrole.sample.framework.view.list.SampleAdapter;
import com.wornrole.sample.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initializeList();
    }

    private void initializeList() {
        ListView listView = (ListView)findViewById(R.id.list_view);
        List<Pair<String, Intent>> itemList = new ArrayList<>();
        itemList.add(new Pair<>(
                getResources().getString(R.string.butterknife_activity_name),
                new Intent(this, ButterKnifeActivity.class)));
        itemList.add(new Pair<>(
                getResources().getString(R.string.otto_activity_name),
                new Intent(this, OttoActivity.class)));
        itemList.add(new Pair<>(
                getResources().getString(R.string.maps_activity_name),
                new Intent(this, MapsActivity.class)));

        listView.setAdapter(new SampleAdapter(this, itemList));
    }
}
