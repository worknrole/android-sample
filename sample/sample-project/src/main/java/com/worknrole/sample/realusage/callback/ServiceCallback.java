package com.worknrole.sample.realusage.callback;

import android.support.annotation.Nullable;

import com.worknrole.sample.realusage.service.ResponseStatus;

/**
 * Created by worknrole on 26/01/17.
 *
 * A custom services callback
 */

public interface ServiceCallback<ResultType> {

    /**
     * Callback retrieving the result
     * @param result The result retrieved
     * @param status The response status (success, failure, ...)
     */
    void onResult(@Nullable ResultType result, ResponseStatus status);
}
