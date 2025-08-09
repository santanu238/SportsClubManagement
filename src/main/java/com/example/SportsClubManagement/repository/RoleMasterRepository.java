package com.example.SportsClubManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SportsClubManagement.model.RoleMaster;
@Repository
public interface RoleMasterRepository extends JpaRepository<RoleMaster,Integer> {

}
