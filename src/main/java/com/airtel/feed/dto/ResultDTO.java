package com.airtel.feed.dto;


import java.util.List;

/**
 * @author rachit
 *
 */
public class ResultDTO {

	private String flag;
	
	private String message;
	
	private List<?> responseData;

	private ResponseDTO pagination;

	public ResultDTO(String flag, String message) {
		super();
		this.flag = flag;
		this.message = message;
	}
		
	public ResultDTO(String flag, String message, List<?> responseData,
			ResponseDTO pagination) {
		super();
		this.flag = flag;
		this.message = message;
		this.responseData = responseData;
		this.pagination = pagination;
	}

	public ResultDTO(String flag, String message, List<?> responseData) {
		super();
		this.flag = flag;
		this.message = message;
		this.responseData = responseData;
	}
	
	public ResultDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<?> getResponseData() {
		return responseData;
	}

	public void setResponseData(List<?> responseData) {
		this.responseData = responseData;
	}

	public ResponseDTO getPagination() {
		return pagination;
	}

	public void setPagination(ResponseDTO pagination) {
		this.pagination = pagination;
	}


}
