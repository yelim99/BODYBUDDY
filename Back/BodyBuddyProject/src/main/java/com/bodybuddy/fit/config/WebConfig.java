package com.bodybuddy.fit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bodybuddy.fit.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	private final LoginInterceptor loginInterceptor;
	
	public WebConfig(LoginInterceptor loginInterceptor) {
		this.loginInterceptor = loginInterceptor;
	}

	// CORS 에러 전역 처리 
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOriginPatterns("http://localhost:5173")
		.allowedMethods("POST", "GET", "PUT", "DELETE", "OPTIONAL")
		.allowCredentials(true);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
		.addInterceptor(loginInterceptor) // 로그인 안 하면
		.addPathPatterns("/mypage/**") //마이페이지 관련 기능 불가
		.addPathPatterns("/users/edit/**") // 회원 정보 수정 불가
		.addPathPatterns("/routine/board/review/**") // 리뷰 관련 기능 불가
		.excludePathPatterns("/routine/board/review/{routine_id}") // 리뷰 보기만 가능
		.addPathPatterns("/routine/wish/**") // 찜 관련 기능 불가(프론트 단에서 하트만 볼 수 있음 -> 저장 x)
		.addPathPatterns("/routine/board/my-routine/add"); // 다르 사람 루틴을 내 루틴에 추가 불가 
		
	}
}

//@Override
//public void addCorsMappings(CorsRegistry registry) {
//	registry.addMapping("/**")
//	.allowedOrigins("http://localhost:5173")
//	.allowedMethods("POST", "GET", "PUT", "DELETE", "OPTIONS")
//	.allowedHeaders("*")
//	.allowCredentials(true);
//}