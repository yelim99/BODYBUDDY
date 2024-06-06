package com.bodybuddy.fit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bodybuddy.fit.model.dto.User;
import com.bodybuddy.fit.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
@Tag(name = "UserController", description = "회원가입 로그인")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// 회원가입
	@PostMapping("/join")
	@Operation(summary = "회원가입", description = "아이디는 소문자, 대문자, 숫자, 6~12자 / 비밀번호는 소문자, 대문자, 숫자, 특수문자 8~16자 / 닉네임은 한글, 알파벳 대소문자, 숫자로 구성. 2-8자 /이메일도 형식에 맞게")
	public ResponseEntity<?> join(@RequestBody User user) {
		String userId = user.getUserId();
		String password = user.getPassword();
		String nickname = user.getNickname();
		String email = user.getEmail();

		// 중복 확인은 따로해서 패스
		// 아이디 유효성 검사
		if (!userId.matches("^[a-zA-Z0-9]{6,12}$"))
			return new ResponseEntity<>("올바르지 않은 아이디 형식입니다.", HttpStatus.BAD_REQUEST);
		// 비밀번호 유효성 검사
		if (!password.matches("^[a-zA-Za-z0-9!@#$%^&*()._-]{8,16}$"))
			return new ResponseEntity<>("올바르지 않은 비밀번호 형식입니다.", HttpStatus.BAD_REQUEST);
		// 닉네임 유효성 검사
		if (!nickname.matches("^[가-힣a-zA-Z0-9]{2,8}$"))
			return new ResponseEntity<>("올바르지 않은 닉네임 형식입니다.", HttpStatus.BAD_REQUEST);
		// 이메일 유효성 검사
		if (!email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
			return new ResponseEntity<>("올바르지 않은 이메일 형식입니다.", HttpStatus.BAD_REQUEST);
		// 로그인 등록이 잘 됐는지 확인
		if (userService.join(user) == 1)
			return new ResponseEntity<>("회원가입 완료", HttpStatus.CREATED);

		return new ResponseEntity<>("회원가입 실패", HttpStatus.BAD_REQUEST);

	}

	// 로그인
	@PostMapping("/login")
	@Operation(summary="로그인", description="기존 유저 목록에서 userId, password가 일치하면 session에 user를 저장")
	public ResponseEntity<?> login(HttpSession httpSession, @RequestBody Map<String, String> map){
		User user = userService.login(map);
		if(user != null) {
			httpSession.setAttribute("user", user);
			
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>("로그인 실패", HttpStatus.UNAUTHORIZED);	
	}
	
	// 로그아웃
	@PostMapping("/logout")
	@Operation(summary="로그아웃", description="세션 로그아웃")
	public ResponseEntity<?> logout(HttpSession httpSession){
		User user = (User)httpSession.getAttribute("user");
		
		if(user != null) {
			httpSession.invalidate();
			return new ResponseEntity<>("로그아웃 성공", HttpStatus.OK);
		}
		return new ResponseEntity<>("로그인하지 않은 상태입니다.", HttpStatus.NOT_FOUND);
	}
	
	// ID 중복 체크 + 형식도 맞는지 체크
	@PostMapping("/check-duplicate-id")
	@Operation(summary = "id 중복 체크", description = "형식에 맞는지 확인, 이미 존재하는 id인지 확인")
	public ResponseEntity<?> checkDuplicateId(@RequestParam("userId") String userId) {
		if (!userId.matches("^[a-zA-Z0-9]{6,12}$"))
			return new ResponseEntity<>("올바르지 않은 아이디 형식입니다.", HttpStatus.BAD_REQUEST);

		if (!userService.searchById(userId))
			return new ResponseEntity<>("사용 가능한 아이디입니다.", HttpStatus.OK);

		return new ResponseEntity<>("이미 사용 중인 아이디입니다.", HttpStatus.BAD_REQUEST);
	}

	// 닉네임 중복 체크 + 형식도 맞는지 체크
	@PostMapping("/check-duplicate-nickname")
	@Operation(summary = "닉네임 중복 체크", description = "형식에 맞는지 확인, 이미 존재하는 닉네임인지 확인")
	public ResponseEntity<?> checkDuplicateNickname(@RequestParam("nickname") String nickname) {
		if (!nickname.matches("^[가-힣a-zA-Z0-9]{2,8}$"))
			return new ResponseEntity<>("올바르지 않은 닉네임 형식입니다.", HttpStatus.BAD_REQUEST);

		if (!userService.searchByNickname(nickname))
			return new ResponseEntity<>("사용 가능한 닉네임입니다.", HttpStatus.OK);

		return new ResponseEntity<>("이미 사용 중인 닉네임입니다.", HttpStatus.BAD_REQUEST);

	}

	// 회원 정보 수정
	@PutMapping("/edit")
	@Operation(summary = "회원 정보 수정", description = "형식에 맞는지 확인, 회원가입이랑 동일한 로직")
	public ResponseEntity<?> edit(@RequestBody User user, HttpSession httpSession) {
		System.out.println(user);
		String userId = user.getUserId();
		String password = user.getPassword();
		String nickname = user.getNickname();
		String email = user.getEmail();
		
		User loginUser = (User) httpSession.getAttribute("user");
		String loginUserId = loginUser.getUserId();
		
		// 프론트 로그인 정보와 백엔드 로그인 정보가 일치하는지 확인
		if(!userId.equals(loginUserId)) {
			return new ResponseEntity<>("유저 아이디가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}

		// 비밀번호 유효성 검사
		if (!password.matches("^[a-zA-Za-z0-9!@#$%^&*()._-]{8,16}$"))
			return new ResponseEntity<>("올바르지 않은 비밀번호 형식입니다.", HttpStatus.BAD_REQUEST);
		// 닉네임 유효성 검사
		if (!nickname.matches("^[가-힣a-zA-Z0-9]{2,8}$"))
			return new ResponseEntity<>("올바르지 않은 닉네임 형식입니다.", HttpStatus.BAD_REQUEST);
		// 이메일 유효성 검사
		if (!email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
			return new ResponseEntity<>("올바르지 않은 이메일 형식입니다.", HttpStatus.BAD_REQUEST);
		// 회원 정보 수정이 잘 됐는지 확인
		if (userService.edit(user) == 1) {
			User updateUser = new User();
			updateUser.setNickname(nickname);
			updateUser.setUserId(loginUserId);
			httpSession.setAttribute("user" , updateUser);
			return new ResponseEntity<>("회원 정보 수정 완료", HttpStatus.OK);
		}

		return new ResponseEntity<>("회원 정보 수정 실패", HttpStatus.BAD_REQUEST);
	}

	// 전체 확인 테스트용
	@GetMapping
	@Operation(summary = "전체 확인", description = "테스트용 전체 목록 확인")
	public ResponseEntity<?> searchAll() {
		List<User> users = userService.searchAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
}
