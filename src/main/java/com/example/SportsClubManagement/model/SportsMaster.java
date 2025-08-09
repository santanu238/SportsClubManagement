 package com.example.SportsClubManagement.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="sports_master")
public class SportsMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sports_id")
	private Integer sportsId;
	
	@Column(name="sports_name")
	private String sportsName;
	
	@Column(name="fees")
	private Double fees;
	
	//Entity Association
		@ManyToOne
		@JoinColumn(name="club_id")
		ClubMaster clubMaster;
	
	

}
