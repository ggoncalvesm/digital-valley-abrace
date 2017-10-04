package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import control.LoginControle;
import exceptions.PessoaInvalidaException;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;

public class LoginView {

	protected Shell shlOngRussasTransformando;
	private Text tfUsuario;
	private Text tfSenha;
	LoginControle controle;
	
	public LoginView() {
		this.controle = new LoginControle(this);
	}

	public Text getTfUsuario() {
		return tfUsuario;
	}

	public void setTfUsuario(Text tfUsuario) {
		this.tfUsuario = tfUsuario;
	}

	public Text getTfSenha() {
		return tfSenha;
	}

	public void setTfSenha(Text tfSenha) {
		this.tfSenha = tfSenha;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginView window = new LoginView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		LoginView.centralize(shlOngRussasTransformando);
		shlOngRussasTransformando.open();
		shlOngRussasTransformando.layout();
		while (!shlOngRussasTransformando.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlOngRussasTransformando = new Shell();
		shlOngRussasTransformando.setImage(SWTResourceManager.getImage("C:\\Users\\Thiago Hellen\\git\\digital-valley-abrace\\src\\main\\java\\view\\img\\ABRACE.png"));
		shlOngRussasTransformando.setSize(530, 513);
		shlOngRussasTransformando.setText("ONG Russas Transformando Vidas - ABRACE");
		
		Label lblUsurio = new Label(shlOngRussasTransformando, SWT.NONE);
		lblUsurio.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblUsurio.setBounds(95, 273, 75, 30);
		lblUsurio.setText("Usu\u00E1rio:");
		
		tfUsuario = new Text(shlOngRussasTransformando, SWT.BORDER);
		tfUsuario.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		tfUsuario.setBounds(176, 270, 230, 36);
		
		Label lblSenha = new Label(shlOngRussasTransformando, SWT.NONE);
		lblSenha.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblSenha.setBounds(108, 323, 62, 30);
		lblSenha.setText("Senha:");
		
		tfSenha = new Text(shlOngRussasTransformando, SWT.BORDER);
		tfSenha.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		tfSenha.setBounds(176, 320, 230, 36);
		
		Button btnEntrar = new Button(shlOngRussasTransformando, SWT.NONE);
		btnEntrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					controle.getEvent(e);
			}
		});
		btnEntrar.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnEntrar.setBounds(193, 385, 128, 40);
		btnEntrar.setText("Entrar");
		
		Label lblBemVindo = new Label(shlOngRussasTransformando, SWT.NONE);
		lblBemVindo.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		lblBemVindo.setBounds(194, 133, 125, 32);
		lblBemVindo.setText("Bem Vindo!");
		
		Label lblDigiteSeusDados = new Label(shlOngRussasTransformando, SWT.NONE);
		lblDigiteSeusDados.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblDigiteSeusDados.setBounds(125, 225, 261, 30);
		lblDigiteSeusDados.setText("Digite seus dados de acesso");
		
		Label label = new Label(shlOngRussasTransformando, SWT.NONE);
		label.setImage(SWTResourceManager.getImage("C:\\Users\\Thiago Hellen\\git\\digital-valley-abrace\\src\\main\\java\\view\\img\\ABRACE.png"));
		label.setBounds(225, 57, 64, 64);

	}
	
	public void mensagemErro(Exception e){
		 MessageBox messageBox = new MessageBox(shlOngRussasTransformando,SWT.ICON_ERROR | SWT.OK); 
         messageBox.setText("Login inv�lido");
         messageBox.setMessage(e.getMessage()+".\nTente novamente");
         messageBox.open();
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