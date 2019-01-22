package me.xujichang.xbase.baseutils.permission;

import java.util.List;

/**
 * Des:XBase - me.xujichang.XBase.baseutils.permission
 *
 * @author xujichang
 * @date 2019/1/21 14:29
 * <p>
 * modify:
 */
public class SimpleCheckCallback implements CheckCallBack {
    @Override
    public void onNothingCheck() {

    }

    @Override
    public void onResult(boolean result, List<String> granted, List<String> denied, List<String> canGrantedAgain) {

    }
}
