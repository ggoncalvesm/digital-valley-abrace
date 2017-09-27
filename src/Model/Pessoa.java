package Model;

import java.time.LocalDate;

import Exceptions.PessoaInvalidaException;

public abstract class Pessoa {
	int id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String endereco;
    private String email;
	private String telefone;
    private String telefone2;
    private LocalDate dataCadastro;
    
    public Pessoa() {
    	
    }
    
    public Pessoa(String nome, String cpf, String endereco, LocalDate dataNascimento, LocalDate dataCadastro,
			String telefone, String telefone2, String rg, String email) throws PessoaInvalidaException{
    	setNome(nome);
    	setCpf(cpf);
    	setEndereco(endereco);
    	setDataNascimento(dataNascimento);
    	setDataCadastro(dataCadastro);
    	setTelefone(telefone);
    	setTelefone2(telefone2);
    	setEmail(email);
    	setRg(rg);
		
    }
    
    public Pessoa(int id, String nome, String cpf, String endereco, LocalDate dataNascimento, LocalDate dataCadastro,
			String telefone, String telefone2, String rg, String email) throws PessoaInvalidaException{
    	setId(id);
    	setNome(nome);
    	setCpf(cpf);
    	setEndereco(endereco);
    	setDataNascimento(dataNascimento);
    	setDataCadastro(dataCadastro);
    	setTelefone(telefone);
    	setTelefone2(telefone2);
    	setEmail(email);
    	setRg(rg);
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) throws PessoaInvalidaException {
		if(id < 0) {
			throw new PessoaInvalidaException("O id informado � inv�lido");
		}
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws PessoaInvalidaException{
		if(nome == null) {
			throw new PessoaInvalidaException("O nome informado � inv�lido");
		}
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) throws PessoaInvalidaException{
		if(cpf == null) {
			throw new PessoaInvalidaException("O cpf informado � inv�lido");
		}//Aqui deveria ter um teste para ver se o cpf � valido!!!!
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) throws PessoaInvalidaException{
		if(endereco == null) {
			throw new PessoaInvalidaException("O endereco informado � inv�lido");
		}
		this.endereco = endereco;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) throws PessoaInvalidaException{
		if(dataNascimento == null || LocalDate.now().isBefore(dataNascimento)) {
			throw new PessoaInvalidaException("A data informada � inv�lida");
		}
		this.dataNascimento = dataNascimento;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) throws PessoaInvalidaException{
		if(dataCadastro == null) {
			throw new PessoaInvalidaException("A data informada � inv�lida");
		}
		this.dataCadastro = dataCadastro;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) throws PessoaInvalidaException{
		if(telefone == null) {
			throw new PessoaInvalidaException("O telefone informado � inv�lido");
		}
		this.telefone = telefone;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) throws PessoaInvalidaException{
		if(telefone2 == null) {
			throw new PessoaInvalidaException("O telefone informado � inv�lido");
		}
		this.telefone2 = telefone2;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) throws PessoaInvalidaException{
		if(rg == null) {
			throw new PessoaInvalidaException("O RG informado � inv�lido");
		}
		this.rg = rg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws PessoaInvalidaException{
		if(email == null || !email.contains("@")) {
			throw new PessoaInvalidaException("O e-mail informado � inv�lido");
		}
		this.email = email;
	}
}
