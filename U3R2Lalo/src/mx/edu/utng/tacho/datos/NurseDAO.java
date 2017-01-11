package mx.edu.utng.tacho.datos;

import org.hibernate.HibernateException;

import mx.edu.utng.tacho.modelo.Nurse;


public class NurseDAO extends DAO<Nurse> {

	public NurseDAO() {
		super(new Nurse());	
	}
	
	public Nurse getOneById(Nurse nurse) throws HibernateException {
		return super.getOneById(nurse.getId());
	}

}
