import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class ContaIntegrationTest {
    
    @Test
    public void testSalvar(){
        Properties configuracoes = new Properties();

        configuracoes.put("javax.persistence.jdbc.driver", "org.hsqldb.jdbcDriver");
        configuracoes.put("javax.persistence.schema-generation.database.action", "drop-and-create");
        configuracoes.put("javax.persistence.validation.mode", "AUTO");
        configuracoes.put("javax.persistence.jdbc.url", "jdbc:hsqldb:file:target/test;hsqldb.lock_file=false;create=true");
        configuracoes.put("javax.persistence.jdbc.user", "sa");
        configuracoes.put("javax.persistence.jdbc.password", "");
        configuracoes.put("eclipselink.logging.level", "FINE");
        
        EntityManagerFactory factory = 
            Persistence.createEntityManagerFactory("caixaeletronico", configuracoes);
        EntityManager manager = factory.createEntityManager();
        
        Conta conta = new Conta("123", 10.0);
       
        manager.getTransaction().begin();
        manager.persist(conta);
        manager.getTransaction().commit();
        
        assertNotNull(manager.find(Conta.class, "123"));
       
    }
    
}
