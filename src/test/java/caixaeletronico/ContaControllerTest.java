package caixaeletronico;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.BeforeClass;
import org.junit.Test;

import caixaeletronico.CaixaEletronicoApi;
import caixaeletronico.Conta;

public class ContaControllerTest extends JerseyTest{
	
	@BeforeClass
	public static void setUpClass(){
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("caixaeletronico");
	    EntityManager manager = factory.createEntityManager();
	    
	    String numero = "789";
	    
	    if(manager.find(Conta.class, numero) == null){
	    	LocalDateTime ocorridoEm = LocalDateTime.of(2001, 1, 1, 1, 1, 1);
	    	Conta conta = new Conta(numero, 10.0, ocorridoEm);
	    	
	    	manager.getTransaction().begin();
	    	manager.persist(conta);
	    	manager.getTransaction().commit();
	    }
	    
	}
	
	
	@Override
    protected Application configure() {
        return new CaixaEletronicoApi();
    }

	@Test
	public void testBuscar() throws Exception{
		String url = "http://localhost:9998/contas/789";
		
		URL obj = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.addRequestProperty("Accept", "application/json");
		assertEquals(200, connection.getResponseCode());

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		assertEquals("{\"numero\":\"789\",\"saldo\":10.0,\"movimentacao\":[{\"id\":2,\"ocorridoEm\":\"2001-01-01T01:01:01\",\"valor\":10.0}]}", response.toString());
	}
	
}
