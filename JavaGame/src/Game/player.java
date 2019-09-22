package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Game.Game.STATE;
import Game.EntityPkg.EntityA;
import Game.EntityPkg.EntityB;

public class player extends GameObj implements EntityA {
	double xVal=0,yval=0;
	Textures tex;
	Animation animation;
	Game game;
	Controller c;
	public static int kills;
	public player(int x,int y,Textures tex,Controller c , Game game) {
		super(x,y);
		this.tex = tex;
		this.game = game;
		this.c = c;
		animation = new Animation(5, tex.player[0],tex.player[1],tex.player[2],tex.player[3]);
	}

	public void tick() {
		x += xVal;
		y += yval;
		if(x <= 0) {
			x = 0;
		}if(x >= 475) {
			x = 475;
		}
		 if(y <= 0) {
			y = 0;
		}
		 if(y >= 343) {
			y = 343;
		}
		 
		for(int i = 0;i < game.eb.size() ; i++) {
			EntityB tempB = game.eb.get(i);
			
			if(Collision.Collide(this,tempB)) {
				c.removeEntity(tempB);
				game.HELTH -= 5;
				game.setEnemy_Killed(game.getEnemy_Killed() + 1);
			}
		}
		
		if(game.HELTH <= 0) {
			game.state = STATE.GAMEOVER;
		
		}
	
		 animation.runAnimation();
	}
	public void render(Graphics g) {
		animation.drawAnimation(g, x, y, 0);
		g.setColor(Color.RED);
		g.drawString("Kills:" + kills, 20,20);
		
		
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	public void setValx(double xval) {
		this.xVal = xval;
	}
	public void setValy(double yval) {
		this.yval = yval;
	}
	public Rectangle getbound() {
		return new Rectangle((int)x,(int) y,32,32);
	}

}
