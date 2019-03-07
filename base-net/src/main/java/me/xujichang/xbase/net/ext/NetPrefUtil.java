package me.xujichang.xbase.net.ext;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.core.content.ContextCompat;

/**
 * Des:XBase - me.xujichang.xbase.net.ext
 *
 * @author xujichang
 * @date 2019/3/1
 * <p>
 * modify:
 */
public class NetPrefUtil {

    private static Application sApplication;

    public static void init(Application application) {
        sApplication = application;
    }

    public static NetPrefUtil getInstance() {
        return classHolder.sNetPrefUtil;
    }

    public static SharedPreferences getDefault() {
        return getInstance().getDefaultPreferences();
    }

    static class classHolder {
        public static NetPrefUtil sNetPrefUtil = new NetPrefUtil();
    }

    public static final String PREF_COOKIES = "cookies";

    public SharedPreferences getDefaultPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(sApplication);
    }
}
