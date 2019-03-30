package org.Ermas.book.chap03;

public class MemberMain {
	
	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();
		MemberRegisterService regService = new MemberRegisterService(memberDao);
		
		RegisterRequest req = new RegisterRequest();
		req.setEmail("Ermas@naver.com");
		req.setPassword("1a2a3a");
		req.setName("Ermas");
		
		regService.regist(req);
	}
}
