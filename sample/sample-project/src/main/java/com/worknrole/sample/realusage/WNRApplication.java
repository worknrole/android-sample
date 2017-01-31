package com.worknrole.sample.realusage;

import android.app.Application;

import com.worknrole.sample.externallibraries.retrofit.GyphyManager;
import com.worknrole.sample.realusage.manager.NetworkManager;

/**
 * Created by worknrole on 24/01/17.
 *
 * This Application class is the main Singleton of my project
 */

public class WNRApplication extends Application {

    private static WNRApplication mSingleton;
    private GyphyManager mGyphyManager;
    private NetworkManager mNetworkManager;

    public static WNRApplication get() {
        return mSingleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSingleton = this;
        mGyphyManager = new GyphyManager();
        mNetworkManager = new NetworkManager(getApplicationContext());
    }

    //region custom managers
    public GyphyManager gyphyManager() {
        return mGyphyManager;
    }

    public NetworkManager networkManager() {
        return mNetworkManager;
    }
    //endregion
}
