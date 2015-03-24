package com.summergroup.summerhospital.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.summergroup.summerhospital.entity.Admission;
import com.summergroup.summerhospital.entity.Doctor;
import com.summergroup.summerhospital.entity.Patient;
import com.summergroup.summerhospital.entity.Specialization;
import com.summergroup.summerhospital.entity.SystemUser;


@Repository("masterDataDAO")
public class MasterDataDAOImpl implements MasterDataDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveSystemUser(SystemUser systemUser) {
		sessionFactory.getCurrentSession().save(systemUser);
	}

	@Override
	public void deleteSystemUser(SystemUser systemUser) {
		sessionFactory.getCurrentSession().delete(systemUser);
	}

	@Override
	public void updateSystemUser(SystemUser systemUser) {
		sessionFactory.getCurrentSession().update(systemUser);
	}

	@Override
	public SystemUser findById(long systemUserId) {
		return (SystemUser) sessionFactory.getCurrentSession().get(
				SystemUser.class, systemUserId);
	}

	@Override
	public List<SystemUser> findAll() {
		return sessionFactory.getCurrentSession()
				.createCriteria(SystemUser.class).list();
	}

	@Override
	public SystemUser findByEmail(String email) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				SystemUser.class);
		criteria.add(Restrictions.eq("email", email));
		return (SystemUser) criteria.uniqueResult();
	}

	@Override
	public SystemUser findByEmailAndPassword(String email, String password) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SystemUser.class);
		criteria.add(Restrictions.conjunction()
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password)));
		return (SystemUser) criteria.uniqueResult();
	}

	@Override
	public List<Specialization> findAllSpecializations() {
		return sessionFactory.getCurrentSession().createCriteria(Specialization.class).list();
	}

	@Override
	public void saveSpecialization(Specialization specialization) {
		sessionFactory.getCurrentSession().save(specialization);
	}

	@Override
	public Specialization findSpecializationById(long specializationId) {
		return (Specialization) sessionFactory.getCurrentSession().get(Specialization.class, specializationId);
	}

	@Override
	public void updateSpecialization(Specialization specialization) {
		sessionFactory.getCurrentSession().update(specialization);		
	}
	
	@Override
	public void deleteSpecialization(Specialization specialization) {
		sessionFactory.getCurrentSession().delete(specialization);		
	}

	@Override
	public List<Doctor> findAllDoctors() {
		return sessionFactory.getCurrentSession().createCriteria(Doctor.class).list();
	}

	@Override
	public void saveDoctor(Doctor doctor) {
		sessionFactory.getCurrentSession().save(doctor);
	}

	@Override
	public Doctor findDoctorById(long doctorId) {
		return (Doctor) sessionFactory.getCurrentSession().get(Doctor.class, doctorId);
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		sessionFactory.getCurrentSession().update(doctor);
	}

	@Override
	public void deleteDoctor(Doctor doctor) {
		sessionFactory.getCurrentSession().delete(doctor);		
	}
	
}
