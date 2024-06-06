package com.bodybuddy.fit.model.dao;

import java.util.List;

import com.bodybuddy.fit.model.dto.Wish;

public interface WishDao {
	
	// 찜 추가
	int insertWish(Wish wish);
	
	// 찜 해제
	int deleteWish(Wish wish);
	
	// 찜 확인
	int wishCheck(Wish wish);
	
	// 찜 목록
	List<Wish> selectAllWish(String userId);
	
}
