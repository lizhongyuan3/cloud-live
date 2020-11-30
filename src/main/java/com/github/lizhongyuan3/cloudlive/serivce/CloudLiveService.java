package com.github.lizhongyuan3.cloudlive.serivce;

import com.github.lizhongyuan3.cloudlive.model.CommonRequest;
import com.github.lizhongyuan3.cloudlive.model.CommonResponse;

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
}
