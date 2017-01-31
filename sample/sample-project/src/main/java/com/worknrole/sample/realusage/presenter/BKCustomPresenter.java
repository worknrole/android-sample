package com.worknrole.sample.realusage.presenter;

import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.worknrole.sample.realusage.WNRApplication;
import com.worknrole.sample.realusage.callback.ServiceCallback;
import com.worknrole.sample.realusage.presenter.BKCustomInterface.PresenterBridge;
import com.worknrole.sample.realusage.presenter.BKCustomInterface.ViewBridge;
import com.worknrole.sample.realusage.service.ResponseStatus;
import com.worknrole.sample.externallibraries.retrofit.GyphyManager;
import com.worknrole.sample.externallibraries.retrofit.GyphyResponse;

import java.lang.ref.WeakReference;

/**
 * Created by worknrole on 30/01/17.
 *
 * This presenter is used to manage and update treatment about
 * {@link com.worknrole.sample.externallibraries.butterknife.BKCustomView}
 */

public class BKCustomPresenter implements PresenterBridge {

    //region Properties
    /**
     * A reference to the view to update
     */
    private WeakReference<ViewBridge> mViewBridge;

    /**
     * The manager used to update the view
     */
    private GyphyManager mGyphyManager;
    //endregion


    //region Constructors
    public BKCustomPresenter(ViewBridge viewBridge) {
        mViewBridge = new WeakReference<>(viewBridge);
        mGyphyManager = WNRApplication.get().gyphyManager();
    }
    //endregion


    //region Custom bridge methods
    @Override
    public void searchImage(final String searchTerms) {
        new AsyncTask<Void, Pair<GyphyResponse, ResponseStatus>, GyphyResponse>() {

            @Override
            protected GyphyResponse doInBackground(Void... params) {
                mGyphyManager.searchGyphy(searchTerms, new ServiceCallback<GyphyResponse>() {
                    @Override
                    public void onResult(GyphyResponse result, ResponseStatus status) {
                        onProgressUpdate(new Pair<>(result, status));
                    }
                });

                return null;
            }

            @Override
            protected void onProgressUpdate(Pair<GyphyResponse, ResponseStatus>... results) {
                // Ex for retrieving the url of the first images
                String url = results[0].first.getData().get(0).getImages().getParam().getUrl();
                if (mViewBridge.get() != null) mViewBridge.get().updateImage(url);
            }
        }.execute();
    }
    //endregion
}
