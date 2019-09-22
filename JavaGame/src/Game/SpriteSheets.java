package Game;
import java.awt.image.BufferedImage;

public class SpriteSheets {
	
	private BufferedImage image;
	
	public SpriteSheets(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage garbImg(int row,int col,int width,int hight) {
		BufferedImage img = image.getSubimage((row * 32) - 32, (col * 32) - 32, width, hight);
		return img;
	}

}