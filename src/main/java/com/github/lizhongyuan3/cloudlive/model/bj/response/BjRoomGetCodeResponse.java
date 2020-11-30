package com.github.lizhongyuan3.cloudlive.model.bj.response;

import com.github.lizhongyuan3.cloudlive.model.CommonResponse;
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
public class BjRoomGetCodeResponse extends CommonResponse {
    /**
     * 学生公共参加码，该参加码可以进多个学生，不互踢
     */
    private String studentCode;
}
