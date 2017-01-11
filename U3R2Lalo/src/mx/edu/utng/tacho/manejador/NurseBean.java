package mx.edu.utng.tacho.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.edu.utng.tacho.datos.DoctorDAO;
import mx.edu.utng.tacho.datos.NurseDAO;
import mx.edu.utng.tacho.modelo.Doctor;
import mx.edu.utng.tacho.modelo.Nurse;


@ManagedBean
@SessionScoped
public class NurseBean implements Serializable {
	
	private List<Nurse> nurses;
	private Nurse nurse;
	private List<Doctor> doctors;
	
	
	public NurseBean() {
		nurse = new Nurse(); 
	}


	public String listar(){
		NurseDAO dao = new NurseDAO();
		try {
			nurses = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Nurses";
	}
	
	public String eliminar(){
		NurseDAO dao = new NurseDAO();
		try {
			dao.delete(nurse);
			nurses = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		nurse = new Nurse();
		nurse.setDoctor(new Doctor());
		try{
			doctors = new DoctorDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Agregar";
	}
	
	public String guardar(){
		NurseDAO dao = new NurseDAO();
		try {
			if (nurse.getId() != 0) {
				dao.update(nurse);
			} else {
				dao.insert(nurse);
			}
			nurses = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}
	
	public String cancelar(){
		return "Cancelar";
	}
	
	public String editar(Nurse nurse){
		this.nurse = nurse;
		try{
			doctors = new DoctorDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Editar";
	}


	public List<Nurse> getNurses() {
		return nurses;
	}


	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}


	public Nurse getNurse() {
		return nurse;
	}


	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}


	public List<Doctor> getDoctors() {
		return doctors;
	}


	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	
}
