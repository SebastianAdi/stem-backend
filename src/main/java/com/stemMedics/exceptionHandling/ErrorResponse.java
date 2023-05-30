package com.stemMedics.exceptionHandling;

import java.time.LocalDate;

public class ErrorResponse {

	private LocalDate timestamp;
	private String message;
	private String desc;

	public ErrorResponse(LocalDate timestamp, String message, String desc) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.desc = desc;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDesc() {
		return desc;
	}

}
