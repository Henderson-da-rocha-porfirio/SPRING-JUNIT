package com.tuyo.jpqlequerynative.repository;

import com.tuyo.jpqlequerynative.entities.Estudante;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstudanteRepository extends CrudRepository<Estudante, Long> { // Usando JPQL

    @Query("from Estudante")                                // necessário utilizar @Query. E "from Estudante" não é a tabela estudante do database. Ela sofrerá conversão. Porque se não teria que usar nativeQuery.
    List<Estudante> findAllEstudantes(Pageable pageable);   /* List<Estudante> findAllEstudantes();*/ // Para achar todos os estudantes
                                                            // List = Para listar todos os estudantes
                                                            // Pageable = implementando o Paging

    @Query("select es.firstName,es.lastName from Estudante es") // es = estudante. É uma aliás. Como se você estivesse utilizando uma native query.
    List<Object[]> findAllEstudantesPartialData(); // List<Object> array contem cada coluna que nós especificarmos nessa query.

    @Query("from Estudante where firstName=:firstName")
    List<Estudante> findAllEstudantesByFirstName(@Param("firstName") String firstName); //@Param = é dizendo ao Spring que ele deve usar o parâmetro firstName passado na Query.

/*    @Query("from Estudante where firstName=:firstName")
    List<Object[]> findAllEstudantesByFirstName(@Param("firstName") String firstName);*/


    @Query("from Estudante where score>:min and score<:max")
    List<Estudante> findEstudantesForGivenScores(@Param("min") int min, @Param("max") int max);

    @Modifying //previne exception
    @Query("delete from Estudante where firstName = :firstName")
    void deleteEstudantesByFirstName(@Param("firstName") String firstName);

/*
    @Query(value = "select * from student", nativeQuery = true)
    List<Estudante> findAllEstudanteNQ();

    @Query(value = "select * from student where fname=:firstName", nativeQuery = true)
    List<Estudante> findByFirstNQ(@Param("firstName")String firstName);
*/

}
