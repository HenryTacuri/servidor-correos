package ec.edu.ups.ppw63.carros_crud.business;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.carros_crud.dao.CarroDAO;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

//@Singleton
//@Startup
public class GestionDatos {

	/*@Inject
	private CarroDAO daoCliente;
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setDni("0103709911");
		cliente.setDireccion("Monay");
		cliente.setNombre("Cristian Timbi");
		
		daoCliente.insert(cliente);
		
		cliente = new Cliente();
		cliente.setCodigo(2);
		cliente.setDni("098987332");
		cliente.setDireccion("Monay");
		cliente.setNombre("Juan Torres");
		
		daoCliente.insert(cliente);
		
	}*/
}
