package kr.co.acomp.hello.dao;

import org.springframework.stereotype.Repository;

import kr.co.acomp.hello.vo.Article;

@Repository
public class ArticleDao {

	public void insertArticle(Article article) {
		System.out.println("insert ok..");
		System.out.println(article);
	}
	
}
