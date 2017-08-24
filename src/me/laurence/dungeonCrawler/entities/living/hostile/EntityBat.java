package me.laurence.dungeonCrawler.entities.living.hostile;

import me.laurence.dungeonCrawler.entities.living.EntityLiving;

//This is not actually needed - look at EntityList to see another way to create generic entities.
public class EntityBat extends EntityLiving{
	
	public EntityBat(){
		super();
		this.name = "bat";
		this.atk = 1;
		this.canPassThrough = true;
		this.charCode = 'b';
		this.health = 3;
		this.maxHealth = 3;
		this.moveRange = 2;
	}
	
	@Override
	public float getSpawnChance() {
		return 0;
	}
}
