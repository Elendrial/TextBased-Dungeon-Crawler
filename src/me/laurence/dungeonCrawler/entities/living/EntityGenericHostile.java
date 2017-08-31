package me.laurence.dungeonCrawler.entities.living;

import java.awt.Point;

import me.laurence.dungeonCrawler.ai.AIHostile;

public class EntityGenericHostile extends EntityLiving{

	protected float preferredDifficulty = 1;
	
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
		((AIHostile) this.ai).e = this;
	}
	
	public float getPreferredDifficulty() {
		return preferredDifficulty;
	}

	public EntityGenericHostile setPreferredDifficulty(float preferredDifficulty) {
		this.preferredDifficulty = preferredDifficulty;
		return this;
	}

	@Override // Uses modified Chi-squared/Chi distribution to get results - need to edit to stop large difficulties overloading factorial.
	public float getSpawnChance(float currentDifficulty) {
		return (float) ((Math.pow(currentDifficulty, preferredDifficulty -1) * Math.pow(Math.E, -currentDifficulty))/(Math.pow(2, preferredDifficulty) * factorial(1, (int)(preferredDifficulty-1))));
	}

	@Override
	public EntityGenericHostile clone() {
		return new EntityGenericHostile(this);
	}

	public int factorial(int n, int x){
		if(x <= 1) return n;
		return factorial(n*x, x-1);
	}
	
}
