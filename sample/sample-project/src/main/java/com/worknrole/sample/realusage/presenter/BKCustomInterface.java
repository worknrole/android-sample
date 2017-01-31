package com.worknrole.sample.realusage.presenter;

/**
 * Created by worknrole on 30/01/17.
 */

public class BKCustomInterface {

    public interface ViewBridge {
        void updateImage(String url);
    }

    public interface PresenterBridge {
        void searchImage(String searchTerms);
    }
}
