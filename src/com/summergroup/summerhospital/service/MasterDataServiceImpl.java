package com.summergroup.summerhospital.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.summergroup.summerhospital.dao.MasterDataDAO;
import com.summergroup.summerhospital.entity.CommonDomainProperty;
import com.summergroup.summerhospital.entity.Doctor;
import com.summergroup.summerhospital.entity.Patient;
import com.summergroup.summerhospital.entity.Specialization;
import com.summergroup.summerhospital.entity.SystemUser;

@Service("masterDataService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MasterDataServiceImpl implements MasterDataService {

	@Autowired
	private MasterDataDAO masterDataDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveSystemUser(SystemUser systemUser) {
		masterDataDAO.saveSystemUser(systemUser);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SystemUser findByEmail(String email) {
		return masterDataDAO.findByEmail(email);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SystemUser findByEmailAndPassword(String email, String password) {
		return masterDataDAO.findByEmailAndPassword(email, password);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Specialization> findAllSpecializations() {
		return masterDataDAO.findAllSpecializations();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveSpecialization(Specialization specialization, SystemUser systemUser) {
		Specialization specializationObj = new Specialization();
		CommonDomainProperty commonDomainProperty = new CommonDomainProperty();
		specializationObj.setName(specialization.getName().trim());
		specializationObj.setDescription(specialization.getDescription().trim());
		commonDomainProperty = constructCommonDomainProperty(commonDomainProperty, systemUser);
		specialization.setCommanDomainProperty(commonDomainProperty);
		masterDataDAO.saveSpecialization(specialization);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Specialization findSpecializationById(long specializationId) {
		return masterDataDAO.findSpecializationById(specializationId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateSpecialization(Specialization specialization,	SystemUser systemUser) {
		Specialization specializationObj = masterDataDAO.findSpecializationById(specialization.getSpecializationId());
		specializationObj.setName(specialization.getName().trim());
		specializationObj.setDescription(specialization.getDescription().trim());
		specializationObj.getCommanDomainProperty().setLastModifiedDate(new Date());
		specializationObj.getCommanDomainProperty().setLastModifiedUser(systemUser.getSystemUserId());
		masterDataDAO.updateSpecialization(specializationObj);		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteSpecialization(Long specializationId) {
		Specialization specialization = masterDataDAO.findSpecializationById(specializationId);		
		masterDataDAO.deleteSpecialization(specialization);		
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Doctor> findAllDoctors() {
		return masterDataDAO.findAllDoctors();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveDoctor(Doctor doctor, SystemUser systemUser) {		
		CommonDomainProperty commonDomainProperty = new CommonDomainProperty();
		commonDomainProperty = constructCommonDomainProperty(commonDomainProperty, systemUser);
		doctor.getSystemUser().setCommanDomainProperty(commonDomainProperty);
		doctor.setCommanDomainProperty(commonDomainProperty);
		masterDataDAO.saveDoctor(doctor);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Doctor findDoctorById(long doctorId) {
		return masterDataDAO.findDoctorById(doctorId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateDoctor(Doctor doctor, SystemUser systemUser) {
		Doctor doctorObj = masterDataDAO.findDoctorById(doctor.getDoctorId());		
		doctorObj.setDescription(doctor.getDescription());
		doctorObj.setLicenceNo(doctor.getLicenceNo());
		doctorObj.setAccountStatus(doctor.getAccountStatus());
		doctorObj.setSpecialization(doctor.getSpecialization());
		doctorObj.getSystemUser().setAddress(doctor.getSystemUser().getAddress());
		doctorObj.getSystemUser().setEmail(doctor.getSystemUser().getEmail());
		doctorObj.getSystemUser().setFirstName(doctor.getSystemUser().getFirstName());
		doctorObj.getSystemUser().setLastName(doctor.getSystemUser().getLastName());
		doctorObj.getSystemUser().setGender(doctor.getSystemUser().getGender());
		doctorObj.getSystemUser().setPassword(doctor.getSystemUser().getPassword());
		doctorObj.getSystemUser().setPhoneNo(doctor.getSystemUser().getPhoneNo());
		doctorObj.getSystemUser().setProfile(doctor.getSystemUser().getProfile());
		doctorObj.getSystemUser().setBirthDate(doctor.getSystemUser().getBirthDate());
		doctorObj.getCommanDomainProperty().setLastModifiedDate(new Date());
		doctorObj.getCommanDomainProperty().setLastModifiedUser(systemUser.getSystemUserId());
		masterDataDAO.updateDoctor(doctorObj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteDoctor(long doctorId) {
		Doctor doctor = masterDataDAO.findDoctorById(doctorId);
		masterDataDAO.deleteDoctor(doctor);
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
