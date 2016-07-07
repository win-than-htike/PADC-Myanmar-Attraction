package xyz.winthanhtike.padc_myanmarattractions.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

import xyz.winthanhtike.padc_myanmarattractions.MyanmarAttractionsApp;

/**
 * Created by winthanhtike on 7/6/16.
 */
public class JsonUtils {

    private static String PATH_DUMMY_DATA = "dummy_data";

    public static JsonUtils objInstance;

    private Context context;

    public static JsonUtils getInstance(){

        if (objInstance == null){
            objInstance = new JsonUtils();
        }
        return objInstance;
    }

    private JsonUtils() {
        this.context = MyanmarAttractionsApp.getContext();
    }

    private byte[] readJsonFile(String filename) throws IOException {

        //open json file
        InputStream inStream = context.getAssets().open(filename);

        //create json size
        int size = inStream.available();

        //create json byte array
        byte[] buffer = new byte[size];

        //read json
        inStream.read(buffer);

        return buffer;

    }

    public String loadDummyData(String filename) throws IOException {
        byte[] buffer = readJsonFile(PATH_DUMMY_DATA + "/" + filename);
        return new String(buffer,"UTF-8").toString();
    }

}
