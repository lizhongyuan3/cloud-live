package com.github.lizhongyuan3.cloudlive.serivce;

import cn.hutool.json.JSONObject;
import com.github.lizhongyuan3.cloudlive.model.CommonRequest;
import com.github.lizhongyuan3.cloudlive.model.CommonResponse;

import java.util.Map;

/**
 * @author lizhongyuan
 */
public interface CloudLiveService {
    /**
     * 创建课堂
     * @param request request
     * @return 请求结果
     */
    CommonResponse roomCreate(CommonRequest request);
    /**
     * 更新房间信息
     * @param request request
     * @return 请求结果
     */
    Void roomUpdate(CommonRequest request);
    /**
     * 删除课堂
     * @param request request
     * @return 请求结果
     */
    Void roomDelete(CommonRequest request);
    /**
     * 获取房间信息
     * @param request request
     * @return 请求结果
     */
    CommonResponse roomInfo(CommonRequest request);
    /**
     * 生成用户参加码
     * @param request request
     * @return 请求结果
     */
    CommonResponse roomGetCode(CommonRequest request);
    /**
     * 获取视频/音频上传地址
     * @param request request
     * @return 请求结果
     */
    CommonResponse videoGetUploadUrl(CommonRequest request);
    /**
     * 批量获取播放器token
     * @param request request
     * @return 请求结果
     */
    Map<String, String> videoGetPlayerTokenBatch(CommonRequest request);
    /**
     * 更新视频信息
     * @param request request
     */
    void videoUpdate(CommonRequest request);
    /**
     * 删除视频信息
     * @param request request
     */
    void videoDelete(CommonRequest request);
    /**
     * 获取视频详情
     * @param request request
     * @return 请求结果
     */
    CommonResponse videoGetInfo(CommonRequest request);
    /**
     * 批量获取回放token
     * @param request request
     * @return 请求结果
     */
    Map<String, String> playbackGetPlayerTokenBatch(CommonRequest request);
    /**
     * 更新回放信息
     * @param request request
     */
    void playbackUpdate(CommonRequest request);
    /**
     * 删除回放信息
     * @param request request
     */
    void playbackDelete(CommonRequest request);
    /**
     * 获取回放详情
     * @param request request
     * @return 请求结果
     */
    CommonResponse playBackGetBasicInfo(CommonRequest request);
    /**
     * 设置转码回调地址（点播和回放）
     * @param request request
     */
    void videoAccountSetTranscodeCallbackUrl(CommonRequest request);
    /**
     * 查询转码回调地址（点播和回放）
     * @param request request
     * @return 请求结果
     */
    CommonResponse videoAccountGetTranscodeCallbackUrl(CommonRequest request);
}
