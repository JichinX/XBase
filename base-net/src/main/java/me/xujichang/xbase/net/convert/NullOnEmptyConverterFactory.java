package me.xujichang.xbase.net.convert;


import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Des:XBase - me.xujichang.xbase.net.convert
 *
 * @author xujichang
 * @date 2019/3/7
 * <p>
 * modify:
 */
public class NullOnEmptyConverterFactory extends Converter.Factory {

    public static NullOnEmptyConverterFactory create() {
        return new NullOnEmptyConverterFactory();
    }

    private NullOnEmptyConverterFactory() {

    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
        return new Converter<ResponseBody, Object>() {
            @Override
            public Object convert(ResponseBody body) throws IOException {
                long contentLength = body.contentLength();
                if (contentLength == 0) {
                    return null;
                }
                return delegate.convert(body);
            }
        };
    }
}