package com.worknrole.sample.realusage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.worknrole.sample.realusage.view.list.SampleAdapter;
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
                getResources().getString(R.string.firstTestActivity),
                new Intent(this, FirstTestActivity.class)));

        listView.setAdapter(new SampleAdapter(this, itemList));
    }
}
