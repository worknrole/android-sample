package com.worknrole.sample.externallibraries.retrofit;

/**
 * Created by worknrole on 14/03/17.
 *
 * This is a gyphy class containing only some particular elements
 * from the Json object received from the server
 *
 * The Json is deserialized inside {@link GyphyDeserializer}
 */

public class GyphyMinify {

    //region Properties
    private String mType;
    private String mUsername;
    private String mSource;
    private String mTitle;
    private String mUrl;
    //endregion


    //region Accessors
    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getSource() {
        return mSource;
    }

    public void setSource(String source) {
        mSource = source;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    //endregion
}
