package com.example.SportsClubManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SportsClubManagement.model.ClubMaster;
import com.example.SportsClubManagement.repository.ClubMasterRepository;



@Service
public class ClubMasterServiceImpl implements ClubMasterService {

	
	@Autowired
	ClubMasterRepository clubmasterRepository;

	@Override
	public ClubMaster saveClub(ClubMaster club) {
		
		return clubmasterRepository.save(club);
	}

	@Override
	public List<ClubMaster> getAllClubList() {
	
		return clubmasterRepository.findAll();
	}

	@Override
	public ClubMaster getClubById(Integer cId) {
		
		return clubmasterRepository.findById(cId).get();
	}

	@Override
	public void deleteClub(ClubMaster club) {
		clubmasterRepository.delete(club);		
	}
	
	
	
}
