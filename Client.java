import java.awt.*;
import java.net.*;
import java.io.*;

public class Client {

	public static void main(String [] args){

		try {

			Socket socket = new Socket("localhost", 3000);
			DataInputStream in = new DataInputStream(socket.getInputStream());
	
			while(true){

				int status = in.readInt();
				long time = in.readLong();
				double x = in.readDouble();
				double y = in.readDouble();

				//quando x estiver perto 0 = virar esquerda no jogo

				System.out.println(status + " " + time + ": (" + x + ", " + y + ")");
			}
		}

		catch(Exception e){

			e.printStackTrace();
		}
	}
}
