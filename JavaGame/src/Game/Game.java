package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

import Game.EntityPkg.EntityA;
import Game.EntityPkg.EntityB;

public class Game extends Canvas implements Runnable{
	public static final int WIDHT = 250;
	public static final int HIEGHT = WIDHT / 12 * 9;
	public final static int SCALE = 2;
	public static final String TITLE = "Space War";
	public boolean running = false;
	public Thread thread;
	private BufferedImage image = new BufferedImage(WIDHT, HIEGHT,BufferedImage.TYPE_INT_RGB);
	private BufferedImage sheet = null;
	private BufferedImage background = null;
	private player p;
	public Controller c;
	GameOver go = new GameOver();
	private boolean shooted;
	private Textures tex;
	private int enemy_Count = 1;
	private int enemy_Killed = 0; 
	public static int HELTH = 100;
	Menu m = new Menu();
	public LinkedList<EntityA> ea;
	public LinkedList<EntityB> eb;
	public static enum STATE {
		GAME,
		MENU,
		GAMEOVER
	};
	public static STATE state = STATE.GAME;
	
	public void Init() {
		requestFocus();
		BufferImageLoader loader = new BufferImageLoader();
		try {
			sheet = loader.loadImager("/spritesheet2.png");
			background = loader.loadImager("/background.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		addKeyListener(new KeysInput(this));
		tex = new Textures(this);
		c = new Controller(this,tex);
		p = new player(WIDHT * SCALE/ 2, 300,tex,c,this);
		c.createEmeny(enemy_Count);
		ea = c.getenA();
		eb = c.getenB();
		this.addMouseListener(new MouseInput());
	}

	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(state == STATE.GAME) {	
		if(key == KeyEvent.VK_LEFT) {
			p.setValx(-5);
		}else if(key == KeyEvent.VK_RIGHT)
		{
			p.setValx(5);
		}else if(key == KeyEvent.VK_UP){
			p.setValy(-5);
			
		}else if(key == KeyEvent.VK_DOWN) {
			p.setValy(5);
		}
		else if(key == KeyEvent.VK_SPACE && !shooted) {
			
			c.addEntity(new Bullet(p.getX(),p.getY()-15 ,tex,c,this));
			shooted = true;
			}
		}
		}
	
	public void keyReleased(KeyEvent e) {
int key = e.getKeyCode();
	
		if(key == KeyEvent.VK_LEFT) {
			p.setValx(0);
		}else if(key == KeyEvent.VK_RIGHT)
		{
			p.setValx(0);
		}else if(key == KeyEvent.VK_UP){
			p.setValy(0);
			
		}else if(key == KeyEvent.VK_DOWN) {
			p.setValy(0);	
		}else if(key == KeyEvent.VK_SPACE) {
			shooted = false;
		}	
	}
	
	private synchronized void Start() {
		if(running){
			return;
		}
		running = true;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop() throws InterruptedException {
		if(!running) {
			return;
		}
		running = false;
		thread.join();
		System.exit(1);
	}

	public void run() {
		Init();
		long lastTime = System.nanoTime();
		final double amountsOfTicks = 60;
		double ns = 1000000000 /  amountsOfTicks;
		double delta = 0;
		int updates = 0, frames = 0;
		long timer = System.currentTimeMillis();
		
		
		while(running) {
			long now  = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000 ) {
				timer += 1000;
				System.out.println(updates + "TICKS , FPS :" + frames);	
				frames = 0;
				updates = 0;
			}
		}
		try {
			stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
	if(state == STATE.GAME) {
		p.tick();
		c.tick();
		
		if(enemy_Killed == enemy_Count) {
			enemy_Count += 2;
			enemy_Killed = 0;
			c.createEmeny(enemy_Count);
			}
		}
	}
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
			
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();	
		g.drawImage(image, 0, 0,getWidth(),getHeight(),this);
		g.drawImage(background,0, 0,null);
		
		
		if(state == STATE.GAME) {
		g.setColor(Color.gray);
		g.fillRect(400, 10, 100, 20);
		g.setColor(Color.red);
		g.fillRect(400, 10,HELTH,20);
		g.setColor(Color.white);
		g.drawRect(400, 10,100,20);
		p.render(g);
		c.render(g);
		//sg.render(g);
		}else if(state == STATE.MENU) {
			m.render(g);
		}else if(state == STATE.GAMEOVER) {
			go.render(g);
		}
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDHT * SCALE, HIEGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDHT * SCALE, HIEGHT * SCALE ));
		game.setMinimumSize(new Dimension(WIDHT * SCALE, HIEGHT * SCALE ));
		JFrame frame = new JFrame(TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.Start();
	}
	
	public BufferedImage getSpritSheet() {
		return sheet;
	}
	
	public int getEnemy_Killed() {
		return enemy_Killed;
	}
	public int getEnemy_Count() {
		return enemy_Count;
	}
	public void setEnemy_Count(int e_count) {
		this.enemy_Count = e_count;
	}
	public void setEnemy_Killed(int e_killed) {
		this.enemy_Killed = e_killed;
	}
}
