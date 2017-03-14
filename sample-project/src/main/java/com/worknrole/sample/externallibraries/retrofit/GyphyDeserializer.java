package com.worknrole.sample.externallibraries.retrofit;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by worknrole on 14/03/17.
 *
 * This deserializer avoid creating many objects to match with the Json
 * received from the server:
 * {@link GyphyMinify} with deserialization VS {@link GyphyResponse}
 */

public class GyphyDeserializer implements JsonDeserializer<GyphyMinify> {

    @Override
    public GyphyMinify deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        GyphyMinify gyphy = new GyphyMinify();
        final JsonObject jsonRoot = json.getAsJsonObject();
        final JsonArray jsonData = jsonRoot.get("data").getAsJsonArray();
        final JsonObject jsonDescription = jsonData.get(0).getAsJsonObject();
        final JsonObject jsonUser = jsonDescription.getAsJsonObject("user");
        final JsonObject jsonImages = jsonDescription.getAsJsonObject("images");
        final JsonObject jsonFixedHeight = jsonImages.getAsJsonObject("fixed_height");

        gyphy.setType(jsonDescription.get("type").getAsString());
        gyphy.setSource(jsonDescription.get("source").getAsString());
        gyphy.setUsername(jsonUser.get("username").getAsString());
        gyphy.setTitle(jsonUser.get("display_name").getAsString());
        gyphy.setUrl(jsonFixedHeight.get("url").getAsString());

        return gyphy;
    }
}
