package com.github.lizhongyuan3.cloudlive.model.bj.response.callback;

import com.github.lizhongyuan3.cloudlive.model.CommonResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author lizhongyuan
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BjVideoAccountTranscodeCallbackUrlResponse extends CommonResponse {
    /**
     * 回调地址，必须是http(s)://开头
     */
    private String url;
}
