import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class pantalla_lecciones extends JFrame {

	private JPanel contentPane;
	public static JLabel lblNivel, lblNombreNivel, lblComencemos, lblLetras, letras, lblParaComenzar;
	//public static JLabel lblNombreNivel, lblNivel;
	public static String tabla="", letrasT="", campo="",nivel="", imagen="Aa";
	public static int identificador=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantalla_lecciones frame = new pantalla_lecciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}f


	public pantalla_lecciones() throws SQLException {
		setAlwaysOnTop(true);
		metodos metodos = new metodos ();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 531);
		setLocationRelativeTo(null);
		setTitle("En-Señas MX: Curso de enseñanza de Lengua de Señas Mexicana");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/imagenes/logo.png");
	    setIconImage(miIcono);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 152, 179));
		panel.setBounds(0, 0, 951, 499);
		contentPane.add(panel);
		panel.setLayout(null);
	    
	    lblNombreNivel = new JLabel("ABECEDARIO");
	    lblNombreNivel.setForeground(Color.ORANGE);
	    lblNombreNivel.setFont(new Font("Segoe UI Black", Font.PLAIN, 49));
	    lblNombreNivel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNombreNivel.setBounds(0, 56, 969, 83);
	    panel.add(lblNombreNivel);
		
	    lblNivel = new JLabel();
	    lblNivel.setText("Nivel");
	    lblNivel.setVerticalAlignment(SwingConstants.TOP);
	    lblNivel.setForeground(Color.WHITE);
		lblNivel.setFont(new Font("Segoe UI Black", Font.PLAIN, 58));
		lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivel.setBounds(0, 11, 959, 70);
		panel.add(lblNivel);
		
		JLabel lblComencemos = new JLabel("Da click en el botón 'siguiente'\r\n");
		lblComencemos.setHorizontalAlignment(SwingConstants.CENTER);
		lblComencemos.setFont(new Font("Segoe UI Black", Font.PLAIN, 33));
		lblComencemos.setBounds(40, 210, 500, 95);
		lblComencemos.setForeground(new Color(220, 20, 60));
		panel.add(lblComencemos);
		
		JLabel lblParaComenzar_1 = new JLabel("Para Comenzar");
		lblParaComenzar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblParaComenzar_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 33));
		lblParaComenzar_1.setBounds(40, 287, 500, 39);
		lblParaComenzar_1.setForeground(new Color(220, 20, 60));
		panel.add(lblParaComenzar_1);
		
		JLabel lblObjeto = new JLabel("");
		lblObjeto.setHorizontalAlignment(SwingConstants.CENTER);
		lblObjeto.setFont(new Font("Tekton Pro", Font.PLAIN, 60));
		lblObjeto.setBounds(40, 186, 500, 108);
		panel.add(lblObjeto); 
		
		JLabel letras = new JLabel("");
		letras.setHorizontalAlignment(SwingConstants.CENTER);
		letras.setFont(new Font("Lato Black", Font.PLAIN, 99));
		letras.setBounds(40, 236, 500, 200);
		panel.add(letras);
		
		JButton imagenboton = new JButton("");
		//imagenboton.setIcon(new ImageIcon(pantalla_lecciones.class.getResource("/Imagenes/a.png")));
		imagenboton.setForeground(Color.WHITE);
		imagenboton.setBackground(Color.WHITE);
		//button.setIcon(new ImageIcon("D:\\Proyectos Java\\LSM\\bin\\letras\\Aa.jpg"));
		//imagen="D:/proyectos Java/LSM/src/images.jpg/";
		imagenboton.setBounds(661, 154, 225, 282);
		panel.add(imagenboton);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnSiguiente.setBounds(515, 463, 97, 25);
		btnSiguiente.setBackground(new Color(179, 81, 0));
		btnSiguiente.setForeground(Color.WHITE);
		panel.add(btnSiguiente);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnAnterior.setEnabled(false);
		btnAnterior.setBounds(408, 463, 97, 25);
		btnAnterior.setBackground(new Color(179, 81, 0));
		btnAnterior.setForeground(Color.WHITE);
		panel.add(btnAnterior);
		
		JButton btnSalir = new JButton("Salir del nivel");
		btnSalir.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnSalir.setBounds(10, 463, 141, 25);
		btnSalir.setBackground(new Color(179, 81, 0));
		btnSalir.setForeground(Color.WHITE);
		panel.add(btnSalir);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnFinalizar.setBounds(844, 463, 97, 25);
		btnFinalizar.setEnabled(false);
		btnFinalizar.setBackground(new Color(179, 81, 0));
		btnFinalizar.setForeground(Color.WHITE);
		panel.add(btnFinalizar);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(pantalla_lecciones.class.getResource("/Imagenes/IconoLecciones.png")));
		lblLogo.setBounds(10, 11, 99, 150);
		panel.add(lblLogo);
		
		//Nos va mostrando los registros de la base de datos.
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			try {
				//System.out.println("El registro final es el "+identificador);
				//System.out.println("La comparación es "+metodos.validar()+" de "+identificador);
				lblComencemos.setText("");//Borra la label comencemos
				lblParaComenzar_1.setText("");//Borra la label para comenzar
				panel.add(lblObjeto);//Se añade la lbl Objeto
				metodos.obtener(tabla,1);//Llamamos al método obtener
				if(letrasT.length()>6) {
					letras.setFont(new Font("Lato Black", Font.PLAIN, 50));
				}
				else if (letrasT.length()<=6) {
					letras.setFont(new Font("Lato Black", Font.PLAIN, 90));
				}
				letras.setText(letrasT);
				lblObjeto.setText(campo);
				imagenboton.setIcon(new ImageIcon("src/Imagenes/lecciones/"+imagen+".jpg"));

				//String arreglo[]=new String [2];
				//arreglo=metodos.siguiente();
				//letras.setText(arreglo[0]);
				ConexionPython.getCorrect(letrasT);
				if (metodos.validar() >= 2) {
					btnAnterior.setEnabled(true);
					if (metodos.validar()==identificador) {
						btnSiguiente.setEnabled(false);
						btnFinalizar.setEnabled(true);
					}
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		});
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			try {
				//metodos.anterior(tabla);
				//String arreglo[]=new String [2];
				//arreglo=metodos.anterior();
				//letras.setText(arreglo[0]);//Arreglo en la posición Cero es para obtener letra
				metodos.obtener(tabla,-1);
				
				//Los dos siguientes Ifs cambian el tamaño de las letras dependiendo la cantidad de caracteres
				if(letrasT.length()>6) {
					letras.setFont(new Font("Lato Black", Font.PLAIN, 50));
				}
				else if (letrasT.length()<=6) {
					letras.setFont(new Font("Lato Black", Font.PLAIN, 90));
				}
				//
				
				letras.setText(letrasT);
				imagenboton.setIcon(new ImageIcon("src/Imagenes/lecciones/"+imagen+".jpg"));
				
				if (metodos.validar() == 1) {
					//Este If ayuda a NO activar el botón "anterior" cuando la letra es A (posición 1 en la base de datos)
					btnAnterior.setEnabled(false);
				}
				else if (metodos.validar()<identificador) {
					//System.out.println("YA NO ES EL FINAL DEL REGISTRO");
					btnFinalizar.setEnabled(false);
					btnSiguiente.setEnabled(true);
				}
				//else if (metodos.validarFin(tabla)==metodos.validar()) {//}
			
			} 
			catch (SQLException e) {
				// En caso de haber un error, lo toma e imprime
				e.printStackTrace();
			}
		}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pantalla_menu pantalla = new pantalla_menu ();
					setVisible(false);
					pantalla.setVisible(true);
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//metodos.cambios();
					practica practica = new practica ();
					setVisible(false);
					practica.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
