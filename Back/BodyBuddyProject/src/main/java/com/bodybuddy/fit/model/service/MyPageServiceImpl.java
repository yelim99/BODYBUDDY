package com.bodybuddy.fit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodybuddy.fit.model.dao.MyPageDao;
import com.bodybuddy.fit.model.dto.Exercise;
import com.bodybuddy.fit.model.dto.Routine;

@Service
public class MyPageServiceImpl implements MyPageService {

	private final MyPageDao myDao;
	
	@Autowired
	public MyPageServiceImpl(MyPageDao myDao) {
		this.myDao = myDao;
	}
	
	// 내 루틴 목록 가져오기
	@Override
	public List<Routine> getAllMyRoutines(String userId) {
		return myDao.selectAllMyRoutines(userId);
	}


}
