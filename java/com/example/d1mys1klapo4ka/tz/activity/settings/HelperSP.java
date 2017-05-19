package com.example.d1mys1klapo4ka.tz.activity.settings;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 1. Использовать Singleton для хранения паролей.
 * 2. Бонусное задание - использовать SharedPreferences.
 */

public class HelperSP {

    private static HelperSP helperSP;

    private HelperSP(){}

    public static HelperSP initialization(){
        if (helperSP == null){

            helperSP = new HelperSP();
        }
        return helperSP;
    }

    private SharedPreferences settings = null;
    private SharedPreferences.Editor editor = null;
    private Context context = null;

    public void init(Context cntxt){
        context = cntxt;
    }

    private void init(){
        String FILE_NAME = "settings";
        settings = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.apply();
    }

    public void setUser( String key, String value ){
        if( settings == null ){
            init();
        }
        editor.putString( key, value );
        editor.apply();
    }

    public String getUser( String key ){
        if( settings == null ){
            init();
        }
        return settings.getString( key, "###########" );
    }

    public boolean settingSearch(String key){
        if( settings == null ){
            init();
        }
        return settings.contains(key);
    }

}
