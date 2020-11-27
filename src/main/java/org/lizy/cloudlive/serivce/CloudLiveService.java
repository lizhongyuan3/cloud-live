package org.lizy.cloudlive.serivce;

import org.lizy.cloudlive.model.bj.request.BjCreateRoomRequest;
import org.lizy.cloudlive.model.bj.response.BjCreateRoomResponse;

/**
 * @author lizhongyuan
 */
public interface CloudLiveService {
    /**
     * 创建课堂
     * @param request request
     * @return 请求结果
     */
    BjCreateRoomResponse createRoom(BjCreateRoomRequest request);
}
