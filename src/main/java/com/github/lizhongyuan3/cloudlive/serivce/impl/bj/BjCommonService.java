package com.github.lizhongyuan3.cloudlive.serivce.impl.bj;

import com.github.lizhongyuan3.cloudlive.config.BusException;
import com.github.lizhongyuan3.cloudlive.config.ErrorCode;
import com.github.lizhongyuan3.cloudlive.model.bj.BjLiveResponse;

import java.util.Objects;

/**
 * @author lizhongyuan
 */
public class BjCommonService {

    private static  <T> T dealResponse(BjLiveResponse<T> bjLiveResponse, String errMsg) {
        if (bjLiveResponse == null) {
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        if (!Objects.equals(bjLiveResponse.getCode(), 0)) {
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, bjLiveResponse.getMsg());
        }
        return bjLiveResponse.getData();
    }
}
