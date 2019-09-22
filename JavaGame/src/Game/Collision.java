package Game;
import java.util.LinkedList;

import Game.EntityPkg.EntityA;
import Game.EntityPkg.EntityB;

public class Collision {
	
	public static boolean Collide(EntityA enta,EntityB entb) {
	
	
		if(enta.getbound().intersects(entb.getbound())){
				return true;
		}
		return false;
	}
	
	public static boolean Collide(EntityB entb,EntityA enta) {
		
				if(entb.getbound().intersects(enta.getbound())){
				return true;
			}
		
		return false;
	}

}
