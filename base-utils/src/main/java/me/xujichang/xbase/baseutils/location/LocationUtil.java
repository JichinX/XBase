package me.xujichang.xbase.baseutils.location;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;

import androidx.core.content.ContextCompat;

/**
 * Des:XBase - me.xujichang.XBase.baseutils.location
 * 位置相关
 *
 * @author xujichang
 * @date 2019/1/21 19:52
 * <p>
 * modify:
 */
public class LocationUtil {
    @SuppressLint("MissingPermission")
    public static void registerLocationChangedListener(Context context, long minTimeMs,
                                                       int minDistance, SelfLocationListener listener) {
        LocationManager locationManager = ContextCompat.getSystemService(context,
                LocationManager.class);
        if (null == locationManager) {
            return;
        }
        boolean use = false;
        use = tryUseNetWorkProvider(locationManager, minTimeMs, minDistance, listener) ||
                tryUseGpsProvider(locationManager, minTimeMs, minDistance, listener);
        if (!use) {
            listener.onNoProviderUseful();
        }
    }

    private static boolean tryUseGpsProvider(LocationManager manager, long minTimeMs,
                                             int minDistance, SelfLocationListener listener) {
        return tryUseProvider(manager, LocationManager.GPS_PROVIDER, minTimeMs, minDistance, listener);
    }

    private static boolean tryUseNetWorkProvider(LocationManager manager, long minTimeMs,
                                                 int minDistance, LocationListener listener) {
        return tryUseProvider(manager, LocationManager.NETWORK_PROVIDER, minTimeMs, minDistance,
                listener);
    }

    @SuppressLint("MissingPermission")
    private static boolean tryUseProvider(LocationManager manager, String provider,
                                          long minTimeMs, int minDistance, LocationListener listener) {
        if (manager.getAllProviders().contains(provider)) {
            if (manager.isProviderEnabled(provider)) {
                manager.requestLocationUpdates(provider, minTimeMs,
                        minDistance, listener);
                return true;
            }
        }
        return false;
    }
}
