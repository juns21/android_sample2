package com.example.c.t02_criminalintent;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by c on 2015-02-01.
 */
public class Photo {
    private static final String JSON_FILENAME = "filename";

    private String mFilename;

    public Photo(String filename) {
        mFilename = filename;
    }

    public Photo(JSONObject json) throws JSONException {
        mFilename = json.getString(JSON_FILENAME);
    }

    public String getFilename() {
        return mFilename;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_FILENAME, mFilename);

        return json;
    }


}
