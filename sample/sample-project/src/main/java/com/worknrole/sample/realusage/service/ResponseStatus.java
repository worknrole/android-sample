package com.worknrole.sample.realusage.service;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by worknrole on 26/01/17.
 */

public class ResponseStatus {

    private @ErrorType int mErrorType;
    private String mMessage;

    public static final int SUCCESS = 0;
    public static final int FAILURE = 1;

    @IntDef({
            SUCCESS,
            FAILURE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorType {}


    public ResponseStatus(@ErrorType int errorType) {
        this(errorType, "");
    }


    public ResponseStatus(@ErrorType int errorType, String message) {
        mErrorType = errorType;
        mMessage = message;
    }
}
