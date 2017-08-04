package caixaeletronico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Stateless
@Path("contas")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class ContaController {

	
	@GET
	@Path("/{numero}")
	public Conta buscar(@PathParam("numero") String numero){
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("caixaeletronico");
	    EntityManager manager = factory.createEntityManager();
	    return manager.find(Conta.class, numero);
	}
	
}
