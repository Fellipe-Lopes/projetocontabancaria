package com.example.banco.contaBancaria;
import jakarta.persistence.*;

@Entity
public class ContaBancariaVersionada {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    private float saldo;

    @Version
    private int dataMovimento;

    public void deposita(float valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    public void retirada(float valor) {
        this.setSaldo(this.getSaldo() - valor);
    }

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

}
