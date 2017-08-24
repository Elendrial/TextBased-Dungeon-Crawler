package me.laurence.dungeonCrawler.entities.living;

import java.awt.Point;

import me.laurence.dungeonCrawler.entities.ai.AIHostile;

public class EntityGenericHostile extends EntityLiving{

	public EntityGenericHostile(){
		super();
		this.name = "generic";
		this.canPassThrough = false;
		this.charCode = 'g';
		
		this.ai = new AIHostile();
		((AIHostile) this.ai).e = this;
		this.position = new Point(0,0);
	}
	
	@Override
	public float getSpawnChance() {
		// TODO Auto-generated method stub
		return 0;
	}

}
