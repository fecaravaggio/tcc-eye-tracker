import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.*;
import java.io.*;


public class Client {
	
	public static void verificaMovimento(double x, double y, Dimension d, Robot robot) {
		double xmax = (double) d.width-1;
		double ymax = (double) d.height-1;
		double esquerda = xmax/3, direita = xmax*2/3;
		double acima = ymax/3, abaixo = ymax*2/3;
		//boolean esq = false, dir = false, cima = false, baixo = false;
		
		/*
		//vira a esquerda
		if (esq == false && x < esquerda && y > acima && y < abaixo) {
			robot.keyPress(KeyEvent.VK_LEFT);
			esq = true;
		}
		//vira a direita
		if (dir == false && x > direita && y > acima && y < abaixo) {
			robot.keyPress(KeyEvent.VK_RIGHT);
			dir = true;
		}
		//anda para frente
		if (cima == false && y < acima && x < direita && x > esquerda) {
			robot.keyPress(KeyEvent.VK_W);
			cima = true;
		}
		//anda para trás
		if (baixo == false && y > abaixo && x < direita && x > esquerda) {
			robot.keyPress(KeyEvent.VK_S);
			baixo = true;
		}
		
		robot.keyRelease(KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_S);
		
		*/
		

		if (x < esquerda && y > acima && y < abaixo) {
			//vira a esquerda
			robot.keyPress(KeyEvent.VK_LEFT);
		}
		else {
			robot.keyRelease(KeyEvent.VK_LEFT);
			if (x > direita && y > acima && y < abaixo) {
				//vira a direita
				robot.keyPress(KeyEvent.VK_RIGHT);
			}
			else {
				robot.keyRelease(KeyEvent.VK_RIGHT);
				//centro da tela
				if (y < acima && x < direita && x > esquerda)
					//acima
					robot.keyPress(KeyEvent.VK_W);
				else {
					robot.keyRelease(KeyEvent.VK_W);
					if (y > abaixo && x < direita && x > esquerda)
						//abaixo
						robot.keyPress(KeyEvent.VK_S);
					else {
						robot.keyRelease(KeyEvent.VK_S);
						System.out.println("zona neutra");
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//System.out.println("Tamanho da tela: largura = " + dim.width + " e altura = " + dim.height);
		
		try {

			Socket socket = new Socket("localhost", 3000);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			Robot robot = new Robot();

			while(true){

				int status = in.readInt();
				long time = in.readLong();
				double x = in.readDouble();
				double y = in.readDouble();

				System.out.println(status + " " + time + ": (" + x + ", " + y + ")");
			
				verificaMovimento(x, y, dim, robot);
				
				
				
			}
		}

		catch(Exception e){

			e.printStackTrace();
		}
	}

}
