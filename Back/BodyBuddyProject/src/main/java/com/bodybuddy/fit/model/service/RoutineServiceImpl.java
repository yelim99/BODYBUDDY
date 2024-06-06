package com.bodybuddy.fit.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodybuddy.fit.model.dao.RoutineDao;
import com.bodybuddy.fit.model.dto.Exercise;
import com.bodybuddy.fit.model.dto.Routine;

@Service
public class RoutineServiceImpl implements RoutineService {
	
	private final RoutineDao routineDao;
	
	@Autowired
	public RoutineServiceImpl(RoutineDao routineDao) {
		this.routineDao = routineDao;
	}	

	// 루틴 전체 목록
	@Override
	public List<Routine> getAllRoutine(String keyword) {
		return routineDao.selectAll(keyword);
	}

	// 해당 루틴의 운동 정보 리스트 가져오기
	@Override
	public List<Exercise> getAllExercise(int routineId) {
		return routineDao.selectAllExercise(routineId);
	}


	// 해당 루틴의 각 운동 상세 정보 (운동 한 개)
	@Override
	public Exercise getExerciseInfo(int routineId, int exerciseId) {
		Map<String, Integer> map = new HashMap<>();
		map.put("routineId", routineId);
		map.put("exerciseId", exerciseId);
		return routineDao.selectExercise(map);
	}
	
	// 루틴 상세보기
	@Override
	public Routine getOneRoutine(int routineId) {
		return routineDao.selectOne(routineId);
	}

	// 1. 루틴 등록
	@Override
	public int addRoutine(Routine routine) {
		return routineDao.insertRoutine(routine);
	}

	// 2. 루틴 등록 - 운동 등록
	@Override
	public int addExercise(Exercise exercise) {
		return routineDao.insertExercise(exercise);
	}

	// 3. 루틴 수정 - 제목, 내용 추가 (루틴 처음 만들 떄 사용)
	@Override
	public int updateText(int routineId, String routineTitle, String description) {
		Map<String, Object> map = new ConcurrentHashMap<>();
		// 루틴 제목을 입력 안 하면 제목 없음으로 생성 
		if (routineTitle == null || routineTitle.equals("")) routineTitle = "제목 없음";
		map.put("routineId", routineId);
		map.put("routineTitle", routineTitle);
		map.put("description", description);
		return routineDao.updateText(map);
	}
	
	// 루틴에 운동 전부 삭제 (루틴 수정용)
	@Override
	public int deleteExercises(int routineId) {
		return routineDao.deleteExercises(routineId);
	}

	// 내 루틴 삭제
	@Override
	public int deleteRoutine(int routineId) {
		return routineDao.deleteRoutine(routineId);
	}

	// 예림 추가 -----------------
	// 내 루틴에 추가 (루틴 추가)
	@Override
	public int addMyRoutine(Routine routine) {
		String routineTitle = routine.getRoutineTitle();
		if (routineTitle == null || routineTitle.equals("")) routineTitle = "제목 없음";
		routine.setRoutineTitle(routineTitle);
		return routineDao.insertMyRoutine(routine);
	}

	// 내 루틴에 추가 (운동 추가)
	@Override
	public int addMyExercise(Map<String, Object> dataMap) {
		return routineDao.insertMyExercise(dataMap);
	}

	
	
	// ------------------------

}
