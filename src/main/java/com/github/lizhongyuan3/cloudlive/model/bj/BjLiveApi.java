package com.github.lizhongyuan3.cloudlive.model.bj;

import com.github.lizhongyuan3.cloudlive.model.bj.response.BjCreateRoomResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.response.BjLiveResponse;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

/**
 * @author lizhongyuan
 */
public interface BjLiveApi {
    /**
     * 创建课堂
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/room/create")
    Call<BjLiveResponse<BjCreateRoomResponse>> roomCreate(@FieldMap Map<String, Object> map);
}
