package Game;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import Game.Game.STATE;



public class MouseInput implements MouseInputListener{
	Game g;
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		/*
		public Rectangle PlayBtn = new Rectangle(210 ,120 ,100, 50);
		public Rectangle HelpBtn = new Rectangle(210 ,180 ,100, 50);
		public Rectangle QuitBtn = new Rectangle(210 ,240, 100,50);
		
		public Rectangle RetryBtn = new Rectangle(100 ,300, 100,40);
		public Rectangle MenuBtn = new Rectangle(300 ,300, 100,40);
		*/
		if(Game.state == STATE.GAME.GAMEOVER) {
			if((x >= 100) && (x <= 200)) {
				if(y >= 300 && y <= 350) {
					Game.state = STATE.GAME;
					player.kills = 0;
					Game.HELTH = 100;
					g.setEnemy_Count(1);
				}
			}
			if((x >= 300) && (x <= 400)) {
				if(y >= 300 && y <= 350) {
					Game.state = STATE.MENU;
				}
			}
		if(Game.state == STATE.MENU) {
		if((x >= 210) && (x <= 310)) {
			if((y >= 120) && (y <= 170)) {
				Game.state = Game.STATE.GAME;
				player.kills = 0;
				Game.HELTH = 100;
				g.setEnemy_Count(1);
			}
		}
		if((x >= 210) && (x <= 310)) {
			if((y >= 180) && (y <= 230)) {
				System.out.println("help");
			}
		}
		 if((x >= 210) && (x <= 310)) {
			if((y >= 240) && (y <= 290)) {
				System.exit(1);	
			}
		}
	}
		}
}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
