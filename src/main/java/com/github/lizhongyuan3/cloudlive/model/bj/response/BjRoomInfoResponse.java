package com.github.lizhongyuan3.cloudlive.model.bj.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.lizhongyuan3.cloudlive.model.CommonResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author lizhongyuan
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BjRoomInfoResponse extends CommonResponse {
    /**
     * 房间id
     */
    private Long roomId;
    /**
     * 直播课标题
     */
    private String title;
    /**
     * 开课时间，格式如：2017-08-18 14:00:00
     */
    @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    /**
     * 结束时间，格式如：2017-08-18 14:00:00
     */
    @JsonFormat(timezone = "GMT+8", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    /**
     * 1:一对一课 2:大班课
     */
    private Integer type;
    /**
     * 直播间允许的最大人数
     */
    private Integer maxUsers;
    /**
     * 管理员进入直播间的参加码
     */
    private String adminCode;
    /**
     * 老师进入直播间的参加码
     */
    private String teacherCode;
}
