package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
			
		public Rectangle PlayBtn = new Rectangle(210 ,120 ,100, 50);
		public Rectangle HelpBtn = new Rectangle(210 ,180 ,100, 50);
		public Rectangle QuitBtn = new Rectangle(210 ,240, 100,50);

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Font f1 = new Font("arial",Font.BOLD,50);
		g.setFont(f1);
		g.setColor(Color.WHITE);
		g.drawString("SPACE WAR",105, 80);
		g2d.draw(PlayBtn);
		g2d.draw(HelpBtn);
		g2d.draw(QuitBtn);
		Font f2 = new Font("arial",Font.BOLD ,30);
		g.setFont(f2);
		g.setColor(Color.pink);
		g.drawString("PLAY",PlayBtn.x + 12,PlayBtn.y + 35);
		g.drawString("HELP",HelpBtn.x + 12,HelpBtn.y + 35);
		g.drawString("QUIT",QuitBtn.x + 12,QuitBtn.y + 35);
	}
}
