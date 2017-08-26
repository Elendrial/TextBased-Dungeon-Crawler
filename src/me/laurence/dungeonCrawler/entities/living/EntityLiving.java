package me.laurence.dungeonCrawler.entities.living;

import java.awt.Point;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.ai.AIEmpty;
import me.laurence.dungeonCrawler.ai.IEntityAI;
import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.general.AbilityStats;
import me.laurence.dungeonCrawler.handlers.PrintHandler;
import me.laurence.dungeonCrawler.inventory.InventoryEquips;
import me.laurence.dungeonCrawler.items.equippables.ItemEquippable;

abstract public class EntityLiving extends Entity{
	protected AbilityStats stats;
	protected IEntityAI ai = new AIEmpty();
	protected InventoryEquips inventory = (InventoryEquips) new InventoryEquips().setMaxSize(5);
	// TODO: Statuses
	// TODO: Change how health is stored.
	
	public void attack(Point position){
		DungeonCrawler.getFloor().getEntityAt(position).onHit(this);
	}
	
	@Override
	public void onHit(Entity e) {
		if(e instanceof EntityLiving){
			stats.health -= (((EntityLiving) e).getAtk() - this.getDef());
			PrintHandler.println(this.getName() + " was hit, health now: " + this.getHealth());
			
			if(stats.health <= 0) destroy(e);
		}
	}
	
	public void onDestroy(Entity e){};
	public void onInteract(Entity e) {}
	public void onWalkOn(Entity e) {}
	
	public void equip(ItemEquippable i, boolean fromInventory){
		if(fromInventory) inventory.removeItem(i);
		ItemEquippable i2 = inventory.equipItem(i);
		if(i2 != null) inventory.addItem(i2);
	}
	
	public int getMaxHealth() {
		return stats.maxHealth;
	}

	public EntityLiving setMaxHealth(int maxHealth) {
		stats.maxHealth = maxHealth;
		return this;
	}

	public int getHealth() {
		return stats.health;
	}

	public EntityLiving setHealth(int health) {
		stats.health = health > stats.maxHealth ? stats.maxHealth : health;
		return this;
	}

	public int getMoveRange() {
		return stats.moveRange;
	}

	public EntityLiving setMoveRange(int moveRange) {
		stats.moveRange = moveRange;
		return this;
	}

	public int getAttackRange() {
		return stats.attackRange;
	}

	public EntityLiving setAttackRange(int attackRange) {
		stats.attackRange = attackRange;
		return this;
	}

	public int getDef() {
		return stats.def;
	}

	public EntityLiving setDef(int def) {
		stats.def = def;
		return this;
	}

	public int getAtk() {
		return stats.atk;
	}

	public EntityLiving setAtk(int atk) {
		stats.atk = atk;
		return this;
	}

	public int getSatk() {
		return stats.satk;
	}

	public EntityLiving setSatk(int satk) {
		stats.satk = satk;
		return this;
	}

	public int getSdef() {
		return stats.sdef;
	}

	public EntityLiving setSdef(int sdef) {
		stats.sdef = sdef;
		return this;
	}

	public IEntityAI getAi() {
		return ai;
	}

	public EntityLiving setAi(IEntityAI ai) {
		this.ai = ai;
		return this;
	}

	public InventoryEquips getInventory() {
		return inventory;
	}

	public EntityLiving setInventory(InventoryEquips inventory) {
		this.inventory = inventory;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ai == null) ? 0 : ai.hashCode());
		result = prime * result + stats.atk;
		result = prime * result + stats.attackRange;
		result = prime * result + stats.def;
		result = prime * result + stats.health;
		result = prime * result + stats.maxHealth;
		result = prime * result + stats.moveRange;
		result = prime * result + stats.satk;
		result = prime * result + stats.sdef;
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
		if (stats.atk != other.stats.atk)
			return false;
		if (stats.attackRange != other.stats.attackRange)
			return false;
		if (stats.def != other.stats.def)
			return false;
		if (stats.health != other.stats.health)
			return false;
		if (stats.maxHealth != other.stats.maxHealth)
			return false;
		if (stats.moveRange != other.stats.moveRange)
			return false;
		if (stats.satk != other.stats.satk)
			return false;
		if (stats.sdef != other.stats.sdef)
			return false;
		return true;
	}
	
}
