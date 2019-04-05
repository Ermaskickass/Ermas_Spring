package org.Ermas.book.chap04;

import org.Ermas.book.chap03.RegisterRequest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMainUsingComponentScan {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("chap04.xml");
		MemberRegisterService regService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
		
		RegisterRequest req = new RegisterRequest();
		req.setEmail("Ermas@naver.com");
		req.setPassword("1a2a3a");
		req.setName("Ermas");

		regService.regist(req);
		ctx.close();
	}

}
