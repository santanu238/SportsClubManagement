package com.example.SportsClubManagement.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SportsClubManagement.model.ClubMaster;
import com.example.SportsClubManagement.model.RegistrationDetails;
import com.example.SportsClubManagement.model.RoleMaster;
import com.example.SportsClubManagement.model.SportsMaster;
import com.example.SportsClubManagement.model.UserMaster;
import com.example.SportsClubManagement.service.ClubMasterService;
import com.example.SportsClubManagement.service.RoleMasterService;
import com.example.SportsClubManagement.service.SportsMasterService;
import com.example.SportsClubManagement.service.UserMasterService;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/menu")
public class SportsControler {

	@Autowired
	UserMasterService usermasterService;

	@Autowired
	RoleMasterService rolemasterService;

	@Autowired
	ClubMasterService clubmasterService;

	@Autowired
	SportsMasterService sportmasterService;

	@GetMapping("/home")
	public String homepage() {

		return "index";
	}

	@GetMapping("/adminDashboard")
	public String goToAdminPage() {

		return "admin";
	}

	@GetMapping("/addClub")
	public String addClub(Model model) {
		List<ClubMaster> clubList = clubmasterService.getAllClubList();

		model.addAttribute("clubObj", "yes");
		model.addAttribute("cList", clubList);

		return "admin";
	}

	@GetMapping("/addSports")
	public String addSports(Model model) {

		List<SportsMaster> sportsList = sportmasterService.getAllSportsList();
		List<ClubMaster> clubList = clubmasterService.getAllClubList();

		model.addAttribute("SportsObj", "yes");
		model.addAttribute("sList", sportsList);
		model.addAttribute("clList", clubList);

		return "admin";
	}

	@GetMapping("/userDashboard")
	public String goToUserPage(Model model) {

		List<ClubMaster> clubList = clubmasterService.getAllClubList();
		model.addAttribute("clubList", clubList);

		return "user";
	}

	@PostMapping("/userLogin")
	public String userLogin(@RequestParam("type") Integer type, @RequestParam("uname") String uname,
			@RequestParam("pass") String password) {

		System.out.println(type + " " + uname + " " + password);

		RoleMaster role = rolemasterService.findRoleById(type);

		UserMaster currUser = new UserMaster();
		currUser.setUserName(uname);
		currUser.setPassword(password);
		currUser.setRoleMaster(role);

		UserMaster user = usermasterService.findUser(currUser);

		System.out.println(user);

		if (user == null) {
			return "redirect:./home";
		} else {
			if (type == 1) {
				return "redirect:./adminDashboard";
//				return "adminDashboard";
			} else {
				return "redirect:./userDashboard";
//				return "userDashboard";
			}
		}

	}

	@PostMapping("/saveClub")
	public String saveClub(@RequestParam("clubName") String cname) {

		ClubMaster club = new ClubMaster();
		club.setClubName(cname);

		ClubMaster savedClub = clubmasterService.saveClub(club);

		return "redirect:./addClub";
	}

	@GetMapping("/deleteClub")
	public String deleteClub(@RequestParam("cId") Integer cId) {

		ClubMaster club = clubmasterService.getClubById(cId);

		System.out.println(club);

		clubmasterService.deleteClub(club);

		return "redirect:./addClub";
	}

	@PostMapping("/saveSports")
	public String saveSports(@RequestParam("sportsName") String sName, @RequestParam("cId") Integer cId,
			@RequestParam("fees") Double fees) {

		ClubMaster club = clubmasterService.getClubById(cId);

		SportsMaster sports = new SportsMaster();

		sports.setSportsName(sName);
		sports.setFees(fees);
		sports.setClubMaster(club);

		SportsMaster savedSports = sportmasterService.saveSports(sports);

		return "redirect:./addSports";
	}

	@GetMapping("/deleteSports")
	public String deleteSports(@RequestParam("sId") Integer sId) {
		SportsMaster sportsMaster = sportmasterService.getSportsById(sId);

		sportmasterService.deleteSports(sportsMaster);

		return "redirect:./addSports";
	}

	@PostMapping("/getSportsByClub")
	public void getSportsByClub(@RequestParam("cId") Integer cId, HttpServletResponse response) throws IOException {
		List<SportsMaster> sportsList = sportmasterService.getSportsByClubId(cId);
		String option = "<option> --select--</option>";
		for (SportsMaster x : sportsList) {
			option = option + "<option value='" + x.getSportsId() + "'>" + x.getSportsName() + "</option>";

		}
		System.out.println(option);
		response.getWriter().print(option);

	}

	@PostMapping("/registerUser")
	public String registerUser(@RequestParam("uname") String uname, @RequestParam("email") String email,
			@RequestParam("phone") String phone,
			@RequestParam("dob") String dob,
			@RequestParam("gender") Character gender, 
			@RequestParam("photo") MultipartFile photo,
			@RequestParam("clubId") Integer clubId, 
			@RequestParam("sportsId") Integer sportsId)throws ParseException {
			 
			ClubMaster club=clubmasterService.getClubById(clubId);
			SportsMaster sports=sportmasterService.getSportsById(sportsId);
			
			RegistrationDetails details=new RegistrationDetails();
			details.setClubMaster(club);
			details.setSportsMaster(sports);
			details.setApplicantName(uname);
			details.setEmail(email);
			details.setMobileNo(phone);
			
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Date birthDate=dateFormat.parse(dob);
			
			details.setDob(birthDate);
			details.setGender(gender);
			
			
		return "null";
	}

}