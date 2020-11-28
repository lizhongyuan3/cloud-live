package com.github.lizhongyuan3.cloudlive.serivce.impl.bj;

import com.github.lizhongyuan3.cloudlive.config.BjConfig;
import com.github.lizhongyuan3.cloudlive.config.BusException;
import com.github.lizhongyuan3.cloudlive.config.ErrorCode;
import com.github.lizhongyuan3.cloudlive.model.CloudLiveRetrofit;
import com.github.lizhongyuan3.cloudlive.serivce.CloudLiveService;
import com.github.lizhongyuan3.cloudlive.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import com.github.lizhongyuan3.cloudlive.model.bj.BjLiveApi;
import com.github.lizhongyuan3.cloudlive.model.bj.request.BjCreateRoomRequest;
import com.github.lizhongyuan3.cloudlive.model.bj.response.BjCreateRoomResponse;
import com.github.lizhongyuan3.cloudlive.model.bj.response.BjLiveResponse;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Objects;

/**
 * @author lizhongyuan
 */
@Slf4j
public class BjCloudLiveServiceImpl implements CloudLiveService {

    private BjConfig bjConfig;

    public void setBjConfig(BjConfig bjConfig) {
        this.bjConfig = bjConfig;
    }

    @Override
    public BjCreateRoomResponse createRoom(BjCreateRoomRequest request) {
        request.setPartnerId(bjConfig.getPartnerId());
        request.setSign(CommonUtil.bjSign(CommonUtil.object2MapWithUnderline(request), bjConfig.getPartnerKey()));
        CloudLiveRetrofit cloudLiveRetrofit = new CloudLiveRetrofit();
        cloudLiveRetrofit.setBjConfig(bjConfig);
        Retrofit retrofit = cloudLiveRetrofit.getRetrofit();
        BjLiveResponse<BjCreateRoomResponse> bjLiveResponse;
        try {
            bjLiveResponse = retrofit
                    .create(BjLiveApi.class)
                    .roomCreate(CommonUtil.object2MapWithUnderline(request))
                    .execute()
                    .body();
        }catch (IOException io) {
            log.error("创建百家云课堂出错");
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, "创建百家云课堂出错");
        }
        if (bjLiveResponse == null) {
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, "创建百家云课堂出错");
        }
        if (!Objects.equals(bjLiveResponse.getCode(), 0)) {
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, bjLiveResponse.getMsg());
        }
        BjCreateRoomResponse response =  bjLiveResponse.getData();
        response.setBaseUrlPrefix(bjConfig.getBaseUrl() + "/web/room/quickenter");
        return response;
    }
}
