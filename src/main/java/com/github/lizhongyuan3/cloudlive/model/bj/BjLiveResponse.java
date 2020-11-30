package com.github.lizhongyuan3.cloudlive.model.bj;

import lombok.Data;


/**
 * @author lizhongyuan
 */
@Data
public class BjLiveResponse<T> {

    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 状态信息
     */
    private String msg;
    /**
     * 时间戳
     */
    private Long ts;
}
