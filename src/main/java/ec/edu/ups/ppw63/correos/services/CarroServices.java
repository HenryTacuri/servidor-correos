package ec.edu.ups.ppw63.correos.services;


import ec.edu.ups.ppw63.correos.business.GestionCorreos;
import ec.edu.ups.ppw63.correos.model.Correo;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("sendEmail")
public class CarroServices {
	
	@Inject
	private GestionCorreos gCorreos;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarCarro(Correo correo) {
		try{
			gCorreos.enviarCorreo(correo);
			ErrorMessage error = new ErrorMessage(1, "OK");
			return Response.status(Response.Status.CREATED)
					.entity(error)
					.build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}

}
