package mx.edu.utng.tacho.datos;

import java.io.Serializable;
import org.hibernate.HibernateException;

import mx.edu.utng.tacho.modelo.Proveedor;


public class ProveedorDAO extends DAO<Proveedor> {

	public ProveedorDAO() {
		super(new Proveedor());	
	}
	
	public Proveedor getOneById(Proveedor proveedor) throws HibernateException {
		return super.getOneById(proveedor.getId());
	}
}
