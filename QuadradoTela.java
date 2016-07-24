import java.awt.*;

public abstract class QuadradoTela {
	
	boolean ponteiro;
	double posX, posY, posXFim, posYFim;
	
	public QuadradoTela (double posX, double posY, double posXFim, double posYFim, Dimension dimTela) {
		
		this.posX = posX;
		this.posY = posY;
		this.posXFim = posXFim;
		this.posYFim = posYFim;
		
	}	
	
	void ponteiroMouseAqui (double x, double y) {
		
		if ((x >= posX && x <= posXFim) && (y >= posY && y <= posYFim)) {
			ponteiro = true;
			System.out.println("Ponteiro true...");
			//iniciaMovimento(robot);
		}
		else {
			ponteiro = false;
			System.out.println("Ponteiro false...");
		}
	}
	
	abstract void movimentoMouse (Robot robot);

}
