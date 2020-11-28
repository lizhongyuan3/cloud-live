package com.github.lizhongyuan3.cloudlive.enums;

import com.github.lizhongyuan3.cloudlive.config.ErrorCode;
import com.github.lizhongyuan3.cloudlive.config.BusException;

import java.util.Objects;

/**
 * @author lizhongyuan
 */

public enum CloudLivePlatformEnum {
    /**
     * 云直播平台
     */
    BJ(1, "百家云"),

    TX(2, "腾讯云");

    private Integer code;

    private String name;

    CloudLivePlatformEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static CloudLivePlatformEnum getEnumByCode(Integer code) {
        for (CloudLivePlatformEnum c : values()) {
            if (Objects.equals(c.getCode(), code)) {
                return c;
            }
        }
        throw new BusException(ErrorCode.RE_CODE_ERROR_CLOUD_LIVE_ERROR, "直播类型错误");
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
