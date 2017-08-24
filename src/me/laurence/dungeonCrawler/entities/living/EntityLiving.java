package me.laurence.dungeonCrawler.entities.living;

import java.awt.Point;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.entities.ai.IEntityAI;
import me.laurence.dungeonCrawler.handlers.PrintHandler;

abstract public class EntityLiving extends Entity{
	protected int maxHealth=1, health=1;
	protected int moveRange=1;
	protected int attackRange=1;
	protected int def=0, atk=0, satk=0, sdef=0;
	protected IEntityAI ai;
	// TODO: Statuses
	
	
	
	public void attack(Point position){
		DungeonCrawler.getFloor().getEntityAt(position).onHit(this);
	}
	
	@Override
	public void onHit(Entity e) {
		if(e instanceof EntityLiving){
			this.health -= (((EntityLiving) e).getAtk() - this.getDef());
			PrintHandler.println(this.getName() + " was hit, health now: " + this.getHealth());
			
			if(this.health <= 0) destroy(e);
		}
	}
	
	public void onDestroy(Entity e){};
	public void onInteract(Entity e) {}
	public void onWalkOn(Entity e) {}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public EntityLiving setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
		return this;
	}

	public int getHealth() {
		return health;
	}

	public EntityLiving setHealth(int health) {
		this.health = health;
		return this;
	}

	public int getMoveRange() {
		return moveRange;
	}

	public EntityLiving setMoveRange(int moveRange) {
		this.moveRange = moveRange;
		return this;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public EntityLiving setAttackRange(int attackRange) {
		this.attackRange = attackRange;
		return this;
	}

	public int getDef() {
		return def;
	}

	public EntityLiving setDef(int def) {
		this.def = def;
		return this;
	}

	public int getAtk() {
		return atk;
	}

	public EntityLiving setAtk(int atk) {
		this.atk = atk;
		return this;
	}

	public int getSatk() {
		return satk;
	}

	public EntityLiving setSatk(int satk) {
		this.satk = satk;
		return this;
	}

	public int getSdef() {
		return sdef;
	}

	public EntityLiving setSdef(int sdef) {
		this.sdef = sdef;
		return this;
	}

	public IEntityAI getAi() {
		return ai;
	}

	public EntityLiving setAi(IEntityAI ai) {
		this.ai = ai;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ai == null) ? 0 : ai.hashCode());
		result = prime * result + atk;
		result = prime * result + attackRange;
		result = prime * result + def;
		result = prime * result + health;
		result = prime * result + maxHealth;
		result = prime * result + moveRange;
		result = prime * result + satk;
		result = prime * result + sdef;
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
		EntityLiving other = (EntityLiving) obj;
		if (ai == null) {
			if (other.ai != null)
				return false;
		} else if (!ai.equals(other.ai))
			return false;
		if (atk != other.atk)
			return false;
		if (attackRange != other.attackRange)
			return false;
		if (def != other.def)
			return false;
		if (health != other.health)
			return false;
		if (maxHealth != other.maxHealth)
			return false;
		if (moveRange != other.moveRange)
			return false;
		if (satk != other.satk)
			return false;
		if (sdef != other.sdef)
			return false;
		return true;
	}
	
}
