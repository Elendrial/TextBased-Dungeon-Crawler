package me.laurence.dungeonCrawler.items;

import me.laurence.dungeonCrawler.entities.Entity;

abstract public class Item extends Entity{

	protected boolean destroyable;
	
	public Item(){
		this.charCode = 'i';
		this.canPassThrough = true;
	}
	
	@Override
	public float getSpawnChance() {return 0;}

	@Override
	public void onHit(Entity e) {
		if(destroyable) onDestroy(e);
	}

	@Override
	public void onInteract(Entity e) {
		// pickup
	}

	@Override
	public void onWalkOn(Entity e) {}

	@Override
	public void onDestroy(Entity e) {}

	public abstract void onUse(Entity e);

	public boolean isDestroyable() {
		return destroyable;
	}

	public Item setDestroyable(boolean destroyable) {
		this.destroyable = destroyable;
		return this;
	}

	
	
}
