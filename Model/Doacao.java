package Model;

import java.time.LocalDate;

import Exceptions.DoacaoInvalidaException;

public class Doacao {
	private int id;
	private float valor;//No diagrama tava String, mas preferi usar float
	private LocalDate data;
	private Pessoa doador;
	
	public int getId() {
		return id;
	}
	public void setId(int id) throws DoacaoInvalidaException {
		if(id < 0) {
			throw new DoacaoInvalidaException("O ID informado � inv�lido!");
		}
		this.id = id;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) throws DoacaoInvalidaException {
		if(valor < 0) {
			throw new DoacaoInvalidaException("O valor informado � inv�lido!");
		}
		this.valor = valor;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) throws DoacaoInvalidaException {
		if(data == null) {
			throw new DoacaoInvalidaException("A data informada � inv�lida!");
		}
		this.data = data;
	}
	public Pessoa getDoador() {
		return doador;
	}
	public void setDoador(Pessoa doador) throws DoacaoInvalidaException {
		if(doador == null) {
			throw new DoacaoInvalidaException("O doador informado � inv�lido!");
		}
		this.doador = doador;
	}
}
