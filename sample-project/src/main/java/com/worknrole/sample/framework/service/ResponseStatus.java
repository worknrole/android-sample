package com.worknrole.sample.framework.service;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by worknrole on 26/01/17.
 *
 * A custom response status
 */

public class ResponseStatus {

    /**
     * The type of error
     */
    private @ErrorType int mErrorType;

    /**
     * A custom message according the the type error
     */
    private String mMessage;

    public static final int SUCCESS = 0;
    public static final int FAILURE = 1;

    @IntDef({
            SUCCESS,
            FAILURE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorType {}


    //region constructor
    /**
     * A constructor without mentioning a message
     * @param errorType The type of error
     */
    public ResponseStatus(@ErrorType int errorType) {
        this(errorType, "");
    }

    /**
     * A constructor mentioning all elements (type of error and message)
     * @param errorType The type of error
     * @param message A custom message
     */
    public ResponseStatus(@ErrorType int errorType, String message) {
        mErrorType = errorType;
        mMessage = message;
    }
    //endregion
}
