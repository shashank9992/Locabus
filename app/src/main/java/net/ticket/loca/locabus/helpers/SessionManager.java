package net.ticket.loca.locabus.helpers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import net.ticket.loca.locabus.screens.LoginNormalActivity;

import java.util.HashMap;


public class SessionManager {
    public static final String USERNAME = "username";
    public static final String MOBILE_NO = "mobile";
    public static final String GPC_CODE = "gpc";
    public static final String fullname = "fullname";
    public static final String LASTNAME = "lastname";
    public static final String IS_PINACTIVE = "isPinActive";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String USER_ID = "user_id";
    private static final String PREF_NAME = "ActivityFlag";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String EMAIL = "email";
    public static final String PERMISSION_GRANT = "m_permission";
    public static final String MANTIS_ACCESS_TOKEN="token";
    public static final String SLANG_LOCALE="slang_locale";
    public static final String LANGUAGE="language";
    // Shared Preferences
    SharedPreferences pref;
    Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;


    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void createLoginSession(String access_token, String Mobile, String email,
                                   String Firstname, String userid) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(ACCESS_TOKEN, access_token);
        editor.putString(MOBILE_NO, Mobile);
        editor.putString(fullname, Firstname);
        editor.putString(EMAIL, email);
        editor.putString(USER_ID, userid);
        editor.putBoolean(PERMISSION_GRANT, false);
        editor.commit();
    }

    public void setPermssionGrant(boolean val) {
        editor.putBoolean(PERMISSION_GRANT, val);
        editor.commit();
    }

    public void setSlangLocale(String locale){
        editor.putString(SLANG_LOCALE,locale);
        editor.commit();
    }

    public void setAppLocale(String locale){
        editor.putString(LANGUAGE,locale);
        editor.commit();
    }

    public String getSlangLocale(){
        return pref.getString(SLANG_LOCALE,"none");
    }

    public String getAppLocale(){
        return pref.getString(LANGUAGE,"en");
    }


    public HashMap<String, String> getLoginData() {

        HashMap<String, String> getParam = new HashMap<>();
        getParam.put(ACCESS_TOKEN, pref.getString(ACCESS_TOKEN, ""));
        getParam.put(MOBILE_NO, pref.getString(MOBILE_NO, ""));
        getParam.put(fullname, pref.getString(MOBILE_NO, ""));
        getParam.put(EMAIL, pref.getString(MOBILE_NO, ""));
        getParam.put(USER_ID, pref.getString(USER_ID, ""));
        return getParam;
    }

    public String getMantisToken(){

        return pref.getString(MANTIS_ACCESS_TOKEN,"");
    }

    public void createMantisToken(String token){

        editor.putString(MANTIS_ACCESS_TOKEN,token);
        editor.commit();
    }

    public String getUserId() {

        return pref.getString(USER_ID, "");
    }

    public String getUserName() {
        return pref.getString(fullname, "");
    }

    public boolean getPremission() {
        return pref.getBoolean(PERMISSION_GRANT, false);
    }

    public String getUserEmail() {

        return pref.getString(EMAIL, "");
    }

    public String getUserMobile() {

        return pref.getString(MOBILE_NO, "");
    }

    public String getAccessToken() {

        return pref.getString(ACCESS_TOKEN, "");
    }

    public void logout() {

        editor.clear();
        editor.commit();
    }


    public void checkLogin() {
        // Check login status
        if (!this.isLoggedIn()) {
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, LoginNormalActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);


            // Staring Login Activity
            _context.startActivity(i);
        }

    }


    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();

        editor.commit();

        Intent i = new Intent(_context, LoginNormalActivity.class);
        _context.startActivity(i);

        // After logout redirect user to Loing Activity
//        Intent i = new Intent(_context, LoginActivity.class);
//        // Closing all the Activities
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        // Add new Flag to start new Activity
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        // Staring Login Activity
//        _context.startActivity(i);

    }


    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }


    public void updateProfile(String name,String email,String mobile) {
        editor.putString(MOBILE_NO, mobile);
        editor.putString(fullname, name);
        editor.putString(EMAIL, email);
        editor.commit();
    }
}