import java.awt.*;	
import java.awt.event.KeyEvent;

public class QuadradoEsq extends QuadradoTela {

	public QuadradoEsq(double posX, double posY, double posXFim, double posYFim, Dimension dimTela) {
		
		super(posX, posY, posXFim, posYFim, dimTela);
		
	}
	
	@Override
	void movimentoMouse(Robot robot) {
		if (ponteiro == true) {
			robot.keyPress(KeyEvent.VK_LEFT);
		}
		else {
			robot.keyRelease(KeyEvent.VK_LEFT);	
		}
	}

}
