package com.jhonatas.bookstore.service.exceptions;

public class StandardError {

	private Long timesTamp;
	private Integer status;
	private String message;
	
	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandardError(Long timesTamp, Integer status, String message) {
		super();
		this.timesTamp = timesTamp;
		this.status = status;
		this.message = message;
	}

	public Long getTimesTamp() {
		return timesTamp;
	}

	public void setTimesTamp(Long timesTamp) {
		this.timesTamp = timesTamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
