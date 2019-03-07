package me.xujichang.xbase.net.cookie;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Des:XBase - me.xujichang.xbase.net.cookie
 *
 * @author xujichang
 * @date 2019/3/1
 * <p>
 * modify:
 */
public class CookieManager implements CookieJar {
    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {

    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        return null;
    }
}
