package com.worknrole.sample.externallibraries.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by worknrole on 24/01/17.
 *
 * Example of a GyphyMinify object matching the Json response
 */

public class GyphyResponse {

    @SerializedName("data")
    private List<GyphyData> mData;

    @SerializedName("meta")
    private GyphyMeta mMeta;

    @SerializedName("pagination")
    private GyphyPagination mPagination;

    //region Accessors
    public List<GyphyData> getData() {
        return mData;
    }

    public void setData(List<GyphyData> data) {
        mData = data;
    }

    public GyphyMeta getMeta() {
        return mMeta;
    }

    public void setMeta(GyphyMeta meta) {
        mMeta = meta;
    }

    public GyphyPagination getPagination() {
        return mPagination;
    }

    public void setPagination(GyphyPagination pagination) {
        mPagination = pagination;
    }
    //endregion


    public class GyphyData {

        @SerializedName("type")
        private String mType;

        @SerializedName("id")
        private String mId;

        @SerializedName("username")
        private String mUsername;

        @SerializedName("rating")
        private String mRating;

        @SerializedName("source_tld")
        private String mSource;

        @SerializedName("source_post_url")
        private String mSourcePost;

        @SerializedName("images")
        private GyphyImage mImages;

        public String getType() {
            return mType;
        }

        public String getId() {
            return mId;
        }

        public String getUsername() {
            return mUsername;
        }

        public String getRating() {
            return mRating;
        }

        public String getSource() {
            return mSource;
        }

        public String getSourcePost() {
            return mSourcePost;
        }

        public GyphyImage getImages() {
            return mImages;
        }
    }

    public class GyphyImage {
        @SerializedName("fixed_height")
        private GyphyParam mParam;

        public GyphyParam getParam() {
            return mParam;
        }
    }

    public class GyphyParam {

        @SerializedName("url")
        private String mUrl;

        public String getUrl() {
            return mUrl;
        }
    }

    public class GyphyMeta {

        @SerializedName("status")
        private int mStatus;

        @SerializedName("msg")
        private String mMsg;

        @SerializedName("respose_id")
        private String mResponseId;

        public String getResponseId() {
            return mResponseId;
        }

        public int getStatus() {
            return mStatus;
        }

        public String getMsg() {
            return mMsg;
        }
    }

    public class GyphyPagination {

        @SerializedName("total_count")
        private int mTotalCount;

        @SerializedName("count")
        private int mCount;

        @SerializedName("offset")
        private int mOffset;

        public int getOffset() {
            return mOffset;
        }

        public int getTotalCount() {
            return mTotalCount;
        }

        public int getCount() {
            return mCount;
        }
    }
}
