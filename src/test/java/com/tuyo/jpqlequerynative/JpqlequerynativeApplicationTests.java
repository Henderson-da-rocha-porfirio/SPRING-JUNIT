package com.tuyo.jpqlequerynative;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;

import com.tuyo.jpqlequerynative.entities.Estudante;
import com.tuyo.jpqlequerynative.repository.EstudanteRepository;

@SpringBootTest
class JpqlequerynativeApplicationTests {

	@Autowired
	EstudanteRepository repository;

	@Test
	public void testEstudanteCreate() {
		Estudante estudante = new Estudante();
		estudante.setFirstName("John");
		estudante.setLastName("Ferguson");
		estudante.setScore(88);

		Estudante estudante2 = new Estudante();
		estudante2.setFirstName("Bill");
		estudante2.setLastName("Gates");
		estudante2.setScore(75);

		repository.save(estudante);
		repository.save(estudante2);
	}

}
