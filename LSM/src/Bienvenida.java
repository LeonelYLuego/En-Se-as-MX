import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Bienvenida extends JFrame {

	private JPanel contentPane;
	private JTextField txtCorreo;
	private JPasswordField contraseña;
	public static String correo;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Bienvenida() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setForeground(new Color(0, 0, 0));
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("En-Se\u00F1as MX");
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 535);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/imagenes/logo.png");
	    setIconImage(miIcono);
	    
		metodos metodos = new metodos ();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 155, 0));
		panel.setBounds(0, 0, 453, 508);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHola = new JLabel("¡Hola! Es un placer verte por aquí.");
		lblHola.setForeground(Color.WHITE);
		lblHola.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblHola.setHorizontalAlignment(SwingConstants.CENTER);
		lblHola.setBounds(12, 11, 428, 33);
		panel.add(lblHola);
		
		JLabel lblIniciaSesinO = new JLabel("Inicia sesión o regístrate para comenzar\r\n");
		lblIniciaSesinO.setForeground(Color.WHITE);
		lblIniciaSesinO.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblIniciaSesinO.setBounds(93, 309, 276, 27);
		panel.add(lblIniciaSesinO);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo Electrónico");
		lblCorreoElectrnico.setForeground(Color.WHITE);
		lblCorreoElectrnico.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblCorreoElectrnico.setBounds(14, 332, 153, 16);
		panel.add(lblCorreoElectrnico);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblContraseña.setBounds(14, 386, 85, 16);
		panel.add(lblContraseña);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(50, 359, 354, 22);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		contraseña = new JPasswordField();
		contraseña.setBounds(50, 413, 354, 22);
		panel.add(contraseña);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setBounds(322, 473, 123, 25);
		btnIniciarSesion.setBackground(new Color(0,152,179));
		panel.add(btnIniciarSesion);
		
		JLabel lblCrear = new JLabel("Crea una cuenta");
		lblCrear.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblCrear.setForeground(Color.WHITE);
		lblCrear.setBounds(14, 446, 123, 16);
		panel.add(lblCrear);
		
		JButton btnRegistrate = new JButton("Regístrate");
		btnRegistrate.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnRegistrate.setForeground(Color.WHITE);
		btnRegistrate.setBounds(12, 473, 97, 25);
		btnRegistrate.setBackground(new Color(0,152,179));
		panel.add(btnRegistrate);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setBounds(93, 44, 233, 254);
		lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png")));
		panel.add(lblIcono);
		
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nueva = new String(contraseña.getPassword());
				
				try {
					
					if(metodos.iniciar_sesion(txtCorreo.getText(), nueva)) {
						correo=txtCorreo.getText();
						pantalla_menu siguiente = new pantalla_menu();
						siguiente.setVisible(true);
						//dispose();
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Verifica la información", "¡Ups! Ha habido un error", JOptionPane.WARNING_MESSAGE);
					}
				}
				
				catch (SQLException e) {
					e.printStackTrace();
				}
				
			}

		});
		
		btnRegistrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pantalla_registro registro = new pantalla_registro ();
				setVisible (false);
				registro.setVisible(true);
			}
		});
		
		btnIniciarSesion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
	}
}
