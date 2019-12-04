package kr.co.ioncares.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import kr.co.ioncares.service.CommonService;

public class ApiRequestResult implements Serializable {
private static final long serialVersionUID = 1L;

	
	public enum ResultTypes
	{
		SUCCESS(200, "성공"),
		
		BAD_REQUEST(400, "잘못된 요청입니다!"),
		LOGIN_REQUIRED(403, "로그인이 필요합니다!"),
		NOT_FOUND(404, "요청하신 데이터를 찾을 수 없습니다!"),
		PERMISSION_DENIED(406, "권한이 없습니다!"),
		INVALID_PARAMETER(412, "파라미터 부족!"),
		NOT_IMPLEMENTS(600, "구현되지 않은 기능입니다!"),
		
		SYSTEM_ERROR(500, "시스템 오류가 발생하였습니다!");
		
		
		
		private Integer code;
		private String message;
		
		public Integer getCode()
		{
			return this.code;
		}
		
		public String getMessage()
		{
			return this.message;
		}
		
		@Override
		public String toString()
		{
			return String.valueOf(code);
		}
		
		ResultTypes(Integer code, String message)
		{
			this.code = code;
			this.message = message;
		}
	}
	
	
	
	
	@Autowired
	private CommonService commonService;
	
	
	private Integer code;
	
	@JsonInclude(Include.NON_NULL)
	private Object result;
	
	@JsonInclude(Include.NON_NULL)
	private String error;
	
	
	public Integer getCode() {
		return code;
	}
	public Object getResult() {
		return result;
	}
	public String getError() {
		return error;
	}
	
	@Override
	public String toString()
	{
		return commonService.toJSON(this);
	}
	
	
	
	
	
	public ApiRequestResult(ResultTypes type)
	{
		this.code = type.getCode();
		
		if( !type.equals(ResultTypes.SUCCESS) )
			this.error = type.getMessage();
	}
	
	public ApiRequestResult(Object data)
	{
		this.code = ResultTypes.SUCCESS.getCode();
		this.result = data;
	}
	
	public ApiRequestResult(Exception ex)
	{
		this.code = ResultTypes.SYSTEM_ERROR.getCode();
		this.error = ex.getMessage();
	}
	
	public ApiRequestResult(ResultTypes type, Object data)
	{
		this.code = type.getCode();
		
		if( type.equals(ResultTypes.SUCCESS) )
			this.result = data;
		else
			this.error = type.getMessage();
	}
	
	public ApiRequestResult(String errorMessage)
	{
		this.code = ResultTypes.SYSTEM_ERROR.getCode();
		this.error = errorMessage;
	}
	
	public ApiRequestResult(Integer code, String errorMessage)
	{
		this.code = code;
		this.error = errorMessage;
	}
	
	public ApiRequestResult(List<ObjectError> bindingErrors)
	{
		String errorMessages = "";
		
		for( ObjectError err : bindingErrors )
		{
			errorMessages += err.getDefaultMessage() + "\r\n";
		}
		
		
		this.code = ResultTypes.INVALID_PARAMETER.getCode();
		this.error = errorMessages;
	}
}
