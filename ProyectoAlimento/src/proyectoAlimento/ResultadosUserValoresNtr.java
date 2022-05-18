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
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

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
		frmCalcularValores.setResizable(false);
		frmCalcularValores.setTitle("Calcular Peso Ideal y Valores Nutritivos");
		frmCalcularValores.getContentPane().setBackground(FONDO_COLOR);
		frmCalcularValores.setBounds(100, 100, 962, 504);
		frmCalcularValores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalcularValores.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Estos son tus resultados respecto al Cálculo Nutritivo :D!");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitulo.setBounds(218, 22, 467, 17);
		frmCalcularValores.getContentPane().add(lblTitulo);

		JButton IrAEstado = new JButton(";)");
		IrAEstado.setBounds(603, 284, 41, 30);
		frmCalcularValores.getContentPane().add(IrAEstado);

		JTextPane txtpnIrAValores = new JTextPane();
		txtpnIrAValores.setFont(new Font("Dialog", Font.ITALIC, 14));
		txtpnIrAValores.setEditable(false);
		txtpnIrAValores.setBackground(FONDO_COLOR);
		txtpnIrAValores.setText("Si quieres comprobar a que estado físico correspondes, pulsa aquí :");
		txtpnIrAValores.setBounds(155, 284, 474, 37);
		frmCalcularValores.getContentPane().add(txtpnIrAValores);

		JLabel lblNewLabel = new JLabel("Valores Ideales:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(33, 159, 95, 14);
		frmCalcularValores.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tus resultados:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(33, 208, 95, 14);
		frmCalcularValores.getContentPane().add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(155, 191, 725, 17);
		frmCalcularValores.getContentPane().add(separator);

		JLabel lblGrasa_user = new JLabel();
		lblGrasa_user.setBounds(180, 208, 83, 14);
		frmCalcularValores.getContentPane().add(lblGrasa_user);

		JLabel lblGrasa = new JLabel();
		lblGrasa.setBounds(180, 159, 83, 14);
		frmCalcularValores.getContentPane().add(lblGrasa);

		JLabel lblAzucar = new JLabel();
		lblAzucar.setBounds(293, 159, 83, 14);
		frmCalcularValores.getContentPane().add(lblAzucar);

		JLabel lblProteina = new JLabel();
		lblProteina.setBounds(418, 159, 46, 14);
		frmCalcularValores.getContentPane().add(lblProteina);

		JLabel lblHidratos = new JLabel();
		lblHidratos.setBounds(493, 159, 46, 14);
		frmCalcularValores.getContentPane().add(lblHidratos);

		JLabel lblPotasio = new JLabel();
		lblPotasio.setBounds(573, 159, 46, 14);
		frmCalcularValores.getContentPane().add(lblPotasio);

		JLabel lblCalcio = new JLabel();
		lblCalcio.setBounds(648, 159, 70, 14);
		frmCalcularValores.getContentPane().add(lblCalcio);

		JLabel lblSal = new JLabel();
		lblSal.setBounds(752, 159, 46, 14);
		frmCalcularValores.getContentPane().add(lblSal);

		JLabel lblHierro = new JLabel();
		lblHierro.setBounds(822, 159, 46, 14);
		frmCalcularValores.getContentPane().add(lblHierro);

		JLabel lblAzucar_user = new JLabel();
		lblAzucar_user.setBounds(293, 208, 83, 14);
		frmCalcularValores.getContentPane().add(lblAzucar_user);

		JLabel lblProteina_user = new JLabel();
		lblProteina_user.setBounds(418, 208, 46, 14);
		frmCalcularValores.getContentPane().add(lblProteina_user);

		JLabel lblHidratos_user = new JLabel();
		lblHidratos_user.setBounds(493, 208, 46, 14);
		frmCalcularValores.getContentPane().add(lblHidratos_user);

		JLabel lblPotasio_user = new JLabel();
		lblPotasio_user.setBounds(573, 208, 46, 14);
		frmCalcularValores.getContentPane().add(lblPotasio_user);

		JLabel lblCalcio_user = new JLabel();
		lblCalcio_user.setBounds(648, 208, 70, 14);
		frmCalcularValores.getContentPane().add(lblCalcio_user);

		JLabel lblSal_user = new JLabel();
		lblSal_user.setBounds(752, 208, 46, 14);
		frmCalcularValores.getContentPane().add(lblSal_user);

		JLabel lblHierro_user = new JLabel();
		lblHierro_user.setBounds(822, 208, 46, 14);
		frmCalcularValores.getContentPane().add(lblHierro_user);

		//ZONA TRABAJO
		IrAEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCalcularValores.setVisible(false);
				ResultadosUserEstado.estado(usuario, true, alimentos, alimentosElegidos, cantidadesElegidas);/*misma acción que en la ventana main pero hacia la cuarta ventana, le pasamos la misma persona*/
			}});

		//parte valor ideal
		lblGrasa.setText("<"+CalculoValorIdeal.getGrasainicialideal()+" y <"+CalculoValorIdeal.getGrasafinalideal()+"g");
		lblAzucar.setText("<"+CalculoValorIdeal.getAzucarinicialideal()+" y <"+CalculoValorIdeal.getAzucarfinalideal()+"g");
		if (usuario.getSexo().equalsIgnoreCase("mujer")) {
			lblProteina.setText(CalculoValorIdeal.getProteinaidealmujer()+"g");
			lblPotasio.setText(CalculoValorIdeal.getPotasioidealmujer()+"mg");
			lblHierro.setText(CalculoValorIdeal.getHierroidealmujer()+"mg");
		}else {
			lblProteina.setText(CalculoValorIdeal.getProteinaidealhombre()+"g");
			lblPotasio.setText(CalculoValorIdeal.getPotasioidealhombre()+"g");
			lblHierro.setText(CalculoValorIdeal.getHierroidealhombre()+"g");
		}
		lblCalcio.setText("<"+CalculoValorIdeal.getCalcioidealinicial()+" y <"+CalculoValorIdeal.getCalcioidealfinal()+"g");
		lblHidratos.setText(CalculoValorIdeal.getHidratosideal()+"g");
		lblSal.setText(CalculoValorIdeal.getSalideal()+"g");

		//parte valor user
		lblGrasa_user.setText(CalculoValorIdeal.totalGrasaIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)+"g");
		lblAzucar_user.setText(CalculoValorIdeal.totalAzucarIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)+"g");
		lblProteina_user.setText(CalculoValorIdeal.totalProteinaIdeal(alimentos, usuario, alimentosElegidos, cantidadesElegidas)+"g");
		lblPotasio_user.setText(CalculoValorIdeal.totalPotasioIdeal(alimentos, usuario, alimentosElegidos, cantidadesElegidas)+"mg");
		lblHierro_user.setText(CalculoValorIdeal.totalHierroIdeal(alimentos, usuario, alimentosElegidos, cantidadesElegidas)+"mg");
		lblCalcio_user.setText(CalculoValorIdeal.totalCalcioIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)+"g");
		lblHidratos_user.setText(CalculoValorIdeal.totalHidratosIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)+"g");
		lblSal_user.setText(CalculoValorIdeal.totalSalIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)+"g");
	}
}
