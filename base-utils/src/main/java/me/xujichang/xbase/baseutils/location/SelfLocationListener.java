package me.xujichang.xbase.baseutils.location;

import android.location.LocationListener;

/**
 * Des:XBase - me.xujichang.XBase.baseutils.location
 *
 * @author xujichang
 * @date 2019/1/21 20:07
 * <p>
 * modify:
 */
public interface SelfLocationListener extends LocationListener {
    void onNoProviderUseful();
}
