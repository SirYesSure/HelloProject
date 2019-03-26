package kr.co.acomp.hello.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MeasuringInterceptor extends HandlerInterceptorAdapter{

	Logger log = LoggerFactory.getLogger(MeasuringInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("mi.beginTime", System.currentTimeMillis());
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("여기가 MeasuringInterceptor 클래스인데 ");
		System.out.println("postHandle이 수행중이었다. ?????????????????????");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		long beginTime = (long)request.getAttribute("mi.beginTime");
		
		long endTime = System.currentTimeMillis();
		
//		System.out.println(endTime - beginTime);
		log.debug(request.getRequestURI() + "실행시간 : {}" , (endTime - beginTime));
	}

	
	
	
}
