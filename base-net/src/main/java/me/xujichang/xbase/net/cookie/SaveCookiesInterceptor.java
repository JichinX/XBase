package me.xujichang.xbase.net.cookie;

import java.io.IOException;
import java.util.HashSet;
import java.util.prefs.Preferences;

import me.xujichang.xbase.net.ext.NetPrefUtil;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Des:XBase - me.xujichang.xbase.net.cookie
 *
 * @author xujichang
 * @date 2019/3/1
 * <p>
 * modify:
 */
public class SaveCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            cookies.addAll(originalResponse.headers("Set-Cookie"));

            NetPrefUtil.getDefault().edit()
                    .putStringSet(NetPrefUtil.PREF_COOKIES, cookies)
                    .apply();
        }

        return originalResponse;
    }
}
