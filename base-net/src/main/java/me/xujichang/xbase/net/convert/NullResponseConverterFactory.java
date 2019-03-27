package me.xujichang.xbase.net.convert;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
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
public abstract class NullResponseConverterFactory<T> extends Converter.Factory {
    @Override
    public Converter<ResponseBody, T> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        final Converter<ResponseBody, T> next = retrofit.nextResponseBodyConverter(this, type, annotations);
        return new Converter<ResponseBody, T>() {
            @Override
            public T convert(ResponseBody body) throws IOException {
                long contentLength = body.contentLength();
                if (contentLength == 0) {
                    return convertNull();
                }
                return next.convert(body);
            }
        };
    }

    protected abstract T convertNull();
}
