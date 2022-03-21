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

    @Query("select es.firstName,es.lastName from Estudante es") // es = estudante. Isso é uma aliás.
    List<Object[]> findAllEstudantesPartialData(); // List<Object> array contem cada coluna que nós especificarmos nessa query.

    @Query("from Estudante where firstName=:firstName")
    List<Estudante> findAllEstudantesByFirstName(@Param("firstName") String firstName); //@Param = é dizendo ao Spring que ele deve usar o parâmetro firstName passado na Query.

/*    @Query("from Estudante where firstName=:firstName")
    List<Object[]> findAllEstudantesByFirstName(@Param("firstName") String firstName);*/


    @Query("from Estudante where score>:min and score<:max")
    List<Estudante> findEstudantesForGivenScores(@Param("min") int min, @Param("max") int max);

    @Modifying                                                                          //previne exception
    @Query("delete from Estudante where firstName = :firstName")                           // não esquecer de usar @Transactional e @Rollback(false) no teste correspondente.
    void deleteEstudantesByFirstName(@Param("firstName") String firstName);

    @Query(value = "select * from estudante", nativeQuery = true) // Usando Native Query
    List<Estudante> findAllEstudanteNQ();                           // Lembrar que assim como JPQL, estudante alí é case sensitive, ou seja, tem que estar igual ao database.
                                                                    // nativeQuery tem que ser true para não dar erro.
                                                                    // Não há conversão aqui. Ele está realizando o select diretamente no database.
                                                                    // NQ = nativeQuery

    @Query(value = "select * from estudante where fname=:firstName", nativeQuery = true) // Usando Native Query
    List<Estudante> findByFirstNQ(@Param("firstName")String firstName);                 // Ligamos (bind = ligar) ele ao passarmos o parâmetro firstName e não esquecer de passar o @Param.
                                                                                        // Igual ao feito na linha 22 com JPQL.
}
