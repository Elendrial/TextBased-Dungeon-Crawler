package me.laurence.dungeonCrawler;

import java.util.ArrayList;
import java.util.Random;

import me.laurence.dungeonCrawler.entities.EntityList;
import me.laurence.dungeonCrawler.entities.living.EntityPlayer;
import me.laurence.dungeonCrawler.general.Floor;
import me.laurence.dungeonCrawler.handlers.FileHandler;
import me.laurence.dungeonCrawler.handlers.InputHandler;
import me.laurence.dungeonCrawler.handlers.PrintHandler;
import me.laurence.dungeonCrawler.items.ItemList;

public class DungeonCrawler {
	
	public static ArrayList<Floor> floors = new ArrayList<Floor>();
	public static Random rand = new Random();
	public static boolean running = true;
	public static EntityPlayer player = new EntityPlayer();
	public static boolean floorUpdateSkip = false;
	public static float tempDifficultyModifier = 0;
	public static int tempDifficultyLength = 0;
	
	public static void main(String[] args){
		FileHandler.loadData();
		
		EntityList.initList();
		ItemList.initList();
		InputHandler.initList();
		
		GameData.Dungeon.floor = 0;
		changeDifficulty();
		
		floors.add(new Floor(GameData.Dungeon.difficulty, 0));
		floors.get(0).entities.add(player);
		
		PrintHandler.printFloor(floors.get(0));
		
		gameLoop();
	}
	
	public static void gameLoop(){
		while(running){
			InputHandler.getPlayerAction();
			floors.get(GameData.Dungeon.floor).update();
		}
	}
	
	public static void gameOver(boolean survived){
		FileHandler.saveData();
		System.exit(0);
	}
	
	public static void changeDifficulty(){
		PrintHandler.print("Would you like to play on easy, normal, or hard? ");
		String s = InputHandler.getInput();
		
		switch(s.trim().toLowerCase()){
		case "easy": GameData.Dungeon.difficulty = 0.6f; break;
		case "normal": GameData.Dungeon.difficulty = 1f; break;
		case "hard": GameData.Dungeon.difficulty = 1.5f; break;
		default: 
			PrintHandler.println("\nInput not understood, setting difficulty to 'normal'.");
			GameData.Dungeon.difficulty = 1f; break;
		}
		
		PrintHandler.println("All enemy values will be multiplied to " + GameData.Dungeon.difficulty + " times their standard value for future floors.");
		
	}

	public static void changeFloor(int delta){
		floors.get(GameData.Dungeon.floor).entities.remove(player);
		
		if(GameData.Dungeon.floor + delta < 0) GameData.Dungeon.floor = 0;
		else GameData.Dungeon.floor += delta;
		
		for(int i = floors.size(); i <= GameData.Dungeon.floor; i++){
			floors.add(new Floor(GameData.Dungeon.difficulty + (tempDifficultyLength > 0 ? tempDifficultyModifier : 0f), i));
			if(tempDifficultyLength != 0) tempDifficultyLength--;
		}
		
		floors.get(GameData.Dungeon.floor).entities.add(player);
		
		floorUpdateSkip = true;
		
		if(GameData.Dungeon.floor > GameData.Dungeon.lowestFloor) GameData.Dungeon.lowestFloor = GameData.Dungeon.floor;
	}
	
	public static Floor getFloor(){
		return floors.get(GameData.Dungeon.floor);
	}
	
}
