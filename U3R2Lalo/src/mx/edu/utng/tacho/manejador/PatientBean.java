package mx.edu.utng.tacho.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.edu.utng.tacho.datos.DoctorDAO;
import mx.edu.utng.tacho.datos.PatientDAO;
import mx.edu.utng.tacho.modelo.Doctor;
import mx.edu.utng.tacho.modelo.Patient;


@ManagedBean
@SessionScoped
public class PatientBean implements Serializable {
	
	private List<Patient> patients;
	private Patient patient;
	private List<Doctor> doctors;
	
	
	public PatientBean() {
		patient = new Patient(); 
	}


	public String listar(){
		PatientDAO dao = new PatientDAO();
		try {
			patients = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Patients";
	}
	
	public String eliminar(){
		PatientDAO dao = new PatientDAO();
		try {
			dao.delete(patient);
			patients = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		patient = new Patient();
		patient.setDoctor(new Doctor());
		try{
			doctors = new DoctorDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Agregar";
	}
	
	public String guardar(){
		PatientDAO dao = new PatientDAO();
		try {
			if (patient.getId() != 0) {
				dao.update(patient);
			} else {
				dao.insert(patient);
			}
			patients = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}
	
	public String cancelar(){
		return "Cancelar";
	}
	
	public String editar(Patient patient){
		this.patient = patient;
		try{
			doctors = new DoctorDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Editar";
	}


	public List<Patient> getPatients() {
		return patients;
	}


	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public List<Doctor> getDoctors() {
		return doctors;
	}


	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	

}
