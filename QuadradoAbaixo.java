import java.awt.*;

public class QuadradoAbaixo extends QuadradoTela {

	public QuadradoAbaixo(ThreadVelocidade thread, double posX, double posY, double posXFim, double posYFim, Dimension dimTela) {

		super(thread, posX, posY, posXFim, posYFim, dimTela);
		
	}

	@Override
	void movimentoMouse() {
		if (ponteiro == true)
			thread.velocidadeBotao(3, Client.VELOCIDADE);
		else
			thread.velocidadeBotao(3, 0);	
		
	}

}
