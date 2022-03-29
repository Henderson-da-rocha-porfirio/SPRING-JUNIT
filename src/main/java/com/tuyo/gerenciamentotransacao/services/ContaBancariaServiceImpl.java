package com.tuyo.gerenciamentotransacao.services;

import com.tuyo.gerenciamentotransacao.entities.ContaBancaria;
import com.tuyo.gerenciamentotransacao.repository.ContaBancariaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service                                                                        // Para injeção do serviço: o Spring injeta em outras classes que a chamarem.
public class ContaBancariaServiceImpl implements ContaBancariaService {
    @Autowired
    ContaBancariaRepo repository;

    @Override
    @Transactional                              // Transation Management simulacao
    public void transfer(int total) {              // As transacoes acontecem mas não são "comitteds", por isso nada no banco acontece.

        ContaBancaria joaoConta = repository.findById(1).get(); // .get() = This is shown in the spring 2.x upgrade lecture.Call a repository.findById(1).get() and you will get the Product entity which you can assert on.
        joaoConta.setBal(joaoConta.getBal()-total);
        repository.save(joaoConta);             // Hibernate sabe que aqui será gerado o update

        if(true) {                              //Lancamento de excecao.
            throw new RuntimeException();       // Simulando uma excecao onde o dinheiro transferido some e nem no banco aparece para quem ou onde foi.
        }                                       // Simulacao de uma transacao Automacity

        ContaBancaria mariaConta = repository.findById(2).get();
        mariaConta.setBal(mariaConta.getBal()+total);
        repository.save(mariaConta); // Hibernate sabe que aqui será gerado o update
    }
}
