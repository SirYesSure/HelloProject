package kr.co.acomp.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.acomp.hello.service.BbsService;
import kr.co.acomp.hello.vo.Article;

@Controller
@RequestMapping("/bbs")
public class BbsController {

	@Autowired
	private BbsService bbsService;
	
	@GetMapping("/{articleId}")
	public String viewDetail(@PathVariable String articleId) {
		System.out.println("글 번호는: " + articleId);
		
		return "viewDetail_ok";
	}
	
	@PostMapping("/write")
	public String doWrite(Article article, Model model) {
		bbsService.registArticle(article);
		
		System.out.println("post request..");
		
		model.addAttribute("articleVo", article);
		
		return "write_ok";
	}

	@GetMapping("/write")
	public String write(@RequestParam int[] num) {
		bbsService.registArticle(new Article());
		num[0] = num[0] + 10;
		num[1] = num[1] + 20;
		System.out.println("get request" + num[0]);
		System.out.println("get request" + num[1]);
		
		return "write_ok";
	}
	
	
}
