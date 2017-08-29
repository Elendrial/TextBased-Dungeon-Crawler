package me.laurence.dungeonCrawler.inventory;

import java.util.Arrays;

import me.laurence.dungeonCrawler.items.EquipType;
import me.laurence.dungeonCrawler.items.Item;
import me.laurence.dungeonCrawler.items.equippables.ItemEquippable;

public class InventoryEquips extends Inventory {

	public ItemEquippable[] equippedContents = new ItemEquippable[EquipType.values().length]; // Uses order from EquipType
	
	/**
	 *  @return: The object taken off.
	 */
	public ItemEquippable equipItem(ItemEquippable i){
		int slot = i.getArmourSlot().ordinal();
		ItemEquippable i2 = equippedContents[slot];
		
		unequipItem(slot);
		equippedContents[slot] = i;
		
		return i2;
	}
	
	public void unequipItem(ItemEquippable i){
		equippedContents[i.getArmourSlot().ordinal()] = null;
	}
	
	public void unequipItem(int i){
		equippedContents[i] = null;
	}
	
	public int getMaxHealth() {
		int maxHealth = 0;
		for(ItemEquippable i : equippedContents){
			maxHealth += i.getStats().maxHealth;
		}
		return maxHealth;
	}

	public int getMoveRange() {
		int moveRange = 0;
		for(ItemEquippable i : equippedContents){
			moveRange += i.getStats().moveRange;
		}
		return moveRange;
	}
	
	public int getAttackRange() {
		int attackRange = 0;
		for(ItemEquippable i : equippedContents){
			attackRange += i.getStats().attackRange;
		}
		return attackRange;
	}

	public int getDef() {
		int def = 0;
		for(ItemEquippable i : equippedContents){
			def += i.getStats().def;
		}
		return def;
	}

	public int getAtk() {
		int atk = 0;
		for(ItemEquippable i : equippedContents){
			atk += i.getStats().atk;
		}
		return atk;
	}

	public int getSatk() {
		int satk = 0;
		for(ItemEquippable i : equippedContents){
			satk += i.getStats().satk;
		}
		return satk;
	}

	public int getSdef() {
		int sdef = 0;
		for(ItemEquippable i : equippedContents){
			sdef += i.getStats().sdef;
		}
		return sdef;
	}
	
	public InventoryEquips clone(){
		InventoryEquips e = new InventoryEquips();
		
		for(Item i : this.contents){
			e.contents.add(i.clone());
		}
		
		for(ItemEquippable i : this.equippedContents){
			if(i!=null) e.equippedContents[i.getArmourSlot().ordinal()] = i.clone();
		}
		
		e.maxSize = this.maxSize;
		e.name = this.name;
		
		return e;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(equippedContents);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryEquips other = (InventoryEquips) obj;
		if (!Arrays.equals(equippedContents, other.equippedContents))
			return false;
		return true;
	}
	
}
