package com.github.lizhongyuan3.cloudlive.config;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author lizhongyuan
 */
@Data
@Builder
public class BjConfig {
    private Integer partnerId;
    private String partnerKey;
    private String baseUrl;
    private HttpLoggingInterceptor.Level logLevel;
    private Integer cloudLivePlatform;
    @Tolerate
    public BjConfig(){}
}
