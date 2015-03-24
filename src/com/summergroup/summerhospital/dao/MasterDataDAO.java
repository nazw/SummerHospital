package com.summergroup.summerhospital.dao;

import java.util.List;

import com.summergroup.summerhospital.entity.Doctor;
import com.summergroup.summerhospital.entity.Patient;
import com.summergroup.summerhospital.entity.Specialization;
import com.summergroup.summerhospital.entity.SystemUser;

public interface MasterDataDAO {
	public void saveSystemUser(SystemUser systemUser);

	public void deleteSystemUser(SystemUser systemUser);

	public void updateSystemUser(SystemUser systemUser);

	public SystemUser findById(long systemUserId);

	public List<SystemUser> findAll();

	public SystemUser findByEmail(String email);

	public SystemUser findByEmailAndPassword(String email, String password);

	public List<Specialization> findAllSpecializations();
	
	public void saveSpecialization(Specialization specialization);
	
	public Specialization findSpecializationById(long specializationId);
	
	public void updateSpecialization(Specialization specialization);
	
	public void deleteSpecialization(Specialization specialization);

	public List<Doctor> findAllDoctors();
	
	public void saveDoctor(Doctor doctor);
	
	public Doctor findDoctorById(long doctorId);
	
	public void updateDoctor(Doctor doctor);
	
	public void deleteDoctor(Doctor doctor);
	
	
}
