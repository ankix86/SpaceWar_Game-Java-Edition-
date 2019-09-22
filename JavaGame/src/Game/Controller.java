package Game;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import Game.EntityPkg.EntityA;
import Game.EntityPkg.EntityB;

public class Controller {

	private LinkedList<EntityA> ea = new LinkedList<EntityA>();
	private LinkedList<EntityB> eb = new LinkedList<EntityB>();
	EntityA entA;
	EntityB entB;
	Game game;
	Textures tex;
	Random rand = new Random();
	
	public Controller(Game game,Textures tex) {
		this.tex = tex;
		this.game = game;
	}
	
	public void createEmeny(int e_count) {
		for (int i = 0; i < e_count ; i++) {
			addEntity(new Enemy(rand.nextInt(640),-10,tex,this, game));//spawn enemy
		}
	}
	public void tick() {
		
		for(int i = 0;i < ea.size();i++) {
			entA = ea.get(i);
			entA.tick();
		}

		for(int i = 0;i < eb.size();i++) {
			entB = eb.get(i);
			entB.tick();
		}
	}
	
	public void render(Graphics g) {
	
		for(int i = 0;i < ea.size();i++) {
			entA = ea.get(i);
			entA.render(g);
		}

		for(int i = 0;i < eb.size();i++) {
			entB = eb.get(i);
			entB.render(g);
		}
	}
	
	public void addEntity(EntityA block) {
			ea.add(block);
	}
	
	public void removeEntity(EntityA block) {
			ea.remove(block);
	}
	
	public void addEntity(EntityB block) {
		eb.add(block);
	}

	public void removeEntity(EntityB block) {
		eb.remove(block);
	}
	public LinkedList<EntityA> getenA(){
		return ea;
	}
	public LinkedList<EntityB> getenB(){
		return eb;
	}
}
