package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

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
	
	public void cadastraPessoa() {
			String sql = "insert into ABRACE.Pessoa_Fisica (idPessoa, cpf, rg, dataNascimento) values (1, '047.318.353-18', '20212121212', '02/19/1998')";
			PreparedStatement ps;
			try {
				ps = getConexao().prepareStatement(sql);
				int b = ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	public void cadastra() {
		String sql = "insert into ABRACE.Usuario (idPessoa, login, senha) values (1,'ggoncalvesm', 'doit')";
		PreparedStatement ps;
		try {
			ps = getConexao().prepareStatement(sql);
			boolean b = ps.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void pega() {
		String sql = "SELECT login,senha,idPessoa FROM ABRACE.Usuario WHERE login = ? and senha = ?";
		PreparedStatement ps;
		try {
			ps = getConexao().prepareStatement(sql);
			ps.setString(1, "ggoncalvesm");
			ps.setString(2, "doit");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String login = rs.getString(1);
				String senha = rs.getString(2);
				int id = rs.getInt(3);
				System.err.println("login: "+login);
				System.err.println("senha: "+senha);
				System.err.println("id: "+id);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
		   
	public static void main(String[] args) {
		

		DAOUsuario TEST = new DAOUsuario(new ConnectionFactory().getConnection());
		TEST.cadastraPessoa();
		TEST.cadastra();
		TEST.pega();
	}

}
