package com.example.SportsClubManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SportsClubManagement.model.SportsMaster;

@Repository
public interface SportsMasterRepository extends JpaRepository<SportsMaster,Integer>{
	
	@Query("From SportsMaster where clubMaster.clubId=?1")
	List<SportsMaster> findAllSportsMasterByClubId(Integer cId);

}
