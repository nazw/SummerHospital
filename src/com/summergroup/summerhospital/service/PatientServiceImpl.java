package com.summergroup.summerhospital.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.summergroup.summerhospital.dao.PatientDAO;
import com.summergroup.summerhospital.entity.Admission;
import com.summergroup.summerhospital.entity.CommonDomainProperty;
import com.summergroup.summerhospital.entity.Patient;
import com.summergroup.summerhospital.entity.SystemUser;

@Service("patientService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientDAO patientDAO;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Patient> findAllPatients() {
		return patientDAO.findAllPatients();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Patient findPatientById(long patientId) {
		return patientDAO.findPatientById(patientId);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void savePatient(Patient patient, SystemUser systemUser) {
		CommonDomainProperty commonDomainProperty = new CommonDomainProperty();
		commonDomainProperty = constructCommonDomainProperty(commonDomainProperty, systemUser);
		patient.getSystemUser().setCommanDomainProperty(commonDomainProperty);
		patient.setCommanDomainProperty(commonDomainProperty);
		patientDAO.savePatient(patient);		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updatePatient(Patient patient, SystemUser systemUser) {
		Patient patientObj = patientDAO.findPatientById(patient.getPatientId());		
		patientObj.getSystemUser().setAddress(patient.getSystemUser().getAddress());
		patientObj.getSystemUser().setEmail(patient.getSystemUser().getEmail());
		patientObj.getSystemUser().setFirstName(patient.getSystemUser().getFirstName());
		patientObj.getSystemUser().setLastName(patient.getSystemUser().getLastName());
		patientObj.getSystemUser().setGender(patient.getSystemUser().getGender());
		patientObj.getSystemUser().setPassword(patient.getSystemUser().getPassword());
		patientObj.getSystemUser().setPhoneNo(patient.getSystemUser().getPhoneNo());
		patientObj.getSystemUser().setProfile(patient.getSystemUser().getProfile());
		patientObj.getSystemUser().setBirthDate(patient.getSystemUser().getBirthDate());
		patientObj.setBloodGroup(patient.getBloodGroup());
		patientObj.getCommanDomainProperty().setLastModifiedDate(new Date());
		patientObj.getCommanDomainProperty().setLastModifiedUser(systemUser.getSystemUserId());
		patientDAO.updatePatient(patientObj);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePatient(long patientId) {
		Patient patient = patientDAO.findPatientById(patientId);
		patientDAO.deletePatient(patient);
		
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Map> findAdmittedPatients() {
		return patientDAO.findAdmittedPatients();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveAdmission(Admission admission, SystemUser systemUser) {
		CommonDomainProperty commonDomainProperty = new CommonDomainProperty();
		commonDomainProperty = constructCommonDomainProperty(commonDomainProperty, systemUser);
		admission.getPatient().getSystemUser().setCommanDomainProperty(commonDomainProperty);
		admission.getPatient().setCommanDomainProperty(commonDomainProperty);
		admission.setCommanDomainProperty(commonDomainProperty);		
		patientDAO.saveAdmission(admission);
		
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Admission findAdmissionById(long admissionId) {
		return patientDAO.findAdmissionById(admissionId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateAdmission(Admission admission, SystemUser systemUser) {
		Admission admissionObj = patientDAO.findAdmissionById(admission.getAdmissionId());		
		admissionObj.getPatient().getSystemUser().setAddress(admission.getPatient().getSystemUser().getAddress());
		admissionObj.getPatient().getSystemUser().setEmail(admission.getPatient().getSystemUser().getEmail());
		admissionObj.getPatient().getSystemUser().setFirstName(admission.getPatient().getSystemUser().getFirstName());
		admissionObj.getPatient().getSystemUser().setLastName(admission.getPatient().getSystemUser().getLastName());
		admissionObj.getPatient().getSystemUser().setGender(admission.getPatient().getSystemUser().getGender());
		admissionObj.getPatient().getSystemUser().setPassword(admission.getPatient().getSystemUser().getPassword());
		admissionObj.getPatient().getSystemUser().setPhoneNo(admission.getPatient().getSystemUser().getPhoneNo());
		admissionObj.getPatient().getSystemUser().setProfile(admission.getPatient().getSystemUser().getProfile());
		admissionObj.getPatient().getSystemUser().setBirthDate(admission.getPatient().getSystemUser().getBirthDate());
		admissionObj.getPatient().setBloodGroup(admission.getPatient().getBloodGroup());
		admissionObj.setAdmissionStatus(admission.getAdmissionStatus());
		admissionObj.setDateAdmitted(admission.getDateAdmitted());
		admissionObj.setDateDischarged(admission.getDateDischarged());
		admissionObj.getPatient().getSystemUser().getCommanDomainProperty().setLastModifiedDate(new Date());
		admissionObj.getPatient().getSystemUser().getCommanDomainProperty().setLastModifiedUser(systemUser.getSystemUserId());
		admissionObj.getPatient().getCommanDomainProperty().setLastModifiedDate(new Date());
		admissionObj.getPatient().getCommanDomainProperty().setLastModifiedUser(systemUser.getSystemUserId());
		admissionObj.getCommanDomainProperty().setLastModifiedDate(new Date());
		admissionObj.getCommanDomainProperty().setLastModifiedUser(systemUser.getSystemUserId());
		patientDAO.updateAdmission(admissionObj);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAdmission(long admissionId) {
		Admission admission = patientDAO.findAdmissionById(admissionId);
		patientDAO.deleteAdmission(admission);
		
	}
	
	public CommonDomainProperty constructCommonDomainProperty(CommonDomainProperty commonDomainProperty, SystemUser systemUser){		
		Date date =  new Date();		
		commonDomainProperty.setCreatedUser(systemUser.getSystemUserId());
		commonDomainProperty.setCreationDate(date);		
		commonDomainProperty.setLastModifiedDate(date);
		commonDomainProperty.setLastModifiedUser(systemUser.getSystemUserId());
		return commonDomainProperty;
	}
}
