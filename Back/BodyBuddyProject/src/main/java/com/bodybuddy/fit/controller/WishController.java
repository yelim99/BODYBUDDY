package com.bodybuddy.fit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodybuddy.fit.model.dto.User;
import com.bodybuddy.fit.model.dto.Wish;
import com.bodybuddy.fit.model.service.WishService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/routine/wish")
@Tag(name="WishController", description="Wish Rest Controller")
public class WishController {
	
	@Autowired
	private WishService wService;
	
	// 찜 추가
	@GetMapping("/add-heart/{routine_id}")
	@Operation(summary="찜 추가", description="빈 하트 눌러서 찜 추가하기")
	public ResponseEntity<?> addWish(@PathVariable("routine_id") int routineId, HttpSession session){
		
		Map<String, Integer> map = new HashMap<>();
		
		// 로그인 유저 확인
		User loginUser = (User) session.getAttribute("user");
		if (loginUser == null) {
			map.put("result", -1);
		}
		
		String loginId = "";
		
		// 로그인한 유저 아이디 저장
		if (loginUser != null) {
			loginId = loginUser.getUserId();
		}
		
		// wish 객체 생성
		Wish wish = new Wish();
		
		// 받아온 routineId와 로그인한 유저 아이디 wish 객체에 넣어주기
		wish.setRoutineId(routineId);
		wish.setUserId(loginId);
		
		// 찜 했는지 확인
		int check = wService.wishCheck(wish);

		int n = 0;
		
		// 찜이 되어있지 않은 상태이면 찜 추가
		if (check == 0) {
			n = wService.addWish(wish);
		}
		
		// 찜 추가하면 result값 1로 저장
		map.put("result", n);
		
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}


	// 찜 해제
	@DeleteMapping("/delete-heart/{routine_id}")
	@Operation(summary="찜 해제", description="꽉 찬 하트 눌러서 찜 해제하기")
	public ResponseEntity<?> delWish(@PathVariable("routine_id") int routineId, HttpSession session){
		Map<String, Integer> map = new HashMap<>();
		
		// 로그인 유저 체크
		User loginUser = (User)session.getAttribute("user");
		if (loginUser == null) {
			map.put("result", -1);
		}
		
		String loginId = "";
		
		if (loginUser != null) {
			loginId = loginUser.getUserId();
		}
		
		Wish wish = new Wish();
		wish.setRoutineId(routineId);
		wish.setUserId(loginId);
		
		int n = wService.delWish(wish);
		
		map.put("result", n);
		
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}
	
	// 찜 목록 불러오기
	@GetMapping("/wishList")
	@Operation(summary="찜 목록 가져오기", description="내가 찜한 목록 가져오기")
	public ResponseEntity<?>wishList(HttpSession session) {
		
		User loginUser = (User)session.getAttribute("user");
		String loginId = loginUser.getUserId();
		
		List<Wish> wishList = wService.wishList(loginId);
		
		return new ResponseEntity<>(wishList, HttpStatus.OK);
	}
	
}
