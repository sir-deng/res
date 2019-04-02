//package com.helen.mytest.api;
//
//
//import com.google.gson.Gson;
//import com.google.gson.TypeAdapter;
//import com.google.gson.reflect.TypeToken;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Type;
//
//import okhttp3.RequestBody;
//import okhttp3.ResponseBody;
//import retrofit2.Converter;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonRequestBodyConverter;
//import retrofit2.converter.gson.GsonResponseBodyConverter;
//
//public class CustomConverterFactory extends Converter.Factory {
//    /**
//     * Create an instance using a default {@link Gson} instance for conversion. Encoding to JSON and
//     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
//     */
//
//    /**
//     * Create an instance using {@code gson} for conversion. Encoding to JSON and
//     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
//     */
//    public static CustomConverterFactory create() {
//        return new CustomConverterFactory();
//    }
//
//
//    private CustomConverterFactory() {
//    }
//
//    @Override
//    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
//                                                            Retrofit retrofit) {
//        return new CustomConverterFactory<>(adapter);
//    }
//
//    @Override
//    public Converter<?, RequestBody> requestBodyConverter(Type type,
//                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
////        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
//        return new GsonRequestBodyConverter<>(gson, adapter);
//    }
//}
