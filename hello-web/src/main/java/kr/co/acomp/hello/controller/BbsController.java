package kr.co.acomp.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.acomp.hello.service.BbsService;
import kr.co.acomp.hello.vo.Article;

@Controller
@RequestMapping("/bbs")
public class BbsController {

	@Autowired
	private BbsService bbsService;
	
	@RequestMapping("/write")
	public String write(@RequestParam("author") String author) {
		bbsService.registArticle(new Article());
		
		System.out.println(author);
		
		return "write_ok";
	}
	
}
