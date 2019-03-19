package kr.co.acomp.hello;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.acomp.hello.service.BbsService;
import kr.co.acomp.hello.vo.Article;

public class HelloMain {

	public static void main(String[] args) {
//		HelloDao dao = new HelloDao();
//		int result = dao.addTwoNumber(3, 5);

		AbstractApplicationContext ctx =
				new ClassPathXmlApplicationContext("/spring-context.xml");
		
//		HelloDao dao = ctx.getBean("helloDao", HelloDao.class);
		BbsService service = ctx.getBean("bbsService", BbsService.class);
		
//		int result = dao.addTwoNumber(5, 67);
		service.registArticle(new Article());
		
//		System.out.println(result);
		
		
	}
	
}
