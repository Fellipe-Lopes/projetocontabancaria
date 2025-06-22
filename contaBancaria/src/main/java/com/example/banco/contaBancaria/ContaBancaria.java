package com.example.banco.contaBancaria;
import jakarta.persistence.*;


@Entity
public class ContaBancaria {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCliente;
    private float saldo;

    public synchronized void deposita(float valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    public synchronized void retirada(float valor) {
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
	public Long getId() {
	    return this.id;
	}
}
