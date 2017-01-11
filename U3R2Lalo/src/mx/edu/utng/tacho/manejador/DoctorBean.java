package mx.edu.utng.tacho.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.edu.utng.tacho.datos.DoctorDAO;
import mx.edu.utng.tacho.modelo.Doctor;


@ManagedBean
@SessionScoped
public class DoctorBean implements Serializable {

	private List<Doctor> doctors;
	private Doctor doctor;
	

	public String listar() {
		DoctorDAO dao = new DoctorDAO();
		try {
			doctors = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Doctors";
	}

	public String eliminar() {
		DoctorDAO dao = new DoctorDAO();
		try {
			dao.delete(doctor);
			doctors = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		doctor = new Doctor();	
		return "Agregar";
	}

	public String guardar() {
		DoctorDAO dao = new DoctorDAO();
		try {
			if (doctor.getId() != 0) {
				dao.update(doctor);
			} else {
				dao.insert(doctor);
			}
			doctors = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}

	public String cancelar() {
		return "Cancelar";
	}

	public String editar(Doctor doctor){
		this.doctor = doctor;
		return "Editar";
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	

	
}
