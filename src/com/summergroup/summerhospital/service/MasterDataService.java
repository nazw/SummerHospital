package com.summergroup.summerhospital.service;

import java.util.List;

import com.summergroup.summerhospital.entity.Doctor;
import com.summergroup.summerhospital.entity.Patient;
import com.summergroup.summerhospital.entity.Specialization;
import com.summergroup.summerhospital.entity.SystemUser;

public interface MasterDataService {
	public void saveSystemUser(SystemUser systemUser);

	public SystemUser findByEmail(String email);

	public SystemUser findByEmailAndPassword(String email, String password);
	
	public List<Specialization> findAllSpecializations();
	
	public void saveSpecialization(Specialization specialization,SystemUser systemUser);
	
	public Specialization findSpecializationById(long specializationId);
	
	public void updateSpecialization(Specialization specialization,SystemUser systemUser);
	
	public void deleteSpecialization(Long specializationId);
	
	public List<Doctor> findAllDoctors();
	
	public void saveDoctor(Doctor doctor, SystemUser systemUser);
	
	public Doctor findDoctorById(long DoctorId);
	
	public void updateDoctor(Doctor doctor, SystemUser systemUser);
	
	public void deleteDoctor(long doctorId);
	
	

}
