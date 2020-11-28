package com.github.lizhongyuan3.cloudlive.config;

/**
 * @author lizhongyuan
 */
public enum ErrorTypeEnum {
    /**
     * 错误类型的枚举
     */
    COMMON(1,"默认日志"),
    BUSINESS(2,"业务错误"),
    DB(3,"数据库错误"),
    PLATFORM(4,"平台日志");


    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ErrorTypeEnum(Integer code, String desc){
        this.code=code;
        this.desc=desc;

    }

    /**
     * 自己定义一个静态方法,通过code返回枚举常量对象
     * @param code
     * @return
     */
    public static ErrorTypeEnum getValue(Integer code){

        for (ErrorTypeEnum errorTypeEnum : values()) {
            if(errorTypeEnum.getCode().equals(code)){
                return errorTypeEnum;
            }
        }
        return null;
    }
}
