package com.ust.app.customer1.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private LocalDateTime timesstamp;
	private int status;
	private String error;
	private String message;
	private String path;

}
