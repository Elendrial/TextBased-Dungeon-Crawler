package me.laurence.dungeonCrawler.entities;

import java.awt.Point;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.general.PrintHandler;
import me.laurence.dungeonCrawler.general.Stats;

public abstract class Entity{
	protected char charCode = ' ';
	protected String name = "";
	protected Point position;
	protected boolean canPassThrough;
	
	public Entity(){}
	
	/* e is entity which destroyed, not the entity to be destroyed */
	public void destroy(Entity e){
		try{
			DungeonCrawler.getFloor().entities.remove(this);
			this.onDestroy(e);
		}
		catch(Exception e2){
			PrintHandler.println("Entity (" + this.toString() + ") not destroyed properly, error:");
			e2.printStackTrace();
		}
	}
	
	public abstract float getSpawnChance();
	public abstract void onHit(Entity e);
	public abstract void onInteract(Entity e);
	public abstract void onWalkOn(Entity e);
	public abstract void onDestroy(Entity e);
	
	public String getName(){
		return this.name;
	}
	
	public void moveBy(Point p){
		Point toMoveTo = new Point(p.x + position.x, p.y + position.y);
		Entity e = DungeonCrawler.floors.get(Stats.Dungeon.floor).getEntityAt(toMoveTo);
		if(e == null) position.setLocation(toMoveTo);
		else if(e.canPassThrough()) position.setLocation(toMoveTo);
		
		else PrintHandler.println("Could not move to (" + (this.position.x + p.x) +", " + (this.position.y + p.y) + ")!");
	}
	
	public void moveBy(int x, int y){
		moveBy(new Point(x,y));
	}
	
	public Point getPosition(){
		return this.position;
	}
	
	public Entity setPosition(Point p){
		this.position = p;
		return this;
	}
	
	public boolean canPassThrough(){
		return canPassThrough;
	}

	public char getCharCode() {
		return charCode;
	}

	public Entity setCharCode(char charRepresentation) {
		this.charCode = charRepresentation;
		return this;
	}

	public boolean isCanPassThrough() {
		return canPassThrough;
	}

	public Entity setCanPassThrough(boolean canPassThrough) {
		this.canPassThrough = canPassThrough;
		return this;
	}

	public Entity setName(String name) {
		this.name = name;
		return this;
	}
	
	
}
