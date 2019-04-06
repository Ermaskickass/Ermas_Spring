package org.Ermas.book.cahp07;

import java.util.List;

import org.Ermas.book.chap03.Member;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 


@Service 
public class MemberService { 
	Logger logger = LogManager.getLogger(); 
 
 	@Autowired 
 	MemberDao memberDao = null; 
 	 
 	public void setMemberDao(MemberDao memberDao) { 
 		this.memberDao = memberDao; 
 	} 
	 
 	public void selectAll() { 
 		List<Member> members = memberDao.selectAll(0, 100); 
 		logger.debug(members); 
 	} 
 	 
 	public void updateMember() { 
 		Member member = memberDao.selectByEmail("Ermas@naver.com"); 
 		member.setPassword("1a2a3a"); 
 		memberDao.update(member); 
 		logger.debug("Udate complate."); 
 	} 
 	 
 	public void insertMember() { 
 		Member member = new Member(); 
 		member.setEmail("Ermas@naver.com"); 
 		member.setPassword("1a2a3a"); 
 		member.setName("황윤성"); 
 		memberDao.insert(member); 
 		logger.debug("Insert complate"); 
 	} 
} 

