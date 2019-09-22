package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {

	private int speed;
	private int index = 0;
	private int count = 0;
	
	private BufferedImage[] img = new BufferedImage[10];

	
	private BufferedImage currentImg;
	//13 frame animation
	public Animation(int speed,BufferedImage img1,BufferedImage img2,BufferedImage img3,BufferedImage img4){
		this.speed = speed;
		this.img[0] = img1;
		this.img[1] = img2;
		this.img[2] = img3;
		this.img[3] = img4;
	}
	
	
	public void runAnimation(){
		index++;
		if(index > speed){
			index = 0;
			nextFrame();
		}	
	}
	
	public void nextFrame(){
			if(count == 0)
				currentImg = img[0];
			if(count == 1)
				currentImg = img[1];
			if(count == 2)
				currentImg = img[2];
			if(count == 3)
				currentImg = img[3];
			count++;
			if(count == 3) {
				count = 0;
			}
		}
	public void drawAnimation(Graphics g, double x, double y, int offset){
		g.drawImage(currentImg, (int)x - offset, (int)y, null);
	}
	
	public void setCount(int count){
		this.count = count;
	}
	public int getCount(){
		return count;
	}
	public int getSpeed(){
		return speed;
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
}
