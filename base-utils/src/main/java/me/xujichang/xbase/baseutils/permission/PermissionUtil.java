package me.xujichang.xbase.baseutils.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.google.common.collect.Lists;

import java.util.List;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * Des:XBase - me.xujichang.XBase.baseutils.permission
 * 权限申请 统一封装类
 *
 * @author xujichang
 * @date 2019/1/21 13:52
 * <p>
 * modify:
 */
public class PermissionUtil {
    //=================================检测==================================

    /**
     * 检测权限
     */
    public static boolean checkPermission(Context context, String permission) {
        return checkPermission(context, new String[]{permission});
    }

    /**
     * 检测多个权限
     *
     * @param context     上下文
     * @param permissions 允许的权限
     * @return
     */
    public static boolean checkPermission(Context context, String[] permissions) {
        //结果
        final boolean[] result = {false};
        CheckCallBack checkCallBack = new SimpleCheckCallback() {
            @Override
            public void onResult(boolean pResult, List<String> granted, List<String> denied, List<String> canGrantedAgain) {
                result[0] = pResult;
            }
        };
        checkPermission(context, permissions, checkCallBack);
        return result[0];
    }

    /**
     * 带回调参数的 权限检测
     *
     * @param context
     * @param permissions
     * @param callBack
     */
    public static void checkPermission(Context context, String[] permissions, CheckCallBack callBack) {
        //申请的权限为空
        if (null == permissions || permissions.length == 0) {
            callBack.onNothingCheck();
            return;
        }
        List<String> granted         = Lists.newArrayList();
        List<String> denied          = Lists.newArrayList();
        List<String> canGrantedAgain = Lists.newArrayList();
        //遍历
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
                granted.add(permission);
            } else {
                if (permissionReminder(context, permission)) {
                    canGrantedAgain.add(permission);
                } else {
                    denied.add(permission);
                }
            }
        }
        callBack.onResult(denied.size() == 0, granted, denied, canGrantedAgain);
    }

    /**
     * 单个带回调参数的权限检测
     *
     * @param context
     * @param permission
     * @param callBack
     */
    public static void checkPermission(Context context, String permission, CheckCallBack
            callBack) {
        checkPermission(context, new String[]{permission}, callBack);
    }
    //=================================申请==================================

    public static void requestPermission(Context context, String permission, int requestCode) {
        requestPermission(context, new String[]{permission}, requestCode);
    }

    public static void requestPermission(Context context, String[] permissions, int requestCode) {
        ActivityCompat.requestPermissions((Activity) context, permissions, requestCode);
    }

    public static boolean permissionReminder(Context context, String permission) {
        return ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permission);
    }

    //=================================检测并申请==================================

    public static void checkAndRequestPermission(Context context, String permission, int requestCode) {
        if (!checkPermission(context, permission)) {
            requestPermission(context, permission, requestCode);
        }
    }

    public static void checkAndRequestPermission(Context context, String[] permissions,
                                                 int requestCode) {
        if (!checkPermission(context, permissions)) {
            requestPermission(context, permissions, requestCode);
        }
    }

    //=================================对权限申请回调的处理==================================

    public static void onRequestPermissionResult(Context context, String permission,
                                                 CheckCallBack callBack) {
        checkPermission(context, permission, callBack);
    }

    public static void onRequestPermissionResult(Context context, String[] permissions,
                                                 CheckCallBack callBack) {
        checkPermission(context, permissions, callBack);
    }

    /**
     * 判断权限是否申请成功
     */
    public static boolean isPermissionRequestSuccess(int[] grantResults) {
        if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 跳转到权限设置界面
     */
    public static void toAppSetting(Context context) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        context.startActivity(intent);
    }
}
