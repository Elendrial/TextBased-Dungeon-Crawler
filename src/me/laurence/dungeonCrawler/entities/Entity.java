package me.laurence.dungeonCrawler.entities;

import java.awt.Point;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.GameData;
import me.laurence.dungeonCrawler.handlers.PrintHandler;

public abstract class Entity{
	protected char charCode = ' ';
	protected String name = "";
	protected Point position = new Point();
	protected boolean canPassThrough = true;
	
	public Entity(){}
	
	public Entity(Entity e) {
		this.canPassThrough = e.canPassThrough;
		this.charCode = e.charCode;
		this.name = e.name;
		this.position = new Point(e.position);
	}

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
	
	public abstract Entity clone();
	
	public String getName(){
		return this.name;
	}
	
	public void moveBy(Point p){
		Point toMoveTo = new Point(p.x + position.x, p.y + position.y);
		Entity e = DungeonCrawler.floors.get(GameData.Dungeon.floor).getEntityAt(toMoveTo);
		if(e == null) position.setLocation(toMoveTo);
		else if(e.canPassThrough()) position.setLocation(toMoveTo);
		
		else PrintHandler.println("Could not move by (" + p.x + ", " + p.y + ") to (" + (this.position.x + p.x) +", " + (this.position.y + p.y) + ")!");
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (canPassThrough ? 1231 : 1237);
		result = prime * result + charCode;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (canPassThrough != other.canPassThrough)
			return false;
		if (charCode != other.charCode)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
	
}
