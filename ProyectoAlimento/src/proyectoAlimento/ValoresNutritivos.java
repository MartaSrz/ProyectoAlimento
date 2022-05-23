/**
 *Clase llamada por ResultadosUserEstado la cual llamará a Resultados User.
 *Esta clase ha sido creada para preguntar al usuario qué alimento y cuánta cántidad
 *ha consumido de este, también mostrará los valores nutritivos del alimento elegido.
 */

package proyectoAlimento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JButton;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ValoresNutritivos {

	private JFrame ventanaCalc;
	private final static Color FONDO_COLOR= new Color(255, 255, 221);
	private JTextField txtFondoColor;
	private static boolean hayAlimentos=false;
	private static Persona usuario;  //Persona que mandaremos a la clase ResultadosUserEstado
	private Alimento alimento[] = { //Declaración de los alimentos a usar
			new Alimento("Manzana",95,396,0.03,0.1,25.1,18.9,0.5,4.4,0.1,10.9,0.2,194.7),
			new Alimento("Macarrones",390,1631,1.6,0.3,78.4,2.8,13.7,3.4,0.1,22.1,3.5,234.2),
			new Alimento("Cacahuetes",180,752,15.8,2.6,4.6,1.3,8.4,2.8,0.1,18.3,0.2,217.8),
			new Alimento("Tomate",32,133,0.6,0.1,6.3,0,2.1,1.5,0.1,23.3,1,547),
			new Alimento("Patata",52,219,0.1,0.1,12.1,0.5,1.1,1.2,0.1,3,0.2,227.4),
			new Alimento("Lentejas",353,1478,1.1,0.2,60.1,2,25.8,30.5,0.1,56,7.5,955),
			new Alimento("Pechuga de pollo",260,1089,13.2,3.5,9.0,0,24.8,0.3,0.3,20,1.3,201),
			new Alimento("Pizza",266,1114,9.7,4.5,33.3,3.6,11.4,2.3,0.6,188,2.5,172),
			new Alimento("Nuggets",296,1239,19.8,4,14.1,0,15.3,2.1,0.6,31,0.1,265),
			new Alimento("Tortilla",154,645,11.7,3.3,0.6,0.3,10.6,0,0.2,48,1.5,117),
			new Alimento("Yogurt",243,1016,2.8,1.8,45.7,45.7,9.8,0,0.1,338.1,0.1,433.7),
			new Alimento("Hamburguesa",254,1063,12.3,3.8,24.8,0,11.7,0,0.5,57,2.4,206),
			new Alimento("Costillas",224,938,16.3,5.8,0,0,19.1,0,0.1,31,0.8,247),
			new Alimento("Arroz",97,406,0.2,0.1,21.1,0.1,2.0,1,0.1,2,0.1,10)
	};
	ImageIcon imgAlimento[] = {
			new ImageIcon(new ImageIcon("img/manzana.jpg").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//0
			new ImageIcon(new ImageIcon("img/macarrones.jpg").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//1
			new ImageIcon(new ImageIcon("img/cacahuetes.jpg").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//2
			new ImageIcon(new ImageIcon("img/tomate.jpeg").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//3
			new ImageIcon(new ImageIcon("img/patata.jpg").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//4
			new ImageIcon(new ImageIcon("img/lentejas.jpg").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//5
			new ImageIcon(new ImageIcon("img/pechuga.jpg").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//6
			new ImageIcon(new ImageIcon("img/pizza.jpg").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//7
			new ImageIcon(new ImageIcon("img/nuggets.jpg").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//8
			new ImageIcon(new ImageIcon("img/tortilla.png").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//9
			new ImageIcon(new ImageIcon("img/yogurt.jpg").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//10
			new ImageIcon(new ImageIcon("img/hamburguesa.jpg").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//11
			new ImageIcon(new ImageIcon("img/Costillas.jpg").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//12
			new ImageIcon(new ImageIcon("img/Arroz.png").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)),//13
	};
	private static ArraysToString<String> alimentosElegidos= new ArraysToString<>();
	private static ArraysToString<Integer> cantidadesElegidas= new ArraysToString<>();
	/**
	 * Launch the application.
	 * @param usuario 
	 */
	private static JSpinner cantidadGramos = new JSpinner();
	private static	JEditorPane txtAlimentosElegidos = new JEditorPane();
	private static 	JEditorPane txtCantidadesElegidas = new JEditorPane();
	private JButton btnComprobarValoresNtr = new JButton("Comprobar Valores Nutritivos");

	public static void arrancar(Persona usuario, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) { /*Metodo para arrancar la segunda ventana*/
		ValoresNutritivos.usuario=usuario;
		ValoresNutritivos.alimentosElegidos=alimentosElegidos;
		ValoresNutritivos.cantidadesElegidas=cantidadesElegidas;
		
		/*el user que va a ser pasado a la clase ResultadoUser es el mismo que el user mandado a esta clase en la clase DatosUsuario*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValoresNutritivos window = new ValoresNutritivos();
					window.ventanaCalc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void insertarValores() {
		if (cantidadesElegidas.size()>0) {
			txtAlimentosElegidos.setText(alimentosElegidos.toString());
			txtCantidadesElegidas.setText(cantidadesElegidas.toString());
			cantidadGramos.setValue(100);
			btnComprobarValoresNtr.setEnabled(true);
			hayAlimentos=true;
		}
	}
	
	public static boolean isHayAlimentos() {
		return hayAlimentos;
	}

	/**
	 * Create the application.
	 */
	public ValoresNutritivos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		insertarValores() ;
		
		ventanaCalc = new JFrame();
		ventanaCalc.setTitle("DietOMatic");
		ventanaCalc.setResizable(false);
		ventanaCalc.getContentPane().setBackground(new Color(236, 224, 251));
		ventanaCalc.setBounds(100, 100, 1313, 987);
		ventanaCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaCalc.getContentPane().setLayout(null);

		/* creación del for para coger solo el nombre de los alimento para utilizarlo en el comboBox*/
		int longitudArray=alimento.length;
		String[] nombreAlimentos= new String[longitudArray];
		for (int i=0; i<longitudArray; i++) {
			nombreAlimentos[i]=alimento[i].getNombre();
		}

		JComboBox selectAlimentos = new JComboBox();
		selectAlimentos.setAlignmentX(Component.RIGHT_ALIGNMENT);
		selectAlimentos.setFont(new Font("Dialog", Font.BOLD, 16));
		selectAlimentos.setModel(new DefaultComboBoxModel(nombreAlimentos));
		selectAlimentos.setSelectedIndex(-1);
		selectAlimentos.setBounds(259, 23, 217, 37);
		ventanaCalc.getContentPane().add(selectAlimentos);

		JLabel lblEscogeUnAlimento = new JLabel("Escoge un alimento:");
		lblEscogeUnAlimento.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEscogeUnAlimento.setBounds(49, 23, 192, 32);
		ventanaCalc.getContentPane().add(lblEscogeUnAlimento);

		JLabel lblValorLetrero = new JLabel("Valor");
		lblValorLetrero.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblValorLetrero.setBounds(49, 169, 192, 32);
		ventanaCalc.getContentPane().add(lblValorLetrero);

		JLabel lblEnergticoLetrero = new JLabel("energ\u00E9tico");
		lblEnergticoLetrero.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblEnergticoLetrero.setBounds(49, 197, 192, 32);
		ventanaCalc.getContentPane().add(lblEnergticoLetrero);

		JLabel lblGrasasLetrero = new JLabel("Grasas");
		lblGrasasLetrero.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGrasasLetrero.setBounds(49, 244, 192, 32);
		ventanaCalc.getContentPane().add(lblGrasasLetrero);

		JLabel lblSaturadasLetrero = new JLabel("Saturadas");
		lblSaturadasLetrero.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSaturadasLetrero.setBounds(85, 270, 192, 32);
		ventanaCalc.getContentPane().add(lblSaturadasLetrero);

		JLabel lblHidratosDeCarbonoLetrero = new JLabel("Hidratos de carbono");
		lblHidratosDeCarbonoLetrero.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHidratosDeCarbonoLetrero.setBounds(49, 314, 192, 32);
		ventanaCalc.getContentPane().add(lblHidratosDeCarbonoLetrero);

		JLabel lblAzcarLetrero = new JLabel("Az\u00FAcar");
		lblAzcarLetrero.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblAzcarLetrero.setBounds(85, 341, 192, 32);
		ventanaCalc.getContentPane().add(lblAzcarLetrero);

		JLabel lblProtenasLetrero = new JLabel("Prote\u00EDnas");
		lblProtenasLetrero.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblProtenasLetrero.setBounds(49, 385, 192, 32);
		ventanaCalc.getContentPane().add(lblProtenasLetrero);

		JLabel lblSalLetrero = new JLabel("Sal");
		lblSalLetrero.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSalLetrero.setBounds(49, 428, 192, 32);
		ventanaCalc.getContentPane().add(lblSalLetrero);

		JLabel lblCalcioLetrero = new JLabel("Calcio");
		lblCalcioLetrero.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblCalcioLetrero.setBounds(49, 472, 192, 32);
		ventanaCalc.getContentPane().add(lblCalcioLetrero);

		JLabel lblFibraLetrero = new JLabel("Fibra");
		lblFibraLetrero.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblFibraLetrero.setBounds(49, 516, 192, 32);
		ventanaCalc.getContentPane().add(lblFibraLetrero);

		JLabel lblPotasioLetrero = new JLabel("Potasio");
		lblPotasioLetrero.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblPotasioLetrero.setBounds(49, 560, 192, 32);
		ventanaCalc.getContentPane().add(lblPotasioLetrero);

		JLabel lblHierroLetrero = new JLabel("Hierro");
		lblHierroLetrero.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHierroLetrero.setBounds(49, 604, 192, 32);
		ventanaCalc.getContentPane().add(lblHierroLetrero);

		JLabel lblPorg = new JLabel("por 100g");
		lblPorg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPorg.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPorg.setBounds(629, 133, 80, 32);
		ventanaCalc.getContentPane().add(lblPorg);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(38, 123, 678, 10);
		ventanaCalc.getContentPane().add(separator);

		JLabel lblImgAlimentos = new JLabel();
		lblImgAlimentos.setBorder(null);
		lblImgAlimentos.setBounds(49, 670, 246, 246);
		ventanaCalc.getContentPane().add(lblImgAlimentos);
		lblImgAlimentos.setIcon(new ImageIcon(new ImageIcon("img/Piramide.png").getImage().getScaledInstance(246, 246, Image.SCALE_DEFAULT)));

		JLabel lblcuntaCantidadHas = new JLabel("\u00BFCu\u00E1nta cantidad has consumido?");
		lblcuntaCantidadHas.setFont(new Font("Dialog", Font.BOLD, 16));
		lblcuntaCantidadHas.setBounds(49, 79, 280, 32);
		ventanaCalc.getContentPane().add(lblcuntaCantidadHas);


		cantidadGramos.setEnabled(false);
		cantidadGramos.setModel(new SpinnerNumberModel(new Integer(100), new Integer(10), null, new Integer(1)));
		cantidadGramos.setFont(new Font("Dialog", Font.BOLD, 16));
		cantidadGramos.setBounds(388, 79, 88, 32);
		ventanaCalc.getContentPane().add(cantidadGramos);

		JButton btnEstadoFisico = new JButton("Comprobar estado físico");
		btnEstadoFisico.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEstadoFisico.setBounds(1048, 871, 245, 45);
		ventanaCalc.getContentPane().add(btnEstadoFisico);

		JButton btnAnyadir = new JButton("A\u00F1adir");

		btnAnyadir.setEnabled(false);
		btnAnyadir.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAnyadir.setBounds(517, 79, 192, 32);
		ventanaCalc.getContentPane().add(btnAnyadir);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(38, 648, 678, 10);
		ventanaCalc.getContentPane().add(separator_2);

		JLabel lblValor = new JLabel("0");
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblValor.setBounds(587, 169, 61, 32);
		ventanaCalc.getContentPane().add(lblValor);

		JLabel lblEnergtico = new JLabel("0");
		lblEnergtico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnergtico.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblEnergtico.setBounds(587, 197, 61, 32);
		ventanaCalc.getContentPane().add(lblEnergtico);

		JLabel lblGrasas = new JLabel("0");
		lblGrasas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrasas.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGrasas.setBounds(587, 244, 61, 32);
		ventanaCalc.getContentPane().add(lblGrasas);

		JLabel lblSaturadas = new JLabel("0");
		lblSaturadas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaturadas.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSaturadas.setBounds(587, 270, 61, 32);
		ventanaCalc.getContentPane().add(lblSaturadas);

		JLabel lblHidratosDeCarbono = new JLabel("0");
		lblHidratosDeCarbono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHidratosDeCarbono.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHidratosDeCarbono.setBounds(587, 314, 61, 32);
		ventanaCalc.getContentPane().add(lblHidratosDeCarbono);

		JLabel lblAzcar = new JLabel("0");
		lblAzcar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAzcar.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblAzcar.setBounds(587, 341, 61, 32);
		ventanaCalc.getContentPane().add(lblAzcar);

		JLabel lblProtenas = new JLabel("0");
		lblProtenas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProtenas.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblProtenas.setBounds(587, 385, 61, 32);
		ventanaCalc.getContentPane().add(lblProtenas);

		JLabel lblSal = new JLabel("0");
		lblSal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSal.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSal.setBounds(587, 428, 61, 32);
		ventanaCalc.getContentPane().add(lblSal);

		JLabel lblCalcio = new JLabel("0");
		lblCalcio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalcio.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblCalcio.setBounds(587, 472, 61, 32);
		ventanaCalc.getContentPane().add(lblCalcio);

		JLabel lblFibra = new JLabel("0");
		lblFibra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFibra.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblFibra.setBounds(587, 516, 61, 32);
		ventanaCalc.getContentPane().add(lblFibra);

		JLabel lblPotasio = new JLabel("0");
		lblPotasio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPotasio.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblPotasio.setBounds(587, 560, 61, 32);
		ventanaCalc.getContentPane().add(lblPotasio);

		JLabel lblHierro = new JLabel("0");
		lblHierro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHierro.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHierro.setBounds(587, 604, 61, 32);
		ventanaCalc.getContentPane().add(lblHierro);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(49, 233, 660, 10);
		ventanaCalc.getContentPane().add(separator_1);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.LIGHT_GRAY);
		separator_3.setBounds(49, 305, 660, 10);
		ventanaCalc.getContentPane().add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.LIGHT_GRAY);
		separator_4.setBounds(49, 376, 660, 10);
		ventanaCalc.getContentPane().add(separator_4);

		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setForeground(Color.LIGHT_GRAY);
		separator_3_1.setBounds(49, 428, 660, 2);
		ventanaCalc.getContentPane().add(separator_3_1);

		JSeparator separator_4_1 = new JSeparator();
		separator_4_1.setForeground(Color.LIGHT_GRAY);
		separator_4_1.setBounds(49, 505, 660, 10);
		ventanaCalc.getContentPane().add(separator_4_1);

		JSeparator separator_4_1_1 = new JSeparator();
		separator_4_1_1.setForeground(Color.LIGHT_GRAY);
		separator_4_1_1.setBounds(49, 463, 660, 10);
		ventanaCalc.getContentPane().add(separator_4_1_1);

		JSeparator separator_4_1_2 = new JSeparator();
		separator_4_1_2.setForeground(Color.LIGHT_GRAY);
		separator_4_1_2.setBounds(49, 549, 660, 10);
		ventanaCalc.getContentPane().add(separator_4_1_2);

		JSeparator separator_4_1_3 = new JSeparator();
		separator_4_1_3.setForeground(Color.LIGHT_GRAY);
		separator_4_1_3.setBounds(49, 594, 660, 10);
		ventanaCalc.getContentPane().add(separator_4_1_3);

		JLabel lblGramos = new JLabel("g");
		lblGramos.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos.setBounds(671, 244, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos);

		JLabel lblGramos_1 = new JLabel("g");
		lblGramos_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos_1.setBounds(671, 270, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos_1);

		JLabel lblGramos_2 = new JLabel("g");
		lblGramos_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos_2.setBounds(671, 314, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos_2);

		JLabel lblGramos_3 = new JLabel("g");
		lblGramos_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos_3.setBounds(671, 341, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos_3);

		JLabel lblGramos_4 = new JLabel("g");
		lblGramos_4.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos_4.setBounds(671, 385, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos_4);

		JLabel lblGramos_5 = new JLabel("g");
		lblGramos_5.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos_5.setBounds(671, 428, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos_5);

		JLabel lblGramos_6 = new JLabel("g");
		lblGramos_6.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos_6.setBounds(671, 472, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos_6);

		JLabel lblMiliGramos_1 = new JLabel("mg");
		lblMiliGramos_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblMiliGramos_1.setBounds(671, 560, 38, 32);
		ventanaCalc.getContentPane().add(lblMiliGramos_1);

		JLabel lblMiliGramos_2 = new JLabel("mg");
		lblMiliGramos_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblMiliGramos_2.setBounds(671, 604, 38, 32);
		ventanaCalc.getContentPane().add(lblMiliGramos_2);

		JLabel lblMiliGramos = new JLabel("mg");
		lblMiliGramos.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblMiliGramos.setBounds(671, 516, 38, 32);
		ventanaCalc.getContentPane().add(lblMiliGramos);

		JLabel lblKiloCalorias = new JLabel("Kcal");
		lblKiloCalorias.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblKiloCalorias.setBounds(671, 169, 38, 32);
		ventanaCalc.getContentPane().add(lblKiloCalorias);
		
		JLabel lblPorg_1 = new JLabel("por 0g");
		lblPorg_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPorg_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPorg_1.setBounds(396, 133, 80, 32);
		ventanaCalc.getContentPane().add(lblPorg_1);
		
		JLabel lblKiloCalorias_1 = new JLabel("Kcal");
		lblKiloCalorias_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblKiloCalorias_1.setBounds(438, 169, 38, 32);
		ventanaCalc.getContentPane().add(lblKiloCalorias_1);
		
		JLabel lblValorUser = new JLabel("0");
		lblValorUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblValorUser.setBounds(354, 169, 61, 32);
		ventanaCalc.getContentPane().add(lblValorUser);
		
		JLabel lblEnergticoUser = new JLabel("0");
		lblEnergticoUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnergticoUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblEnergticoUser.setBounds(354, 197, 61, 32);
		ventanaCalc.getContentPane().add(lblEnergticoUser);
		
		JLabel lblKiloJulios_1 = new JLabel("KJ");
		lblKiloJulios_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblKiloJulios_1.setBounds(438, 197, 38, 32);
		ventanaCalc.getContentPane().add(lblKiloJulios_1);
		
		JLabel lblGramos_7 = new JLabel("g");
		lblGramos_7.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos_7.setBounds(438, 244, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos_7);
		
		JLabel lblGrasasUser = new JLabel("0");
		lblGrasasUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrasasUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGrasasUser.setBounds(354, 244, 61, 32);
		ventanaCalc.getContentPane().add(lblGrasasUser);
		
		JLabel lblSaturadasUser = new JLabel("0");
		lblSaturadasUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaturadasUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSaturadasUser.setBounds(354, 270, 61, 32);
		ventanaCalc.getContentPane().add(lblSaturadasUser);
		
		JLabel lblGramos_2_1 = new JLabel("g");
		lblGramos_2_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos_2_1.setBounds(438, 314, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos_2_1);
		
		JLabel lblGramos_1_1 = new JLabel("g");
		lblGramos_1_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos_1_1.setBounds(438, 270, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos_1_1);
		
		JLabel lblHidratosDeCarbonoUser = new JLabel("0");
		lblHidratosDeCarbonoUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHidratosDeCarbonoUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHidratosDeCarbonoUser.setBounds(354, 314, 61, 32);
		ventanaCalc.getContentPane().add(lblHidratosDeCarbonoUser);
		
		JLabel lblAzcarUser = new JLabel("0");
		lblAzcarUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAzcarUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblAzcarUser.setBounds(354, 341, 61, 32);
		ventanaCalc.getContentPane().add(lblAzcarUser);
		
		JLabel lblGramos_3_1 = new JLabel("g");
		lblGramos_3_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos_3_1.setBounds(438, 341, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos_3_1);
		
		JLabel lblGramos_4_1 = new JLabel("g");
		lblGramos_4_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos_4_1.setBounds(438, 385, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos_4_1);
		
		JLabel lblProtenasUser = new JLabel("0");
		lblProtenasUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProtenasUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblProtenasUser.setBounds(354, 385, 61, 32);
		ventanaCalc.getContentPane().add(lblProtenasUser);
		
		JLabel lblSalUser = new JLabel("0");
		lblSalUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSalUser.setBounds(354, 428, 61, 32);
		ventanaCalc.getContentPane().add(lblSalUser);
		
		JLabel lblGramos_5_1 = new JLabel("g");
		lblGramos_5_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos_5_1.setBounds(438, 428, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos_5_1);
		
		JLabel lblGramos_6_1 = new JLabel("g");
		lblGramos_6_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGramos_6_1.setBounds(438, 472, 38, 32);
		ventanaCalc.getContentPane().add(lblGramos_6_1);
		
		JLabel lblCalcioUser = new JLabel("0");
		lblCalcioUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalcioUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblCalcioUser.setBounds(354, 472, 61, 32);
		ventanaCalc.getContentPane().add(lblCalcioUser);
		
		JLabel lblFibraUser = new JLabel("0");
		lblFibraUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFibraUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblFibraUser.setBounds(354, 516, 61, 32);
		ventanaCalc.getContentPane().add(lblFibraUser);
		
		JLabel lblMiliGramos_3 = new JLabel("mg");
		lblMiliGramos_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblMiliGramos_3.setBounds(438, 516, 38, 32);
		ventanaCalc.getContentPane().add(lblMiliGramos_3);
		
		JLabel lblMiliGramos_1_1 = new JLabel("mg");
		lblMiliGramos_1_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblMiliGramos_1_1.setBounds(438, 560, 38, 32);
		ventanaCalc.getContentPane().add(lblMiliGramos_1_1);
		
		JLabel lblPotasioUser = new JLabel("0");
		lblPotasioUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPotasioUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblPotasioUser.setBounds(354, 560, 61, 32);
		ventanaCalc.getContentPane().add(lblPotasioUser);
		
		JLabel lblHierroUser = new JLabel("0");
		lblHierroUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHierroUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHierroUser.setBounds(354, 604, 61, 32);
		ventanaCalc.getContentPane().add(lblHierroUser);
		
		JLabel lblMiliGramos_2_1 = new JLabel("mg");
		lblMiliGramos_2_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblMiliGramos_2_1.setBounds(438, 604, 38, 32);
		ventanaCalc.getContentPane().add(lblMiliGramos_2_1);

		txtAlimentosElegidos.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtAlimentosElegidos.setEditable(false);
		txtAlimentosElegidos.setBackground(FONDO_COLOR);
		txtAlimentosElegidos.setBounds(801, 79, 233, 726);
		ventanaCalc.getContentPane().add(txtAlimentosElegidos);

		txtCantidadesElegidas.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtCantidadesElegidas.setEditable(false);
		txtCantidadesElegidas.setBounds(1085, 79, 154, 726);
		txtCantidadesElegidas.setBackground(FONDO_COLOR);
		ventanaCalc.getContentPane().add(txtCantidadesElegidas);

		JLabel lblKiloJulios = new JLabel("KJ");
		lblKiloJulios.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblKiloJulios.setBounds(671, 197, 38, 32);
		ventanaCalc.getContentPane().add(lblKiloJulios);

		JLabel lblCantidad = new JLabel("Cantidades");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCantidad.setBounds(1075, 34, 160, 32);
		ventanaCalc.getContentPane().add(lblCantidad);

		JLabel lblAlimentoElegido = new JLabel("Alimentos elegidos");
		lblAlimentoElegido.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlimentoElegido.setFont(new Font("Dialog", Font.BOLD, 18));
		lblAlimentoElegido.setBounds(791, 37, 243, 26);
		ventanaCalc.getContentPane().add(lblAlimentoElegido);

		txtFondoColor = new JTextField();
		txtFondoColor.setEditable(false);
		txtFondoColor.setBackground(FONDO_COLOR);
		txtFondoColor.setBounds(756, 23, 537, 813);
		ventanaCalc.getContentPane().add(txtFondoColor);
		txtFondoColor.setColumns(10);

		JTextPane textConsejo = new JTextPane();
		textConsejo.setEditable(false);
		textConsejo.setFont(new Font("Dialog", Font.PLAIN, 14));
		textConsejo.setBackground(FONDO_COLOR);
		textConsejo.setBounds(307, 670, 402, 246);
		ventanaCalc.getContentPane().add(textConsejo);

		JLabel lblEspecificarGramos = new JLabel("g");
		lblEspecificarGramos.setHorizontalAlignment(SwingConstants.LEFT);
		lblEspecificarGramos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEspecificarGramos.setBounds(487, 79, 25, 32);
		ventanaCalc.getContentPane().add(lblEspecificarGramos);
		
		btnComprobarValoresNtr.setEnabled(hayAlimentos);
		btnComprobarValoresNtr.setFont(new Font("Dialog", Font.BOLD, 16));
		btnComprobarValoresNtr.setBounds(756, 871, 280, 45);
		ventanaCalc.getContentPane().add(btnComprobarValoresNtr);
		
		JButton btnBorrarRegistro = new JButton("Borrar registro");
		btnBorrarRegistro.setFont(new Font("Dialog", Font.BOLD, 16));
		btnBorrarRegistro.setBounds(517, 23, 192, 37);
		ventanaCalc.getContentPane().add(btnBorrarRegistro);
		btnBorrarRegistro.setEnabled(hayAlimentos);
		


		//ZONA DE TRABAJO-----------------------------------------------------------------------
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		selectAlimentos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) { /*Se cambia de elemento el selector de alimentos*/
				int seleccionado = selectAlimentos.getSelectedIndex();

				cantidadGramos.setEnabled(true);
				btnAnyadir.setEnabled(true);
				lblValor.setText(String.valueOf(alimento[seleccionado].getKcal()));
				lblEnergtico.setText(String.valueOf(alimento[seleccionado].getkJ()));
				lblGrasas.setText(String.valueOf(alimento[seleccionado].getGrasas()));
				lblSaturadas.setText(String.valueOf(alimento[seleccionado].getGrasasSaturadas()));
				lblHidratosDeCarbono.setText(String.valueOf(alimento[seleccionado].getHidratos()));
				lblAzcar.setText(String.valueOf(alimento[seleccionado].getAzucar()));
				lblProtenas.setText(String.valueOf(alimento[seleccionado].getProteinas()));
				lblSal.setText(String.valueOf(alimento[seleccionado].getSal()));
				lblCalcio.setText(String.valueOf(alimento[seleccionado].getCalcio()));
				lblFibra.setText(String.valueOf(alimento[seleccionado].getFibra()));
				lblPotasio.setText(String.valueOf(alimento[seleccionado].getPotasio()));
				lblHierro.setText(String.valueOf(alimento[seleccionado].getHierro()));
				lblImgAlimentos.setIcon(imgAlimento[seleccionado]);
				lblPorg_1.setText("por 100g");
				lblValorUser.setText(String.valueOf(alimento[seleccionado].getKcal()));
				lblEnergticoUser.setText(String.valueOf(alimento[seleccionado].getkJ()));
				lblGrasasUser.setText(String.valueOf(alimento[seleccionado].getGrasas()));
				lblSaturadasUser.setText(String.valueOf(alimento[seleccionado].getGrasasSaturadas()));
				lblHidratosDeCarbonoUser.setText(String.valueOf(alimento[seleccionado].getHidratos()));
				lblAzcarUser.setText(String.valueOf(alimento[seleccionado].getAzucar()));
				lblProtenasUser.setText(String.valueOf(alimento[seleccionado].getProteinas()));
				lblSalUser.setText(String.valueOf(alimento[seleccionado].getSal()));
				lblCalcioUser.setText(String.valueOf(alimento[seleccionado].getCalcio()));
				lblFibraUser.setText(String.valueOf(alimento[seleccionado].getFibra()));
				lblPotasioUser.setText(String.valueOf(alimento[seleccionado].getPotasio()));
				lblHierroUser.setText(String.valueOf(alimento[seleccionado].getHierro()));
			}
		});
		
		cantidadGramos.addChangeListener(new ChangeListener() { /* se cambia el valor de la cantidad de alimentos */
			public void stateChanged(ChangeEvent arg0) {
				int seleccionado = selectAlimentos.getSelectedIndex();
				int cantidad =  (int) cantidadGramos.getValue();
				lblPorg_1.setText("por " + cantidad + "g");
				lblValorUser.setText(String.valueOf(decimalFormat.format(alimento[seleccionado].getKcal()*cantidad/100)));
				lblEnergticoUser.setText(String.valueOf(decimalFormat.format(alimento[seleccionado].getkJ()*cantidad/100)));
				lblGrasasUser.setText(String.valueOf(decimalFormat.format(alimento[seleccionado].getGrasas()*cantidad/100)));
				lblSaturadasUser.setText(String.valueOf(decimalFormat.format(alimento[seleccionado].getGrasasSaturadas()*cantidad/100)));
				lblHidratosDeCarbonoUser.setText(String.valueOf(decimalFormat.format(alimento[seleccionado].getHidratos()*cantidad/100)));
				lblAzcarUser.setText(String.valueOf(decimalFormat.format(alimento[seleccionado].getAzucar()*cantidad/100)));
				lblProtenasUser.setText(String.valueOf(decimalFormat.format(alimento[seleccionado].getProteinas()*cantidad/100)));
				lblSalUser.setText(String.valueOf(decimalFormat.format(alimento[seleccionado].getSal()*cantidad/100)));
				lblCalcioUser.setText(String.valueOf(decimalFormat.format(alimento[seleccionado].getCalcio()*cantidad/100)));
				lblFibraUser.setText(String.valueOf(decimalFormat.format(alimento[seleccionado].getFibra()*cantidad/100)));
				lblPotasioUser.setText(String.valueOf(decimalFormat.format(alimento[seleccionado].getPotasio()*cantidad/100)));
				lblHierroUser.setText(String.valueOf(decimalFormat.format(alimento[seleccionado].getHierro()*cantidad/100)));
				
			}
		});


		textConsejo.setText("CONSEJO NUTRICIONAL\n\nTodas las células del cuerpo necesitan de agua para funcionar, por eso es esencial ingerir suficiente. Una adecuada hidratación te puede ayudar a mejorar tu digestión, la función de tus riñones y lucir una piel más hidratada.\n\nLo ideal es que consumas 2,7 litros de agua potable al día si eres mujer y 3,7 si eres hombre. Aquí se incluye el agua de los alimentos, que representa aproximadamente un 20% del total.");
		


		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {/*eso va a almacenar en el texto la cantidad y el alimento*/
				hayAlimentos=true;
				btnBorrarRegistro.setEnabled(true);
				btnComprobarValoresNtr.setEnabled(true);
				int siceAlimentosElegidos=alimentosElegidos.size();
				int sumaValoresElegidos;
				boolean alimentoEncontrado=false;
				for (int i=0; i<siceAlimentosElegidos && !alimentoEncontrado; i++) { /*Este for es para buscar si el alimento seleccionado ya está en la lista, si lo está, le suma los gramos, sino sale del for y lo añade como uno normal*/
					if (selectAlimentos.getSelectedItem()==alimentosElegidos.get(i)) {
						alimentoEncontrado=true;
						sumaValoresElegidos=(int) cantidadGramos.getValue();
						sumaValoresElegidos+= (Integer)cantidadesElegidas.get(i);
						cantidadesElegidas.remove(i);
						cantidadesElegidas.add(i, sumaValoresElegidos);
					}
				}
				if (!alimentoEncontrado) {
					alimentosElegidos.add((String) selectAlimentos.getSelectedItem());
					cantidadesElegidas.add((Integer) cantidadGramos.getValue());
				}
				insertarValores();
			}
		});
		btnBorrarRegistro.addActionListener(new ActionListener() { /*asi se borrará todo lo almacenado de los alimentos y cantidades elegidas, y desactivara el boton y pondrá el boolean a false para impedir que la ventana de resultados de valores se abra*/
			public void actionPerformed(ActionEvent arg0) {
				alimentosElegidos.clear();
				cantidadesElegidas.clear();
				txtAlimentosElegidos.setText("");
				txtCantidadesElegidas.setText("");
				btnComprobarValoresNtr.setEnabled(false);
				hayAlimentos=false;
				btnBorrarRegistro.setEnabled(false);
			}
		});
		btnEstadoFisico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaCalc.setVisible(false);
				ResultadosUserEstado.estado(usuario, hayAlimentos, alimento, alimentosElegidos, cantidadesElegidas); /*misma acción que en la ventana main pero hacia la tercera ventana pasando los mismos valores (persona, alimentos elegidos, etc) más el booleano para saber si puede abrir ResultadosUserValoresNtr*/
			}
		});
		btnComprobarValoresNtr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaCalc.setVisible(false);
				ResultadosUserValoresNtr.valores(usuario, alimento, alimentosElegidos, cantidadesElegidas);/*misma acción que en la ventana main pero hacia la cuarta ventana pasando los mismos valores (persona, alimentos elegidos, etc)*/
			}
		});
	}
} 
