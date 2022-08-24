package com.spring.pr.user.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.spring.pr.command.*;
import com.spring.pr.user.mapper.*;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserMapper mapper;

	@Override
	public int idCheck(String JOINID) {
		return mapper.idCheck(JOINID);
	}

	@Override
	public void join(UserVO user) {
		mapper.join(user);

	}

	@Override
	public UserVO login(String JOINID, String JOINPW) {
		return mapper.login(JOINID, JOINPW);
	}

	@Override
	public UserVO idSearch(String joinName, String joinSocNum) {
		return mapper.idSearch(joinName, joinSocNum);
	}

	@Override
	public UserVO pwSearch(String joinName, String joinSocNum) {
		return mapper.pwSearch(joinName, joinSocNum);

	}
	
	@Override
	public void newPwRegist(UserVO user) {
		 mapper.newPwRegist(user);
	}

	@Override
	public UserVO getInfo(String JOINID) {
		return mapper.getInfo(JOINID);

	}

	@Override
	public void updateUser(UserVO user) {
		mapper.updateUser(user);

	}

	@Override
	public void deleteUser1(String JOINPW) {
		mapper.deleteUser1(JOINPW);
	}
	@Override
	public void deleteUser2(String JOINNAME, String JOINPW ) {
		mapper.deleteUser2(JOINNAME, JOINPW);
	}

}
