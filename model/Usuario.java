package model;

import java.time.LocalDate;

import exceptions.FuncionarioInvalidoException;
import exceptions.PessoaFisicaException;
import exceptions.PessoaInvalidaException;

public class Usuario extends PessoaFisica{
	private String usuario;
	private String senha;
	
	public Usuario(int id, String usuario, String senha) throws FuncionarioInvalidoException, PessoaInvalidaException {
		setId(id);
		setUsuario(usuario);
		setSenha(senha);
	}
	
	public Usuario(int id, String nome, String endereco,  LocalDate dataCadastro, String telefone, String telefone2, String email, boolean ativo, String cpf, String rg, LocalDate dataNasc, String usuario, String senha) throws PessoaInvalidaException, FuncionarioInvalidoException, PessoaFisicaException {
        super(id, nome, endereco, dataCadastro, telefone, telefone2, email, ativo, cpf, rg, dataNasc);
        setUsuario(usuario);
        setSenha(senha);
    }
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) throws FuncionarioInvalidoException {
		if(usuario == null) {
			throw new FuncionarioInvalidoException("O login informado é inválido");
		}
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws FuncionarioInvalidoException {
		if(senha == null) {
			throw new FuncionarioInvalidoException("A senha informada é inválida");
		}
		this.senha = senha;
	}

}
