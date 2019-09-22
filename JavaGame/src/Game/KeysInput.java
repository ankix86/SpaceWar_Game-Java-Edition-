package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeysInput extends KeyAdapter{
	Game game;

	public KeysInput(Game game) {
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		game.keyPressed(e);
	}
	public void keyReleased(KeyEvent e) {
		game.keyReleased(e);
	}
}	
