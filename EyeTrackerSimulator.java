import java.awt.*;			
import java.net.*;
import java.io.*;

public class EyeTrackerSimulator {

	public static void main(String [] args) throws Exception {

		ServerSocket server = new ServerSocket(3000);
		Socket socket;

		while( (socket = server.accept()) != null ){

			new ServerThread(socket).start();			
		}
		server.close();
		
	}
}


class ServerThread extends Thread {

	DataOutputStream out = null;

	public ServerThread(Socket socket) {

		try{
			out = new DataOutputStream(socket.getOutputStream());
		}
		catch(Exception e){

			e.printStackTrace();
		}
	}

	public void run(){

		try{
			while(true){

				PointerInfo info = MouseInfo.getPointerInfo();
				Point p = info.getLocation();

				out.writeInt(1); // status: 0 -> amostra ruim, 1 -> amostra boa
				out.writeLong(System.currentTimeMillis());
				out.writeDouble(p.getX());
				out.writeDouble(p.getY());

				Thread.sleep(333);
			}
		}
		catch(Exception e){

			e.printStackTrace();
		}
	}
}
	
