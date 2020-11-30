package com.github.lizhongyuan3.cloudlive.serivce.impl.bj;

import com.github.lizhongyuan3.cloudlive.config.BjConfig;
import com.github.lizhongyuan3.cloudlive.config.BusException;
import com.github.lizhongyuan3.cloudlive.config.ErrorCode;
import com.github.lizhongyuan3.cloudlive.model.CommonRequest;
import com.github.lizhongyuan3.cloudlive.model.CommonResponse;
import com.github.lizhongyuan3.cloudlive.model.CloudLiveRetrofit;
import com.github.lizhongyuan3.cloudlive.model.bj.BjLiveResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.response.*;
import com.github.lizhongyuan3.cloudlive.serivce.BjCloudLiveService;
import com.github.lizhongyuan3.cloudlive.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import com.github.lizhongyuan3.cloudlive.model.bj.BjLiveApi;
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
        BjLiveResponse<BjRoomCreateResponse> bjLiveResponse;
        String errMsg = "创建百家云课堂出错";
        try {
            bjLiveResponse = retrofit
                    .create(BjLiveApi.class)
                    .roomCreate(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjLiveResponse, errMsg);
    }

    @Override
    public Void roomUpdate(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjLiveResponse<Void> bjLiveResponse;
        String errMsg = "更新百家云课堂出错";
        try {
            bjLiveResponse = retrofit
                    .create(BjLiveApi.class)
                    .roomUpdate(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjLiveResponse, errMsg);
    }

    @Override
    public Void roomDelete(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjLiveResponse<Void> bjLiveResponse;
        String errMsg = "删除百家云课堂出错";
        try {
            bjLiveResponse = retrofit
                    .create(BjLiveApi.class)
                    .roomDelete(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjLiveResponse, errMsg);
    }

    @Override
    public BjRoomInfoResponse roomInfo(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjLiveResponse<BjRoomInfoResponse> bjLiveResponse;
        String errMsg = "获取百家云课堂详情出错";
        try {
            bjLiveResponse = retrofit
                    .create(BjLiveApi.class)
                    .roomInfo(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjLiveResponse, errMsg);
    }

    @Override
    public BjRoomGetCodeResponse roomGetCode(CommonRequest request) {
        Retrofit retrofit = getRetrofit(request);
        BjLiveResponse<BjRoomGetCodeResponse> bjLiveResponse;
        String errMsg = "获取百家云课堂用户参与码出错";

        try {
            bjLiveResponse = retrofit
                    .create(BjLiveApi.class)
                    .roomGetCode(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error(errMsg);
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        return dealResponse(bjLiveResponse, errMsg);
    }

    private Retrofit getRetrofit(CommonRequest request) {
        request.setPartnerId(bjConfig.getPartnerId());
        request.setSign(CommonUtil.bjSign(CommonUtil.object2MapWithUnderline(request), bjConfig.getPartnerKey()));
        CloudLiveRetrofit cloudLiveRetrofit = new CloudLiveRetrofit();
        cloudLiveRetrofit.setBjConfig(bjConfig);
        return cloudLiveRetrofit.getRetrofit();
    }

    private <T> T dealResponse(BjLiveResponse<T> bjLiveResponse, String errMsg) {
        if (bjLiveResponse == null) {
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        if (!Objects.equals(bjLiveResponse.getCode(), 0)) {
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, bjLiveResponse.getMsg());
        }
        return bjLiveResponse.getData();
    }

}
