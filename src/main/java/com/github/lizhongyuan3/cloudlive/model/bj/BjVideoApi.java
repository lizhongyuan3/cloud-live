package com.github.lizhongyuan3.cloudlive.model.bj;

import cn.hutool.json.JSONObject;
import com.github.lizhongyuan3.cloudlive.model.bj.response.video.BjVideoGetInfoResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.response.video.BjVideoGetUploadUrlResponse;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

/**
 * @author lizhongyuan
 */
public interface BjVideoApi {
    /**
     * 获取视频/音频上传地址
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/video/getUploadUrl")
    Call<BjResponse<BjVideoGetUploadUrlResponse>> videoGetUploadUrl(@FieldMap Map<String, Object> map);

    /**
     * 批量获取播放器token
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/video/getPlayerTokenBatch")
    Call<BjResponse<Map<String, String>>> videoGetPlayerTokenBatch(@FieldMap Map<String, Object> map);

    /**
     * 更新视频信息
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/video/update")
    Call<BjResponse<JSONObject>> videoUpdate(@FieldMap Map<String, Object> map);

    /**
     * 删除视频信息
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/video/delete")
    Call<BjResponse<JSONObject>> videoDelete(@FieldMap Map<String, Object> map);

    /**
     * 获取指定ID视频信息
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/video/getInfo")
    Call<BjResponse<BjVideoGetInfoResponse>> videoGetInfo(@FieldMap Map<String, Object> map);
}
