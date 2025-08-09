package com.example.SportsClubManagement.service;

import java.util.List;

import com.example.SportsClubManagement.model.ClubMaster;



public interface ClubMasterService {

	List<ClubMaster> getAllClubList();

	ClubMaster getClubById(Integer cId);

	void deleteClub(ClubMaster club);

	ClubMaster saveClub(ClubMaster club);

}
