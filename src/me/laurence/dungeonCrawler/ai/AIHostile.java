package me.laurence.dungeonCrawler.ai;

import java.awt.Point;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.entities.living.EntityLiving;

public class AIHostile implements IEntityAI{

	public EntityLiving e;
	
	@Override
	public void update() {
		//TODO: Use A* or Dijkstra's algorithm to accurately navigate around walls/other obstacles once implemented.
		// This is a very very bad implementation.
		// Like incredibly bad.
		// Never do this.
		Point pp = DungeonCrawler.player.getPosition();
		int xDif, yDif;
		boolean inRange = false;
		for(int i = 0 ; i < e.getBaseMoveRange() && !inRange; i++){
			xDif = pp.x - e.getPosition().x;
			yDif = pp.y - e.getPosition().y;
			
			inRange = (xDif * xDif) + (yDif * yDif) < e.getBaseAttackRange();
			
			if(!inRange){
				if(Math.abs(xDif) > Math.abs(yDif)) e.moveBy(new Point((xDif / Math.abs(xDif)) ,0));
				else e.moveBy(new Point((yDif / Math.abs(yDif)) ,0));
			}
			else{
				DungeonCrawler.player.onHit(e);
			}
		}
	}

}
