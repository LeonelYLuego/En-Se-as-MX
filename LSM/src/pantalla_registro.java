import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;

public class pantalla_registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellido, txtCorreo, txtNombre;
	private JPasswordField txtContraseña,txtVerificar;
	public static String correo;
	public static JLabel lblinvalido;
	private final JTextPane textPane = new JTextPane();
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantalla_registro frame = new pantalla_registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public pantalla_registro() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 513);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("En-Se\u00F1as MX");

		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/imagenes/logo.png");
	    setIconImage(miIcono);
		
		Bienvenida bienvenida = new Bienvenida ();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 419, 481);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCreaUnaNueva = new JLabel("Crea una nueva cuenta");
		lblCreaUnaNueva.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreaUnaNueva.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblCreaUnaNueva.setBounds(106, 11, 206, 22);
		panel.add(lblCreaUnaNueva);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblNombre.setBounds(69, 57, 56, 16);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblApellido.setBounds(69, 90, 56, 16);
		panel.add(lblApellido);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreo.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblCorreo.setBounds(69, 133, 56, 16);
		panel.add(lblCorreo);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseña.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblContraseña.setBounds(49, 176, 76, 16);
		panel.add(lblContraseña);
		
		JLabel lblVerificarContraseña = new JLabel("Verificar contraseña");
		lblVerificarContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVerificarContraseña.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblVerificarContraseña.setBounds(10, 212, 115, 16);
		panel.add(lblVerificarContraseña);
		
		JLabel lblVerificar = new JLabel("");
		lblVerificar.setForeground(Color.RED);
		lblVerificar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblVerificar.setBounds(248, 231, 152, 16);
		panel.add(lblVerificar);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtNombre.setBounds(135, 54, 265, 22);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtApellido.setBounds(135, 87, 265, 22);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				metodos metodos = new metodos ();
				try {
					metodos.verificar_correo(txtCorreo.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtCorreo.setBounds(135, 130, 265, 22);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtContraseña.setBounds(135, 173, 265, 22);
		panel.add(txtContraseña);
		txtContraseña.setColumns(10);
		
		txtVerificar = new JPasswordField();
		txtVerificar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtContraseña.getText().equals(txtVerificar.getText()))
					lblVerificar.setText("");
				else
					lblVerificar.setText("Las contraseñas no conciden");
			}
		});
		txtVerificar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtVerificar.setBounds(135, 209, 265, 22);
		panel.add(txtVerificar);
		txtVerificar.setColumns(10);
		
		lblinvalido = new JLabel("");
		lblinvalido.setForeground(Color.RED);
		lblinvalido.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblinvalido.setBounds(229, 152, 171, 16);
		panel.add(lblinvalido);
		
		JButton btnRegistrate = new JButton("Regístrate");
		btnRegistrate.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnRegistrate.setForeground(Color.WHITE);
		btnRegistrate.setBackground(new Color(0,152,179));
		
		btnRegistrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				metodos metodos = new metodos ();
				try {
					/*String nombre, correo, contraseña, apellido, verificar;
					nombre=txtNombre.getText();
					apellido=txtApellido.getText();
					correo=txtCorreo.getText();
					contraseña=txtContraseña.getText();
					verificar=txtVerificar.getText();
					System.out.println("La contraseña es "+txtContraseña.getText()+" y la verificación es "+txtVerificar.getText());*/
					
					/*Este IF nos dice que si La contraseña que ingresa el usuario es la misma que la que verifica
					 * y que si el correo está disponible, entonces se registra
					 */
					
					if (txtContraseña.getText().equals(txtVerificar.getText()) && metodos.verificar_correo(txtCorreo.getText())) {
						metodos.registrar_usuario(txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), txtContraseña.getText());
						bienvenida.correo=txtCorreo.getText();
						metodos.activo=bienvenida.correo;
						JOptionPane.showMessageDialog(null, "Registro correcto","¡Perfecto!", JOptionPane.WARNING_MESSAGE);
						pantalla_menu siguiente = new pantalla_menu();
						setVisible (false);
						siguiente.setVisible(true);
					}
					
					else{
					JOptionPane.showMessageDialog(null, "Verifica la información", "¡Ups! Ha habido un error", JOptionPane.WARNING_MESSAGE);
					}
					
					/*else if (contraseña.equals(verificar)) {
						JOptionPane.showMessageDialog(null, null, "LAS CONTRASEÑAS NO COINCIDEN", JOptionPane.WARNING_MESSAGE);
						txtVerificar.setText("");
					}*/
					/*else if (metodos.verificar_correo(txtCorreo.getText())) {
						
						JOptionPane.showMessageDialog(null, null, "EL CORREO YA ESTÁ REGISTRADO", JOptionPane.WARNING_MESSAGE);
						txtCorreo.setText("");
					}*/
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
				
			}
		});
		btnRegistrate.setBounds(303, 442, 97, 25);
		panel.add(btnRegistrate);
		textPane.setEditable(false);
		textPane.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textPane.setBounds(10, 252, 259, 22);
		panel.add(textPane);
		textPane.setText("\u00BFConoces a alguna persona que maneje la LSM?");
		textPane.setBackground(Color.WHITE);
		
		JRadioButton radioButton = new JRadioButton("S\u00ED");
		radioButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		radioButton.setBackground(Color.WHITE);
		radioButton.setBounds(10, 281, 59, 25);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("No");
		radioButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(69, 281, 81, 25);
		panel.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("Mucho");
		radioButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		radioButton_2.setBackground(Color.WHITE);
		radioButton_2.setBounds(10, 350, 70, 25);
		panel.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("Poco");
		radioButton_3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		radioButton_3.setBackground(Color.WHITE);
		radioButton_3.setBounds(87, 350, 70, 25);
		panel.add(radioButton_3);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textPane_1.setText("\u00BFQu\u00E9 tan importante crees que sea que en nuestra sociedad se aprenda la LSM?");
		textPane_1.setBackground(Color.WHITE);
		textPane_1.setBounds(10, 309, 373, 34);
		panel.add(textPane_1);
		
		JLabel label = new JLabel("\u00BFPor qu\u00E9?");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		label.setBounds(10, 382, 70, 16);
		panel.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textField.setColumns(10);
		textField.setBounds(10, 409, 390, 22);
		panel.add(textField);
		
	
		
	}
}
