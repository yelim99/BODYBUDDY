package com.bodybuddy.fit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
	
	private int exerciseId;
	private int routineId;
	private String exerciseName;
	private String exercisePart;
	private int setCnt;
	private int weight;
	private int repetitions;
	private String dayOfTheWeek;
	private String time;
	
}
