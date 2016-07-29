import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ThreadVelocidade extends Thread {
	
	boolean running = true;
	int []intensidade = new int[6];
	int []codigos = {KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_CONTROL, KeyEvent.VK_SPACE};
	private Robot robot;
	
	public ThreadVelocidade() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void velocidadeBotao(int botao, int velocidade) {
		intensidade[botao] = velocidade;
		if (velocidade == 0)
			robot.keyRelease(codigos[botao]);
			
		
	}
	
	public void run() {
		
		try {			
			while(running) {
				
				for(int j = 0; j < intensidade.length; j++) {
					if (intensidade[j] > 0) {
						robot.keyPress(codigos[j]);
						System.out.println("ligando " + j);
					}
				}

					
				for(int i = 1; i < 100; i++) {
					
					for(int j = 0; j < intensidade.length; j++) {
						
						if (i == intensidade[j]) {
							robot.keyRelease(codigos[j]);
							System.out.println("desligando " + j);
						}
					}
					//Thread.sleep(0, 100000);
					Thread.sleep(1);
					Thread.yield();
				}
			}
			
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}

}
