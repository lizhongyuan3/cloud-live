package com.github.lizhongyuan3.cloudlive.model.bj.request.room;

import com.github.lizhongyuan3.cloudlive.model.CommonRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author lizhongyuan
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BjRoomCreateRequest extends CommonRequest {
    /**
     * 房间标题
     */
    private String title;
    /**
     * 1:一对一课（老的班型，老账号支持） 2:普通大班课 3:小班课普通版（老的班型，老账号支持）
     */
    private Integer type;
    /**
     * 0:表示教育
     */
    private Integer industryType;
    /**
     * 开课时间, unix时间戳(秒)
     */
    private Long startTime;
    /**
     * 结束时间, unix时间戳(秒)
     */
    private Long endTime;
    /**
     * 房间最大人数,代表普通大班课最大人数, 不传或传0表示不限制。
     */
    private Integer maxUsers;
    /**
     * 学生可提前进入的时间，单位为秒
     */
    private Integer preEnterTime;
    /**
     * 可选值：doubleCamera(双摄像头)、classic(经典模板)、triple(三分屏)
     */
    private String templateName;


}