package com.summergroup.summerhospital.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.summergroup.summerhospital.entity.Admission;
import com.summergroup.summerhospital.entity.Patient;
import com.summergroup.summerhospital.entity.Specialization;
import com.summergroup.summerhospital.entity.SystemUser;
import com.summergroup.summerhospital.service.PatientService;
import com.summergroup.summerhospital.util.AdmissionStatus;
import com.summergroup.summerhospital.util.ApplicationConstants;
import com.summergroup.summerhospital.util.BloodGroup;
import com.summergroup.summerhospital.util.Gender;


@Controller
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	@RequestMapping(value = "managePatients", method = RequestMethod.GET)
	public ModelAndView managePatients() {
		List<Map> patientsList = patientService.findAdmittedPatients();
		ModelMap map = new ModelMap();
		map.put("patientsList", patientsList);
		return new ModelAndView("managePatients", map);
	}

	@RequestMapping(value = "createAdmission", method = RequestMethod.GET)
	public ModelAndView createAdmission() {
		ModelMap map = new ModelMap();
		Admission admission = new Admission();		
		map.put("admission", admission);	
		map.put("admissionStatusList", Arrays.asList(AdmissionStatus.values()));	
		map.put("genderList", Arrays.asList(Gender.values()));
		map.put("bloodGroupList", Arrays.asList(BloodGroup.values()));
		return new ModelAndView("addAdmission", map);
	}
	
	@RequestMapping(value = "saveAdmission", method = RequestMethod.POST)
	public ModelAndView saveAdmission(
			@ModelAttribute("admission") Admission admission,
			HttpSession session) {
		SystemUser systemUser = (SystemUser) session.getAttribute(ApplicationConstants.SYSTEM_USER);
		patientService.saveAdmission(admission, systemUser);
		return managePatients();		
	}

	@RequestMapping(value = "getAdmission", method = RequestMethod.GET)
	public ModelAndView getPatient(
			@RequestParam("id") long admissionId) {
		Admission admission = patientService.findAdmissionById(admissionId);
		ModelMap map = new ModelMap();
		map.put("admission", admission);	
		map.put("admissionStatusList", Arrays.asList(AdmissionStatus.values()));	
		map.put("genderList", Arrays.asList(Gender.values()));
		map.put("bloodGroupList", Arrays.asList(BloodGroup.values()));	
		return new ModelAndView("editAdmission", map);
	}

	@RequestMapping(value = "updateAdmission", method = RequestMethod.POST)
	public ModelAndView updateAdmission(
			@ModelAttribute("admission") Admission admission,
			HttpSession session) {
		SystemUser systemUser = (SystemUser) session.getAttribute(ApplicationConstants.SYSTEM_USER);
		patientService.updateAdmission(admission, systemUser);
		return managePatients();
	}

	@RequestMapping(value = "deleteAdmission", method = RequestMethod.GET)
	public ModelAndView deleteAdmission(
			@RequestParam("id") long admissionId) {		
		patientService.deleteAdmission(admissionId);
		return managePatients();
	}
	
	

}
