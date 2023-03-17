package com.myspring.pro28.ex05;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

// HandlerInterceptor란?
// -> Workflow interface that allows for customized handler execution chains.Applications can register any number of existing or custom interceptorsfor certain groups of handlers, to add common preprocessing behaviorwithout needing to modify each handler implementation. 
//    사용자 지정 핸들 실행 체인을 위한 워크플로우 인터페이스입니다.응용 프로그램은 특정 핸들 구현에 대한 기존 또는 사용자 지정 간격이 수정할 필요가 없는 일반적인 준비 작업을 추가할 수 있습니다.   

// HandlerInterceptorAdapter : Abstract adapter class for the HandlerInterceptor interface,for simplified implementation of pre-only/post-only interceptors.

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LocaleInterceptor extends HandlerInterceptorAdapter{
// 'HandlerInterceptorAdapter' extends 해주고 시작, LocaleInterceptor 클래스를 servlet-context에 넣어주기
	
   @Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {

	   
	   // HttpSession javax.servlet.http.HttpServletRequest.getSession()
	   HttpSession session = request.getSession();
	   String locale = request.getParameter("locale");
	   System.out.println(locale);
	   
	   if(locale == null) {
		   locale="ko";
	   }

	   session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE", new Locale(locale));
	   
	   return true;
}
   	   
   @Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mv) throws Exception {

	}
    
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
		   Object handler, Exception ex) throws Exception {
	    
   };
    
}
