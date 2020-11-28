package com.github.lizhongyuan3.cloudlive.model.bj.request;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author lizhongyuan
 */
@Data
@Builder
public class BjCreateRoomRequest {
    private Integer partnerId;
    private String title;
    private Long startTime;
    private Long endTime;
    private Integer type;
    private Long timestamp;
    private String sign;
    @Tolerate
    public BjCreateRoomRequest() {}
}