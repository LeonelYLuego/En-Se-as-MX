import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.net.*;
import java.io.*;
import java.math.*;

public class metodos{

	private Connection conectar = null;
	public static String activo; //Esta variable guarda el usuario que est� activo
	int id;
	public static int no_curso;
	String letras="", imagen="", sql="",correo,i;

	//Conexi�n a la base de datos
    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/lsm", "root", "");
            //JOptionPane.showMessageDialog(null, "Conexion Establecida","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            //System.out.println ("Conectado correctamente");
        } 
        catch (ClassNotFoundException | SQLException error) {
            JOptionPane.showMessageDialog(null, "Error al Conectarse"+"\n"+error,"Mensaje Error",JOptionPane.ERROR_MESSAGE);
        }
        return conectar;
    }
	
	//Los m�todos getCorreo y setCorreo sirven para recuperar la informaci�n del correo y validar
	
    public String getCorreo() {
 		return correo;
 	}

 	public void setCorreo(String correo) {
 		this.correo = correo;
 	}
 	
    //El m�todo validar lo �nico que hace es regresar el valor del ID para saber s� activar o no el bot�n "anterior"
    public int validar () {
    	id=id;
    	return id;
    }
   

	//Este m�todo obtiene el n�mero total de registros en la tabla indicada con el fin de activar o el bot�n finalizar y el bot�n siguiente
    public int validarFin (String tabla) throws SQLException {
    	Connection registros = this.conexion();
        String sql = ("SELECT COUNT(*) FROM "+tabla);
       
        try { 
        	Statement st = (Statement) registros.createStatement();
        	ResultSet rs = st.executeQuery(sql);

        	while (rs.next()) {
        		i = rs.getString("Count(*)");
        	}
        }
        catch (SQLException e) {
			System.out.println("Hubo un error "+e);
		}
        registros.close();
        id=Integer.parseInt (i);
        //System.out.println("Cont� un total de "+id+" registros");
        return id;
    }
 
	
    //M�todo para registrar un usuario un la base de datos
    public void registrar_usuario (String Nombre, String Apellido, String Correo, String Contrase�a) throws SQLException {
    
    		Connection con = this.conexion();
        	String query="INSERT INTO usuarios (Nombre, Apellido, Correo, Contrase�a, Nivel) VALUES ('"+Nombre+"', '"+Apellido+"', '"+Correo+"', '"+Contrase�a+"', 0);";
	        try {
				Statement st=(Statement) con.createStatement();
				st.executeUpdate (query);
				con.close();
				st.close();
			}
			
			catch (SQLException e) {
				System.out.println("Hubo un error "+e);
			}
    	
	}

    //El m�todo verificar correo regresa un TRUE si el correo est� libre para el registro y regresa un FALSE si no est� libre
    public boolean verificar_correo (String correo) throws SQLException {
    	boolean c=false;
    	if(correo.equals("")) {
    		System.out.println("No est� llegando nada");
    	}
    	else {
	     	String letra="";
	        Connection registros = this.conexion();
	        String sql = ("SELECT Correo FROM usuarios WHERE Correo = '"+correo+"'");
	        Statement st = (Statement) registros.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	
	        while (rs.next()) {
	        letra = rs.getString("correo");
	       }
	        
	        if (letra.equals("")) {
	        	System.out.println("El correo est� libre");
	            c=true;
	            pantalla_registro.lblinvalido.setText("");
	        }
	        else {
	        	//System.out.println("El correo est� ocupado");
	        	c=false;
	        	pantalla_registro.lblinvalido.setText("El correo ya est� siendo utilizado");
	        }
	        
	        registros.close();
	    }
        return c;
    	
    }
 
    //Este m�todo verifica el nivel en el que se encuentra el usuario para saber qu� cursos habilitar
    public String verificar_nivel (String correo) throws SQLException {
    	//int ID=this.id_usuario(correo);
    	String nivel="";
        Connection registros = this.conexion();
        String sql = ("SELECT nivel FROM usuarios WHERE Correo = '"+correo+"';");
        Statement st = (Statement) registros.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
        nivel = rs.getString("nivel");
       }
        registros.close();
        //System.out.println("El nivel es "+letra);
    	return nivel;
    	
    }
    
    //Este m�todo permite o no iniciar sesi�n dependiendo de que el correo y la contrase�a sean correctos
    public boolean iniciar_sesion (String correo, String contrase�a) throws SQLException {
    	boolean x=false;
    	//El siguiente IF impide que se inicie sesi�n sin ingresar informaci�n
    	if (correo.equals("")) {
    		//System.out.println("INGRESA UN CORREO");
    	}
    	else {
	    	String correo1="", contra="";
	        Connection registros = this.conexion();
	        String sql = ("SELECT correo FROM usuarios WHERE correo = '"+correo+"';");
	        Statement st = (Statement) registros.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	       
	        while (rs.next()) {
	        correo1 = rs.getString("correo");
	       }
	    
	        sql = ("SELECT contrase�a FROM usuarios WHERE correo = '"+correo+"';");    
	        rs = st.executeQuery(sql);
	        
	        while (rs.next()) {
	            contra = rs.getString("contrase�a");
	          }
	        registros.close();
	    
	        if (contra.equals(contrase�a)&&correo1.equals(correo)) {
	        	//Inicio de sesi�n correcto
	        	x=true;
	        	this.activo=correo; //Se asigna el correo al usuario activo 
	        }
	        else {
	        	//Inicio de sesi�n incorrecto
	        	x=false;
	        }
    	}
    	return x;
    }
    
    //El m�todo cambios es el que hace funcionar las ALTAS en la base de datos
    public void cambios() throws SQLException {
    	String cuenta=this.activo;//Nos dice a qu� cuenta le vamos a asignar el cambio
    	String nivel = this.verificar_nivel(cuenta);//Rectifica el nivel del usuario
    	int cambio = Integer.parseInt(nivel);
    	Connection con = this.conexion();
    	if (cambio<=4) {//Si el nivel del usuario es menor o igual a 4, se le sumar� un 1, de lo contrario no se har� nada, puesto que s�lo hay 5 niveles posibles.
        	  cambio=cambio+1;
    		  String query = "UPDATE usuarios SET nivel="+cambio+" WHERE correo = '"+cuenta+"'";
    	        try {
    	        	Statement st=(Statement) con.createStatement();
    				st.executeUpdate (query);
    				con.close();
    				st.close();
    	        }
    	        catch (SQLException e) {
    				System.out.println("Hubo un error "+e);
    			}
    	}
      
    }
    
   /* El m�todo obtener es el responsable de que la pantalla de las lecciones funcione de forma din�mica, sin importar en qu� nivel
    est� el usuario
    */
   public void obtener (String tabla, int control) throws SQLException {
	   pantalla_lecciones pantalla = new pantalla_lecciones();
	   Connection registros = this.conexion();
	   String nivel ="", imagen="";


	  /*Este Switch lo que hace es ver qu� accci�n tomar dependiendo de si llega un click del bot�n siguiente o un click
	   del bot�n anterior*/
	   switch (control) {
	   		case -1: 
	   			id=id-1;
	   		break;
	   		case 1:
	   			id=id+1;
	   		break;
	   }
	   
	   /*Este Switch lo que hace es cambiar en la pantalla la leyenda que est� arriba de la lecci�n dependiendo de en qu�
	   curso est� */
	   switch (tabla) { 
	   	   case "Abecedario": 
	   		   pantalla.campo="Letra";
	   		   no_curso=1;
		   break;
	   	   case "Saludos":
	   		   pantalla.campo="Saludo";
	   		   no_curso=2;
	   	   break;
	   	   case "Animales":
	   	   		pantalla.campo="Animal";
		   		   no_curso=3;
	   	   break;
	   	   case "Frases":
	   	   		pantalla.campo="Frase com�n";
		   		   no_curso=4;
	   	   break;
	   	   case "Lugares":
	   	   		pantalla.campo="Lugar";
		   		   no_curso=5;
	   	   break;
	   	   case "Colores":
   	   		pantalla.campo="Color";
	   		   no_curso=6;
   	   	   break;
	   }
	   
	   sql = "SELECT * FROM "+tabla+" WHERE ID = "+id;
	   //sql = "SELECT * FROM contenidos WHERE NO_CURSO = "+no_curso+" AND id_contenido = "+id;
       Statement st = (Statement) registros.createStatement();
       ResultSet rs = st.executeQuery(sql);

       while (rs.next()) {
    	    nivel = rs.getString("ejemplo");
    	    imagen = rs.getString("imagen");
      }
       pantalla.letrasT=nivel; //Esta l�nea manda el valor de la consulta al otro frame, para que se actualice
       pantalla.imagen=imagen;//Esta l�nea manda la direcci�n de la imagen obtenida desde la base de datos, al otro frame
       //System.out.println("Lo que tiene la imagen deber�a de sre "+pantalla.imagen);
   }
   
   //Este m�todo recupera la informaci�n de la base de datos para mostrar en pantalla las preguntas y posibles respuestas en cada 
   public String [][] practicas (String tabla) throws SQLException {
       int x,y,curso=0,contador;
       /*El siguiente Switch le asigna un valor a curso seg�n la tabla que haya recibido el m�todo. Esto es porque en la base de datos, los cursos est�n
        asignados a un n�mero del 1 al n empezando por el de abecedario */
      
       switch (tabla) { 
   	   case "Abecedario": 
   		   curso=1;
	   break;
   	   case "Saludos":
   		   curso=2;
   	   break;
   	   case "Animales":
   		   curso=3;
   	   break;
   	   case "Frases":
   		   curso=4;
   	   break;
   	   case "Lugares":
   		   curso=5;
   	   break;
   	   case "Colores":
   		   curso=6;
	   break;
       }
       
	   Connection registros = this.conexion();
	   sql = "SELECT COUNT(*) FROM preguntas WHERE curso="+curso+";";
       Statement st = (Statement) registros.createStatement();
       ResultSet rs = st.executeQuery(sql);
       
       while (rs.next()) {
   		practica.total = rs.getString("Count(*)"); //Recupera el total de preguntas que hay para ese curso y lo vuelve din�mico
   	   }
       
       contador = Integer.parseInt(practica.total);
       String matriz [][]= new String [contador][5];       
       for (x=0;x<contador;x++) { //Este for llena la matriz desde 0 hasta el n�mero de preguntas que haya en el curso MENOS 1
    	   y=x+1; //Esta variable s�lo almacena el n�mero de pregunta en la que vamos, de forma en que inicie desde 1 hasta el n�mero de preguntas.
           sql= "SELECT * FROM preguntas WHERE curso="+curso+" AND pregunta LIKE '"+y+"%'";
           rs = st.executeQuery(sql);
    	   while (rs.next()) {
    		   matriz[x][0]=rs.getString("pregunta");//La columna 0 guarda la pregunta
    		   matriz[x][1]=rs.getString("r1");//La columna 1 guarda la primer posible respuesta
    		   matriz[x][2]=rs.getString("r2");//La columna 2 guarda la  segunda posible respuesta
    		   matriz[x][3]=rs.getString("r3");//La columna 3 guarda la tercera posible respuesta
    		   matriz[x][4]=rs.getString("rc");//La columna 4 es la encargada de guardar la respuesta correcta. Por instrucci�n, devuelve el n�mero de respuesta, m�s no la respuesta. 
    	   }
       }
     return matriz;
   }
   
   public void azar () throws SQLException {
	   String ejemplo="";
	   int vector [] = new int [28];
	   int numero = (int) (Math.random()*28)+1;
	   //System.out.println("El n�mero que arroja es "+numero);
	   
	   Connection registros = this.conexion();
	   sql = "SELECT * FROM abecedario WHERE ID = "+numero;
       Statement st = (Statement) registros.createStatement();
       ResultSet rs = st.executeQuery(sql);
       
       while(rs.next()) {
    	   ejemplo = rs.getString("ejemplo");
       }
       practica_guante.instruccion.setText(ejemplo);
       //System.out.println("La letra que tienes que ahcer es "+ejemplo);
   }

   
   
   /*
   //Este m�todo ser� el responsable de crear comunicaci�n a trav�s de sockets, siendo el servidor
   public void servidor() {
	   ServerSocket server;
	   Socket socket;
	   int puerto=8080;
	   DataOutputStream salida;
	   BufferedReader entrada;
	   try {
		  // pantalla_videollamada pantalla = new pantalla_videollamada();
		   server = new ServerSocket (puerto);
		   socket = new Socket();
		   socket = server.accept();
		   entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		   String mensaje = entrada.readLine();
		   //pantalla.texto=mensaje;
		   System.out.println(mensaje);
		   //salida = new DataOutputStream(socket.getOutputStream());
		   //salida.writeUTF("Adios");
		   //socket.close();  
	   }
	   catch(Exception e){
		   
	   }
   }
   //Este m�todo ser� el responsable de crear comunicaci�n a trav�s de sockets, siendo el cliente
   public void cliente() {
	   Socket cliente;
	   int puerto=8080;
	   String ip = "192.168.1.144";
	   BufferedReader entrada, teclado;
	   PrintStream salida;
	   try {
		   cliente=new Socket (ip,puerto);
		   entrada=new BufferedReader (new InputStreamReader (cliente.getInputStream()));
		   teclado = new BufferedReader(new InputStreamReader(System.in));
		   String tec = teclado.readLine();
		   salida = new PrintStream(cliente.getOutputStream());
		   salida.println(tec);
		   String mensaje = entrada.readLine();
		   System.out.println(mensaje);
		   entrada.close();
		   salida.close();
		   teclado.close();
		   cliente.close();
	   }
	   catch (Exception e) {
		   
	   }   
   }*/
  
   /* public String obtenerImagen (int z) throws SQLException {
    	 
        Connection registros = this.conexion();
        String sql = ("SELECT imagen FROM abecedario WHERE ID="+z);
        Statement st = (Statement) registros.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
        imagen = rs.getString("imagen");
        }

        registros.close();
        return imagen;
         //Query de letra
    	public String obtenerLetra (int z) throws SQLException {
   
    	String letra="";
        Connection registros = this.conexion();
        String sql = ("SELECT letra FROM abecedario WHERE ID="+z);
        Statement st = (Statement) registros.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
        letra = rs.getString("letra");
        }

        registros.close();
        return letra;
    
    }
    
    public int id_usuario (String correo) throws SQLException {
    	int id=0;
    	String letra="";
        Connection registros = this.conexion();
        String sql = ("SELECT id FROM usuarios WHERE Correo = '"+correo+"';");
        Statement st = (Statement) registros.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
        letra = rs.getString("id");
        }
        registros.close();
        return id;  
        }
        
         */

 }

