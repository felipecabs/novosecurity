package cl.usm.novosec.ingreso.signature;

public class CommonResponse {
	
	private boolean success;
	private int errorCode;
	private String message;
	private Object data;
	
	public CommonResponse() {
		
	}
	
	public CommonResponse(boolean success, int errorCode, String message, Object data) {
		this.success = success;
		this.errorCode = errorCode;
		this.message = message;
		this.data = data;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
