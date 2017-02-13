package com.worknrole.sample.framework;

import android.app.Application;

import com.worknrole.sample.externallibraries.retrofit.GyphyManager;
import com.worknrole.sample.framework.manager.NetworkManager;

/**
 * Created by worknrole on 24/01/17.
 *
 * This Application class is the main Singleton of my project
 */

public class WNRApplication extends Application {

    //region Properties
    /**
     * This application singleton used inside the project
     */
    private static WNRApplication mSingleton;

    /**
     * The {@link GyphyManager}
     */
    private GyphyManager mGyphyManager;

    /**
     * The {@link NetworkManager}
     */
    private NetworkManager mNetworkManager;
    //endregion


    //region Lifecycle
    @Override
    public void onCreate() {
        super.onCreate();
        mSingleton = this;
        mGyphyManager = new GyphyManager();
        mNetworkManager = new NetworkManager(getApplicationContext());
    }
    //endregion


    //region Accessors
    /**
     * Get the application instance for calling managers like a singleton
     * @return The application instance
     */
    public static WNRApplication get() {
        return mSingleton;
    }

    /**
     * Get the {@link GyphyManager}
     * @return The {@link GyphyManager}
     */
    public GyphyManager gyphyManager() {
        return mGyphyManager;
    }

    /**
     * Get the {@link NetworkManager}
     * @return The {@link NetworkManager}
     */
    public NetworkManager networkManager() {
        return mNetworkManager;
    }
    //endregion
}
