package me.laurence.dungeonCrawler.entities.stationary;

import java.awt.Point;

public class EntityWall extends EntityStatic{

	public EntityWall(){
		this.canPassThrough = false;
		this.charCode = '/';
		this.name = "wall";
	}
	
	public EntityWall(int x, int y) {
		this();
		this.position = new Point(x,y);
	}

	@Override
	public float getSpawnChance(float currentDifficulty) {
		return 0;
	}

	public EntityWall clone(){
		return (EntityWall) new EntityWall().setPosition(new Point(this.position));
	}
	
}