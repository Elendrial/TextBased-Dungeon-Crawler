package me.laurence.dungeonCrawler.entities.stationary;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.inventory.Inventory;
import me.laurence.dungeonCrawler.items.Item;

public class EntityChest extends EntityStatic{

	protected Inventory inventory;
	
	public EntityChest(){
		this.canPassThrough = false;
		this.charCode = '=';
		this.name = "Chest";
		
		this.inventory = new Inventory();
		this.inventory.setName("Chest Inventory");
		this.inventory.setMaxSize(15);
	}
	
	private EntityChest(EntityChest e){
		this.inventory = e.inventory.clone();
	}
	
	@Override
	public float getSpawnChance(float currentDifficulty) {
		return 0;
	}

	@Override
	public Entity clone() {
		return new EntityChest(this);
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void onDestroy(Entity e){
		final int extra = DungeonCrawler.rand.nextInt(DungeonCrawler.player.getLuck());
		Item j;
		for(int i = 0; i < 1 + extra && i < inventory.getContents().size(); i++){ // the 1 is arbitrary
			j = inventory.getContents().get(DungeonCrawler.rand.nextInt(inventory.getContents().size()));
			DungeonCrawler.getFloor().entities.add(j.clone());
			inventory.removeItem(j);
		}
	}

}
