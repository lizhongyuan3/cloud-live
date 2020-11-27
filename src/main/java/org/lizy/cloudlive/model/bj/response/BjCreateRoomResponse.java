package org.lizy.cloudlive.model.bj.response;

import lombok.Data;

/**
 * @author lizhongyuan
 */
@Data
public class BjCreateRoomResponse {
    private String roomId;
    private String adminCode;
    private String teacherCode;
    private String studentCode;
    private String baseUrlPrefix;
}
