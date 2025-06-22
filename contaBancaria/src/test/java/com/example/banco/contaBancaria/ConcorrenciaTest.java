package com.example.banco.contaBancaria;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
public class ConcorrenciaTest {

    @Autowired
    private ContaBancariaRepository repository;

    @Test
    public void testConcorrenciaDepositoRetirada() throws InterruptedException {
        ContaBancaria conta = new ContaBancaria();
        repository.save(conta);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                conta.deposita(valueOf(10));
                repository.save(conta);
            });

            executor.execute(() -> {
                conta.retirada(valueOf(5));
                repository.save(conta);
            });
        }

        executor.shutdown();
        Thread.sleep(5000);

        ContaBancaria contaFinal = repository.findById(conta.getId()).orElseThrow();
        System.out.println("Saldo final: " + contaFinal.getSaldo());
    }

	private float valueOf(int i) {
		return 0;
	}
}