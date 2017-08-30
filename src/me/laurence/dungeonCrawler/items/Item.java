package me.laurence.dungeonCrawler.items;

import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.entities.living.EntityLiving;

abstract public class Item extends Entity{

	protected boolean destroyable;
	
	public Item(){
		this.charCode = 'i';
		this.canPassThrough = true;
	}
	
	protected Item(Item i){
		this.canPassThrough = i.canPassThrough;
		this.charCode = i.charCode;
		this.destroyable = i.destroyable;
		this.name = i.name;
		this.position = i.position;
	}
	
	@Override
	public float getSpawnChance() {return 0;}

	@Override
	public void onHit(Entity e) {
		if(destroyable) onDestroy(e);
	}

	@Override
	public void onInteract(Entity e) {
		if(e instanceof EntityLiving){
			((EntityLiving) e).getInventory().addItem(this);
			this.destroy(e);
		}
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

	abstract public Item clone();
	
}
