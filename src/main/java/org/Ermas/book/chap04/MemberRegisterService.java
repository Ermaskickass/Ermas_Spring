package org.Ermas.book.chap04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.Ermas.book.chap03.DuplicateMemberException;
import org.Ermas.book.chap03.Member;
import org.Ermas.book.chap03.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;
	
	static Logger logger = (Logger) LogManager.getLogger();
	
	public void regist(RegisterRequest req) {
		logger.debug(req);
		Member member = memberDao.selectByEmail(req.getEmail());
		
		if (member != null) {
			throw new DuplicateMemberException("이메일 중복 " + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName());
		memberDao.insert(newMember);
		logger.debug("회원 정보를 저장했습니다.");
	}
}
