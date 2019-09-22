package Game;

import java.awt.image.BufferedImage;

public class Textures {

	public BufferedImage[] player = new BufferedImage[4];
	public BufferedImage bullet;
	public BufferedImage[] boom = new BufferedImage[4];
	public BufferedImage[] enemy = new BufferedImage[4];
	public SpriteSheets ss = null;

	
	public Textures(Game game) {
		ss = new SpriteSheets(game.getSpritSheet());
		getTextures();
	}
	public void getTextures() {
		player[0] = ss.garbImg(1, 1, 32, 32);
		player[1] = ss.garbImg(1, 2, 32, 32);
		player[2] = ss.garbImg(1, 3, 32, 32);
		player[3] = ss.garbImg(1, 4, 32, 32);
		bullet = ss.garbImg(2,1,32,32);
		enemy[0] = ss.garbImg(3,1,32,32);
		enemy[1] = ss.garbImg(3,2,32,32);
		enemy[2] = ss.garbImg(3,3,32,32);
		enemy[3] = ss.garbImg(3,4,32,32);
		boom[0] = ss.garbImg(4,1,32,32);
		boom[1] = ss.garbImg(4,2,32,32);
		boom[2] = ss.garbImg(4,3,32,32);
		boom[3] = ss.garbImg(4,4,32,32);
	}
	
}
