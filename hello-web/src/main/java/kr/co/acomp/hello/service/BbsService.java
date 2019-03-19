package kr.co.acomp.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.acomp.hello.dao.ArticleDao;
import kr.co.acomp.hello.vo.Article;

@Service
public class BbsService {
	
	@Autowired
	private ArticleDao articleDao;

//	public void setArticleDao(ArticleDao articleDao) {
//		this.articleDao = articleDao;
//	}
	
	public void registArticle(Article article) {
		
		articleDao.insertArticle(article);
		
	}
	
}
