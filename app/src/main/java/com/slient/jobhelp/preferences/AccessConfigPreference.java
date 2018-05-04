package com.slient.jobhelp.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.slient.jobhelp.configs.ConfigPreference;

/**
 * Created by silent on 5/3/2018.
 */
public class AccessConfigPreference {

    private static AccessConfigPreference accessConfigPreference;
    private SharedPreferences sharedPreferences;

    public static AccessConfigPreference getInstance(Context context) {
        if(accessConfigPreference == null){
            accessConfigPreference = new AccessConfigPreference(context);
        }
        return accessConfigPreference;
    }

    private AccessConfigPreference(Context context){
        this.sharedPreferences = context.getSharedPreferences(ConfigPreference.NAME_PREFERENCE, Context.MODE_PRIVATE);
    }

    public boolean firstLauncher(){
        boolean firstLauncher = sharedPreferences.getBoolean(ConfigPreference.FIRST_LAUNCHER,false);
        if(!firstLauncher){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(ConfigPreference.FIRST_LAUNCHER, true);
            editor.apply();
            return true;
        }
        return false;
    }
}
