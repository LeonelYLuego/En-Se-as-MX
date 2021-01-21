import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class practica extends JFrame {

	private JPanel contentPane;
	public static String total, pregunta, r1,r2,r3,rc;
    int contador=-1;
	pantalla_lecciones pantalla = new pantalla_lecciones();
	boolean respuesta = true;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					practica frame = new practica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public practica() throws SQLException {
		metodos metodos = new metodos ();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 531);
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
		panel.setBounds(0, 0, 951, 499);
		panel.setBackground(new Color(0,152,179));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblQuestionario = new JLabel("Questionario");
		lblQuestionario.setForeground(Color.ORANGE);
		lblQuestionario.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestionario.setFont(new Font("Segoe UI Black", Font.PLAIN, 52));
		lblQuestionario.setBounds(308, 11, 352, 59);
		panel.add(lblQuestionario);
		
		JLabel lblPregunta = new JLabel("¿Listo para comenzar? Da click en el botón Siguiente");
		lblPregunta.setForeground(new Color(255, 255, 255));
		lblPregunta.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblPregunta.setBounds(10, 139, 785, 18);
		panel.add(lblPregunta);
		
		JLabel lblTexto = new JLabel("");
		lblTexto.setForeground(new Color(255, 255, 255));
		lblTexto.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblTexto.setBounds(10, 168, 931, 18);
		panel.add(lblTexto);
		
		JButton btnImagen = new JButton("Imagen");
		btnImagen.setBackground(new Color(255, 255, 255));
		btnImagen.setBounds(26, 237, 280, 182);
		//panel.add(btnImagen);
		
		JButton btnImagen2 = new JButton("Imagen");
		btnImagen2.setBackground(new Color(255, 255, 255));
		btnImagen2.setBounds(318, 237, 308, 182);
		//panel.add(btnImagen2);
		
		JButton btnImagen3 = new JButton("Imagen");
		btnImagen3.setBackground(new Color(255, 255, 255));
		btnImagen3.setBounds(638, 237, 280, 182);
		//panel.add(btnImagen3);
		
		JButton btnSiguiente = new JButton("Siguiente");
		
		btnSiguiente.setBounds(737, 463, 97, 25);
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setBackground(new Color(179, 81, 0));
		panel.add(btnSiguiente);
		
		JButton btnFinalizar = new JButton("Finalizar");
		
		btnFinalizar.setBounds(844, 463, 97, 25);
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setBackground(new Color(179, 81, 0));
		btnFinalizar.setEnabled(false);
		panel.add(btnFinalizar);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(practica.class.getResource("/Imagenes/IconoLecciones.png")));
		lblLogo.setBounds(828, 11, 99, 150);
		panel.add(lblLogo);
		
		JLabel Aviso = new JLabel("");
		Aviso.setForeground(new Color(255, 255, 255));
		Aviso.setBounds(320, 454, 317, 16);
		panel.add(Aviso);
		

	    String matriz [][]=metodos.practicas(pantalla.tabla);//Esta matriz guarda lo que retorna el método prácticas.
	    int totales = Integer.parseInt(total);//Esta variable nos dice cuántas preguntas existen en la base de datos para el curso en el que se está
	
	    btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (contador==(totales-1)) {//Verifica que después de mostrar la última pregunta, no se active el botón de siguiente y se active el finalizar.
					btnSiguiente.setEnabled(false);
					btnFinalizar.setEnabled(true);
					Aviso.setText("¡Listo! Terminaste. Ahora a practicar.");
				}
				
				/*Como llegó a esta parte del código, significa que aún no se muestran todas las preguntas que hay en la base de datos para este curso
				 por lo que agrega al panel nuevamente los botones y avala si la respuesta es TRUE o FALSE. La respuesta siempre será FALSE mientras que
				 el usuario no toque el botón correcto. 
				 */
				else {
				panel.add(btnImagen);
				panel.add(btnImagen2);
				panel.add(btnImagen3);
				/*Al momento de que el usuario toque el botón correcto y dé click en siguiente, el contador aumenta porque ya se mostró esa pregunta y ahora
				 * hay que mostrar la que sigue según la matriz. 
				 */
					if (respuesta) {
					contador++;
					Aviso.setText("");
					lblPregunta.setText("Pregunta "+(contador+1));
					lblTexto.setText(matriz[(contador)][0]);
					btnImagen.setIcon(new ImageIcon("D:/Proyectos Java/LSM/bin/letras/"+matriz[(contador)][1]+".jpg"));
					btnImagen2.setIcon(new ImageIcon("D:/Proyectos Java/LSM/bin/letras/"+matriz[(contador)][2]+".jpg"));
					btnImagen3.setIcon(new ImageIcon("D:/Proyectos Java/LSM/bin/letras/"+matriz[(contador)][3]+".jpg"));
					respuesta=false; //Volvemos a poner la respuesta en FALSE para que no pase a la siguiente pregunta sin haber contestado correctamente
					}
					else {
					System.out.println("La respuesta es incorrecta");
					}
				}
			
			}
		});

	    /*El botón finalizar aplica el método cambios para subir de nivel al usuario y nos regresa al menú.
	     * SÓLO DEBERÁ MANDAR A LA SIGUIENTE ACTIVIDAD, ANTES DE SUBIR DE NIEL.
	     */
	    btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//metodos.cambios();
					setVisible(false);
					practica_guante practica = new practica_guante();
					practica.setVisible(true);
			}
		});
	    
	    /*
	     * Cada botón a partir de aquí le asigna un valor TRUE o FALSE a la variable respuesta dependiendo de si la respuesta equivale al número
	     * de botón.
	     */
	    btnImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(matriz[(contador)][4].equals("1")) {
					//System.out.println("La respuesta es correcta");
					Aviso.setText("¡Correcto! Da click en siguiente para continuar");
					respuesta=true;
				}
				else{
					respuesta=false;
					Aviso.setText("¡Incorrecto! Piensa bien tu respuesta");
				}
			}
			
		});
	    
	    btnImagen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(matriz[(contador)][4].equals("2")) {
					Aviso.setText("¡Correcto! Da click en siguiente para continuar");
					respuesta=true;
				}
				else{
					respuesta=false;
					Aviso.setText("¡Incorrecto! Piensa bien tu respuesta");
				}
			}
			
		});
	    
	    btnImagen3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(matriz[(contador)][4].equals("3")) {
					Aviso.setText("¡Correcto! Da click en siguiente para continuar");
					respuesta=true;
				}
				else{
					respuesta=false;
					Aviso.setText("¡Incorrecto! Piensa bien tu respuesta");
				}
			}
			
		});
	    
	    
	    
	}
}
