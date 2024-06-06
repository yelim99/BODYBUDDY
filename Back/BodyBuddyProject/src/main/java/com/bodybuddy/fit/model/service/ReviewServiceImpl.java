package com.bodybuddy.fit.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bodybuddy.fit.model.dao.ReviewDao;
import com.bodybuddy.fit.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private final ReviewDao reviewDao;
	
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	//루틴에 맞는 리뷰 목록 가져오기
	@Override
	public List<Review> getReviewList(int routineId) {
		return reviewDao.getReviewList(routineId);
	}

	// 리뷰 등록
	@Override
	public int reviewRegist(Review review) {
		return reviewDao.reviewRegist(review);
	}

	// 리뷰 수정
	@Override
	public int reviewUpdate(int reviewId, String content) {
		Map<String, Object> map = new HashMap<>();
		map.put("reviewId", reviewId);
		map.put("content", content);
		return reviewDao.reviewUpdate(map);
	}

	// 리뷰 삭제
	@Override
	public int reviewDelete(int reviewId) {
		return reviewDao.reviewDelete(reviewId);
	}

}
