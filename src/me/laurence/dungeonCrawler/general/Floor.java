package me.laurence.dungeonCrawler.general;

import java.awt.Point;
import java.util.ArrayList;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.entities.EntityList;
import me.laurence.dungeonCrawler.entities.living.EntityLiving;
import me.laurence.dungeonCrawler.entities.stationary.EntityStairs;
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
		
		livingVariance = (int) (DungeonCrawler.rand.nextInt(floor+1) - (floor + 1)/(2 + difficulty)); // Arbitrary equations
		staticVariance = (int) (DungeonCrawler.rand.nextInt(floor+1) - (floor + 1)/(2 - difficulty)); // Definitely should find something better
		
		dimensions = new Point(
				(int)(25 + 5*(floor-difficulty) + (DungeonCrawler.rand.nextInt(floor+1) - (floor+1)/2)),
				(int)(10 + 3*(floor-difficulty) + (DungeonCrawler.rand.nextInt(floor+1) - (floor+1)/2)));
		
		for(int i = 0; i < dimensions.x; i++){
			for(int j = 0; j < dimensions.y; j++){
				if(i == 0 || j == dimensions.y-1 || j == 0 || i == dimensions.x-1) 
					entities.add(new EntityWall(i,j));
			}
		}
		
		entities.add(new EntityStairs().setFloorMove(-1).setPosition(new Point(DungeonCrawler.player.getPosition())));
		entities.add(new EntityStairs().setFloorMove(1).setPosition(getRandomPoint(true)));
		
		for(int i = 0; i < Math.ceil(floor * difficulty) + livingVariance; i++){
			entities.add(EntityList.getRandomEntityLiving(difficulty * floor).adjustStats(difficulty).setPosition(getRandomPoint(true)));
		}
		
	}
	
	public void update(){
		if(DungeonCrawler.floorUpdateSkip){
			DungeonCrawler.floorUpdateSkip = false;
			PrintHandler.printFloor(this);
			return;
		}
		
		for(Entity e : entities){
			if(e instanceof EntityLiving) ((EntityLiving) e).getAi().update();
		}
		
		PrintHandler.printFloor(this);
	}
	
	public Entity getEntityAt(Point position) {
		for(Entity e : entities){
			if(e.getPosition().equals(position)) return e;
		}
		return null;
	}
	
	public Point getRandomPoint(boolean empty){
		int x,y;
		Point p;
		
		do{
			x = DungeonCrawler.rand.nextInt(dimensions.x);
			y = DungeonCrawler.rand.nextInt(dimensions.y);
			p = new Point(x, y);
		}while(getEntityAt(p) != null);
		
		return p;
	}
	
	
}
