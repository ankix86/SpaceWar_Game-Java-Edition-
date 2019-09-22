package Game;

import java.awt.Graphics;
import java.awt.Rectangle;

import Game.EntityPkg.EntityA;

public class Bullet extends  GameObj implements EntityA {
	Game game;
	Textures tex;
	Controller c;
	
	public Bullet(double x , double y,Textures tex,Controller c,Game game) {
		super(x,y);
		this.c = c;
		this.game = game;
		this.tex = tex;
	}
	public void render(Graphics g) {
		g.drawImage(tex.bullet, (int)x, (int)y,null);
	}
	public void tick() {
		this.y -= 10 ;
	}
	public Rectangle getbound() {
		return new Rectangle((int)x,(int) y,32, 16);
	}
	public double getY() {
		return this.y;
	}
	public double getX() {
		return x;
	}
}
