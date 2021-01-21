import java.net.*;
import java.io.*;

public class ConexionPython{
	private static String host = "localhost";
	private static int puerto = 5000;
	private static Socket socket;
	
	public static int getCorrect(String _value) throws UnknownHostException, IOException {
		socket = new Socket(host, puerto);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeUTF(_value);
		InputStream input = socket.getInputStream();
		int read; byte[] buffer = new byte[1]; String msg = null;
		if((read = input.read(buffer)) != -1) {
			msg = new String(buffer, 0, read);
			//System.out.println(msg);
		}
		socket.close();
		int value = Integer.parseInt(msg);
		return value;
	}
	
	public static void open() throws IOException {
		String cmd[] = {"cmd.exe","/c" ,"\"start cmd /c \"python -u \".\\src\\Recursos\\main.py\"\"\""};
		Runtime.getRuntime().exec(cmd);
	}
	
	public static void close() throws UnknownHostException, IOException {
		socket = new Socket(host, puerto);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeUTF("exit");
		socket.close();
	}
}
