/**
 *Clase llamada por ValoresNutritivos.
 *Esta clase ha sido creada para mostrar los resultados respecto a los Valores Nutritivos al user.
 *@author Marta
 */


package proyectoAlimento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
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
	 */
	/**
	 * 
	 * @param usuario: Objeto de tipo persona con los datos del usuario que está usando la aplicación
	 * @param alimentos: La lista de alimentos disponibles en la aplicacion
	 * @param alimentosElegidos: Los alimentos seleccionados por el usuario
	 * @param cantidadesElegidas: La cantidad de los alimentos seleccionados por el usuario
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
		frmCalcularValores.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 13));
		frmCalcularValores.setResizable(false);
		frmCalcularValores.setTitle("DietOMatic");
		frmCalcularValores.getContentPane().setBackground(FONDO_COLOR);
		frmCalcularValores.setBounds(100, 100, 1085, 503);
		frmCalcularValores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalcularValores.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Estos son tus resultados respecto al Cálculo Nutritivo :D!");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitulo.setBounds(303, 40, 479, 17);
		frmCalcularValores.getContentPane().add(lblTitulo);

		JButton IrAEstado = new JButton(";)");
		IrAEstado.setBounds(627, 314, 41, 30);
		frmCalcularValores.getContentPane().add(IrAEstado);

		JTextPane txtpnIrAValores = new JTextPane();
		txtpnIrAValores.setFont(new Font("Dialog", Font.ITALIC, 15));
		txtpnIrAValores.setEditable(false);
		txtpnIrAValores.setBackground(FONDO_COLOR);
		txtpnIrAValores.setText("Si quieres comprobar a que estado físico correspondes, pulsa aquí :");
		txtpnIrAValores.setBounds(155, 314, 474, 37);
		frmCalcularValores.getContentPane().add(txtpnIrAValores);

		JLabel lblNewLabel = new JLabel("Valores Ideales:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setBounds(20, 165, 112, 23);
		frmCalcularValores.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tus resultados:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1.setBounds(20, 220, 112, 23);
		frmCalcularValores.getContentPane().add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(142, 203, 913, 17);
		frmCalcularValores.getContentPane().add(separator);

		JLabel lblGrasaUser = new JLabel();
		lblGrasaUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrasaUser.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblGrasaUser.setBounds(175, 220, 98, 23);
		frmCalcularValores.getContentPane().add(lblGrasaUser);

		JLabel lblGrasa = new JLabel();
		lblGrasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrasa.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblGrasa.setBounds(175, 167, 98, 18);
		frmCalcularValores.getContentPane().add(lblGrasa);

		JLabel lblAzucar = new JLabel();
		lblAzucar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAzucar.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAzucar.setBounds(303, 167, 92, 18);
		frmCalcularValores.getContentPane().add(lblAzucar);

		JLabel lblProteina = new JLabel();
		lblProteina.setHorizontalAlignment(SwingConstants.CENTER);
		lblProteina.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblProteina.setBounds(416, 167, 77, 18);
		frmCalcularValores.getContentPane().add(lblProteina);

		JLabel lblHidratos = new JLabel();
		lblHidratos.setHorizontalAlignment(SwingConstants.CENTER);
		lblHidratos.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblHidratos.setBounds(521, 169, 87, 18);
		frmCalcularValores.getContentPane().add(lblHidratos);

		JLabel lblPotasio = new JLabel();
		lblPotasio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPotasio.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPotasio.setBounds(637, 172, 62, 18);
		frmCalcularValores.getContentPane().add(lblPotasio);

		JLabel lblCalcio = new JLabel();
		lblCalcio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalcio.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblCalcio.setBounds(723, 169, 87, 18);
		frmCalcularValores.getContentPane().add(lblCalcio);

		JLabel lblSal = new JLabel();
		lblSal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSal.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblSal.setBounds(835, 169, 83, 18);
		frmCalcularValores.getContentPane().add(lblSal);

		JLabel lblGrasasSaturadas = new JLabel();
		lblGrasasSaturadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrasasSaturadas.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblGrasasSaturadas.setBounds(928, 167, 127, 18);
		frmCalcularValores.getContentPane().add(lblGrasasSaturadas);

		JLabel lblAzucarUser = new JLabel();
		lblAzucarUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblAzucarUser.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAzucarUser.setBounds(303, 220, 92, 23);
		frmCalcularValores.getContentPane().add(lblAzucarUser);

		JLabel lblProteinaUser = new JLabel();
		lblProteinaUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblProteinaUser.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblProteinaUser.setBounds(416, 220, 77, 23);
		frmCalcularValores.getContentPane().add(lblProteinaUser);

		JLabel lblHidratosUser = new JLabel();
		lblHidratosUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblHidratosUser.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblHidratosUser.setBounds(521, 220, 87, 23);
		frmCalcularValores.getContentPane().add(lblHidratosUser);

		JLabel lblPotasioUser = new JLabel();
		lblPotasioUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblPotasioUser.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPotasioUser.setBounds(627, 220, 72, 23);
		frmCalcularValores.getContentPane().add(lblPotasioUser);

		JLabel lblCalcioUser = new JLabel();
		lblCalcioUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalcioUser.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblCalcioUser.setBounds(723, 220, 87, 23);
		frmCalcularValores.getContentPane().add(lblCalcioUser);

		JLabel lblSalUser = new JLabel();
		lblSalUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalUser.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblSalUser.setBounds(835, 220, 77, 23);
		frmCalcularValores.getContentPane().add(lblSalUser);

		JLabel lblGrasasSaturadasUser = new JLabel();
		lblGrasasSaturadasUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrasasSaturadasUser.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblGrasasSaturadasUser.setBounds(928, 220, 127, 23);
		frmCalcularValores.getContentPane().add(lblGrasasSaturadasUser);

		JLabel lblNewLabel_2 = new JLabel("Grasas");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2.setBounds(175, 132, 98, 14);
		frmCalcularValores.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Azúcar");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(304, 133, 91, 14);
		frmCalcularValores.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Proteina");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2_2.setBounds(416, 133, 77, 14);
		frmCalcularValores.getContentPane().add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Hidratos");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2_3.setBounds(521, 133, 87, 14);
		frmCalcularValores.getContentPane().add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("Potasio");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2_4.setBounds(625, 133, 74, 14);
		frmCalcularValores.getContentPane().add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_5 = new JLabel("Calcio");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2_5.setBounds(723, 133, 87, 14);
		frmCalcularValores.getContentPane().add(lblNewLabel_2_5);

		JLabel lblNewLabel_2_6 = new JLabel("Sal");
		lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_6.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2_6.setBounds(835, 133, 77, 14);
		frmCalcularValores.getContentPane().add(lblNewLabel_2_6);

		JLabel lblNewLabel_2_7 = new JLabel("Grasas Saturadas");
		lblNewLabel_2_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_7.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2_7.setBounds(928, 133, 127, 14);
		frmCalcularValores.getContentPane().add(lblNewLabel_2_7);
		
		JButton volverAValoresNutritivos = new JButton("");
		volverAValoresNutritivos.setBackground(FONDO_COLOR);
		volverAValoresNutritivos.setBounds(10, 11, 48, 46);
		volverAValoresNutritivos.setBorderPainted(false);
		frmCalcularValores.getContentPane().add(volverAValoresNutritivos);

		//ZONA TRABAJO
		IrAEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCalcularValores.setVisible(false);
				ResultadosUserEstado.estado(usuario, true, alimentos, alimentosElegidos, cantidadesElegidas);/*misma acción que en la ventana main pero hacia la cuarta ventana,pasando los mismos valores (persona, alimentos elegidos, etc) el true es porque puede abrir esta ventana a través de ResultadosUserEstado*/
			}});
		
		volverAValoresNutritivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCalcularValores.setVisible(false);
				ValoresNutritivos.arrancar(usuario, alimentosElegidos, cantidadesElegidas);/*misma acción que en la ventana main, pasando el mismo valor (persona)*/
			}
		});
		
		ImageIcon flecha=new ImageIcon("img/flecha.png");
		ImageIcon flechaEscalada= new ImageIcon(flecha.getImage().getScaledInstance(48, 46, Image.SCALE_DEFAULT));/*otro objeto tipo ImageIcon para poner escalarla*/
		volverAValoresNutritivos.setIcon(flechaEscalada);
		
		//parte valor ideal
		lblGrasa.setText(">60.0g y <80.0g");
		lblAzucar.setText("<=25.0g");
		if (usuario.getSexo().equalsIgnoreCase("mujer")) {
			lblProteina.setText(CalculoValorIdeal.getProteinaidealmujer()+"g");
			lblPotasio.setText(CalculoValorIdeal.getPotasioidealmujer()+"mg");
		}else {
			lblProteina.setText(CalculoValorIdeal.getProteinaidealhombre()+"g");
			lblPotasio.setText(CalculoValorIdeal.getPotasioidealhombre()+"mg");
		}
		lblCalcio.setText(">1.2g y <1.3g");
		lblHidratos.setText(CalculoValorIdeal.getHidratosideal()+"g");
		lblSal.setText("<=5.0g");
		lblGrasasSaturadas.setText("<"+CalculoValorIdeal.getGrasaSaturadaideal()+"%");


		//parte valor user
		lblGrasaUser.setText(CalculoValorIdeal.totalGrasaIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)+"g");
		lblAzucarUser.setText(CalculoValorIdeal.totalAzucarIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)+"g");
		lblProteinaUser.setText(CalculoValorIdeal.totalProteinaIdeal(alimentos, usuario, alimentosElegidos, cantidadesElegidas)+"g");
		lblPotasioUser.setText(CalculoValorIdeal.totalPotasioIdeal(alimentos, usuario, alimentosElegidos, cantidadesElegidas)+"mg");
		lblGrasasSaturadasUser.setText(CalculoValorIdeal.totalGrasaSaturadaIdeal(alimentos, alimentosElegidos, cantidadesElegidas)+"g " + "(" +CalculoValorIdeal.totalPorcentajeGrasaSaturadaIdeal(alimentos, alimentosElegidos, cantidadesElegidas) + "%)");
		lblCalcioUser.setText(CalculoValorIdeal.totalCalcioIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)+"g");
		lblHidratosUser.setText(CalculoValorIdeal.totalHidratosIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)+"g");
		lblSalUser.setText(CalculoValorIdeal.totalSalIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)+"g");
		
		JLabel lblNewLabel_3 = new JLabel("Atrás");
		lblNewLabel_3.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 56, 46, 14);
		frmCalcularValores.getContentPane().add(lblNewLabel_3);

		if (!CalculoValorIdeal.isGrasaIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)) {
			valoresNoIdeales(lblGrasaUser);
		}

		if (!CalculoValorIdeal.isAzucarIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)) {
			valoresNoIdeales(lblAzucarUser);
		}

		if (!CalculoValorIdeal.isProteinaIdeal(alimentos, usuario, alimentosElegidos, cantidadesElegidas)) {
			valoresNoIdeales(lblProteinaUser);
		}

		if (!CalculoValorIdeal.isPotasioIdeal(alimentos, usuario, alimentosElegidos, cantidadesElegidas)) {
			valoresNoIdeales(lblPotasioUser);
		}

		if (!CalculoValorIdeal.isGrasaSaturadaIdeal(alimentos, alimentosElegidos, cantidadesElegidas)) {
			valoresNoIdeales(lblGrasasSaturadasUser);
		}

		if (!CalculoValorIdeal.isCalcioIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)) {
			valoresNoIdeales(lblCalcioUser);
		}

		if (CalculoValorIdeal.isHidratosIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)) {
			valoresNoIdeales(lblHidratosUser);
		}

		if (CalculoValorIdeal.isSalIdeal(alimentos,  alimentosElegidos, cantidadesElegidas)) {
			valoresNoIdeales(lblSalUser);
		}
	}
	public void valoresNoIdeales(JLabel label) { /*con este método podremos re-utilizar código*/
		label.setForeground(Color.RED);
		label.setFont(new Font("Dialog", Font.BOLD, 13));
	}
}
