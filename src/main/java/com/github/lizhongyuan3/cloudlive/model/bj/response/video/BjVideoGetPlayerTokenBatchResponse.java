package com.github.lizhongyuan3.cloudlive.model.bj.response.video;

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
public class BjVideoGetPlayerTokenBatchResponse extends CommonResponse {
    /**
     * 视频/音频ID
     */
    private Integer videoId;
    /**
     * 视频/音频上传地址
     */
    private String uploadUrl;
}
