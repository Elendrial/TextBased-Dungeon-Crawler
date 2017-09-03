package me.laurence.dungeonCrawler.inventory;

import java.util.Arrays;

import me.laurence.dungeonCrawler.items.EquipType;
import me.laurence.dungeonCrawler.items.Item;
import me.laurence.dungeonCrawler.items.equippables.ItemEquippable;

public class InventoryEquips extends Inventory {

	protected ItemEquippable[] equippedContents = new ItemEquippable[EquipType.values().length]; // Uses order from EquipType
	
	public InventoryEquips(){}
	private InventoryEquips(InventoryEquips i){
		super(i);
		
		for(ItemEquippable ie : i.equippedContents){
			if(ie!=null) this.equippedContents[ie.getArmourSlot().ordinal()] = ie.clone();
		}
	}
	
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
	
	public ItemEquippable equipItem(String s){
		for(Item i : contents){
			if(i.getName().equals(s)){
				return equipItem((ItemEquippable)i);
			}
		}
		return null;
	}
	
	public void unequipItem(ItemEquippable i){
		equippedContents[i.getArmourSlot().ordinal()] = null;
	}
	
	
	public ItemEquippable unequipItem(String s){
		for(ItemEquippable item : equippedContents){
			if(item != null) if(item.getName().equals(s)){
				unequipItem(item);
				return item;
			}
		}
		return null;
	}
	
	public void unequipItem(int i){
		equippedContents[i] = null;
	}
	
	public boolean isEquipped(Item i){
		for(Item item : equippedContents){
			if(item != null) if(item.equals(i)) return true;
		}
		return false;
	}
	
	public boolean isEquipped(String s){
		for(Item item : equippedContents){
			if(item != null) if(item.getName().equals(s)) return true;
		}
		return false;
	}
	
	public int getMaxHealth() {
		int maxHealth = 0;
		for(ItemEquippable i : equippedContents){
			maxHealth += i.getStats().getMaxHealth();
		}
		return maxHealth;
	}

	public int getMoveRange() {
		int moveRange = 0;
		for(ItemEquippable i : equippedContents){
			moveRange += i.getStats().getMoveRange();
		}
		return moveRange;
	}
	
	public int getAttackRange() {
		int attackRange = 0;
		for(ItemEquippable i : equippedContents){
			attackRange += i.getStats().getAttackRange();
		}
		return attackRange;
	}

	public int getDef() {
		int def = 0;
		for(ItemEquippable i : equippedContents){
			def += i.getStats().getDef();
		}
		return def;
	}

	public int getAtk() {
		int atk = 0;
		for(ItemEquippable i : equippedContents){
			atk += i.getStats().getAtk();
		}
		return atk;
	}

	public int getSatk() {
		int satk = 0;
		for(ItemEquippable i : equippedContents){
			satk += i.getStats().getSatk();
		}
		return satk;
	}

	public int getSdef() {
		int sdef = 0;
		for(ItemEquippable i : equippedContents){
			sdef += i.getStats().getSdef();
		}
		return sdef;
	}
	
	public ItemEquippable[] getEquippedContents() {
		return equippedContents;
	}

	public InventoryEquips clone(){
		return new InventoryEquips(this);
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
