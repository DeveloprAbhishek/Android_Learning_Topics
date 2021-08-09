package com.example.unit_2c_2;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    private static final String SHARED_PREFERENCE_KEY = "com.xyz.sharedpreferences";

    public static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE);
    }

    public static void writeStringToPreference(Context context, String key, String value) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStringFromPreference(Context context, String key) {
        return getSharedPreference(context).getString(key, null);
    }
}
