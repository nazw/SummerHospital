package com.summergroup.summerhospital.service;

import java.util.List;
import java.util.Map;

import com.summergroup.summerhospital.entity.Admission;
import com.summergroup.summerhospital.entity.Patient;
import com.summergroup.summerhospital.entity.SystemUser;

public interface PatientService {
	public List<Patient> findAllPatients();

	public List<Map> findAdmittedPatients();
	
	public void savePatient(Patient patient, SystemUser systemUser);
	
	public Patient findPatientById(long patientId);
	
	public void updatePatient(Patient patient, SystemUser systemUser);
	
	public void deletePatient(long patientId);
	
	public void saveAdmission(Admission admission, SystemUser systemUser);
		
	public Admission findAdmissionById(long admissionId);
	
	public void updateAdmission(Admission admission, SystemUser systemUser);
	
	public void deleteAdmission(long admissionId);
}
