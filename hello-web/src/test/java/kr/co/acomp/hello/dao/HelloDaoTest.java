package kr.co.acomp.hello.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:servlet-context.xml")
public class HelloDaoTest {
	
	@Autowired
	HelloDao dao;
	
	@Test
	public void testAddTwoNumber() {
		Assert.assertEquals(3, dao.addTwoNumber(1, 2));
	}
}
