package me.laurence.dungeonCrawler.entities.living;

import java.awt.Point;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.inventory.PlayerInventory;


public class EntityPlayer extends EntityLiving{
	
	public EntityPlayer(){
		this.charCode = 'P';
		this.name = "player";
		stats.moveRange = 2;
		stats.atk = 1;
		stats.def = 0;
		stats.satk = 1;
		stats.sdef = 0;
		
		this.canPassThrough = true;
		this.health = 10;
		this.position = new Point(10, 5);
		this.inventory = new PlayerInventory();
	}
	
	protected EntityPlayer(EntityPlayer e){
		super(e);
	}

	@Override
	public void onHit(Entity e){
		super.onHit(e);
		if(this.health <= 0) DungeonCrawler.gameOver(false);
	}
	
	@Override
	public float getSpawnChance(float currentDifficulty) {
		return 0;
	}

	@Override
	public EntityPlayer clone() {
		return new EntityPlayer(this);
	}
	
}
