package caixaeletronico;
import static org.junit.Assert.assertEquals;

import java.io.StringWriter;
import java.time.LocalDateTime;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import caixaeletronico.Conta;

public class ContaSerializerTest {

	@Test
	public void testSerialize() throws JAXBException {
    	LocalDateTime ocorridoEm = LocalDateTime.of(2001, 1, 1, 1, 1, 1);
		Conta conta = new Conta("123", 3.0, ocorridoEm);
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<conta><numero>123</numero><saldo>3.0</saldo>"
				+ "<movimentacao><ocorridoEm>2001-01-01T01:01:01</ocorridoEm><valor>3.0</valor></movimentacao>"
				+ "</conta>";

		JAXBContext jaxbContext = JAXBContext.newInstance(Conta.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		StringWriter sw = new StringWriter();
		marshaller.marshal(conta, sw);

		assertEquals(xml, sw.toString());
	}

}
