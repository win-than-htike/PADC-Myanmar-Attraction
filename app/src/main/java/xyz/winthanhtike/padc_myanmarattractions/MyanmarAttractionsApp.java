package xyz.winthanhtike.padc_myanmarattractions;

import android.app.Application;
import android.content.Context;

/**
 * Created by winthanhtike on 7/6/16.
 */
public class MyanmarAttractionsApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this.getApplicationContext();

    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        context = null;

    }

    public static Context getContext() {
        return context;
    }
}
