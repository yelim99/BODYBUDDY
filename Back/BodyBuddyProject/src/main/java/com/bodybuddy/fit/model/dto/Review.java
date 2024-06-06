package com.bodybuddy.fit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Review {

	private int reviewId;
	private int routineId;
	private String userId;
	private String nickname;
	private String content;
	private String date;
	
}
