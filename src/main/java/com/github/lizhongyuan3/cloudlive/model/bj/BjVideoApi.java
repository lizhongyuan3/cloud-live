package com.github.lizhongyuan3.cloudlive.model.bj;

import com.github.lizhongyuan3.cloudlive.model.bj.response.room.BjRoomCreateResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.response.room.BjRoomGetCodeResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.response.room.BjRoomInfoResponse;
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
}
