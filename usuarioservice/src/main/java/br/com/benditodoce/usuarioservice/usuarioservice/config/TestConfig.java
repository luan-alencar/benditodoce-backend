package br.com.benditodoce.usuarioservice.usuarioservice.config;

import br.com.benditodoce.usuarioservice.usuarioservice.services.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("test")
@RequiredArgsConstructor
public class TestConfig {

	private final DBService dbService;
	
	@Bean
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}
}
