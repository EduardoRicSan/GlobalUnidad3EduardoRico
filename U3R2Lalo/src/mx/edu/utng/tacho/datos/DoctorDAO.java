package mx.edu.utng.tacho.datos;

import org.hibernate.HibernateException;

import mx.edu.utng.tacho.modelo.Doctor;

public class DoctorDAO extends DAO<Doctor> {

	public DoctorDAO() {
		super(new Doctor());	
	}
	
	public Doctor getOneById(Doctor doctor) throws HibernateException {
		return super.getOneById(doctor.getId());
	}
	

}
