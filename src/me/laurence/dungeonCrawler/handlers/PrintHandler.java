package me.laurence.dungeonCrawler.handlers;

import me.laurence.dungeonCrawler.Floor;
import me.laurence.dungeonCrawler.entities.Entity;

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
		// TODO Auto-generated method stub
	}
	
}
