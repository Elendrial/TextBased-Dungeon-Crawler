package me.laurence.dungeonCrawler.items.standard;

import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.handlers.PrintHandler;
import me.laurence.dungeonCrawler.items.Item;

public class ItemGeneric extends Item{

	public ItemGeneric(){}
	public ItemGeneric(ItemGeneric i){
		super(i);
	}
	
	@Override
	public void onUse(Entity e) {
		PrintHandler.println("Nothing happens.");
	}

	@Override
	public Item clone() {
		return new ItemGeneric(this);
	}

}
