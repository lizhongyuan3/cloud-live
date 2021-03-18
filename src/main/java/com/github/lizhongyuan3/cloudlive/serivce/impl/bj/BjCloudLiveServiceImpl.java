package com.github.lizhongyuan3.cloudlive.serivce.impl.bj;

import cn.hutool.json.JSONObject;
import com.github.lizhongyuan3.cloudlive.config.BjConfig;
import com.github.lizhongyuan3.cloudlive.config.BusException;
import com.github.lizhongyuan3.cloudlive.config.ErrorCode;
import com.github.lizhongyuan3.cloudlive.constants.Constant;
import com.github.lizhongyuan3.cloudlive.model.CommonRequest;
import com.github.lizhongyuan3.cloudlive.model.CloudLiveRetrofit;
import com.github.lizhongyuan3.cloudlive.model.bj.*;
import com.github.lizhongyuan3.cloudlive.model.bj.response.callback.BjVideoAccountTranscodeCallbackUrlResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.response.playback.BjPlayBackGetBasicInfoResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.response.room.*;
import com.github.lizhongyuan3.cloudlive.model.bj.response.video.*;
import com.github.lizhongyuan3.cloudlive.serivce.BjCloudLiveService;
import com.github.lizhongyuan3.cloudlive.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Retrofit;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.Objects;

/**
 * @author lizhongyuan
 */
@Slf4j
public class BjCloudLiveServiceImpl implements BjCloudLiveService {

    private BjConfig bjConfig;

    public void setBjConfig(BjConfig bjConfig) {
        this.bjConfig = bjConfig;
    }

    @Override
    public BjRoomCreateResponse roomCreate(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<BjRoomCreateResponse> bjResponse;
        String errMsg = "创建百家云课堂出错";
        try {
            bjResponse = retrofit
                    .create(BjRoomApi.class)
                    .roomCreate(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjResponse, errMsg);
    }

    @Override
    public Void roomUpdate(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<Void> bjResponse;
        String errMsg = "更新百家云课堂出错";
        try {
            bjResponse = retrofit
                    .create(BjRoomApi.class)
                    .roomUpdate(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjResponse, errMsg);
    }

    @Override
    public Void roomDelete(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<Void> bjResponse;
        String errMsg = "删除百家云课堂出错";
        try {
            bjResponse = retrofit
                    .create(BjRoomApi.class)
                    .roomDelete(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjResponse, errMsg);
    }

    @Override
    public BjRoomInfoResponse roomInfo(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<BjRoomInfoResponse> bjResponse;
        String errMsg = "获取百家云课堂详情出错";
        try {
            bjResponse = retrofit
                    .create(BjRoomApi.class)
                    .roomInfo(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjResponse, errMsg);
    }

    @Override
    public BjRoomGetCodeResponse roomGetCode(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<BjRoomGetCodeResponse> bjResponse;
        String errMsg = "获取百家云课堂用户参与码出错";
        try {
            bjResponse = retrofit
                    .create(BjRoomApi.class)
                    .roomGetCode(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjResponse, errMsg);
    }

    @Override
    public BjVideoGetUploadUrlResponse videoGetUploadUrl(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<BjVideoGetUploadUrlResponse> bjResponse;
        String errMsg = "获取视频/音频上传地址 失败";
        try {
            bjResponse = retrofit
                    .create(BjVideoApi.class)
                    .videoGetUploadUrl(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjResponse, errMsg);
    }

    @Override
    public BjVideoGetInfoResponse videoGetInfo(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<BjVideoGetInfoResponse> bjResponse;
        String errMsg = "获取视频/音频详情 失败";
        try {
            bjResponse = retrofit
                    .create(BjVideoApi.class)
                    .videoGetInfo(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjResponse, errMsg);
    }

    @Override
    public BjVideoAccountTranscodeCallbackUrlResponse videoAccountGetTranscodeCallbackUrl(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<BjVideoAccountTranscodeCallbackUrlResponse> bjResponse;
        String errMsg = "查询转码回调地址（点播和回放）失败";
        try {
            bjResponse = retrofit
                    .create(BjCallbackApi.class)
                    .videoAccountGetTranscodeCallbackUrl(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjResponse, errMsg);
    }

    @Override
    public BjPlayBackGetBasicInfoResponse playBackGetBasicInfo(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<BjPlayBackGetBasicInfoResponse> bjResponse;
        String errMsg = "获取回放详情 失败";
        try {
            bjResponse = retrofit
                    .create(BjPlaybackApi.class)
                    .playBackGetBasicInfo(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjResponse, errMsg);
    }

    @Override
    public Map<String, String> videoGetPlayerTokenBatch(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<Map<String, String>> bjResponse;
        String errMsg = "批量获取播放器token 失败";
        try {
            bjResponse = retrofit
                    .create(BjVideoApi.class)
                    .videoGetPlayerTokenBatch(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjResponse, errMsg);
    }

    @Override
    public void videoUpdate(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<JSONObject> bjResponse;
        String errMsg = "更新视频 失败";
        try {
            bjResponse = retrofit
                    .create(BjVideoApi.class)
                    .videoUpdate(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        dealResponse(bjResponse, errMsg);
    }

    @Override
    public void videoDelete(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<JSONObject> bjResponse;
        String errMsg = "删除视频 失败";
        try {
            bjResponse = retrofit
                    .create(BjVideoApi.class)
                    .videoDelete(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        dealResponse(bjResponse, errMsg);
    }

    @Override
    public Map<String, String> playbackGetPlayerTokenBatch(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<Map<String, String>> bjResponse;
        String errMsg = "批量获取回放token 失败";
        try {
            bjResponse = retrofit
                    .create(BjPlaybackApi.class)
                    .playBackGetPlayerTokenBatch(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjResponse, errMsg);
    }

    @Override
    public void playbackUpdate(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<JSONObject> bjResponse;
        String errMsg = "更新回放 失败";
        try {
            bjResponse = retrofit
                    .create(BjPlaybackApi.class)
                    .playBackUpdate(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        dealResponse(bjResponse, errMsg);
    }

    @Override
    public void playbackDelete(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<JSONObject> bjResponse;
        String errMsg = "删除回放 失败";
        try {
            bjResponse = retrofit
                    .create(BjPlaybackApi.class)
                    .playBackDelete(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        dealResponse(bjResponse, errMsg);
    }

    @Override
    public void videoAccountSetTranscodeCallbackUrl(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjResponse<JSONObject> bjResponse;
        String errMsg = "设置转码回调地址（点播和回放） 失败";
        try {
            bjResponse = retrofit
                    .create(BjCallbackApi.class)
                    .videoAccountSetTranscodeCallbackUrl(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        dealResponse(bjResponse, errMsg);
    }

    private Retrofit getRetrofit(CommonRequest request) {
        request.setPartnerId(bjConfig.getPartnerId());
        request.setTimestamp(LocalDateTime.now(Constant.SHANGHAI).toEpochSecond(ZoneOffset.of("+8")));
        request.setSign(CommonUtil.bjSign(CommonUtil.object2MapWithUnderline(request), bjConfig.getPartnerKey()));
        CloudLiveRetrofit cloudLiveRetrofit = new CloudLiveRetrofit();
        cloudLiveRetrofit.setBjConfig(bjConfig);
        return cloudLiveRetrofit.getRetrofit();
    }

    private <T> T dealResponse(BjResponse<T> bjResponse, String errMsg) {
        if (bjResponse == null) {
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        if (!Objects.equals(bjResponse.getCode(), 0)) {
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, bjResponse.getMsg());
        }
        return bjResponse.getData();
    }

}
