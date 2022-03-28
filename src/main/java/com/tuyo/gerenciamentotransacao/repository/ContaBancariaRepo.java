package com.tuyo.gerenciamentotransacao.repository;

import com.tuyo.gerenciamentotransacao.entities.ContaBancaria;
import org.springframework.data.repository.CrudRepository;

public interface ContaBancariaRepo extends CrudRepository<ContaBancaria, Integer> {
}
