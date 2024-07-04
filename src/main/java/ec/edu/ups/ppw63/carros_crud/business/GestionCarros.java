package ec.edu.ups.ppw63.carros_crud.business;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import ec.edu.ups.ppw63.carros_crud.dao.CarroDAO;
import ec.edu.ups.ppw63.carros_crud.model.Carro;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCarros {
	
	@Inject
	private CarroDAO daoCarro;

	
	public void guardarCarro(Carro carro) {
		Carro car = daoCarro.read(carro.getCodigo());
		if (car != null){
			daoCarro.update(carro);
		}else {
			daoCarro.insert(carro);
		}
		this.enviarCorreo("Registro de carro", "Se registra un carro con codigo " + carro.getCodigo());
	}
	
	
	public void actualizarCarro(Carro carro) throws Exception {
		Carro car = daoCarro.read(carro.getCodigo());
		if (car != null){
			daoCarro.update(carro);
		}else {
			throw new Exception("Carro no existe");
		}
		this.enviarCorreo("Actualización de carro", "Se actualiza un carro con codigo " + carro.getCodigo());
	}
	

	public Carro getCarroPorCodigo(int codigo) throws Exception{
		
		if(codigo<0)
			throw new Exception("Codigo incorrecto");
			
		return daoCarro.getCarroPorCodigo(codigo);
	}
	

	public void borrarCarro(int codigo){
		
		daoCarro.remove(codigo);
		this.enviarCorreo("Eliminación de carro", "Se elimina un carro con codigo " + codigo);
	}
	

	public List<Carro> getCarros(){
		return daoCarro.getAll();
	}
	
	
	private void enviarCorreo(String subject, String body) {
        String apiEndpoint = "http://10.128.0.9:8080/correos/rs/sendEmail";

        String mensaje = "{\"subject\": \"" + subject + "\", \"body\": \"" + body + "\"}";

        HttpClient httpClient = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiEndpoint))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(mensaje))
                .build();

        
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            String responseBody = response.body();

            System.out.println("Status code: " + statusCode);
            System.out.println("Response body: " + responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	}
	
}


