package me.xujichang.xbase.net.convert;


/**
 * Des:XBase - me.xujichang.xbase.net.convert
 *
 * @author xujichang
 * @date 2019/3/7
 * <p>
 * modify:
 */
public class NullOnEmptyConverterFactory extends NullResponseConverterFactory<String> {

    @Override
    protected String convertNull() {
        return "";
    }
}