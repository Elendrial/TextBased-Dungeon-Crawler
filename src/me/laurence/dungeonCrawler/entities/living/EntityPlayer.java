package me.laurence.dungeonCrawler.entities.living;

import java.awt.Point;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.entities.Entity;


public class EntityPlayer extends EntityLiving{
	
	public EntityPlayer(){
		this.charCode = 'P';
		this.name = "player";
		this.moveRange = 2;
		this.atk = 1;
		this.def = 0;
		this.satk = 1;
		this.sdef = 0;
		
		this.canPassThrough = true;
		this.health = 10;
		this.position = new Point(10, 5);
	}

	@Override
	public void onHit(Entity e){
		super.onHit(e);
		if(health <= 0) DungeonCrawler.gameOver();
	}
	
	@Override
	public float getSpawnChance() {
		return 0;
	}
	
}
