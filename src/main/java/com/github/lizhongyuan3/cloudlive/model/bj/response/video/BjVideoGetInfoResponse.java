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
public class BjVideoGetInfoResponse extends CommonResponse {
    /**
     * 视频/音频ID
     */
    private Integer videoId;
    /**
     * 视频状态码（10:上传中 20:转码中 30:转码失败 31:转码超时 32:上传超时 100:转码成功）
     */
    private Integer status;
    /**
     * 视频时长 单位：秒
     */
    private Integer length;
}
