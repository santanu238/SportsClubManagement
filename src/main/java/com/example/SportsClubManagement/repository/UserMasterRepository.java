package com.example.SportsClubManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SportsClubManagement.model.RoleMaster;
import com.example.SportsClubManagement.model.UserMaster;


@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster, Integer>{
	@Query("From UserMaster where userName=:userName and password=:password and roleMaster=:roleMaster")
	UserMaster findUserNameAndPassword(String userName, String password, RoleMaster roleMaster);

}

