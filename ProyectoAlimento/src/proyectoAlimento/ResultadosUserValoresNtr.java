/**
 *Clase llamada por ValoresNutritivos.
 *Esta clase ha sido creada para mostrar los resultados respecto a los Valores Nutritivos al user.
 */


package proyectoAlimento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ResultadosUserValoresNtr {

	private JFrame frmCalcularValores;
	private final Color FONDO_COLOR= new Color(236,224,251);
	private static Persona usuario; 
	private static Alimento alimentos[];
	private static ArraysToString<String> alimentosElegidos= new ArraysToString<>();
	private static ArraysToString<Integer> cantidadesElegidas= new ArraysToString<>();
	
	/**
	 * Launch the application.
	 * @param hayAlimentos2 
	 */
	public static void valores(Persona usuario, Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) { /*accción para arrancar la cuarta ventana*/
		ResultadosUserValoresNtr.usuario=usuario;
		ResultadosUserValoresNtr.alimentos=alimentos;
		ResultadosUserValoresNtr.alimentosElegidos=alimentosElegidos;
		ResultadosUserValoresNtr.cantidadesElegidas=cantidadesElegidas;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultadosUserValoresNtr window = new ResultadosUserValoresNtr();
					window.frmCalcularValores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public ResultadosUserValoresNtr() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalcularValores = new JFrame();
		frmCalcularValores.setTitle("Calcular Peso Ideal y Valores Nutritivos");
		frmCalcularValores.getContentPane().setBackground(FONDO_COLOR);
		frmCalcularValores.setBounds(100, 100, 920, 650);
		frmCalcularValores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalcularValores.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Estos son tus resultados respecto al Cálculo Nutritivo :D!");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitulo.setBounds(218, 22, 467, 17);
		frmCalcularValores.getContentPane().add(lblTitulo);

		JButton IrAEstado = new JButton(";)");
		IrAEstado.setBounds(716, 562, 41, 30);
		frmCalcularValores.getContentPane().add(IrAEstado);

		JTextPane txtpnIrAValores = new JTextPane();
		txtpnIrAValores.setEditable(false);
		txtpnIrAValores.setBackground(FONDO_COLOR);
		txtpnIrAValores.setText("Si quieres comprobar a que estado físico correspondes,\n\npulsa aquí :");
		txtpnIrAValores.setBounds(639, 512, 255, 88);
		frmCalcularValores.getContentPane().add(txtpnIrAValores);

		//ZONA TRABAJO
		IrAEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCalcularValores.setVisible(false);
				ResultadosUserEstado.estado(usuario, true, alimentos, alimentosElegidos, cantidadesElegidas);/*misma acción que en la ventana main pero hacia la cuarta ventana, le pasamos la misma persona*/
			}});
		
		CalculoValorIdeal.getGrasainicialideal();
		
		CalculoValorIdeal.getGrasafinalideal();
		
		CalculoValorIdeal.getAzucarinicialideal();

		CalculoValorIdeal.getAzucarfinalideal();

		CalculoValorIdeal.getProteinaidealhombre();

		CalculoValorIdeal.getProteinaidealmujer();

		CalculoValorIdeal.getHidratosideal();

		CalculoValorIdeal.getPotasioidealhombre();

		CalculoValorIdeal.getPotasioidealmujer();

		CalculoValorIdeal.getCalcioidealinicial();
		
		CalculoValorIdeal.getCalcioidealfinal();
		
		CalculoValorIdeal.getSalideal();

		CalculoValorIdeal.getHierroidealhombre();

		CalculoValorIdeal.getHierroidealmujer();
		
	}
}
