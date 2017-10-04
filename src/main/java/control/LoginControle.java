package control;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import org.eclipse.swt.events.SelectionEvent;

import exceptions.PessoaInvalidaException;
import exceptions.UsuarioInvalidoException;
import facade.LoginFachada;
import model.Usuario;
import view.LoginView;

public class LoginControle {
	private LoginView view;
	private LoginFachada facade = new LoginFachada();
		
	public void getEvent(SelectionEvent event){
		if (event.getSource().toString().equals("Button {Entrar}")){
			try {
				Usuario usuario = facade.loga(view.getTfUsuario().getText(), view.getTfSenha().getText());
				if(usuario == null) {
					System.out.println("Não encontramos o usuário no banco");
				}
			} catch (UsuarioInvalidoException e) {
				view.mensagemErro(e);
			} catch (PessoaInvalidaException e) {
				view.mensagemErro(e);
			}
			
		}else {
			
		}
	}
	
	public LoginControle(LoginView view) {
		setLogin(view);
	}

	private void setLogin(LoginView login) {
		if(login != null) {
			this.view = login;
		}
	}

	private void setFacade(LoginFachada facade) {
		if(facade != null) {
			this.facade = facade; 
		}
	}
		
}
