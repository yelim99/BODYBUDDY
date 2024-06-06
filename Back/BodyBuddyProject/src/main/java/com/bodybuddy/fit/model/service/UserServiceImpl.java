package com.bodybuddy.fit.model.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.bodybuddy.fit.model.dao.UserDao;
import com.bodybuddy.fit.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	// 회원가입
	@Override
	public int join(User user) {
		return userDao.join(user);
	}

	// 로그인
	@Override
	public User login(Map<String, String> map) {
		return userDao.login(map);
	}

	// ID로 검색(ID 중복 확인)
	@Override
	public boolean searchById(String userId) {
		User user = userDao.searchById(userId);
	    return user != null;
	}

	// nickname으로 검색(닉네임 중복 확인)
	@Override
	public boolean searchByNickname(String nickname) {
		User user =  userDao.searchByNickname(nickname);
		return user != null;
	}

	// 회원 정보 수정
	@Override
	public int edit(User user) {
		return userDao.edit(user);
	}
	
	// 전체 회원 검색
	@Override
	public List<User> searchAll() {
		return userDao.searchAll();
	}

}