package com.bodybuddy.fit.model.service;

import java.util.List;

import com.bodybuddy.fit.model.dto.Exercise;
import com.bodybuddy.fit.model.dto.Routine;

public interface MyPageService {
	
	// 내 루틴 전체 목록 가져오기
	List<Routine> getAllMyRoutines(String userId);
	
	// 내 루틴의 각 운동 상세 정보 가져오기 (운동 한 개)

}
