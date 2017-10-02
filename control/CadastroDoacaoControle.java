package control;

import java.awt.event.ActionEvent;

import view.CadastroDoacao;

public class CadastroDoacaoControle {
	private CadastroDoacao visao;
	public CadastroDoacaoControle(CadastroDoacao visao) {
		this.visao = visao;
	}
	
	public void getEvent(ActionEvent event){
		if (event.getActionCommand().equals("Cadastrar")){
			System.our.println()
			Doador d = new DAODoador();
		}
		else {
		if (event.getActionCommand().equals("Cancelar")){
			view.cancelarLogin();
		}
	}
	
}
