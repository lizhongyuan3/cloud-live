package com.github.lizhongyuan3.cloudlive.serivce.impl.bj;

import com.github.lizhongyuan3.cloudlive.config.BusException;
import com.github.lizhongyuan3.cloudlive.config.ErrorCode;
import com.github.lizhongyuan3.cloudlive.model.bj.BjResponse;

import java.util.Objects;

/**
 * @author lizhongyuan
 */
public class BjCommonService {

    private static  <T> T dealResponse(BjResponse<T> bjResponse, String errMsg) {
        if (bjResponse == null) {
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, errMsg);
        }
        if (!Objects.equals(bjResponse.getCode(), 0)) {
            throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, bjResponse.getMsg());
        }
        return bjResponse.getData();
    }
}
