package ec.edu.ups.ppw63.correos.business;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;

import ec.edu.ups.ppw63.correos.model.Correo;
import jakarta.ejb.Stateless;

@Stateless
public class GestionCorreos {

	public void enviarCorreo(Correo correo) {
        Resend resend = new Resend("re_YsFAVDyt_3Ye2DZtf6wgCWfzEnesdeVw8");

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("onboarding@resend.dev")
                .to("henry.tacuri99@gmail.com")
                .subject(correo.getSubject())
                .html("<strong>"+correo.getBody()+"</strong>")
                .build();

         try {
            CreateEmailResponse data = resend.emails().send(params);
            System.out.println(data.getId());
        } catch (ResendException e) {
            e.printStackTrace();
        }
	}
	
}
