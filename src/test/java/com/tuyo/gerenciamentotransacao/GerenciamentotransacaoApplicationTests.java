package com.tuyo.gerenciamentotransacao;

import com.tuyo.gerenciamentotransacao.services.ContaBancariaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GerenciamentotransacaoApplicationTests {

	@Autowired
	ContaBancariaService cbService;

	@Test
	void testTransfer() {
 		cbService.transfer(1000); // Para transferir os $500 vai checar no database se tem o valor.
	}

}
