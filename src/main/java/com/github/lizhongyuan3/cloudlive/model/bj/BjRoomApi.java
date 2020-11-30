package com.github.lizhongyuan3.cloudlive.model.bj;

import com.github.lizhongyuan3.cloudlive.model.bj.response.room.BjRoomCreateResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.response.room.BjRoomGetCodeResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.response.room.BjRoomInfoResponse;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

/**
 * @author lizhongyuan
 */
public interface BjRoomApi {
    /**
     * 创建房间
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/room/create")
    Call<BjResponse<BjRoomCreateResponse>> roomCreate(@FieldMap Map<String, Object> map);
    /**
     * 更新房间信息
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/room/update")
    Call<BjResponse<Void>> roomUpdate(@FieldMap Map<String, Object> map);
    /**
     * 删除房间
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/room/delete")
    Call<BjResponse<Void>> roomDelete(@FieldMap Map<String, Object> map);
    /**
     * 获取房间信息
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/room/info")
    Call<BjResponse<BjRoomInfoResponse>> roomInfo(@FieldMap Map<String, Object> map);
    /**
     * 生成用户参加码
     * @param map 实体
     * @return 返回值
     */
    @FormUrlEncoded
    @POST("/openapi/room/getcode")
    Call<BjResponse<BjRoomGetCodeResponse>> roomGetCode(@FieldMap Map<String, Object> map);
}
