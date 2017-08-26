package me.laurence.dungeonCrawler.inventory;

import me.laurence.dungeonCrawler.items.EquipType;
import me.laurence.dungeonCrawler.items.equippables.ItemEquippable;

public class InventoryEquips extends Inventory {

	public ItemEquippable[] equippedContents = new ItemEquippable[EquipType.values().length]; // Uses order from EquipType
	
	/**
	 *  @return: The object taken off.
	 */
	public ItemEquippable equipItem(ItemEquippable i){
		int slot = i.armourSlot.ordinal();
		ItemEquippable i2 = equippedContents[slot];
		
		unequipItem(slot);
		equippedContents[slot] = i;
		
		return i2;
	}
	
	public void unequipItem(ItemEquippable i){
		equippedContents[i.armourSlot.ordinal()] = null;
	}
	
	public void unequipItem(int i){
		equippedContents[i] = null;
	}
	
}
