package com.worknrole.sample.externallibraries.otto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wornrole.sample.R;

public class OttoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otto);

        FirstOttoFragment firstFrag = new FirstOttoFragment();
        SecondOttoFragment secondFrag = new SecondOttoFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.first_fragment, firstFrag).commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.second_fragment, secondFrag).commit();
    }
}
