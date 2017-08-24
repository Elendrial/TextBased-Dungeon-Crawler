package me.laurence.dungeonCrawler.entities.stationary;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.entities.living.EntityPlayer;
import me.laurence.dungeonCrawler.general.InputHandler;
import me.laurence.dungeonCrawler.general.Stats;

public class EntityStairs extends EntityStatic{
	protected int floorMove; // -ve is up x floors, +ve is down x floors
	
	public EntityStairs(){
		this.name = "stairs";
		this.charCode = '#';
		this.canPassThrough = true;
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
		if(e instanceof EntityPlayer){
			if(Stats.Dungeon.floor + floorMove < 0){
				if(InputHandler.getPlayerConfirmation("If you use this, you will leave the dungeon.")){
					DungeonCrawler.gameOver(true);
				}
			}
			else
				DungeonCrawler.changeFloor(floorMove);
		}
	}
	
}
