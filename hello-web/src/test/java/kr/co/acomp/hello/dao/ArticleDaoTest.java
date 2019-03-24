package kr.co.acomp.hello.dao;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acomp.hello.vo.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*.xml")
public class ArticleDaoTest {

//	private ApplicationContext ctx;

//	@Before
//	public void setup() {
//		ctx = new FileSystemXmlApplicationContext(
//				"file:src/main/webapp/WEB-INF/spring/*.xml");
//	}

	@Autowired
	private ArticleDao dao;

	@Test
	@Ignore
	public void testInsertArticle() {
		Article article = new Article(1, "lee", "test", "테스트입니다.");
		dao.insertArticle(article);
		
//		Article a = new Article();
//		
//		assertThat("게시글 추가", a, instanceOf(Article.class));
	}

	@Test
	public void testSelectArticleById() {

//		ApplicationContext ctx = 
//				new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/*.xml");

		Article article = dao.selectArticleById("2");
		System.out.println(article);
		
		Assert.assertTrue(article.getAuthor().equals("lee"));
		
//		assertThat("그래 이유가있지", article.getAuthor(), equalTo("lee"));
	}

}
