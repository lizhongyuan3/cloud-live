package org.lizy.cloudlive.config;

/**
 * @author lizhongyuan
 */
public class BusException extends RuntimeException {
	private static final long serialVersionUID = -4368873598973127606L;
	private  final String code;
	private final Object data;
	/**
	 * 错误的类型1：
	 */
	private final Integer type;

	public BusException(String code, String message) {
		super(message);
		this.code = code;
		this.data = null;
		this.type = ErrorTypeEnum.COMMON.getCode();
	}

	public BusException(String code, String message, Integer type) {
		super(message);
		this.code = code;
		this.data = null;
		this.type = type;
	}

	public BusException(String code, String message, Integer type, Object data, Exception ex) {
        super(message, ex);
		this.code = code;
		this.data = data;
		this.type = type;
	}
	public BusException(String code, String message, Integer type, Exception ex) {
		super(message, ex);
		this.code = code;
		this.data = null;
		this.type = type;
	}
	public Throwable getInnerException() {
		return super.getCause();
	}
	public Object getData() {
		return data;
	}
	public String getCode() {
		return code;
	}
	public Integer getType() {
		return type;
	}
}
