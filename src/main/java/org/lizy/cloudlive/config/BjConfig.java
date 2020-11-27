package org.lizy.cloudlive.config;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author lizhongyuan
 */
@Data
@Builder
public class BjConfig {
    private Integer partnerId;
    private String partnerKey;
    private String baseUrl;
    private Integer cloudLivePlatform;
    @Tolerate
    public BjConfig(){}
}
