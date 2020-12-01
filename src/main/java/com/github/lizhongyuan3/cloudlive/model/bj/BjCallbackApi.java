package com.github.lizhongyuan3.cloudlive.model.bj;

import cn.hutool.json.JSONObject;
import com.github.lizhongyuan3.cloudlive.model.bj.response.callback.BjVideoAccountTranscodeCallbackUrlResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.response.video.BjVideoGetUploadUrlResponse;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

/**
 * @author lizhongyuan
 */
public interface BjCallbackApi {
    /**
     * 设置转码回调地址（点播和回放）
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/video_account/setTranscodeCallbackUrl")
    Call<BjResponse<JSONObject>> videoAccountSetTranscodeCallbackUrl(@FieldMap Map<String, Object> map);

    /**
     * 查询转码回调地址（点播和回放）
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/video_account/getTranscodeCallbackUrl")
    Call<BjResponse<BjVideoAccountTranscodeCallbackUrlResponse>> videoAccountGetTranscodeCallbackUrl(@FieldMap Map<String, Object> map);
}
