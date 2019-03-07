package me.xujichang.xbase.net.wrapper;

/**
 * Des:EGSApp - com.codvision.egsapp.ext
 *
 * @author xujichang
 * @date 2019/2/28
 * <p>
 * modify:
 */
public interface IWrapper<T> {
    int get_Code();

    String get_Msg();

    T get_Data();
}
