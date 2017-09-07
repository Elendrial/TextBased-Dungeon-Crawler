package me.laurence.dungeonCrawler.entities.stationary;

import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.entities.living.EntityPlayer;
import me.laurence.dungeonCrawler.handlers.PrintHandler;

abstract public class EntityStatic extends Entity{

	public EntityStatic(){}
	public EntityStatic(EntityStatic e) {super(e);}

	@Override
	public void onHit(Entity e) {
		if(e instanceof EntityPlayer) PrintHandler.println("You hit the " + this.name.toLowerCase() + "... Nothing happened.");
	}

	@Override
	public void onInteract(Entity e) {
		if(e instanceof EntityPlayer) PrintHandler.println("You tried interacting with the " + this.name.toLowerCase() + "... Nothing happened.");
	}

	public void onWalkOn(Entity e) {}
	public void onDestroy(Entity e){}
	
	abstract public EntityStatic clone();
	
}
