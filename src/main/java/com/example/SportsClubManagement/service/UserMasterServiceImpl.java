package com.example.SportsClubManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SportsClubManagement.model.UserMaster;
import com.example.SportsClubManagement.repository.UserMasterRepository;


@Service
public class UserMasterServiceImpl implements UserMasterService {

	@Autowired
	UserMasterRepository userMasterRepository;
	
	@Override
	public UserMaster findUser(UserMaster currUser) {
		UserMaster user=userMasterRepository.findUserNameAndPassword(currUser.getUserName(),
				currUser.getPassword(),currUser.getRoleMaster());
		
		return user;
	}

}
