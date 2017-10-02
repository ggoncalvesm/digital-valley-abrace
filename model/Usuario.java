package model;

import java.time.LocalDate;

import exceptions.UsuarioInvalidoException;
import exceptions.PessoaFisicaException;
import exceptions.PessoaInvalidaException;

public class Usuario extends PessoaFisica{
	private String usuario;
	private String senha;
	
	public Usuario(int id, String usuario, String senha) throws UsuarioInvalidoException, PessoaInvalidaException {
		setId(id);
		setUsuario(usuario);
		setSenha(senha);
	}
	
	public Usuario(int id, String nome, String endereco,  LocalDate dataCadastro, String telefone, String telefone2, String email, boolean ativo, String cpf, String rg, LocalDate dataNasc, String usuario, String senha) throws PessoaInvalidaException, UsuarioInvalidoException, PessoaFisicaException {
        super(id, nome, endereco, dataCadastro, telefone, telefone2, email, ativo, cpf, rg, dataNasc);
        setUsuario(usuario);
        setSenha(senha);
    }
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) throws UsuarioInvalidoException {
		if(usuario == null) {
			throw new UsuarioInvalidoException("O login informado � inv�lido");
		}
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws UsuarioInvalidoException {
		if(senha == null) {
			throw new UsuarioInvalidoException("A senha informada � inv�lida");
		}
		this.senha = senha;
	}

}
