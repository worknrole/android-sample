package com.worknrole.sample.framework.presenter;

/**
 * Created by worknrole on 30/01/17.
 *
 * This interface contained all interfaces used to handle
 * the {@link com.worknrole.sample.externallibraries.butterknife.BKCustomView} update
 */

public class BKCustomInterface {

    /**
     * The interface used by the presenter to update the view
     */
    public interface ViewBridge {
        /**
         * Used to update an imageView from the url parameter
         * @param url URL containing the image to displayed
         */
        void updateImage(String url);
    }

    /**
     * The interface used by the view to ask for an update
     */
    public interface PresenterBridge {
        /**
         * Launch the search request
         * @param searchTerms All search terms used into the request
         */
        void searchImage(String searchTerms);
    }
}
