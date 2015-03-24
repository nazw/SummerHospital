package com.summergroup.summerhospital.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.summergroup.summerhospital.entity.Admission;
import com.summergroup.summerhospital.entity.Patient;
import com.summergroup.summerhospital.util.AdmissionStatus;


@Repository("patientDAO")
public class PatientDAOImpl implements PatientDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Patient> findAllPatients() {
		return sessionFactory.getCurrentSession().createCriteria(Patient.class).list();
		
	}

	@Override
	public List<Map> findAdmittedPatients() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Admission.class);
		criteria.createAlias("patient", "patient");
		criteria.createAlias("patient.systemUser", "systemUser");
		criteria.setProjection(Projections.projectionList()
				.add(Property.forName("admissionId").as("admissionId"))
				.add(Property.forName("systemUser.firstName").as("firstName"))
				.add(Property.forName("systemUser.lastName").as("lastName"))
				.add(Property.forName("systemUser.gender").as("gender"))
				.add(Property.forName("systemUser.birthDate").as("birthDate"))
				);
		criteria.add(Restrictions.eq("admissionStatus", AdmissionStatus.ADMITTED));
		return criteria.setResultTransformer(criteria.ALIAS_TO_ENTITY_MAP).list();
		
	}
	
	@Override
	public void savePatient(Patient patient) {
		sessionFactory.getCurrentSession().save(patient);		
	}

	@Override
	public Patient findPatientById(long patientId) {
		return (Patient) sessionFactory.getCurrentSession().get(Patient.class, patientId);
	}

	@Override
	public void updatePatient(Patient patient) {
		sessionFactory.getCurrentSession().update(patient);		
	}

	@Override
	public void deletePatient(Patient patient) {
		sessionFactory.getCurrentSession().delete(patient);		
	}

	@Override
	public void saveAdmission(Admission admission) {
		sessionFactory.getCurrentSession().save(admission);		
	}
	
	@Override
	public Admission findAdmissionById(long admissionId) {
		return (Admission) sessionFactory.getCurrentSession().get(Admission.class, admissionId);
	}

	@Override
	public void updateAdmission(Admission admission) {
		sessionFactory.getCurrentSession().update(admission);		
	}

	@Override
	public void deleteAdmission(Admission admission) {
		sessionFactory.getCurrentSession().delete(admission);		
	}
	
}
