package kr.co.acomp.hello.service;

import kr.co.acomp.hello.dao.HelloDao;

public class HelloService {

	private HelloDao helloDao;
	
//	public HelloService(HelloDao helloDao) {
//		this.helloDao = helloDao;
//	}
	
	public void setHelloDao(HelloDao helloDao) {
		this.helloDao = helloDao;
	}
	
	public int calcTwoNumbers(int a, int b) {
		return helloDao.addTwoNumber(a, b);
	}
	
}
