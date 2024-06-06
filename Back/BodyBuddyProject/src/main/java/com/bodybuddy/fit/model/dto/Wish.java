package com.bodybuddy.fit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wish {

	private int wishId;
	private String userId;
	private int routineId;
	
	@Override
	public String toString() {
		return "Wish [wishId=" + wishId + ", userId=" + userId + ", routineId=" + routineId + "]";
	}
	
	
	
}
