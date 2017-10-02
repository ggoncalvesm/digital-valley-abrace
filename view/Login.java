package view;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;

import javax.swing.JOptionPane;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class Login {
	protected Shell shlLoginProjeto;
	private Text tfUsuario;
	private Text tfSenha;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Realm.runWithDefault(DisplayRealm.getRealm(display), new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlLoginProjeto.open();
		shlLoginProjeto.layout();
		Login.centralize(shlLoginProjeto);
		while (!shlLoginProjeto.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLoginProjeto = new Shell();	
		shlLoginProjeto.setImage(SWTResourceManager.getImage("C:\\Users\\Thiago Hellen\\eclipse-workspace\\ProjetoAbrace\\src\\img\\ABRACE.png"));
		shlLoginProjeto.setSize(450, 478);
		shlLoginProjeto.setText("Login - ONG Abrace");
		
		Label lblFaaSeuLogin = new Label(shlLoginProjeto, SWT.CENTER);
		lblFaaSeuLogin.setFont(SWTResourceManager.getFont("Segoe UI Emoji", 15, SWT.NORMAL));
		lblFaaSeuLogin.setBounds(51, 200, 332, 35);
		lblFaaSeuLogin.setText("Digite seus dados de acesso");
		
		tfUsuario = new Text(shlLoginProjeto, SWT.BORDER);
		tfUsuario.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		tfUsuario.setBounds(142, 241, 202, 35);
		
		Label lblUsurio = new Label(shlLoginProjeto, SWT.NONE);
		lblUsurio.setAlignment(SWT.RIGHT);
		lblUsurio.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblUsurio.setBounds(61, 243, 75, 30);
		lblUsurio.setText("Usu\u00E1rio:");
		
		Label lblBemVindoPor = new Label(shlLoginProjeto, SWT.NONE);
		lblBemVindoPor.setAlignment(SWT.CENTER);
		lblBemVindoPor.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblBemVindoPor.setBounds(51, 143, 332, 30);
		lblBemVindoPor.setText("Bem vindo!");
		
		Label lblSenha = new Label(shlLoginProjeto, SWT.NONE);
		lblSenha.setAlignment(SWT.RIGHT);
		lblSenha.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblSenha.setBounds(61, 290, 75, 30);
		lblSenha.setText("Senha:");
		
		tfSenha = new Text(shlLoginProjeto, SWT.BORDER | SWT.PASSWORD);
		tfSenha.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		tfSenha.setBounds(142, 288, 202, 35);
		
		Button btnEntrar = new Button(shlLoginProjeto, SWT.CENTER);
		btnEntrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(login.LoginFachada.verificaLogin(tfUsuario.getText(), tfSenha.getText())){
					MessageBox messageBox = new MessageBox(shlLoginProjeto,SWT.ICON_WORKING | SWT.OK); 
					messageBox.setText("Bem vindo!");
					messageBox.setMessage("Dados validados com sucesso! Seja bem vindo");
					messageBox.open();
				} else {
					MessageBox messageBox = new MessageBox(shlLoginProjeto,SWT.ICON_ERROR | SWT.OK); 
					messageBox.setText("Login inválido");
					messageBox.setMessage("Ops... Parece que você digitou o usuário ou senha errados.\nTente novamente");
					messageBox.open();
				}
			}
		});
		btnEntrar.setFont(SWTResourceManager.getFont("Segoe UI Emoji", 16, SWT.NORMAL));
		btnEntrar.setBounds(162, 355, 111, 35);
		btnEntrar.setText("Entrar");
		
		shlLoginProjeto.setDefaultButton(btnEntrar);
		
		Label lblLogoDaOng = new Label(shlLoginProjeto, SWT.CENTER);
		lblLogoDaOng.setText("Logo da ONG Abrace");
		lblLogoDaOng.setImage(SWTResourceManager.getImage("C:\\Users\\Thiago Hellen\\eclipse-workspace\\ProjetoAbrace\\src\\img\\ABRACE.png"));
		lblLogoDaOng.setBounds(182, 50, 69, 76);
		initDataBindings();

	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		return bindingContext;
	}
	
	public static synchronized void centralize(Shell shell) {  
        try {  
            if (!shell.isDisposed()) {  
                Rectangle r = Display.getCurrent().getClientArea();  
                int sW = r.width; // largura da tela  
                int sH = r.height; // altura da tela  
  
                r = shell.getBounds();  
                int w = r.width; // largura da janela  
                int h = r.height; // altura da janela  
  
                int x = (sW - w) / 2; // novo ponto x  
                int y = (sH - h) / 2; // novo ponto y  
  
                shell.setLocation(x, y);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
}
