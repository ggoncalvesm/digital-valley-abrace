package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exceptions.PessoaFisicaException;
import model.Assistido;

public class DAOAssistido {
	Connection con;
	public DAOAssistido() throws ClassNotFoundException {
		this.con = new ConnectionFactory().abreConexao();
	}
	@SuppressWarnings("deprecation")
	public void adiciona(Assistido assistido) {
		String sql = "insert into Assistido"
	+"(nome, cpf, endereco, dataNascimento, dataCadastro, telefone, telefone2, rg, email, tipodeCancer, ativo)"
	+"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = con.prepareStatement(sql);

			// seta os valores

			stmt.setString(1, assistido.getNome());
			stmt.setString(2, assistido.getCpf());
			stmt.setString(3, assistido.getEndereco());
			stmt.setDate(4, new Date (assistido.getDataNasc().getYear(),assistido.getDataNasc().getMonthValue(),assistido.getDataNasc().getDayOfMonth()));
			stmt.setDate(5, new Date (assistido.getDataCadastro().getYear(),assistido.getDataCadastro().getMonthValue(),assistido.getDataCadastro().getDayOfMonth()));
			stmt.setString(6, assistido.getTelefone());
			stmt.setString(7, assistido.getTelefone2());
			stmt.setString(8, assistido.getRg());
			stmt.setString(10, assistido.getTipoDeCancer());
			stmt.setBoolean(11, assistido.isAtivo());
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
