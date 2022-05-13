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
	private final static Color FONDO_COLOR= new Color(255, 255, 221);
	private static Persona usuario; 

	/**
	 * Launch the application.
	 * @param hayAlimentos2 
	 */
	public static void valores(Persona usuario) { /*accción para arrancar la cuarta ventana*/
		ResultadosUserValoresNtr.usuario=usuario;

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
		
		JLabel lblInfopeso = new JLabel("Sobre su peso:");
		lblInfopeso.setFont(new Font("Dialog", Font.BOLD, 16));
		lblInfopeso.setBounds(597, 102, 118, 17);
		frmCalcularValores.getContentPane().add(lblInfopeso);
		
		JTextArea textAreaCualEsSuPeso = new JTextArea();
		textAreaCualEsSuPeso.setEditable(false);
		textAreaCualEsSuPeso.setBounds(597, 130, 255, 129);
		frmCalcularValores.getContentPane().add(textAreaCualEsSuPeso);
		textAreaCualEsSuPeso.setText("¡Hola " + usuario.getNombre() + "!\n");
		textAreaCualEsSuPeso.append(Imc.calcular_peso_ideal(usuario.getEdad(), usuario.getAltura(), usuario.getPeso(), usuario.getSexo())+"\n\n");
		textAreaCualEsSuPeso.append(Imc.imc_persona(usuario.getAltura(), usuario.getPeso()));
		
		JLabel lblReferenciaImagen = new JLabel("Esta imagen te ayudará a orientarte dependiendo de tu resultado.");
		lblReferenciaImagen.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblReferenciaImagen.setBounds(46, 64, 512, 30);
		frmCalcularValores.getContentPane().add(lblReferenciaImagen);
		
		JLabel lblLabelImagen = new JLabel("");
        lblLabelImagen.setBounds(46, 80, 512, 476);
        frmCalcularValores.getContentPane().add(lblLabelImagen);
        
        JButton IrAEstado = new JButton(";)");
        IrAEstado.setBounds(674, 352, 41, 30);
        frmCalcularValores.getContentPane().add(IrAEstado);
        
        JTextPane txtpnIrAValores = new JTextPane();
        txtpnIrAValores.setBackground(FONDO_COLOR);
        txtpnIrAValores.setText("Si quieres comprobar a que estado físico correspondes,\n\npulsa aquí :");
        txtpnIrAValores.setBounds(597, 302, 255, 88);
        frmCalcularValores.getContentPane().add(txtpnIrAValores);
        
        //ZONA TRABAJO
	    ImageIcon estadoFisico=new ImageIcon("img/estadoFisico.png");
        lblLabelImagen.setIcon(estadoFisico);
        
        IrAEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCalcularValores.setVisible(false);
				ResultadosUserEstado.estado(usuario, true);/*misma acción que en la ventana main pero hacia la cuarta ventana, le pasamos la misma persona*/
			}});
	}
}
