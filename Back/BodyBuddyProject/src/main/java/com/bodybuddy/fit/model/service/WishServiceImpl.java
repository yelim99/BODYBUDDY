package com.bodybuddy.fit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodybuddy.fit.model.dao.WishDao;
import com.bodybuddy.fit.model.dto.Wish;

@Service
public class WishServiceImpl implements WishService {

	private final WishDao wishDao;
	
	@Autowired
	public WishServiceImpl(WishDao wishDao) {
		this.wishDao = wishDao;
	}
	
	
	@Override
	public int addWish(Wish wish) {
		return wishDao.insertWish(wish);
	}

	@Override
	public int delWish(Wish wish) {
		return wishDao.deleteWish(wish);
	}

	@Override
	public int wishCheck(Wish wish) {
		return wishDao.wishCheck(wish);
	}

	@Override
	public List<Wish> wishList(String userId) {
		return wishDao.selectAllWish(userId);
	}

}
