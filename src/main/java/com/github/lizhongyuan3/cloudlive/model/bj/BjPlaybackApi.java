package com.github.lizhongyuan3.cloudlive.model.bj;

import cn.hutool.json.JSONObject;
import com.github.lizhongyuan3.cloudlive.model.bj.response.video.BjVideoGetUploadUrlResponse;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

/**
 * @author lizhongyuan
 */
public interface BjPlaybackApi {

    /**
     * 批量获取回放token
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/playback/getPlayerTokenBatch")
    Call<BjResponse<Map<String, String>>> videoGetPlayerTokenBatch(@FieldMap Map<String, Object> map);

    /**
     * 更新回放信息
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/playback/update")
    Call<BjResponse<JSONObject>> videoUpdate(@FieldMap Map<String, Object> map);

    /**
     * 删除回放信息
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/playback/delete")
    Call<BjResponse<JSONObject>> videoDelete(@FieldMap Map<String, Object> map);
}
