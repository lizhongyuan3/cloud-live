package com.github.lizhongyuan3.cloudlive.model.bj.request.room;

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
public class BjRoomGetCodeRequest extends CommonRequest {
    /**
     * 房间ID，14位
     */
    private Long roomId;
    /**
     * 合作方账号体系下的用户ID号，必须是数字
     */
    private Long userNumber;
    /**
     * 用户头像，需要完整的url地址
     */
    private String userAvatar;
    /**
     * 将已生成的试听参加码状态转为正式参加码，传值为：1
     */
    private Integer updateAuditionType;

}