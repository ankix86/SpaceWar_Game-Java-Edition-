package Game.EntityPkg;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface EntityB {

	public void tick();
	public void render(Graphics g);
	public Rectangle getbound();
	public double getX();
	public double getY();
}
