package br.com.drianodev.migracao_dados_job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MigracaoDadosJobApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MigracaoDadosJobApplication.class, args);
		context.close();
	}

}
