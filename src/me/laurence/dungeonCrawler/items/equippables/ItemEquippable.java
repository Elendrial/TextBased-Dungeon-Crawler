package me.laurence.dungeonCrawler.items.equippables;

import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.entities.living.EntityLiving;
import me.laurence.dungeonCrawler.items.EquipType;
import me.laurence.dungeonCrawler.items.Item;

public class ItemEquippable extends Item{

	public EquipType armourSlot;
	
	
	
	@Override
	public void onUse(Entity e) {
		if(e instanceof EntityLiving) ((EntityLiving) e).equip(this, ((EntityLiving) e).getInventory().containsItem(this));
	}
	
	
	
}
