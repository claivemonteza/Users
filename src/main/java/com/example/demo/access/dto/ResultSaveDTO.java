package com.example.demo.access.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ResultSaveDTO {

	private Long id;
	private Boolean integrated;
	private String message;
}
