package com.bodybuddy.fit.model.dao;

import java.util.List;
import java.util.Map;

import com.bodybuddy.fit.model.dto.Review;

public interface ReviewDao {
	//루틴에 맞는 리뷰 목록 가져오기
	List<Review> getReviewList(int routineId);
	// 리뷰 등록
	int reviewRegist(Review review);
	// 리뷰 수정
	int reviewUpdate(Map<String, Object> map);
	// 리뷰 삭제
	int reviewDelete(int reviewId);
}
