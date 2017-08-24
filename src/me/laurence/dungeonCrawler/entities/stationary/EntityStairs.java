package me.laurence.dungeonCrawler.entities.stationary;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.entities.living.EntityPlayer;

public class EntityStairs extends EntityStatic{
	protected int floorMove; // -ve is up x floors, +ve is down x floors
	
	public EntityStairs(){
		this.name = "stairs";
		this.charCode = '#';
	}
	
	public int getFloorMove() {
		return floorMove;
	}

	public EntityStairs setFloorMove(int floorMove) {
		this.floorMove = floorMove;
		return this;
	}

	@Override
	public float getSpawnChance() {
		return 0;
	}
	
	@Override
	public void onInteract(Entity e){
		if(e instanceof EntityPlayer) DungeonCrawler.changeFloor(floorMove);
	}
	
}
