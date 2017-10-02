package facade;

import DAO.ConnectionFactory;
import DAO.DAOFuncionario;
import exceptions.FuncionarioInvalidoException;
import exceptions.PessoaInvalidaException;
import model.Usuario;

public class LoginFachada {

	public Usuario loga(String login, String senha) {
		Usuario func = null;
		try {
			func = new DAOFuncionario(new ConnectionFactory().abreConexao()).getFuncionario(login, senha);
			if(func == null) {
				System.out.println("O funcionário está null");
			}
		} catch (FuncionarioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (PessoaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		finally {
			return func;
		}
	}
}
