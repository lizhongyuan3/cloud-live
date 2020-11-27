package org.lizy.cloudlive.model.bj;

import org.lizy.cloudlive.model.bj.response.BjCreateRoomResponse;
import org.lizy.cloudlive.model.bj.response.BjLiveResponse;
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
