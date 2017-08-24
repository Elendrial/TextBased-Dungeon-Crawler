package me.laurence.dungeonCrawler.items.standard;

import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.handlers.PrintHandler;
import me.laurence.dungeonCrawler.items.Item;

public class ItemGeneric extends Item{

	@Override
	public void onUse(Entity e) {
		PrintHandler.println("Nothing happens.");
	}

}
