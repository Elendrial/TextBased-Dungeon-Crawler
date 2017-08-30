package me.laurence.dungeonCrawler.items;

import java.util.HashMap;

import me.laurence.dungeonCrawler.general.AbilityStats;
import me.laurence.dungeonCrawler.items.equippables.ItemEquippable;

public class ItemList {
	
	public static HashMap<String, Item> items = new HashMap<String, Item>();
	
	public static void initList(){
		ItemEquippable weakHelm = (ItemEquippable) new ItemEquippable().setStats(new AbilityStats().setDef(2)).setArmourSlot(EquipType.HEAD).setName("weak helmet");
		
		addToItemList(weakHelm);
	}
	
	public static void addToItemList(Item i){
		items.put(i.getName(), i);
	}
	
}
