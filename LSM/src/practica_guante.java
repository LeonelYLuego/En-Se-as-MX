import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import JPanelWebCam.JPanelWebCam;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class practica_guante extends JFrame {

	private JPanel contentPane;
	public static JLabel instruccion;
	int cont=0;
	boolean respuesta=false;
	private JButton btnFinalizar;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					practica_guante frame = new practica_guante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public practica_guante() {
		ConexionPython python = new ConexionPython();
		metodos metodos = new metodos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 531);
		setLocationRelativeTo(null);
		setTitle("En-Señas MX: Curso de enseñanza de Lengua de Señas Mexicana");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTexto = new JLabel("Ponte el guante y cuando est\u00E9s listo da click en el bot\u00F3n Siguiente");
		lblTexto.setBounds(75, 77, 698, 71);
		contentPane.add(lblTexto);
		
		instruccion = new JLabel("Aa");
		instruccion.setBounds(75,147,698,71);
		contentPane.add(instruccion);

		JButton btnSiguiente = new JButton("Siguiente");
	
		btnSiguiente.setBounds(675, 446, 97, 25);
		contentPane.add(btnSiguiente);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(798, 446, 97, 25);
		btnFinalizar.setEnabled(false);
		contentPane.add(btnFinalizar);
		
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/imagenes/logo.png");
	    setIconImage(miIcono);
	

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblTexto.setText("Realiza la siguiente estructura en LSM");
				if (respuesta) {
					try {
						metodos.azar();
						if (python.getCorrect(instruccion.getText())==1) {
							respuesta=true;
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					cont++;
				}
				else {
					System.out.println("Respuesta incorrecta");
				}
				
				if (cont<=6) {
					btnSiguiente.setEnabled(true);
					btnFinalizar.setEnabled(false);
				}
				else {
					btnFinalizar.setEnabled(true);
				}
			}
		});
		
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					python.close();
					metodos.cambios();
					pantalla_menu menu = new pantalla_menu();
					menu.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				setVisible(false);
			
			}
		});
	}
}
