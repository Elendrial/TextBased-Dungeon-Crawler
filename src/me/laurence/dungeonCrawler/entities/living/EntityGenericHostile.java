package me.laurence.dungeonCrawler.entities.living;

import java.awt.Point;

import me.laurence.dungeonCrawler.ai.AIHostile;

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
	
	protected EntityGenericHostile(EntityGenericHostile e){
		super(e);
	}
	
	@Override
	public float getSpawnChance() {return 0;}

	@Override
	public EntityGenericHostile clone() {
		return new EntityGenericHostile(this);
	}

}
