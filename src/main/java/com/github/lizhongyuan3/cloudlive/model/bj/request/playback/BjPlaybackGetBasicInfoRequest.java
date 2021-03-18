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
public class BjPlaybackGetBasicInfoRequest extends CommonRequest {
    /**
     * 教室号
     */
    private Long roomId;

}
