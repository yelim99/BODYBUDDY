package com.bodybuddy.fit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bodybuddy.fit.model.dto.Exercise;
import com.bodybuddy.fit.model.dto.Routine;
import com.bodybuddy.fit.model.dto.User;
import com.bodybuddy.fit.model.service.MyPageService;
import com.bodybuddy.fit.model.service.RoutineService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/mypage")
//@CrossOrigin("*")
@Tag(name="MyPageController", description="MyPage Rest Controller")
public class MyPageController {
	
	@Autowired
	private RoutineService rService;
	
	@Autowired
	private MyPageService myService;
	
	// 1. 루틴 등록하기
	@PostMapping("/my-routine/regist")
	@Operation(summary="루틴 등록하기", description="루틴 정보를 등록한다.")
	public ResponseEntity<?> addRoutine(HttpSession session) {
	    // 세션에서 사용자 정보 가져오기
	    User loginUser = (User) session.getAttribute("user");
	    
	    if (loginUser == null) {
	        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	    }
	    
	    Routine routine = new Routine();
	    // 루틴 객체 생성 및 사용자 ID 설정
	    String userId = loginUser.getUserId();
	    routine.setUserId(userId);
	    rService.addRoutine(routine);
	    int routineId = routine.getRoutineId();
	    // 루틴 등록 서비스 호출
	    	
	    return new ResponseEntity<>(routineId, HttpStatus.CREATED);	    	

	}
	
	
	// 2. 루틴 등록 - 운동 추가하기
	@PostMapping("/my-routine/regist/{routineId}")
	@Operation(summary="루틴의 운동 등록하기", description="해당 루틴의 운동 정보를 등록한다.")
	public ResponseEntity<?> addExercise(@PathVariable("routineId") int routineId, 
										@RequestBody Exercise[] exercises) {
		for(Exercise exercise : exercises) {
			exercise.setRoutineId(routineId);
			rService.addExercise(exercise);
		}
		return new ResponseEntity<>(exercises, HttpStatus.CREATED);
	}
	
	// 3. 루틴 수정 - 제목, 내용 추가 (루틴 처음 만들 떄 사용)
	@PutMapping("/my-routine/update-text/{routineId}")
	@Operation(summary="해당 루틴의 제목, 내용을 추가한다.", description="기존에 만들어놓은 루틴에 추가하는거여서 PutMapping")
	public ResponseEntity<?> updateText(@PathVariable("routineId") int routineId, 
			@RequestParam(value = "routineTitle", required = false) String routineTitle, @RequestParam(value = "description", required = false) String description) {
		rService.updateText(routineId, routineTitle, description);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	// 루틴 수정 
	@PutMapping("/my-routine/update/{routineId}")
	@Operation(summary="해당 루틴의 제목, 내용을 추가한다.", description="기존에 만들어놓은 루틴에 추가하는거여서 PutMapping")
	public ResponseEntity<?> updateRoutine(@PathVariable("routineId") int routineId, @RequestBody Exercise[] exercises,
			@RequestParam(value = "routineTitle", required = false) String routineTitle, @RequestParam(value="description", required = false) String description) {
		
		rService.deleteExercises(routineId); // 루틴에 있는 운동 전부 삭제
		
		for(Exercise exercise : exercises) { // 루틴에 운동 추가
			exercise.setRoutineId(routineId);
			rService.addExercise(exercise);
		}
		
		rService.updateText(routineId, routineTitle, description); // 루틴에 있는 제목, 내용 수정
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	// 루틴 삭제
	@DeleteMapping("/my-routine/{routineId}")
	@Operation(summary="루틴 삭제", description="내 루틴 삭제")
	public ResponseEntity<?> deleteRoutine(@PathVariable("routineId") int routineId) {
		rService.deleteRoutine(routineId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// 내 루틴 전체 목록 (내 루틴 관리 페이지)
	@GetMapping("/my-routine")
	@Operation(summary="내 루틴 전체 목록 가져오기", description="내 루틴 전체 목록을 가져온다.")
	public ResponseEntity<List<Routine>> getMyRoutines(HttpSession session) {
		
		User loginUser = (User) session.getAttribute("user");
		String loginId = loginUser.getUserId();
		
		List<Routine> list = myService.getAllMyRoutines(loginId);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	

	// 각 루틴 상세보기 (각 루틴 별 페이지)
	@GetMapping("/my-routine/{routine_id}")
	@Operation(summary="각 루틴 상세보기", description="각 루틴들의 상세 정보를 가져온다.")
	public ResponseEntity<Map<String, Object>> getRoutine(@PathVariable("routine_id") int routineId) {
		
		Map<String, Object> map = new HashMap<>();
		
		// 내 루틴 상세정보 가져오기
		Routine routine = rService.getOneRoutine(routineId);
		
		// 각 루틴의 운동 정보 리스트 가져오기
		List<Exercise> exList = rService.getAllExercise(routineId);
		
		map.put("routine", routine);
		map.put("exList", exList);
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	// 내 루틴의 각 운동 상세 정보 가져오기 (운동 한 개 팝업)
	@GetMapping("/my-routine/{routine_id}/{ex_id}")
	@Operation(summary="내 루틴의 각 운동 상세보기", description="각 루틴의 운동 상세 정보를 가져온다.")
	public ResponseEntity<Exercise> exerciseInfo(@PathVariable("routine_id") int routineId,
												@PathVariable("ex_id") int exerciseId) {
		
		Exercise ex = rService.getExerciseInfo(routineId, exerciseId);
		
		return new ResponseEntity<>(ex, HttpStatus.OK);
	}

}
