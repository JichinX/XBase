package me.xujichang.xbase.baseutils.permission;

import java.util.List;

/**
 * Des:XBase - me.xujichang.XBase.baseutils.permission
 * 检测权限的回调
 *
 * @author xujichang
 * @date 2019/1/21 14:03
 * <p>
 * modify:
 */
public interface CheckCallBack {
    /**
     * 权限为空的请求
     */
    void onNothingCheck();

    void onResult(boolean result, List<String> granted, List<String> denied, List<String> canGrantedAgain);
}
