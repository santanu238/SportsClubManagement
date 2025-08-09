package com.example.SportsClubManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SportsClubManagement.model.RoleMaster;
import com.example.SportsClubManagement.repository.RoleMasterRepository;

@Service
public class RoleMasterServiceImpl implements RoleMasterService {

	@Autowired
	RoleMasterRepository roleMasterRepository;
	
	@Override
	public RoleMaster findRoleById(Integer type) {
		
		return roleMasterRepository.findById(type).get();
	}

}
