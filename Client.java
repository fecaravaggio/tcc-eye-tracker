import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//System.out.println("Tamanho da tela: largura = " + dim.width + " e altura = " + dim.height);	
		
		try {

			Socket socket = new Socket("localhost", 3000);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			Robot robot = new Robot();
			List<QuadradoTela> listaQuadrado = new ArrayList<QuadradoTela>();
			
			//Criação dos objetos das regiões da tela 
			QuadradoTela quadrado1 = new QuadradoEsq(0, (dim.getHeight()-1)/3, (dim.getWidth()-1)/3, (dim.getHeight()-1)*2/3, dim);
			QuadradoTela quadrado2 = new QuadradoDir( (dim.getWidth()-1)*2/3, (dim.getHeight()-1)/3, dim.getWidth()-1, (dim.getHeight()-1)*2/3, dim);
			QuadradoTela quadrado3 = new QuadradoAcima((dim.getWidth()-1)/3, 0, (dim.getWidth()-1)*2/3, (dim.getHeight()-1)/3, dim);
			QuadradoTela quadrado4 = new QuadradoAbaixo((dim.getWidth()-1)/3, (dim.getHeight()-1)*2/3, (dim.getWidth()-1)*2/3, dim.getHeight()-1, dim);
			
			listaQuadrado.add(quadrado1);
			listaQuadrado.add(quadrado2);
			listaQuadrado.add(quadrado3);
			listaQuadrado.add(quadrado4);

			while(true){

				int status = in.readInt();
				long time = in.readLong();
				double x = in.readDouble();
				double y = in.readDouble();

				System.out.println(status + " " + time + ": (" + x + ", " + y + ")");
				
				Iterator<QuadradoTela> iter = listaQuadrado.iterator();
				
				int i = 1;
				
				//Verifica a lista das regiões da tela, se o ponteiro está em algum deles
				while (iter.hasNext()) {
					System.out.println("iterador: " + i);
					i++;
					QuadradoTela aux = iter.next();
					aux.ponteiroMouseAqui(x, y);
					aux.movimentoMouse(robot);
				}			
				
			}
		}

		catch(Exception e){

			e.printStackTrace();
		}
	}

}
