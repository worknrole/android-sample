package com.worknrole.sample.externallibraries.otto;

import com.squareup.otto.Bus;

/**
 * Created by worknrole on 09/02/17.
 *
 * Otto library design by Square (cf: <a href="http://square.github.io/otto/">link</a>)
 * This class is a singleton for using a unique instance of the Otto event bus
 */
public class OttoBus {

    /**
     * The Otto Event bus
     * It must be used has a singleton
     */
    private Bus mBus;

    /**
     * The unique OttoBus instance
     */
    private static OttoBus mInstance;

    /**
     * Private constructor to avoid calling it directly
     */
    private OttoBus() {
        mBus = new Bus();
    }

    /**
     * Get the unique Otto Event bus
     * @return The unique Otto Event bus
     */
    public static OttoBus get() {
        if (mInstance == null)
            mInstance = new OttoBus();
        return mInstance;
    }

    /**
     * Getting access to the event bus
     * @return Get the event bus
     */
    public Bus getBus() {
        return mBus;
    }
}
