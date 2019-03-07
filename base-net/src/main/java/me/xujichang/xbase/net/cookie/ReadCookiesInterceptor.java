package me.xujichang.xbase.net.cookie;

import android.util.Log;

import java.io.IOException;
import java.util.HashSet;
import java.util.prefs.Preferences;

import me.xujichang.xbase.net.ext.NetPrefUtil;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Des:XBase - me.xujichang.xbase.net.cookie
 *
 * @author xujichang
 * @date 2019/3/1
 * <p>
 * modify:
 */
public class ReadCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> preferences = (HashSet) NetPrefUtil.getDefault().getStringSet(NetPrefUtil.PREF_COOKIES, new HashSet<>());
        for (String cookie : preferences) {
            // This is done so I know which headers are being added; this interceptor is used after the normal logging of OkHttp
            builder.addHeader("Cookie", cookie);
            Log.v("OkHttp", "Adding Header: " + cookie);
        }

        return chain.proceed(builder.build());
    }
}
