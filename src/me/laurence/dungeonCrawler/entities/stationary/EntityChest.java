package me.laurence.dungeonCrawler.entities.stationary;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.GameData;
import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.entities.living.EntityPlayer;
import me.laurence.dungeonCrawler.handlers.InputHandler;
import me.laurence.dungeonCrawler.handlers.PrintHandler;
import me.laurence.dungeonCrawler.inventory.Inventory;
import me.laurence.dungeonCrawler.items.Item;

public class EntityChest extends EntityStatic{

	protected Inventory inventory;
	
	public EntityChest(){
		this.canPassThrough = false;
		this.charCode = '=';
		this.name = "chest";
		
		this.inventory = new Inventory();
		this.inventory.setName("chest");
		this.inventory.setMaxSize(15);
	}
	
	private EntityChest(EntityChest e){
		super(e);
		this.inventory = e.inventory.clone();
	}
	
	@Override
	public float getSpawnChance(float currentDifficulty) {
		return 0;
	}

	@Override
	public EntityChest clone() {
		return new EntityChest(this);
	}

	public Inventory getInventory() {
		return inventory;
	}

	public EntityChest setInventory(Inventory inventory) {
		this.inventory = inventory;
		return this;
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
	
	public void onInteract(Entity e){
		if(e instanceof EntityPlayer){
			PrintHandler.printInventory(inventory);
			String s = InputHandler.getPlayerChestAction();
			if(s.startsWith("p ")){
				if(inventory.containsItem(s.substring(2))){
					DungeonCrawler.player.getInventory().addItem(inventory.getItem(s.substring(2)));
					inventory.removeItem(s.substring(2));
				}
				else{
					PrintHandler.println("Item " + s.substring(2) + "not found.");
					if(GameData.Global.debug) PrintHandler.println("command: " + s);
				}
			}
			else if(s.startsWith("d ")){
				Inventory inv = DungeonCrawler.player.getInventory();
				if(inv.containsItem(s.substring(2))){
					inventory.addItem(inv.getItem(s.substring(2)));
					inv.removeItem(s.substring(2));
				}
				else{
					PrintHandler.println("Item " + s.substring(2) + "not found.");
					if(GameData.Global.debug) PrintHandler.println("command: " + s);
				}
			}
			else{
				DungeonCrawler.floorUpdateSkip = true;
			}
		}
	}

}
