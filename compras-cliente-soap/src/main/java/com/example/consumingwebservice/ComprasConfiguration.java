
package com.example.consumingwebservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ComprasConfiguration {
	
	@Value("${marshaller.context.path}")
	private String marshallerContextPath;

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(marshallerContextPath);
		return marshaller;
	}

	@Bean
	public ComprasClient comprasCliente(Jaxb2Marshaller marshaller) {
		ComprasClient client = new ComprasClient();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
