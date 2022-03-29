package com.tuyo.gerenciamentotransacao.services;

import com.tuyo.gerenciamentotransacao.entities.ContaBancaria;
import com.tuyo.gerenciamentotransacao.repository.ContaBancariaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service                                                                        // Para injeção do serviço: o Spring injeta em outras classes que a chamarem.
public class ContaBancariaServiceImpl implements ContaBancariaService {
    @Autowired
    ContaBancariaRepo repository;

    @Override
    public void transfer(int total) {

        ContaBancaria joaoConta = repository.findById(1).get(); // .get() = This is shown in the spring 2.x upgrade lecture.Call a repository.findById(1).get() and you will get the Product entity which you can assert on.
        joaoConta.setBal(joaoConta.getBal()-total);
        repository.save(joaoConta); // Hibernate sabe que aqui será gerado o update

        ContaBancaria mariaConta = repository.findById(2).get();
        mariaConta.setBal(mariaConta.getBal()+total);
        repository.save(mariaConta); // Hibernate sabe que aqui será gerado o update
    }
}
