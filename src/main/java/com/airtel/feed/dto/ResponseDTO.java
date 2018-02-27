package com.airtel.feed.dto;

/**
 *
 *@author rachit 
 */
public class ResponseDTO {

	Integer totalPages;
	Integer currentPage;
	Long totalElement;
	String responseMessage;
	// 0-Success, 1-Failure
	Byte result = 1;

	public ResponseDTO(Integer totalPages, Long totalElement) {
		super();
		this.totalPages = totalPages;
		this.totalElement = totalElement;
	}

	public ResponseDTO(String responseMessage, Byte result) {
		super();
		this.responseMessage = responseMessage;
		this.result = result;
	}

	public ResponseDTO(Integer currentPage, Integer totalPages, Long totalElement, String responseMessage, Byte result) {
		super();
		this.currentPage = currentPage;
		this.totalPages = totalPages;
		this.totalElement = totalElement;
		this.responseMessage = responseMessage;
		this.result = result;
	}
	
	public ResponseDTO(Integer currentPage, Integer totalPages, Long totalElement) {
		super();
		this.currentPage = currentPage;
		this.totalPages = totalPages;
		this.totalElement = totalElement;

	}
	
	public ResponseDTO(Integer totalPages, Long totalElement, String responseMessage, Byte result) {
		super();
		this.totalPages = totalPages;
		this.totalElement = totalElement;
		this.responseMessage = responseMessage;
		this.result = result;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Long getTotalElement() {
		return totalElement;
	}

	public void setTotalElement(Long totalElement) {
		this.totalElement = totalElement;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Byte getResult() {
		return result;
	}

	public void setResult(Byte result) {
		this.result = result;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

}
