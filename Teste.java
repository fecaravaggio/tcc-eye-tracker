import java.awt.AWTException;	
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Teste {

	 public static void movimenta (Robot robot, int coordX, int coordY) {
	        robot.mouseMove(coordX, coordY);
	 }
	    
	 public static void atira (Robot robot) {
	    robot.mousePress(InputEvent.BUTTON3_MASK);
	    robot.delay(500);
	    robot.mouseRelease(InputEvent.BUTTON3_MASK);
	        //InputEvent.BUTTON2_MASK
	}
	 
	public static void movimentaTeclado (Robot robot) {
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(4000);
		robot.keyRelease(KeyEvent.VK_LEFT);
	}

	public static void main(String[] args) {

		int x = 650, y = 420, tecla;
		//KeyEvent tecla; 
		

		try {
			Robot robot = new Robot();
			
			movimentaTeclado(robot);
			/*while (x >= 190) {
				movimenta(robot, x, y);
				robot.delay(1);
				x--;
			}*/

			//atira(robot);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}
}
