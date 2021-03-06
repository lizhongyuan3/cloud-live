package com.github.lizhongyuan3.cloudlive.serivce;

import com.github.lizhongyuan3.cloudlive.model.*;
import com.github.lizhongyuan3.cloudlive.model.bj.response.callback.BjVideoAccountTranscodeCallbackUrlResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.response.playback.BjPlayBackGetBasicInfoResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.response.room.*;
import com.github.lizhongyuan3.cloudlive.model.bj.response.video.*;

import java.util.Map;

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
    /**
     * 获取视频/音频上传地址
     * @param request request
     * @return 请求结果
     */
    @Override
    BjVideoGetUploadUrlResponse videoGetUploadUrl(CommonRequest request);
    /**
     * 获取视频详情
     * @param request request
     * @return 请求结果
     */
    @Override
    BjVideoGetInfoResponse videoGetInfo(CommonRequest request);
    /**
     * 设置转码回调地址（点播和回放）
     * @param request request
     * @return 请求结果
     */
    @Override
    BjVideoAccountTranscodeCallbackUrlResponse videoAccountGetTranscodeCallbackUrl(CommonRequest request);
    /**
     * 获取回放详情
     * @param request request
     * @return 请求结果
     */
    @Override
    BjPlayBackGetBasicInfoResponse playBackGetBasicInfo(CommonRequest request);
}
