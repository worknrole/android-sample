package com.worknrole.sample.util;

import okhttp3.logging.HttpLoggingInterceptor.Level;

/**
 * Created by worknrole on 25/01/17.
 */

public class WNRConstant {

    /**
     * Allow services log
     */
    public static final boolean LOG_SERVICE_ENABLE = true;

    /**
     * Allow to customize services cache
     */
    public static final boolean ENABLE_SERVICE_CUSTOM_CACHE = true;

    /**
     * For retrofit/okHttp: The type of log to displayed
     */
    public static final Level SERVICE_LEVEL = Level.BODY;

    /**
     * For retrofit/okHttp: Give the type of retrofit/okHttp log
     */
    public static final Level SERVICE_LOG_LEVEL = LOG_SERVICE_ENABLE ? SERVICE_LEVEL : Level.NONE;
}
