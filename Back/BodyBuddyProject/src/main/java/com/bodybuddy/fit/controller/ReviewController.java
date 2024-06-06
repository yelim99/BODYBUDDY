package com.bodybuddy.fit.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bodybuddy.fit.model.dto.Review;
import com.bodybuddy.fit.model.dto.User;
import com.bodybuddy.fit.model.service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/routine/board/review")
public class ReviewController {

	private final ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	//루틴에 맞는 리뷰 목록 가져오기
	@GetMapping("/{routineId}")
	@Operation(summary="리뷰 목록 가져오기", description="루틴에 맞는 리뷰 목록 가져오기")
	public ResponseEntity<List<Review>> getReviewList(@PathVariable("routineId") int routineId){
		List<Review> reviews = reviewService.getReviewList(routineId);
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}
	
	// 리뷰 등록
	@PostMapping("/{routineId}/regist")
	@Operation(summary="리뷰 등록", description="리뷰 등록")
	public ResponseEntity<?> reviewRegist(@RequestBody Review review, @PathVariable("routineId") int routineId, HttpSession session){

		User user = (User)session.getAttribute("user");
		String nickname = user.getNickname();

		String userId = user.getUserId();
		review.setNickname(nickname);
		review.setUserId(userId);
		review.setRoutineId(routineId);
		if(reviewService.reviewRegist(review) == 1) {
			return new ResponseEntity<>("리뷰 등록 완료", HttpStatus.OK);			
		}
		return new ResponseEntity<>("리뷰 등록 실패", HttpStatus.BAD_REQUEST);			
	}
	
	// 리뷰 수정
	@PutMapping("/update")
	@Operation(summary="리뷰 수정", description="리뷰 수정")
	public ResponseEntity<?> reviewUpdate(@RequestParam("reviewId") int reviewId, @RequestParam("content") String content){
		
		return new ResponseEntity<>("리뷰 수정 완료", HttpStatus.OK);
		
	}
	
	// 리뷰 삭제
	@DeleteMapping("/delete")
	@Operation(summary="리뷰 삭제", description="리뷰 삭제")
	public ResponseEntity<?> reviewDelete(@RequestParam("reviewId") int reviewId){
		if(reviewService.reviewDelete(reviewId) == 1) {
			return new ResponseEntity<>("리뷰 삭제 완료", HttpStatus.OK);			
		}
		return new ResponseEntity<>("리뷰 삭제 실패", HttpStatus.BAD_REQUEST);
	}
}
