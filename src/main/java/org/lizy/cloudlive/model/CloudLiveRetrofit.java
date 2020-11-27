package org.lizy.cloudlive.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.lizy.cloudlive.config.BjConfig;
import org.lizy.cloudlive.config.BusException;
import org.lizy.cloudlive.config.ErrorCode;
import org.lizy.cloudlive.enums.CloudLivePlatformEnum;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Objects;

/**
 * @author lizhongyuan
 */
public class CloudLiveRetrofit {

    private BjConfig bjConfig;

    public void setBjConfig(BjConfig bjConfig) {
        this.bjConfig = bjConfig;
    }

    public Retrofit getRetrofit() {
        if (Objects.equals(CloudLivePlatformEnum.BJ.getCode(), bjConfig.getCloudLivePlatform())) {
            // https://e41359928.at.baijiayun.com
            return new Retrofit.Builder()
                    .baseUrl(bjConfig.getBaseUrl())
                    .addConverterFactory(
                            JacksonConverterFactory.create(
                                    new ObjectMapper()
                                            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                            )
                    )
                    .client(new OkHttpClient
                                    .Builder().addInterceptor(
                            new HttpLoggingInterceptor()
                                    .setLevel(HttpLoggingInterceptor.Level.BODY)
                            )

                                    .build()
                    )
                    .build();
        }
        throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, "错误的直播选择方式");
    }
}
