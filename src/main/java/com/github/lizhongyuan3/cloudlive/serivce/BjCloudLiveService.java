package com.github.lizhongyuan3.cloudlive.serivce;

import com.github.lizhongyuan3.cloudlive.model.*;
import com.github.lizhongyuan3.cloudlive.model.bj.response.*;

/**
 * @author lizhongyuan
 */
public interface BjCloudLiveService extends CloudLiveService {
    /**
     * 创建课堂
     * @param request request
     * @return 请求结果
     */
    @Override
    BjRoomCreateResponse roomCreate(CommonRequest request);
    /**
     * 更新房间信息
     * @param request request
     * @return 请求结果
     */
    @Override
    Void roomUpdate(CommonRequest request);
    /**
     * 删除课堂
     * @param request request
     * @return 请求结果
     */
    @Override
    Void roomDelete(CommonRequest request);
    /**
     * 获取房间信息
     * @param request request
     * @return 请求结果
     */
    @Override
    BjRoomInfoResponse roomInfo(CommonRequest request);
    /**
     * 生成用户参加码
     * @param request request
     * @return 请求结果
     */
    @Override
    BjRoomGetCodeResponse roomGetCode(CommonRequest request);
}
