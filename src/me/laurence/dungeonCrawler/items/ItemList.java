package me.laurence.dungeonCrawler.items;

import java.util.HashMap;

import me.laurence.dungeonCrawler.general.AbilityStats;
import me.laurence.dungeonCrawler.items.equippables.ItemEquippable;
import me.laurence.dungeonCrawler.items.food.ItemFood;

public class ItemList {
	
	public static HashMap<String, Item> items = new HashMap<String, Item>();
	
	public static void initList(){
		ItemEquippable weakHelm = (ItemEquippable) new ItemEquippable().setStats(new AbilityStats().setDef(2)).setArmourSlot(EquipType.HEAD).setName("weak helmet");
		ItemFood chicken = (ItemFood) new ItemFood().setHealthGained(2).setName("chicken");
		
		addToItemList(weakHelm);
		addToItemList(chicken);
	}
	
	public static void addToItemList(Item i){
		items.put(i.getName(), i);
	}
	
}
