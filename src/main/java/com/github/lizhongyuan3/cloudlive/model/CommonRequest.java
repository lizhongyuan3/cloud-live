package com.github.lizhongyuan3.cloudlive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author lizhongyuan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CommonRequest {
    private Integer partnerId;
    private Long timestamp;
    private String sign;
}
