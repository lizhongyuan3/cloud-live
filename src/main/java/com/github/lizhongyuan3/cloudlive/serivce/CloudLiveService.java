package com.github.lizhongyuan3.cloudlive.serivce;

import com.github.lizhongyuan3.cloudlive.model.bj.request.BjCreateRoomRequest;
import com.github.lizhongyuan3.cloudlive.model.bj.response.BjCreateRoomResponse;

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
