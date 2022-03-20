package com.tuyo.jpqlequerynative.repository;

import com.tuyo.jpqlequerynative.entities.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.*;

import java.util.*;

import com.tuyo.jpqlequerynative.entities.Estudante;

public interface EstudanteRepository extends CrudRepository<Estudante, Long> {

/*
    @Query("from Estudante")
    List<Estudante> findAllEstudantes(Pageable pageable);

    @Query("select st.firstName,st.lastName from Estudante st")
    List<Object[]> findAllEstudantesPartialData();

    @Query("from Estudante where firstName=:firstName")
    List<Estudante> findAllEstudantesByFirstName(@Param("firstName") String firstName);

    @Query("from Estudante where score>:min and score<:max")
    List<Estudante> findEstudantesForGivenScores(@Param("min") int min, @Param("max") int max);

    @Modifying
    @Query("delete from Estudante where firstName = :firstName")
    void deleteEstudantesByFirstName(@Param("firstName") String firstName);

    @Query(value = "select * from student", nativeQuery = true)
    List<Estudante> findAllEstudanteNQ();

    @Query(value = "select * from student where fname=:firstName", nativeQuery = true)
    List<Estudante> findByFirstNQ(@Param("firstName")String firstName);
*/

}
