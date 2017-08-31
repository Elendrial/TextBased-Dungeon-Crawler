package me.laurence.dungeonCrawler.handlers;

import java.awt.Point;
import java.util.HashMap;
import java.util.Scanner;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.GameData;
import me.laurence.dungeonCrawler.entities.Entity;
import me.laurence.dungeonCrawler.entities.living.EntityPlayer;
import me.laurence.dungeonCrawler.entities.stationary.EntityWall;
import me.laurence.dungeonCrawler.general.Floor;
import me.laurence.dungeonCrawler.items.Item;
import me.laurence.dungeonCrawler.items.equippables.ItemEquippable;

public class InputHandler {
	private static Scanner scan = new Scanner(System.in);
	public static HashMap<String, String> commandDesc = new HashMap<String, String>();
	
	public static String getInput(){
		return scan.nextLine();
	}

	//TODO: Tidy this up, maybe split each into a method? Probably just put the point stuff in a method.
	private static String helpString = "Unknown command, type '?' for help.";
	public static void getPlayerAction() {
		PrintHandler.print("\nWhat would you like to do? ");
		String s = scan.nextLine().trim().toLowerCase();
		while(!commandDesc.containsKey(s.split(" ")[0])){
			PrintHandler.println(helpString);
			s = scan.nextLine();
		}
		
		try{
			switch(s.split(" ")[0]){
			case "?":
				PrintHandler.printHelp();
				getPlayerAction();
				return;
			
			case "stats":
				PrintHandler.printStats();
				getPlayerAction();
				return;
			
			case "mv":
				if(s.split(" ").length > 0){
					char[] s2 = s.split(" ")[1].toCharArray();
					EntityPlayer p = DungeonCrawler.player;
					for(int i = 0; i < s2.length && i < p.getBaseMoveRange(); i++){
						switch(s2[i]){
						case 'u': p.moveBy(0, -1); break;
						case 'd': p.moveBy(0, 1); break;
						case 'r': p.moveBy(1, 0); break;
						case 'l': p.moveBy(-1, 0); break;
						}
					}
				}
				else{
					PrintHandler.println(helpString);
					getPlayerAction();
				}
				return;
			
			case "i":
				if(s.split(" ").length > 0){
					char[] s2 = s.split(" ")[1].toCharArray();
					Floor f = DungeonCrawler.getFloor();
					Point p = new Point(DungeonCrawler.player.getPosition());
					
					switch(s2[0]){
					case 'u': p.translate(0, -1); break;
					case 'd': p.translate(0, 1); break;
					case 'r': p.translate(1, 0); break;
					case 'l': p.translate(-1, 0); break;
					}
					Entity e = f.getEntityAt(p);
					if(e != null) e.onInteract(DungeonCrawler.player);
					else{
						PrintHandler.println("There is nothing there... {" + p.toString() + "}");
						getPlayerAction();
					}
				}
				else{
					PrintHandler.println(helpString);
					getPlayerAction();
				}
				return;
				
			case "matk":
				if(s.split(" ").length > 0){
					char[] s2 = s.split(" ")[1].toCharArray();
					Floor f = DungeonCrawler.getFloor();
					Point p = new Point(DungeonCrawler.player.getPosition());
					
					switch(s2[0]){
					case 'u': p.translate(0, -1); break;
					case 'd': p.translate(0, 1); break;
					case 'r': p.translate(1, 0); break;
					case 'l': p.translate(-1, 0); break;
					}
					Entity e = f.getEntityAt(p);
					if(e != null) e.onHit(DungeonCrawler.player);
					else PrintHandler.println("There is nothing there... {" + p.toString() + "}");
				}
				else{
					PrintHandler.println(helpString);
					getPlayerAction();
				}
				return;
			
			case "inv":
				PrintHandler.println("Inventory:");
				for(Item i : DungeonCrawler.player.getInventory().getContents()){
					PrintHandler.println(i.getName());
				}
				
				PrintHandler.println("\nEquipped Items:");
				for(ItemEquippable i : DungeonCrawler.player.getInventory().getEquippedContents()){
					if(i != null) PrintHandler.println(i.getName());
				}
				getPlayerAction();
				return;
			
			case "equip":
				if(DungeonCrawler.player.getInventory().containsItem(s.substring(6))){
					DungeonCrawler.player.equip(s.substring(6), true);
				}
				else{
					PrintHandler.println("You do not currently have '" + s.substring(6) + "' in your inventory.");
					getPlayerAction();
				}
				return;
				
			case "#list":
				for(Entity e : DungeonCrawler.getFloor().entities){
					if(!(e instanceof EntityWall)) PrintHandler.printEntityInfo(e);
				}
				getPlayerAction();
				return;
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
			PrintHandler.println(helpString);
			getPlayerAction();
		}
	}
	
	public static boolean getPlayerConfirmation(String st){
		PrintHandler.print(st);
		String s = scan.next().trim().toLowerCase();
		switch(s){
		case "y":
		case "yes":
		case "true":
		case "ye":
			return true;
		}
		return false;
	}
	
	public static void initList(){
		commandDesc.put("stats", "Print stats for this run");
		commandDesc.put("mv", "Move in l/r/d/u directions - allows for multiple moves in 1 turn, eg1: 'mv l', eg2: 'mv rrurd'");
		commandDesc.put("i", "Interact in l/r/d/u direction.");
		commandDesc.put("matk", "Melee Attack in l/r/d/u direction.");
	//	commandDesc.put("ratk", "Ranged attack in l/r/d/u direction.");
	//	commandDesc.put("satk", "Spell Attack in l/r/d/u direction.");
		commandDesc.put("?", "Show this help menu.");
		commandDesc.put("inv", "Display your inventory.");
		commandDesc.put("equip", "Equip \"x\" item from your inventory");
		
		if(GameData.Global.debug) commandDesc.put("#list", "Lists all entities & their positions");
	}
	
}
