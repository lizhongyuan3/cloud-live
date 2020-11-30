package com.github.lizhongyuan3.cloudlive.model.bj;

import com.github.lizhongyuan3.cloudlive.model.bj.response.*;
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
     * 创建房间
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/room/create")
    Call<BjLiveResponse<BjRoomCreateResponse>> roomCreate(@FieldMap Map<String, Object> map);
    /**
     * 更新房间信息
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/room/update")
    Call<BjLiveResponse<Void>> roomUpdate(@FieldMap Map<String, Object> map);
    /**
     * 删除房间
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/room/delete")
    Call<BjLiveResponse<Void>> roomDelete(@FieldMap Map<String, Object> map);
    /**
     * 获取房间信息
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/room/info")
    Call<BjLiveResponse<BjRoomInfoResponse>> roomInfo(@FieldMap Map<String, Object> map);
    /**
     * 生成用户参加码
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/room/getcode")
    Call<BjLiveResponse<BjRoomGetCodeResponse>> roomGetCode(@FieldMap Map<String, Object> map);
}
