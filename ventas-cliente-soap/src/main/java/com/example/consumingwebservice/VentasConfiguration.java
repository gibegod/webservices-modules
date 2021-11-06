
package com.example.consumingwebservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class VentasConfiguration {
	
	@Value("${marshaller.context.path}")
	private String marshallerContextPath;

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(marshallerContextPath);
		return marshaller;
	}

	@Bean
	public VentasClient ventasClient(Jaxb2Marshaller marshaller) {
		VentasClient client = new VentasClient();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
