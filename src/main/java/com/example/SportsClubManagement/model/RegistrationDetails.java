package com.example.SportsClubManagement.model;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="registration_details")
public class RegistrationDetails {
	
	//, , mobile_no, gender, dob, image_path
	@Id
	@Column(name="registration_id")
	private Integer registrationId;
	
	@Column(name="applicant_name")
	private String applicantName;
	
	@Column(name="email_id")
	private String email;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="gender")
	private Character gender;
	
	@Column(name="image_path")
	private String imageath;
	
	@Column(name="dob")
	private Date dob;
	
	@ManyToOne
	@JoinColumn(name="club_id")
	ClubMaster clubMaster;
	
	@ManyToOne
	@JoinColumn(name="sports_id")
	SportsMaster sportsMaster;

}
