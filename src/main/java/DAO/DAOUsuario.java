package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.UsuarioInvalidoException;
import exceptions.PessoaInvalidaException;
import model.Usuario;

public class DAOUsuario extends ExecutaSQL{

	public DAOUsuario(Connection connection) {
		super(connection);
	}
	
	public Usuario getFuncionario(String login, String senha) throws UsuarioInvalidoException, PessoaInvalidaException {
        try {
        	String sql = "SELECT idDoador FROM Usuario WHERE login=? AND senha=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                rs.next();
                int id = rs.getInt(1);
                return new Usuario(id, login, senha);
            }
        } catch (SQLException ex) {
            System.err.println("Erro com a sintaxe SQL no metodo de consulta. GerenteDAO");    
        }
        return null;
    }
	
	public void cadastrar() {
			String sql = "insert into ABRACE.Pessoa (ativo, datacadastro, email, telefone1, telefone2, endereco, nome) values (TRUE, '02/19/1998', 'ggoncalvesmg@gmail.com', '97893515', '97893515', 'Joaquim de Castro Meireles, 583', 'Gabriel Gonçalves')";
			PreparedStatement ps;
			try {
				ps = getConexao().prepareStatement(sql);
				boolean b = ps.execute();
				System.out.println(b);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}

	
	public static void main(String[] args) {
		new DAOUsuario(new ConnectionFactory().getConnection()).cadastrar();
	}
}
