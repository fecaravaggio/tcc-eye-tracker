import java.awt.*;

public class QuadradoEsq extends QuadradoTela {

	public QuadradoEsq(ThreadVelocidade thread, double posX, double posY, double posXFim, double posYFim, Dimension dimTela) {
		
		super(thread, posX, posY, posXFim, posYFim, dimTela);
		
	}
	
	@Override
	void movimentoMouse() {
		if (ponteiro == true)
			thread.velocidadeBotao(0, Client.VELOCIDADE);
		else
			thread.velocidadeBotao(0, 0);	
	}

}
