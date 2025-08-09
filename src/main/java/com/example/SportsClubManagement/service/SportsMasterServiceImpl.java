package com.example.SportsClubManagement.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SportsClubManagement.model.SportsMaster;
import com.example.SportsClubManagement.repository.SportsMasterRepository;



@Service
public class SportsMasterServiceImpl implements SportsMasterService {

	@Autowired
	SportsMasterRepository sportsMasterRepository;

	@Override
	public List<SportsMaster> getAllSportsList() {
		return sportsMasterRepository.findAll();
	}

	@Override
	public SportsMaster saveSports (SportsMaster sports) {
		
		return sportsMasterRepository.save(sports);
	}

	@Override
	public SportsMaster getSportsById(Integer sId) {
		return sportsMasterRepository.findById(sId).get();
	}

	@Override
	public void deleteSports (SportsMaster sportsMaster) {
		sportsMasterRepository.delete(sportsMaster);
		
	}

	@Override
	public List<SportsMaster> getSportsByClubId(Integer cId) {
		
		return sportsMasterRepository.findAllSportsMasterByClubId(cId);
	}

	
}
