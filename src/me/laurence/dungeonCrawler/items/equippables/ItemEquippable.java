package me.laurence.dungeonCrawler.items.equippables;

import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.entities.living.EntityLiving;
import me.laurence.dungeonCrawler.general.AbilityStats;
import me.laurence.dungeonCrawler.items.EquipType;
import me.laurence.dungeonCrawler.items.Item;

public class ItemEquippable extends Item{

	protected EquipType armourSlot;
	protected AbilityStats stats;
	
	public ItemEquippable(){}
	
	protected ItemEquippable(ItemEquippable i) {
		super(i);
		this.armourSlot = i.armourSlot;
		this.stats = i.stats.clone();
	}


	@Override
	public void onUse(Entity e) {
		if(e instanceof EntityLiving) ((EntityLiving) e).equip(this, ((EntityLiving) e).getInventory().containsItem(this));
	}


	public EquipType getArmourSlot() {
		return armourSlot;
	}


	public ItemEquippable setArmourSlot(EquipType armourSlot) {
		this.armourSlot = armourSlot;
		return this;
	}


	public AbilityStats getStats() {
		return stats;
	}


	public ItemEquippable setStats(AbilityStats stats) {
		this.stats = stats;
		return this;
	}


	@Override
	public ItemEquippable clone() {
		return new ItemEquippable(this);
	}
	
}
