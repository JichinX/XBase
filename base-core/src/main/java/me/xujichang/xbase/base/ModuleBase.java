package me.xujichang.xbase.base;

import android.app.Application;

/**
 * Des:XBase - me.xujichang.XBase.base
 *
 * @author xujichang
 * @date 2019/1/18 11:08
 * <p>
 * modify:
 */
public interface ModuleBase {

    void initFirst(Application application);

    void initSlow(Application application);
}
