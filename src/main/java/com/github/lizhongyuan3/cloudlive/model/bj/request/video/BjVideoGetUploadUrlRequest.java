package com.github.lizhongyuan3.cloudlive.model.bj.request.video;

import com.github.lizhongyuan3.cloudlive.model.CommonRequest;
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
public class BjVideoGetUploadUrlRequest extends CommonRequest {
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 目标清晰度(16:标清 1:高清 2:超清 4:720p 8:1080p 多种清晰度用英文逗号分隔)
     */
    private String definition;
    /**
     * 是否作为音频处理 0：否 1：是
     */
    private Integer audioWithView;
    /**
     * 转码格式（1:mp4 2:flv 4:m3u8 多种格式用英文逗号分隔）默认是3种格式都转
     */
    private String format;
    /**
     * 是否生成加密格式视频/音频1:是 2:否（该功能需要申请加密视频/音频的权限，开通加密视频/音频权限后，默认都会加密）
     */
    private Integer encrypt;
    /**
     * 是否使用https上传地址，默认不使用
     */
    private Integer useHttps;
}
