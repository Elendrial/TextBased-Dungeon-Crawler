package me.laurence.dungeonCrawler.items.food;

import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.entities.living.EntityLiving;
import me.laurence.dungeonCrawler.handlers.PrintHandler;
import me.laurence.dungeonCrawler.items.Item;

public class ItemFood extends Item{

	public ItemFood(){
		super();
		this.charCode = 'f';
	}
	
	
	protected ItemFood(ItemFood i) {
		super(i);
		this.healthGained = i.healthGained;
	}
	
	protected int healthGained;
	
	@Override
	public void onUse(Entity e) {
		if(e instanceof EntityLiving){
			((EntityLiving) e).setHealth(((EntityLiving) e).getHealth() + healthGained);
			PrintHandler.println(e.getName() + " used " + this.getName());
		}
	}

	public int getHealthGained() {
		return healthGained;
	}

	public void setHealthGained(int healthGained) {
		this.healthGained = healthGained;
	}
	
	@Override
	public ItemFood clone() {
		return new ItemFood(this);
	}
	
	
}
