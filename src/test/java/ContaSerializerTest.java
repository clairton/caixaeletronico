import static org.junit.Assert.assertEquals;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

public class ContaSerializerTest {

	@Test
	public void testSerialize() throws JAXBException {
		Conta conta = new Conta("123", 3.0);
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<conta><numero>123</numero><saldo>3.0</saldo><movimentacao/></conta>";

		JAXBContext jaxbContext = JAXBContext.newInstance(Conta.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		StringWriter sw = new StringWriter();
		marshaller.marshal(conta, sw);

		assertEquals(xml, sw.toString());
	}

}
