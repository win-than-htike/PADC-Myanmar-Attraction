package xyz.winthanhtike.padc_myanmarattractions.utils;

import com.google.gson.Gson;

/**
 * Created by winthanhtike on 7/6/16.
 */
public class CommonInstances {

    private static Gson gson = new Gson();

    public static Gson getGson() {
        return gson;
    }
}
