package com.github.lizhongyuan3.cloudlive.model.bj.request.playback;

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
public class BjPlaybackGetPlayerTokenBatchRequest extends CommonRequest {
    /**
     * 多个视频ID以英文逗号分隔
     */
    private String roomIds;
    /**
     * 过期时间，以秒为单位。如果传0则表示不过期
     */
    private Integer expiresIn;

}
