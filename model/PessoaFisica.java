package model;

import java.time.LocalDate;

import exceptions.PessoaFisicaException;
import exceptions.PessoaInvalidaException;

public class PessoaFisica extends Pessoa{
	private String cpf;
	private String rg;
	private LocalDate dataNasc;
	
	 public PessoaFisica() {
	    	
	 }
	 
	 public PessoaFisica(int id, String cpf, String rg, LocalDate dataNasc) throws PessoaFisicaException, PessoaInvalidaException {
		 setIdPessoa(id);
		 setCpf(cpf);
		 setRg(rg);
		 setDataNasc(dataNasc);
	 }
	    
	 public PessoaFisica(int id, String nome, String endereco,  LocalDate dataCadastro, String telefone, String telefone2, String email, boolean ativo, String cpf, String rg, LocalDate dataNasc) throws PessoaInvalidaException, PessoaFisicaException{
		 super(id, nome, endereco, dataCadastro, telefone, telefone2, email, ativo);
		 setCpf(cpf);
		 setRg(rg);
		 setDataNasc(dataNasc);
	 }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws PessoaFisicaException {
		CNP validador = new CNP();
		if((cpf == null) || !(validador.isValidCPF(cpf.replace(".", "").replace("-", "")))) {
			throw new PessoaFisicaException("O CPF informado � inv�lido!");
		}
		this.cpf = cpf;
	}

	public String getRg() throws PessoaFisicaException {
		if(rg == null) {
			throw new PessoaFisicaException("O RG informado � inv�lido!");
		}
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) throws PessoaFisicaException {
		if(dataNasc == null || dataNasc.isAfter(LocalDate.now())) {
			throw new PessoaFisicaException("A data de nascimento informada � inv�lida!");
		}
		this.dataNasc = dataNasc;
	}
}
