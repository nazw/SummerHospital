package com.summergroup.summerhospital.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.summergroup.summerhospital.entity.Doctor;
import com.summergroup.summerhospital.entity.Patient;
import com.summergroup.summerhospital.entity.Specialization;
import com.summergroup.summerhospital.entity.SystemUser;
import com.summergroup.summerhospital.service.MasterDataService;
import com.summergroup.summerhospital.util.AccountStatus;
import com.summergroup.summerhospital.util.ApplicationConstants;
import com.summergroup.summerhospital.util.BloodGroup;
import com.summergroup.summerhospital.util.Gender;

@Controller
public class MasterDataController {

	@Autowired
	private MasterDataService masterDataService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getUserLogin() {
		SystemUser systemUser = new SystemUser();
		ModelMap map = new ModelMap();
		map.put("systemUser", systemUser);
		return new ModelAndView("login", map);
	}

	@RequestMapping(value = "dashBoard", method = RequestMethod.GET)
	public ModelAndView getDashBoard() {
		return new ModelAndView("dashBoard");
	}

	@RequestMapping(value = "systemUserLogin", method = RequestMethod.POST)
	public ModelAndView systemUserLogin(
			@ModelAttribute("systemUser") SystemUser systemUser,
			HttpSession session) {
		SystemUser user = masterDataService.findByEmailAndPassword(
				systemUser.getEmail(), systemUser.getPassword());
		ModelMap map = new ModelMap();
		if (user != null) {
			if ((SystemUser) session
					.getAttribute(ApplicationConstants.SYSTEM_USER) != null) {
				session.removeAttribute(ApplicationConstants.SYSTEM_USER);
			}
			session.setAttribute(ApplicationConstants.SYSTEM_USER, user);
			return getDashBoard();
		} else {
			String errorMessage = "Invalid UserName or Password";
			map.put("errorMessage", errorMessage);
			return new ModelAndView("error", map);
		}
	}

	@RequestMapping(value = "userSignOut", method = RequestMethod.GET)
	public ModelAndView userSignOut(HttpSession session) {
		session.removeAttribute(ApplicationConstants.SYSTEM_USER);
		return new ModelAndView("login");
	}

	@RequestMapping(value = "manageSpecialization", method = RequestMethod.GET)
	public ModelAndView manageSpecialization() {
		List<Specialization> specializationsList = masterDataService
				.findAllSpecializations();
		ModelMap map = new ModelMap();
		map.put("specializationsList", specializationsList);
		return new ModelAndView("manageSpecialization", map);
	}

	@RequestMapping(value = "createSpecialization", method = RequestMethod.GET)
	public ModelAndView createSpecialization() {
		ModelMap map = new ModelMap();
		Specialization specialization = new Specialization();
		map.put("specialization", specialization);
		return new ModelAndView("addSpecialization", map);
	}

	@RequestMapping(value = "saveSpecialization", method = RequestMethod.POST)
	public ModelAndView saveSpecialization(
			@ModelAttribute("specialization") Specialization specialization,
			HttpSession session) {
		SystemUser systemUser = (SystemUser) session
				.getAttribute(ApplicationConstants.SYSTEM_USER);
		masterDataService.saveSpecialization(specialization, systemUser);
		return manageSpecialization();
	}

	@RequestMapping(value = "getSpecialization", method = RequestMethod.GET)
	public ModelAndView getSpecialization(
			@RequestParam("id") long specializationId) {
		Specialization specialization = masterDataService
				.findSpecializationById(specializationId);
		ModelMap map = new ModelMap();
		map.put("specialization", specialization);
		return new ModelAndView("editSpecialization", map);
	}

	@RequestMapping(value = "updateSpecialization", method = RequestMethod.POST)
	public ModelAndView updateSpecialization(
			@ModelAttribute("specialization") Specialization specialization,
			HttpSession session) {
		SystemUser systemUser = (SystemUser) session
				.getAttribute(ApplicationConstants.SYSTEM_USER);
		masterDataService.updateSpecialization(specialization, systemUser);
		return manageSpecialization();
	}

	@RequestMapping(value = "deleteSpecialization", method = RequestMethod.GET)
	public ModelAndView deleteSpecialization(
			@RequestParam("id") long specializationId) {		
		masterDataService.deleteSpecialization(specializationId);
		return manageSpecialization();
	}

	
	@RequestMapping(value = "manageDoctors", method = RequestMethod.GET)
	public ModelAndView manageDoctors() {
		List<Doctor> doctorsList = masterDataService.findAllDoctors();
		ModelMap map = new ModelMap();
		map.put("doctorsList", doctorsList);
		return new ModelAndView("manageDoctors", map);
	}

	@RequestMapping(value = "createDoctor", method = RequestMethod.GET)
	public ModelAndView createDoctor() {
		ModelMap map = new ModelMap();
		Doctor doctor = new Doctor();
		List<Specialization> specializationList = masterDataService.findAllSpecializations();
		map.put("doctor", doctor);
		map.put("specializationList", specializationList);
		map.put("genderList", Arrays.asList(Gender.values()));
		map.put("accountStatusList", Arrays.asList(AccountStatus.values()));
		return new ModelAndView("addDoctor", map);
	}

	@RequestMapping(value = "saveDoctor", method = RequestMethod.POST)
	public ModelAndView saveDoctor(
			@ModelAttribute("doctor") Doctor doctor,
			HttpSession session) {
		SystemUser systemUser = (SystemUser) session.getAttribute(ApplicationConstants.SYSTEM_USER);
		masterDataService.saveDoctor(doctor, systemUser);
		return manageDoctors();
	}

	@RequestMapping(value = "getDoctor", method = RequestMethod.GET)
	public ModelAndView getDoctor(
			@RequestParam("id") long doctorId) {
		Doctor doctor = masterDataService.findDoctorById(doctorId);
		ModelMap map = new ModelMap();
		List<Specialization> specializationList = masterDataService.findAllSpecializations();
		map.put("doctor", doctor);
		map.put("specializationList", specializationList);
		map.put("genderList", Arrays.asList(Gender.values()));
		map.put("accountStatusList", Arrays.asList(AccountStatus.values()));
		return new ModelAndView("editDoctor", map);
	}

	@RequestMapping(value = "updateDoctor", method = RequestMethod.POST)
	public ModelAndView updateDoctor(
			@ModelAttribute("doctor") Doctor doctor,
			HttpSession session) {
		SystemUser systemUser = (SystemUser) session.getAttribute(ApplicationConstants.SYSTEM_USER);
		masterDataService.updateDoctor(doctor, systemUser);
		return manageDoctors();
	}

	@RequestMapping(value = "deleteDoctor", method = RequestMethod.GET)
	public ModelAndView deleteDoctor(
			@RequestParam("id") long doctorId) {		
		masterDataService.deleteDoctor(doctorId);
		return manageDoctors();
	}

	
}
