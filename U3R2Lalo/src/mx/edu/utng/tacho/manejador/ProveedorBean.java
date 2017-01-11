package mx.edu.utng.tacho.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.edu.utng.tacho.datos.ProveedorDAO;

import mx.edu.utng.tacho.modelo.Proveedor;



@ManagedBean
@SessionScoped
public class ProveedorBean implements Serializable {

	private List<Proveedor> proveedores;
	private Proveedor proveedor;
	

	public String listar() {
		ProveedorDAO dao = new ProveedorDAO();
		try {
			proveedores = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Proveedores";
	}

	public String eliminar() {
		ProveedorDAO dao = new ProveedorDAO();
		try {
			dao.delete(proveedor);
			proveedores = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		proveedor = new Proveedor();	
		return "Agregar";
	}

	public String guardar() {
		ProveedorDAO dao = new ProveedorDAO();
		try {
			if (proveedor.getId() != 0) {
				dao.update(proveedor);
			} else {
				dao.insert(proveedor);
			}
			proveedores = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}

	public String cancelar() {
		return "Cancelar";
	}

	public String editar(Proveedor proveedor){
		this.proveedor = proveedor;
		return "Editar";
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	

	
	
	
}
