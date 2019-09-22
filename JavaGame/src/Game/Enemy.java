package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import Game.EntityPkg.EntityA;
import Game.EntityPkg.EntityB;

public class Enemy extends GameObj implements EntityB {
	private Textures tex;
	Game game;
	Random rand = new Random();
	private int speed  = rand.nextInt(5)+1;
	Animation animation;
	Controller c;


	
	public Enemy(double x,double y,Textures tex,Controller c, Game game) {
		super(x,y);
		this.tex = tex;
		this.c =c;
		this.game = game;
		animation = new Animation(3,tex.enemy[0],tex.enemy[1],tex.enemy[2],tex.enemy[3]);
	}
	public void tick() {
		if(y > 380) { 
			y = -12;
			x = rand.nextInt(Game.WIDHT * game.SCALE - 16);
			y += speed;
			
		}
		
		y += speed;
		
		for(int i = 0;i<game.ea.size();i++) {
			
			EntityA TempEntA = game.ea.get(i);

			if(Collision.Collide(this,TempEntA)) {
			player.kills++;
			c.removeEntity(this);
			c.removeEntity(c.entA);
			game.setEnemy_Killed(game.getEnemy_Killed() + 1);
		}
		}
		
		animation.runAnimation();
	}
	public void render(Graphics g) {
		animation.drawAnimation(g, x, y, 0);
	}
	public double getY() {
		return y;
	}
	
	public double getX() {
		return 0;
	}
	public Rectangle getbound() {
		return new Rectangle((int)x,(int) y,32,32);
	}

}
