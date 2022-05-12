/**
 *Clase llamada por ValoresNutritivos.
 *Esta clase ha sido creada para mostrar los resultados finales al user.
 */


package proyectoAlimento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class ResultadosUser {

	private JFrame frame;
	private final static Color FONDO_COLOR= new Color(255, 255, 221);
	private static Persona usuario;
	/**
	 * Launch the application.
	 */
	public static void resultados(Persona usuario) { /*accción para arrancar la tercera ventana*/
		ResultadosUser.usuario=usuario;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultadosUser window = new ResultadosUser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResultadosUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(FONDO_COLOR);
		frame.setBounds(100, 100, 920, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Estos son tus resultados respecto al Cálculo Nutritivo :D!");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitulo.setBounds(218, 22, 467, 17);
		frame.getContentPane().add(lblTitulo);
		
		JLabel lblInfopeso = new JLabel("Sobre su peso:");
		lblInfopeso.setFont(new Font("Dialog", Font.BOLD, 16));
		lblInfopeso.setBounds(597, 102, 118, 17);
		frame.getContentPane().add(lblInfopeso);
		
		JTextArea textAreaCualEsSuPeso = new JTextArea();
		textAreaCualEsSuPeso.setEditable(false);
		textAreaCualEsSuPeso.setBounds(597, 130, 255, 129);
		frame.getContentPane().add(textAreaCualEsSuPeso);
		textAreaCualEsSuPeso.setText("¡Hola " + usuario.getNombre() + "!\n");
		textAreaCualEsSuPeso.append(Imc.calcular_peso_ideal(usuario.getEdad(), usuario.getAltura(), usuario.getPeso(), usuario.getSexo())+"\n\n");
		textAreaCualEsSuPeso.append(Imc.imc_persona(usuario.getAltura(), usuario.getPeso()));
		
		JLabel lblReferenciaImagen = new JLabel("Esta imagen te ayudará a orientarte dependiendo de tu resultado.");
		lblReferenciaImagen.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblReferenciaImagen.setBounds(46, 64, 512, 30);
		frame.getContentPane().add(lblReferenciaImagen);
		
		JLabel lblLabelImagen = new JLabel("");
        lblLabelImagen.setBounds(46, 80, 512, 476);
        frame.getContentPane().add(lblLabelImagen);
        
        //ZONA TRABAJO
	    ImageIcon estadoFisico=new ImageIcon("img/estadoFisico.png");
        lblLabelImagen.setIcon(estadoFisico);
	}
}
