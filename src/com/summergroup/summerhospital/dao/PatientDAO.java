package com.summergroup.summerhospital.dao;

import java.util.List;
import java.util.Map;

import com.summergroup.summerhospital.entity.Admission;
import com.summergroup.summerhospital.entity.Patient;

public interface PatientDAO {

	public List<Patient> findAllPatients();

	public List<Map> findAdmittedPatients();

	public void savePatient(Patient patient);

	public Patient findPatientById(long patientId);

	public void updatePatient(Patient patient);

	public void deletePatient(Patient patient);
	
	public void saveAdmission(Admission admission);
		
	public Admission findAdmissionById(long admissionId);
	
	public void updateAdmission(Admission admission);
	
	public void deleteAdmission(Admission admission);

}
