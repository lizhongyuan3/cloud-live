package com.github.lizhongyuan3.cloudlive.model.bj.response.playback;

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
public class BjPlayBackGetBasicInfoResponse extends CommonResponse {
    /**
     * 云端录制视频ID
     */
    private Integer videoId;
    /**
     * 回放状态码 0:回放未生成 10:回放生成中 20:转码中 30:回放生成失败 100:回放生成成功。回放未生成的没有video_id等其它信息
     */
    private Integer status;
    /**
     * 视频时长（单位为秒）
     */
    private Integer length;
}
