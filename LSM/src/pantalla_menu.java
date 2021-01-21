import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import java.sql.SQLException;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.SwingConstants;

public class pantalla_menu extends JFrame {


	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantalla_menu frame = new pantalla_menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public pantalla_menu() throws SQLException {
		setResizable(false);
		pantalla_lecciones pantalla = new pantalla_lecciones ();
		ConexionPython python = new ConexionPython();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 514);
		setLocationRelativeTo(null);
		setTitle("En-Señas MX: Curso de enseñanza de Lengua de Señas Mexicana");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/imagenes/logo.png");
	    setIconImage(miIcono);
		
		metodos metodos = new metodos ();
		Bienvenida bienvenida = new Bienvenida ();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 898, 499);
		panel.setBackground(new Color(0,152,179));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMenu = new JLabel("");
		lblMenu.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Imagenes/Cursos.png")));
		lblMenu.setBounds(570, 38, 150, 67);
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblMenu);
		
		JLabel Activo = new JLabel("Cuenta activa: "+metodos.activo);//Nos dice qué usuario está actualmente activo.
		Activo.setHorizontalAlignment(SwingConstants.CENTER);
		Activo.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		Activo.setBounds(552, 442, 187, 16);
		panel.add(Activo);
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Imagenes/Fondo principal.png")));
		lblFondo.setBounds(0, 26, 399, 462);
		panel.add(lblFondo);
		
		JLabel lblAbecedario = new JLabel("");
		lblAbecedario.setEnabled(false);
		lblAbecedario.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lblAbecedario.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bAbecedarioP.png")));
			}
			public void mouseExited(MouseEvent e) {
				lblAbecedario.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bAbecedario.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblAbecedario.isEnabled()) {
					try {
						python.open();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					pantalla.setVisible(true);
					pantalla.tabla="Abecedario";//Trae el nombre del curso que se escogió, para después sacar información de la base de datos.
					try {
						pantalla.identificador=metodos.validarFin("abecedario");//Nos da como resultado el total de registros que se tienen en esa tabla.
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					pantalla.lblNombreNivel.setText("Abecedario");//Manda el nombre de la tabla
					pantalla.lblNivel.setText("Nivel introducción");;//Manda el nivel en el que está el usuario
					setVisible (false);
				}
			}
		});
		lblAbecedario.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bAbecedario.png")));
		lblAbecedario.setBounds(430, 129, 210, 65);
		panel.add(lblAbecedario);
		
		JLabel lblAnimales = new JLabel("");
		lblAnimales.setEnabled(false);
		lblAnimales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAnimales.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bAnimalesP.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAnimales.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bAnimales.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblAnimales.isEnabled()) {
					pantalla.setVisible(true);
					pantalla.tabla="Animales";
					try {
						pantalla.identificador=metodos.validarFin("animales");
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					pantalla.lblNombreNivel.setText("Animales");
					pantalla.lblNivel.setText("Nivel 2");;
					setVisible (false);
				}
			}
		});
		lblAnimales.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bAnimales.png")));
		lblAnimales.setBounds(430, 231, 210, 65);
		panel.add(lblAnimales);
		
		JLabel lblFrasesComunes = new JLabel("");
		lblFrasesComunes.setEnabled(false);
		lblFrasesComunes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFrasesComunes.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bFrasesComunesP.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFrasesComunes.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bFrasesComunes.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblFrasesComunes.isEnabled()) {
					pantalla.setVisible(true);
					pantalla.tabla="Frases";
					try {
						pantalla.identificador=metodos.validarFin("frases");
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					pantalla.lblNombreNivel.setText("Frases Comúnes");
					pantalla.lblNivel.setText("Nivel 3");;
					setVisible (false);
				}
			}
		});
		lblFrasesComunes.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bFrasesComunes.png")));
		lblFrasesComunes.setBounds(650, 231, 210, 65);
		panel.add(lblFrasesComunes);
		
		JLabel lblColores = new JLabel("");
		lblColores.setEnabled(false);
		lblColores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblColores.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bColoresP.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblColores.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bColores.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblColores.isEnabled()) {
					pantalla.setVisible(true);
					pantalla.tabla="Colores";
					try {
						pantalla.identificador=metodos.validarFin("colores");
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					pantalla.lblNombreNivel.setText("Colores");
					pantalla.lblNivel.setText("Nivel 5");;
					setVisible (false);
				}
			}
		});
		lblColores.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bColores.png")));
		lblColores.setBounds(430, 331, 210, 65);
		panel.add(lblColores);
		
		JLabel lblSaludos = new JLabel("");
		lblSaludos.setEnabled(false);
		lblSaludos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSaludos.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bSaludosP.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSaludos.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bSaludos.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblSaludos.isEnabled()) {
					pantalla.setVisible(true);
					pantalla.tabla="Saludos";
					try {
						pantalla.identificador=metodos.validarFin("saludos");
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					pantalla.lblNombreNivel.setText("Saludos");
					pantalla.lblNivel.setText("Nivel 1");;
					setVisible (false);
				}
			}
		});
		lblSaludos.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bSaludos.png")));
		lblSaludos.setBounds(650, 129, 210, 65);
		panel.add(lblSaludos);
		
		JLabel lblLugares = new JLabel("");
		lblLugares.setEnabled(false);
		lblLugares.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLugares.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bLugaresP.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLugares.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bLugares.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblLugares.isEnabled()) {
					pantalla.setVisible(true);
					pantalla.tabla="Lugares";
					try {
						pantalla.identificador=metodos.validarFin("lugares");
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					pantalla.lblNombreNivel.setText("Lugar");
					pantalla.lblNivel.setText("Nivel 4");;
					setVisible (false);
				}
			}
		});
		lblLugares.setIcon(new ImageIcon(pantalla_menu.class.getResource("/Botones/bLugares.png")));
		lblLugares.setBounds(650, 331, 210, 65);
		panel.add(lblLugares);
		
		String nivel = metodos.verificar_nivel(bienvenida.correo); //Verificamos el nivel del usuario y se encienden los botones según el mismo.
	
		switch (nivel) {
		case "0":
			lblAbecedario.setEnabled(true);
			//System.out.println("Estás en el nivel 0");
		break;
		case "1": 
			lblAbecedario.setEnabled(true);
			lblSaludos.setEnabled(true);
			//System.out.println("Estás en el nivel 1");
		break;
		case "2": 
			lblAbecedario.setEnabled(true);
			lblSaludos.setEnabled(true);
			lblAnimales.setEnabled(true);
			
			//System.out.println("Estás en el nivel 2");
		break;
		case "3": 
			lblAbecedario.setEnabled(true);
			lblSaludos.setEnabled(true);
			lblAnimales.setEnabled(true);
			lblFrasesComunes.setEnabled(true);
			//System.out.println("Estás en el nivel 3");
		break;
		case "4": 
			lblAbecedario.setEnabled(true);
			lblSaludos.setEnabled(true);
			lblAnimales.setEnabled(true);
			lblFrasesComunes.setEnabled(true);
			lblLugares.setEnabled(true);
			//System.out.println("Estás en el nivel 4");
		break;
		case "5": 
			lblAbecedario.setEnabled(true);
			lblSaludos.setEnabled(true);
			lblAnimales.setEnabled(true);
			lblFrasesComunes.setEnabled(true);
			lblLugares.setEnabled(true);
			lblColores.setEnabled(true);
			//System.out.println("Estás en el nivel 5");
		break;
	
		}
		
		
	}
}
