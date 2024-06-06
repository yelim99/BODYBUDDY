package com.bodybuddy.fit.model.dao;

import java.util.List;
import java.util.Map;

import com.bodybuddy.fit.model.dto.Exercise;
import com.bodybuddy.fit.model.dto.Routine;

public interface RoutineDao {
	
	// 루틴 전체 목록 보여주기
	List<Routine> selectAll(String keyword);
	
	// 해당 루틴의 운동 정보 리스트 가져오기
	List<Exercise> selectAllExercise(int routineId);
	
	// 해당 루틴의 각 운동 정보 상세보기 (운동 한 개)
	Exercise selectExercise(Map<String, Integer> map);
	
	// 루틴 상세보기
	Routine selectOne(int routineId);
	
	// 1. 루틴 등록
	int insertRoutine(Routine routine);
	
	// 2. 루틴 등록 - 운동 등록
	int insertExercise(Exercise exercise);

	// 3. 루틴 수정 - 제목, 내용 추가 (루틴 처음 만들 떄 사용)
	int updateText(Map<String, Object> map);

	// 루틴에 운동 전부 삭제 (루틴 수정용)
	int deleteExercises(int routineId);
	
	// 루틴 삭제
	int deleteRoutine(int routineId);
	
	// 예림 추가 ---------
	// 내 루틴에 추가 (루틴 추가)
	int insertMyRoutine(Routine routine);
	
	// 내 루틴에 추가 (운동 추가)
	int insertMyExercise(Map<String, Object> dataMap);

	
	// -------------------
	
	// 검색 및 페이징

}
