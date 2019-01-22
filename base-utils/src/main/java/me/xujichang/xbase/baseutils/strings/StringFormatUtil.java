package me.xujichang.xbase.baseutils.strings;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Des:XBase - me.xujichang.XBase.baseutils.strings
 * 对字符串进行各种格式化
 *
 * @author xujichang
 * @date 2019/1/21 21:06
 * <p>
 * modify:
 */
public class StringFormatUtil {
    public static String formatTime(long time) {

        return formatTime(time, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatTime(long time, String pattern) {
        if (time == 0L) {
            return "未知";
        }
        SimpleDateFormat sDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        return sDateFormat.format(new java.util.Date(time));
    }
}
