package me.laurence.dungeonCrawler.handlers;

import me.laurence.dungeonCrawler.GameData;
import me.laurence.dungeonCrawler.GameData.Dungeon;
import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.general.Floor;

public class PrintHandler {
	
	public static void print(Object s){
		System.out.print(s);
	}
	
	public static void println(Object s){
		System.out.println(s);
	}
	
	public static void printFloor(Floor f){
		char[][] s = new char[f.dimensions.y][f.dimensions.x];
		
		for(int i = 0; i < f.dimensions.y; i++) for(int j = 0; j < f.dimensions.x; j++) s[i][j] = '.';
		
		for(Entity e : f.entities){
			s[e.getPosition().y][e.getPosition().x] = e.getCharCode();
		}
		
		println("\n");
		for(char[] c : s){
			for(char c2 : c) print(c2);
			println("");
		}
	}

	public static void printHelp() {
		for(String s : InputHandler.commandDesc.keySet()){
			println(s + "\t:\t" + InputHandler.commandDesc.get(s));
		}
	}
	
	public static void printStats(){
		println("Difficulty\t:\t" + GameData.Dungeon.difficulty);
		println("Current Floor\t:\t" + GameData.Dungeon.floor);
		println("Lowest Floor\t:\t" + GameData.Dungeon.lowestFloor);
	}
	
}
