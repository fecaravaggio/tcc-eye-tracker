import java.awt.*;
import java.awt.event.KeyEvent;

public class QuadradoDir extends QuadradoTela {

	public QuadradoDir(double posX, double posY, double posXFim, double posYFim, Dimension dimTela) {
	
		super(posX, posY, posXFim, posYFim, dimTela);
		
	}

	@Override
	void movimentoMouse(Robot robot) {
		if (ponteiro == true)
			robot.keyPress(KeyEvent.VK_RIGHT);
		else
			robot.keyRelease(KeyEvent.VK_RIGHT);	
	}

}
