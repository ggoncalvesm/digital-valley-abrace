package model;

import java.time.LocalDate;

import exceptions.AssistidoInvalidoException;
import exceptions.PessoaFisicaException;
import exceptions.PessoaInvalidaException;

public class Assistido extends PessoaFisica {
	private String apelido;
    private String tipoDeCancer;
    private boolean status;

    public Assistido(int id, String nome, String endereco,  LocalDate dataCadastro, String telefone, String telefone2, String email, boolean ativo, String cpf, String rg, LocalDate dataNasc, String apelido, String tipoDeCancer, boolean status) throws PessoaInvalidaException, PessoaFisicaException, AssistidoInvalidoException {
    	super(id, nome, endereco, dataCadastro, telefone, telefone2, email, ativo, cpf, rg, dataNasc);
        setApelido(apelido);
        setStatus(status);
        setTipoDeCancer(tipoDeCancer);
    }

    public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) throws AssistidoInvalidoException {
		if(apelido == null) {
    		throw new AssistidoInvalidoException("O apelido informado é inválido!");
    	}
		this.apelido = apelido;
	}

	public String getTipoDeCancer() {
        return tipoDeCancer;
    }

    public void setTipoDeCancer(String tipoDeCancer) throws AssistidoInvalidoException {
    	if(tipoDeCancer == null) {
    		throw new AssistidoInvalidoException("O tipo de cancer informado é inválido!");
    	}
        this.tipoDeCancer = tipoDeCancer;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}