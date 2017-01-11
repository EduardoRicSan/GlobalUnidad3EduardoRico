package mx.edu.utng.tacho.datos;

import org.hibernate.HibernateException;

import mx.edu.utng.tacho.modelo.Patient;


public class PatientDAO extends DAO<Patient> {

	public PatientDAO() {
		super(new Patient());	
	}
	
	public Patient getOneById(Patient patient) throws HibernateException {
		return super.getOneById(patient.getId());
	}

}
