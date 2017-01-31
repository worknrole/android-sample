package com.worknrole.sample.realusage.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by worknrole on 30/01/17.
 */

public class NetworkManager {

    //region Properties
    private Context mContext;
    //endregion


    //region Constructor
    public NetworkManager(Context context) {
        mContext = context;
    }
    //endregion


    //region Custom methods

    /**
     * Check if the user has a network connection
     * @return true if the user has a connection, false otherwise
     */
    public boolean hasNetworkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null) && (networkInfo.isConnectedOrConnecting());
    }
    //endregion
}
