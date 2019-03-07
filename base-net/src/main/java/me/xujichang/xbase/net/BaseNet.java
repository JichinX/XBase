package me.xujichang.xbase.net;

import android.app.Application;

import me.xujichang.xbase.base.ModuleBase;
import me.xujichang.xbase.net.ext.NetPrefUtil;

/**
 * Des:XBase - me.xujichang.xbase.net
 *
 * @author xujichang
 * @date 2019/1/22 10:12
 * <p>
 * modify:
 */
public class BaseNet implements ModuleBase {

    @Override
    public void initFirst(Application application) {
        NetPrefUtil.init(application);
    }

    @Override
    public void initSlow(Application application) {

    }
}
