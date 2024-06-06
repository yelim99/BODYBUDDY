package com.bodybuddy.fit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Routine {
	
	private int routineId;
	private String userId;
	private String routineTitle;
	private String date;
	private String description;
	private String nickname;
	
}
