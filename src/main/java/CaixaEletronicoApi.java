import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class CaixaEletronicoApi extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> controllers = new HashSet<Class<?>>();
		controllers.add(ContaController.class);
		return controllers;
	}
	
}
