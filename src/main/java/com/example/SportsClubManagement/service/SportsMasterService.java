package com.example.SportsClubManagement.service;
import java.util.List;

import com.example.SportsClubManagement.model.SportsMaster;
public interface SportsMasterService {

	List<SportsMaster> getAllSportsList();

	SportsMaster saveSports(SportsMaster sports);

	SportsMaster getSportsById(Integer sId);

	void deleteSports(SportsMaster sportsMaster);

	List<SportsMaster> getSportsByClubId(Integer cId);

}
