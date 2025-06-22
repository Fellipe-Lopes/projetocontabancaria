package com.example.banco.contaBancaria;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/contas")
public class ContaBancariaController {
	
	@Autowired
    private ContaBancariaRepository repository;

    @GetMapping
    public List<ContaBancaria> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ContaBancaria criar(@RequestBody ContaBancaria conta) {
        return repository.save(conta);
    }

    @PutMapping("/{id}/deposito")
    public ContaBancaria depositar(@PathVariable Long id, @RequestParam float valor) {
        ContaBancaria conta = repository.findById(id).orElseThrow();
        conta.deposita(valor);
        return repository.save(conta);
    }

    @PutMapping("/{id}/retirada")
    public ContaBancaria retirar(@PathVariable Long id, @RequestParam float valor) {
        ContaBancaria conta = repository.findById(id).orElseThrow();
        conta.retirada(valor);
        return repository.save(conta);
    }
}
