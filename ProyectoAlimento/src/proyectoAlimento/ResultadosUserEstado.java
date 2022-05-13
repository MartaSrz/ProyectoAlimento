/**
 *Clase llamada por ValoresNutritivos.
 *Esta clase ha sido creada para mostrar los resultados respecto al estado fisico  al user.
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

public class ResultadosUserEstado {

	private JFrame frmCalcularPesoIdeal;
	private final static Color FONDO_COLOR= new Color(255, 255, 221);
	private static Persona usuario;
	/**
	 * Launch the application.
	 */
	public static void estado(Persona usuario) { /*accción para arrancar la tercera ventana*/
		ResultadosUserEstado.usuario=usuario;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultadosUserEstado window = new ResultadosUserEstado();
					window.frmCalcularPesoIdeal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResultadosUserEstado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalcularPesoIdeal = new JFrame();
		frmCalcularPesoIdeal.setTitle("Calcular Peso Ideal y Valores Nutritivos");
		frmCalcularPesoIdeal.getContentPane().setBackground(FONDO_COLOR);
		frmCalcularPesoIdeal.setBounds(100, 100, 920, 650);
		frmCalcularPesoIdeal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalcularPesoIdeal.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Estos son tus resultados respecto al Cálculo Nutritivo :D!");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitulo.setBounds(218, 22, 467, 17);
		frmCalcularPesoIdeal.getContentPane().add(lblTitulo);
		
		JLabel lblInfopeso = new JLabel("Sobre su peso:");
		lblInfopeso.setFont(new Font("Dialog", Font.BOLD, 16));
		lblInfopeso.setBounds(597, 102, 118, 17);
		frmCalcularPesoIdeal.getContentPane().add(lblInfopeso);
		
		JTextArea textAreaCualEsSuPeso = new JTextArea();
		textAreaCualEsSuPeso.setEditable(false);
		textAreaCualEsSuPeso.setBounds(597, 130, 255, 129);
		frmCalcularPesoIdeal.getContentPane().add(textAreaCualEsSuPeso);
		textAreaCualEsSuPeso.setText("¡Hola " + usuario.getNombre() + "!\n");
		textAreaCualEsSuPeso.append(Imc.calcular_peso_ideal(usuario.getEdad(), usuario.getAltura(), usuario.getPeso(), usuario.getSexo())+"\n\n");
		textAreaCualEsSuPeso.append(Imc.imc_persona(usuario.getAltura(), usuario.getPeso()));
		
		JLabel lblReferenciaImagen = new JLabel("Esta imagen te ayudará a orientarte dependiendo de tu resultado.");
		lblReferenciaImagen.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblReferenciaImagen.setBounds(46, 64, 512, 30);
		frmCalcularPesoIdeal.getContentPane().add(lblReferenciaImagen);
		
		JLabel lblLabelImagen = new JLabel("");
        lblLabelImagen.setBounds(56, 102, 512, 476);
        frmCalcularPesoIdeal.getContentPane().add(lblLabelImagen);
        
        JButton IrAValores = new JButton(";)");
        IrAValores.setBounds(674, 362, 41, 30);
        frmCalcularPesoIdeal.getContentPane().add(IrAValores);
        
        JTextPane txtpnIrAValores = new JTextPane();
        txtpnIrAValores.setBackground(FONDO_COLOR);
        txtpnIrAValores.setText("Si quieres comprobar que tomaste los adecuados valores nutritivos respecto grasas, azucares, ect.,\n\npulsa aquí :");
        txtpnIrAValores.setBounds(597, 302, 255, 88);
        frmCalcularPesoIdeal.getContentPane().add(txtpnIrAValores);
        
        //ZONA TRABAJO
	    ImageIcon estadoFisico=new ImageIcon("img/estadofisico.png");
        lblLabelImagen.setIcon(estadoFisico);
        
        IrAValores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCalcularPesoIdeal.setVisible(false);
				ResultadosUserValoresNtr.valores(usuario);/*misma acción que en la ventana main pero hacia la cuarta ventana, le pasamos la misma persona*/
			}});
    	
        
	}
}
