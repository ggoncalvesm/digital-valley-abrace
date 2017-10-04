package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import control.CadastroDoacaoControle;

public class CadastroDoacao {
	private CadastroDoacaoControle controle;
	protected Shell shell;
	private Text tfNomeDoador;
	private Text tfValorDoado;

	/**
	 * Launch the application.
	 * @param args
	 */
	
	public CadastroDoacao() {
	}
	public static void main(String[] args) {
		try {
			CadastroDoacao window = new CadastroDoacao();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(676, 476);
		shell.setText("Cadastrar de doações");
		
		Button btnCadastrar = new Button(shell, SWT.NONE);
		btnCadastrar.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCadastrar.setBounds(350, 308, 100, 40);
		btnCadastrar.setText("Cadastrar");
		
		Button btnCancelar = new Button(shell, SWT.NONE);
		btnCancelar.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnCancelar.setBounds(200, 308, 100, 40);
		btnCancelar.setText("Cancelar");
		
		tfNomeDoador = new Text(shell, SWT.BORDER);
		tfNomeDoador.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		tfNomeDoador.setBounds(195, 100, 230, 25);
		
		Button btnPesquisar = new Button(shell, SWT.NONE);
		btnPesquisar.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnPesquisar.setBounds(450, 90, 97, 40);
		btnPesquisar.setText("Pesquisar");
		
		tfValorDoado = new Text(shell, SWT.BORDER);
		tfValorDoado.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		tfValorDoado.setBounds(195, 160, 115, 25);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblNewLabel.setBounds(114, 95, 75, 30);
		lblNewLabel.setText("Doador:");
		
		Label lblValor = new Label(shell, SWT.NONE);
		lblValor.setText("Valor:");
		lblValor.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblValor.setBounds(138, 155, 51, 30);

	}
}
