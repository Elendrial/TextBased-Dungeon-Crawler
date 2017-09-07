package me.laurence.dungeonCrawler.items;

import java.util.HashMap;

import me.laurence.dungeonCrawler.DungeonCrawler;
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
	
	private static HashMap<Float, HashMap<Item, Float>> iChancesList = new HashMap<Float, HashMap<Item, Float>>();
	public static Item getRandomItem(float difficulty) {
		if(!iChancesList.containsKey(difficulty)){
			HashMap<Item, Float> chances = new HashMap<Item, Float>();
			float total = 0, f;
			for(String s : items.keySet()){
				f= items.get(s).getSpawnChance(difficulty);
				
				chances.put(items.get(s), f);
				total += f;
			}
			
			for(Item e : chances.keySet()){
				chances.put(e, chances.get(e)/total);
			}
			
			iChancesList.put(difficulty, chances);
		}
		
		final float f = DungeonCrawler.rand.nextFloat();
		float count = 0;
		for(Item e : iChancesList.get(difficulty).keySet()){
			count += iChancesList.get(difficulty).get(e);
			if(count >= f) return e.clone();
		}
		
		System.err.println("No entity found.");
		return null;
	}
	
	
}
