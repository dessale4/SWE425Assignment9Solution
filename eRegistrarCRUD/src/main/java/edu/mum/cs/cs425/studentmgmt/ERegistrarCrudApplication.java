package edu.mum.cs.cs425.studentmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({ "edu.mum.cs.cs425.studentmgmt"})
public class ERegistrarCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ERegistrarCrudApplication.class, args);
	}

}
