package com.tuyo.gerenciamentotransacao;

import com.tuyo.gerenciamentotransacao.entities.ContaBancaria;
import org.springframework.data.repository.CrudRepository;

public interface ContaBancariaRepo extends CrudRepository<ContaBancaria, Integer> {
}
