package com.bodybuddy.fit.model.service;

import java.util.List;

import com.bodybuddy.fit.model.dto.Wish;

public interface WishService {
	
	// 찜 추가
	int addWish(Wish wish);
	
	// 찜 해제
	int delWish(Wish wish);
	
	// 찜 확인
	int wishCheck(Wish wish);
	
	// 찜 목록
	List<Wish> wishList(String userId);
	
}
