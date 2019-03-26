package kr.co.acomp.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.acomp.hello.service.BbsService;
import kr.co.acomp.hello.vo.Article;


@Controller
@RequestMapping("/bbs")
public class BbsController {

	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	private BbsService bbsService;
	
	@GetMapping("")
	public String index() {
//		bbsService.testService();
//		bbsService.insertArticle(new Article(5, "kim", "test", "test"));
		
		return "index";
	}
	
	@GetMapping("/{articleId}")
//	@ResponseBody
	public String viewDetail(@PathVariable String articleId) {
		logger.debug("BbsController ?" + articleId);
		System.out.println("? 왜 여기 안돌까?");
		Article article = this.bbsService.viewArticleDetail(articleId);
		
		logger.info("BbsController ?" + article);
		
		return "index";
	}
	
	@PostMapping("/write")
	@ResponseBody
	public Article write(@RequestBody Article article) {
		
		bbsService.insertArticle(article);
		
		return article;
	}
	
	
//	@GetMapping("/{articleId}")
//	public String viewDetail(@PathVariable String articleId) {
//		System.out.println("글 번호는: " + articleId);
//		
//		return "viewDetail_ok";
//	}
	
//	@PostMapping("/write")
//	public String doWrite(Article article, Model model) {
//		bbsService.registArticle(article);
//		
//		System.out.println("post request..");
//		
//		model.addAttribute("articleVo", article);
//		
//		return "write_ok";
//	}

	
//	@PostMapping("/write")
//	public String write(Article a) {
//		bbsService.insertArticle(a);
//
//	
//		
//		return "write_ok";
//	}
	
	
}
