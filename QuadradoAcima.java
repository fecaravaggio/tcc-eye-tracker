import java.awt.*;

public class QuadradoAcima extends QuadradoTela {

	public QuadradoAcima(double posX, double posY, double posXFim, double posYFim, Dimension dimTela) {

		super(posX, posY, posXFim, posYFim, dimTela);
		
	}

	@Override
	void movimentoMouse(Robot robot) {
		if (ponteiro == true)
			robot.keyPress(KeyEvent.VK_W);
		else
			robot.keyRelease(KeyEvent.VK_W);
		
	}

}
