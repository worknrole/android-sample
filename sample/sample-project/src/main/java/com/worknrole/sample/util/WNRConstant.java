package com.worknrole.sample.util;

import okhttp3.logging.HttpLoggingInterceptor.Level;

/**
 * Created by worknrole on 25/01/17.
 */

public class WNRConstant {

    public static final boolean LOG_SERVICE_ENABLE = true;
    public static final boolean ENABLE_SERVICE_CUSTOM_CACHE = true;
    public static final Level SERVICE_LEVEL = Level.BODY;
    public static final Level SERVICE_LOG_LEVEL = LOG_SERVICE_ENABLE ? SERVICE_LEVEL : Level.NONE;
}
