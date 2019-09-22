package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameOver {
		Game game;
		public Rectangle RetryBtn = new Rectangle(100 ,300, 100,40);
		public Rectangle MenuBtn = new Rectangle(300 ,300, 100,40);

		public void render(Graphics g) {
				Graphics2D g2d =(Graphics2D)g;
				Font f =new Font("arial",Font.BOLD,50);
				g.setColor(Color.pink);
				g.setFont(f);
				g.drawString("Game Over",120,150);
				g.setColor(Color.white);
				g.drawRect(100,80, 300, 200);
				g2d.draw(MenuBtn);
				g2d.draw(RetryBtn);
				Font f1 = new Font("arial",Font.BOLD ,35);
				g.setFont(f1);
				g.setColor(Color.RED);
				g.drawString("Score :" + player.kills,180,250);
				g.setColor(Color.pink);
				Font f2 = new Font("arial",Font.BOLD ,25);
				g.setFont(f2);
				g.drawString("RETRY",RetryBtn.x+10  ,RetryBtn.y+ 30);
				g.drawString("MENU",MenuBtn.x+10  ,MenuBtn.y+ 30);
				
		}
}
