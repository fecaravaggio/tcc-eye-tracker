import java.awt.*;

public class QuadradoDir extends QuadradoTela {

	public QuadradoDir(ThreadVelocidade thread, double posX, double posY, double posXFim, double posYFim, Dimension dimTela) {
	
		super(thread, posX, posY, posXFim, posYFim, dimTela);
		
	}

	@Override
	void movimentoMouse() {
		if (ponteiro == true)
			thread.velocidadeBotao(1, Client.VELOCIDADE);
		else
			thread.velocidadeBotao(1, 0);	
	}

}
