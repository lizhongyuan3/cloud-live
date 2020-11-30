package com.github.lizhongyuan3.cloudlive.serivce.impl.bj;

import com.github.lizhongyuan3.cloudlive.config.BjConfig;
import com.github.lizhongyuan3.cloudlive.config.BusException;
import com.github.lizhongyuan3.cloudlive.config.ErrorCode;
import com.github.lizhongyuan3.cloudlive.model.CommonRequest;
import com.github.lizhongyuan3.cloudlive.model.CloudLiveRetrofit;
import com.github.lizhongyuan3.cloudlive.model.bj.BjResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.BjVideoApi;
import com.github.lizhongyuan3.cloudlive.model.bj.response.room.*;
import com.github.lizhongyuan3.cloudlive.model.bj.response.video.*;
import com.github.lizhongyuan3.cloudlive.serivce.BjCloudLiveService;
import com.github.lizhongyuan3.cloudlive.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import com.github.lizhongyuan3.cloudlive.model.bj.BjRoomApi;
import retrofit2.Retrofit;

import java.io.IOException;
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

    private Retrofit getRetrofit(CommonRequest request) {
        request.setPartnerId(bjConfig.getPartnerId());
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
