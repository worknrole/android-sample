package com.worknrole.sample.externallibraries.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.worknrole.sample.framework.WNRApplication;
import com.worknrole.sample.framework.WNRConstant;
import com.worknrole.sample.framework.callback.ServiceCallback;
import com.worknrole.sample.framework.service.ResponseStatus;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by worknrole on 25/01/17.
 *
 * The gyphy service request/response manager
 */

public class GyphyManager {

    //region Properties
    private static final String CACHE_NAME = "http-cache";
    public static final boolean ENABLE_MINIFY = false;

    /**
     * The gyphy web service
     */
    private GyphyService mService;
    //endregion



    //region constructor
    /**
     * The constructor initializing the gyphy service
     */
    public GyphyManager() {
        mService = ENABLE_MINIFY ?
                getRetrofit(GyphyService.API_URL, buildCustomGsonConverter()).create(GyphyService.class) :
                getRetrofit(GyphyService.API_URL).create(GyphyService.class);
    }
    //endregion


    //region Initializer
    /**
     * Get retrofit according to the first solution
     * @param apiUrl The API url
     * @return a retrofit object matching our service
     */
    private Retrofit getRetrofit(String apiUrl) {
        return getRetrofit(apiUrl, null);
    }

     /**
     * Get retrofit according to the first solution
     * @param apiUrl The API url
      * @param converterFactory Converter used to manipulate the Json response
     * @return a retrofit object matching our service
     */
    private Retrofit getRetrofit(String apiUrl, GsonConverterFactory converterFactory) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(WNRConstant.SERVICE_LOG_LEVEL);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(createCache())
                .addInterceptor(createCacheInterceptor())
                .build();

        return new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(
                        converterFactory == null ?
                                GsonConverterFactory.create() :
                                converterFactory)
                .client(client)
                .build();
    }

    /**
     * Create a custom converter to manipulate the Json response
     * @return a custom {@link GsonConverterFactory} to manipulate the Json response
     */
    private GsonConverterFactory buildCustomGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(GyphyMinify.class, new GyphyDeserializer());
        Gson gson = gsonBuilder.create();
        return GsonConverterFactory.create(gson);
    }


    /**
     * Create a custom cache named "http-cache"
     * It's will be created under the data/data/ directory
     * @return The custom cache
     */
    private Cache createCache() {
        return new Cache(
                new File(WNRApplication.get().getCacheDir(), CACHE_NAME),
                10 * 1024 * 1024); // 10MB
    }

    /**
     * Create a custom cache management for online and offline request
     * @return The custom cache manager
     */
    private Interceptor createCacheInterceptor() {
        return new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (WNRConstant.ENABLE_SERVICE_CUSTOM_CACHE) {
                    CacheControl.Builder ccBuilder = new CacheControl.Builder();
                    if (WNRApplication.get().networkManager().hasNetworkConnection())
                        ccBuilder.maxAge(2, TimeUnit.MINUTES);
                    else
                        ccBuilder.maxStale(7, TimeUnit.DAYS);

                    request = request.newBuilder().cacheControl(ccBuilder.build()).build();
                }
                return chain.proceed(request);
            }
        };
    }
    //endregion


    //region Custom methods
    /**
     * Search for a gyphy image with callback
     * @param terms All search terms
     * @param callback Response callback to the one asking for search
     */
    public void searchGyphy(String terms, final ServiceCallback callback) {
        String finalTerm = terms.replaceAll("\\+s", "+");
        Call<GyphyResponse> gyphyCall = mService.retrieveGyphyList(finalTerm, 1, 0);

        gyphyCall.enqueue(new Callback<GyphyResponse>() {
            @Override
            public void onResponse(Call<GyphyResponse> call, Response<GyphyResponse> response) {
                if (response.isSuccessful()) {
                    callback.onResult(response.body(), new ResponseStatus(ResponseStatus.SUCCESS));
                }
            }

            @Override
            public void onFailure(Call<GyphyResponse> call, Throwable t) {
                callback.onResult(null, new ResponseStatus(ResponseStatus.FAILURE));
            }
        });
    }

    /**
     * Search for a gyphy image and return it
     * @param terms All search terms
     * @return a gyphy image response
     */
    public GyphyResponse searchGyphy(String terms) {
        GyphyResponse response = null;
        String finalTerm = terms.replaceAll("\\+s", "+");
        Call<GyphyResponse> gyphyCall = mService.retrieveGyphyList(finalTerm, 1, 0);

        try {
            response = gyphyCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }


    /**
     * Search for a gyphy image with callback for {@link GyphyMinify}
     * @param terms All search terms
     * @param callback Response callback to the one asking for search
     */
    public void searchGyphyMinify(String terms, final ServiceCallback callback) {
        String finalTerm = terms.replaceAll("\\+s", "+");
        Call<GyphyMinify> gyphyCall = mService.retrieveGyphyListMinify(finalTerm, 1, 0);

        gyphyCall.enqueue(new Callback<GyphyMinify>() {
            @Override
            public void onResponse(Call<GyphyMinify> call, Response<GyphyMinify> response) {
                if (response.isSuccessful()) {
                    callback.onResult(response.body(), new ResponseStatus(ResponseStatus.SUCCESS));
                }
            }

            @Override
            public void onFailure(Call<GyphyMinify> call, Throwable t) {
                callback.onResult(null, new ResponseStatus(ResponseStatus.FAILURE));
            }
        });
    }
    //endregion
}
