package me.laurence.dungeonCrawler;

import java.util.ArrayList;
import java.util.Random;

import me.laurence.dungeonCrawler.entities.EntityList;
import me.laurence.dungeonCrawler.entities.living.EntityPlayer;
import me.laurence.dungeonCrawler.handlers.InputHandler;
import me.laurence.dungeonCrawler.handlers.PrintHandler;

public class DungeonCrawler {
	
	public static ArrayList<Floor> floors = new ArrayList<Floor>();
	public static Random rand = new Random();
	public static boolean running = true;
	public static EntityPlayer player = new EntityPlayer();
	public static boolean floorUpdateSkip = false;
	public static float tempDifficultyModifier = 0;
	public static int tempDifficultyLength = 0;
	
	public static void main(String[] args){
		EntityList.initList();
		InputHandler.initList();
		
		Stats.Dungeon.floor = 0;
		changeDifficulty();
		
		floors.add(new Floor(Stats.Dungeon.difficulty, 0));
		floors.get(0).entities.add(player);
		PrintHandler.printFloor(floors.get(0));
		
		gameLoop();
	}
	
	public static void gameLoop(){
		while(running){
			PrintHandler.print("What would you like to do? ");
			InputHandler.getPlayerAction();
			floors.get(Stats.Dungeon.floor).update();
		}
	}
	
	public static void gameOver(boolean survived){
		
	}
	
	public static void changeDifficulty(){
		PrintHandler.print("Would you like to play on easy, normal, or hard? ");
		String s = InputHandler.getInput();
		
		switch(s.trim().toLowerCase()){
		case "easy": Stats.Dungeon.difficulty = 0.6f; break;
		case "normal": Stats.Dungeon.difficulty = 1f; break;
		case "hard": Stats.Dungeon.difficulty = 1.5f; break;
		default: PrintHandler.println("\nInput not understood, setting difficulty to 'normal'.");
		}
		
		PrintHandler.println("All enemy values will be multiplied to " + Stats.Dungeon.difficulty + " times their standard value for future floors.");
		
	}

	public static void changeFloor(int delta){
		floors.get(Stats.Dungeon.floor).entities.remove(player);
		
		if(Stats.Dungeon.floor + delta < 0) Stats.Dungeon.floor = 0;
		else Stats.Dungeon.floor += delta;
		
		for(int i = floors.size(); i <= Stats.Dungeon.floor; i++){
			floors.add(new Floor(Stats.Dungeon.difficulty + (tempDifficultyLength > 0 ? tempDifficultyModifier : 0f), i));
			if(tempDifficultyLength != 0) tempDifficultyLength--;
		}
		
		floors.get(Stats.Dungeon.floor).entities.add(player);
		
		floorUpdateSkip = true;
		
		if(Stats.Dungeon.floor > Stats.Dungeon.lowestFloor) Stats.Dungeon.lowestFloor = Stats.Dungeon.floor;
	}
	
	public static Floor getFloor(){
		return floors.get(Stats.Dungeon.floor);
	}
	
}
