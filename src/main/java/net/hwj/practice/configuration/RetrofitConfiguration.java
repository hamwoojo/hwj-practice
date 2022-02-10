package net.hwj.practice.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.hwj.practice.model.ApiInterface;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
public class RetrofitConfiguration {

    @Autowired
    private Interceptor dcatMapperInterceptor;


    @Bean("dcatMapperOkHttpClient")
    public OkHttpClient dcatMapperOkHttpClient() {

        return new OkHttpClient.Builder()
                .addInterceptor(dcatMapperInterceptor)
                .connectTimeout(30, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.MINUTES)
                .build();
    }

    @Bean("dcatMapperObjectMapper")
    public ObjectMapper dcatMapperObjectMapper() {

        return Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .modules(new JavaTimeModule())
                .build();
    }

    @Bean("dcatMapperRetrofit")
    public Retrofit dcatMapperRetrofit(

            @Qualifier("dcatMapperObjectMapper") ObjectMapper dcatMapperObjectMapper,
            @Qualifier("dcatMapperOkHttpClient") OkHttpClient dcatMapperOkHttpClient
    ) {

        return new Retrofit.Builder()

                .baseUrl("http://localhost:18080")
                .addConverterFactory(JacksonConverterFactory.create(dcatMapperObjectMapper))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(dcatMapperOkHttpClient)
                .build();
    }

    @Bean("apiRetrofit")
    public Retrofit apiRetrofit(
            @Qualifier("dcatMapperOkHttpClient") OkHttpClient apiOkHttpClient
    ) {

        return new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(apiOkHttpClient)
                .build();
    }


    @Bean("ApiInterface")
    public ApiInterface apiInterface(

            @Qualifier("apiRetrofit") Retrofit apiRetrofit
    ) {
        return apiRetrofit.create(ApiInterface.class);
    }
}
