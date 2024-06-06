package com.bodybuddy.fit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private String userId;
	private String password;
	private String name;
	private String nickname;
	private String email;

}
