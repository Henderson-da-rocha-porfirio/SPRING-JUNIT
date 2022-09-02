package com.tuyo.jpqlequerynative;

import com.tuyo.jpqlequerynative.entities.Estudante;
import com.tuyo.jpqlequerynative.repository.EstudanteRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class TesteUnitarioApplicationTests {

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

	/*@Test
	public void testFindAllEstudantes() { // retorna uma lista de arrays de objeto sem o nome.
		System.out.println(repository.findAllEstudantes());
	}*/

	@Test
	public void testFindAllEstudantes() {
		System.out.println(repository.findAllEstudantes(PageRequest.of(1, 5, Direction.DESC, "id")));
	}

	@Test
	public void testFindAllEstudantesPartial() {
		List<Object[]> partialData = repository.findAllEstudantesPartialData();
		for (Object[] objects : partialData) { // usando um forEach
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}

	@Test
	public void testFindAllEstudantesByFirstName() {
		System.out.println(repository.findAllEstudantesByFirstName("Bill"));
	}

/*	@Test
	public void testFindAllEstudantesByFirstName() {
		List<Object[]> partialData = repository.findAllEstudantesPartialData();
		for (Object[] objects : partialData) { // usando um forEach
			System.out.println(objects[0]);
		}
	}*/


	@Test
	public void testFindAllEstudantesByScores() {
		System.out.println(repository.findEstudantesForGivenScores(80, 90));
	}


	@Test
	@Transactional // O fato de estar fazendo uma transação no banco, é preciso utilizar Transactional.
	@Rollback(false) // JUnit faz rollback(reversão de dados após alguma ação) por padrão, por questões de segurança. Por isso, deixar como false.
	public void testDeleteEstudantesByFirstName() {
		repository.deleteEstudantesByFirstName("Bill");
	}

	@Test
	public void testFindAllEstudanteNQ() {
		System.out.println(repository.findAllEstudanteNQ()); // teste com native query
	}

	@Test
	public void testFindByFirstNameNQ() {
		System.out.println(repository.findByFirstNQ("Bill"));
	} // teste com native query

}
