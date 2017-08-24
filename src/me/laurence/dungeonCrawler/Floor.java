package me.laurence.dungeonCrawler;

import java.awt.Point;
import java.util.ArrayList;

import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.entities.ai.IEntityAI;
import me.laurence.dungeonCrawler.entities.stationary.EntityWall;
import me.laurence.dungeonCrawler.handlers.PrintHandler;

public class Floor {
	
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public final Point dimensions;
	public final float difficulty;
	public final int floor;
	public final int livingVariance;
	public final int staticVariance;
	
	public Floor(float difficulty, int floor){
		this.difficulty = difficulty;
		this.floor = floor;
		
		livingVariance = (int) (DungeonCrawler.rand.nextInt(floor+1) - (floor+1)/(2 + difficulty));
		staticVariance = (int) (DungeonCrawler.rand.nextInt(floor+1) - (floor+1)/(2-difficulty));
		
		dimensions = new Point(
				(int)(25 + 5*(floor-difficulty) + (DungeonCrawler.rand.nextInt(floor+1) - (floor+1)/2)),
				(int)(10 + 3*(floor-difficulty) + (DungeonCrawler.rand.nextInt(floor+1) - (floor+1)/2)));
		
		//for(int i = 0; i < Math.ceil(floor * difficulty) + livingVariance; i++){
			
		//}
		
		for(int i = 0; i < dimensions.x; i++){
			for(int j = 0; j < dimensions.y; j++){
				if(i == 0 || j == dimensions.y-1 || j == 0 || i == dimensions.x-1) 
					entities.add(new EntityWall(i,j));
			}
		}
		
	}
	
	public void update(){
		if(DungeonCrawler.floorUpdateSkip){
			DungeonCrawler.floorUpdateSkip = false;
			PrintHandler.printFloor(this);
			return;
		}
		
		for(Entity e : entities){
			if(e instanceof IEntityAI) ((IEntityAI) e).update();
		}
		
		PrintHandler.printFloor(this);
	}
	
	public Entity getEntityAt(Point position) {
		for(Entity e : entities){
			if(e.getPosition().equals(position)) return e;
		}
		return null;
	}
	
	
}
