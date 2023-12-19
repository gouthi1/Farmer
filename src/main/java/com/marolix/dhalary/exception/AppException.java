package com.marolix.dhalary.exception;


import java.time.LocalDateTime;

import lombok.Data;
import lombok.Setter;

@Data
public class AppException {

	private String msg;
	
	private Integer code;
	
	private LocalDateTime time;

	
}
