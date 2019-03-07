package me.xujichang.xbase.base.ext;

import android.app.Application;

import me.xujichang.xbase.base.ModuleBase;


/**
 * Project: Platform
 * Des:
 *
 * @author xujichang
 * created by 2018/7/19 - 9:10 PM
 */
public class InitUtil {
    public static void initModulesSpeed(String[] inits, Application application) {
        try {
            for (String init : inits) {
                Class<?> clazz = Class.forName(init);
                ModuleBase baseInit = (ModuleBase) clazz.newInstance();
                baseInit.initFirst(application);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void initModulesLow(String[] inits, Application application) {
        try {
            for (String init : inits) {
                Class<?> clazz = Class.forName(init);
                ModuleBase baseInit = (ModuleBase) clazz.newInstance();
                baseInit.initSlow(application);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void initModulesSpeed(Class<? extends ModuleBase>[] inits, Application application) {
        try {
            for (Class clazz : inits) {
                ModuleBase baseInit = (ModuleBase) clazz.newInstance();
                baseInit.initFirst(application);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void initModulesLow(Class<? extends ModuleBase>[] inits, Application application) {
        try {
            for (Class clazz : inits) {
                ModuleBase baseInit = (ModuleBase) clazz.newInstance();
                baseInit.initSlow(application);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
