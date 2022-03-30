package com.tuyo.mongodemo;

import com.tuyo.mongodemo.model.Produto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class MongodemoApplicationTests {

	@Autowired
	ProdutoRepository repository;

	@Test
	void testSave() { 	// Cria o Database (mas precisa estar configurado no application.properties, tabela e colunas.
		Produto produto = new Produto(); // É possível fazer updates mudando aqui as informações ou criar elementos diretamente do Client, do MongoDB.
		produto.setName("Mac Book Pro");
		produto.setPrice(2000f);
		Produto saveProduto = repository.save(produto);
		assertNotNull(saveProduto);
	}

	@Test
	void testFindAll() {  // Teste para achar um ID no Mongo
		List<Produto> produtos = (List<Produto>) repository.findAll();
		assertEquals(1, produtos.size()); // assertEquals por esperar apenas uma gravação no banco.
	}

	@Test
	void testDelete(){	// Deletar Coluna no Mongo
		repository.deleteById("6243b9502fba272fe718589a");
		Optional<Produto> produto = repository.findById("6243b9502fba272fe718589a");
		assertEquals(Optional.empty(), produto);
	}

}
