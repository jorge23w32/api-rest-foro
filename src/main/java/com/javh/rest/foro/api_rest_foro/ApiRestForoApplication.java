package com.javh.rest.foro.api_rest_foro;

//import com.javh.rest.foro.api_rest_foro.console.PruebasClases;
//import com.javh.rest.foro.api_rest_foro.domain.topico.TopicoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiRestForoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestForoApplication.class, args);
	}

}

////Ejecutar desde consola
//
//@SpringBootApplication
//public class ApiRestForoApplication implements CommandLineRunner {
//	@Autowired
//	private TopicoRepository topicoRepository;
//
//	public ApiRestForoApplication() {
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(ApiRestForoApplication.class, args);
//	}
//
//	public void run(String... args) throws Exception {
//		PruebasClases pruebasClases = new PruebasClases(topicoRepository);
//		pruebasClases.probar();
//	}
//}