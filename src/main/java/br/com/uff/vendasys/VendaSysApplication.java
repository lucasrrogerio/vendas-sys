package br.com.uff.vendasys;

import br.com.uff.vendasys.web.mapper.MapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendaSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendaSysApplication.class, args);
	}

}
