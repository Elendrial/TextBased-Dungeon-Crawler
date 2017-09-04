package me.laurence.dungeonCrawler.handlers;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import me.laurence.dungeonCrawler.GameData;

/* Definitely a shorter way of doing this, but hey, copying and pasting code I wrote/stole ages ago is nice
   It's also easier to expand this if needed.
   Could save everything, but it feels more in the roguelike spirit to have minimal saving.*/
public class FileHandler {

	private static void serialize(String path, Object obj) throws Exception {
		FileOutputStream fileOut = new FileOutputStream(path);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(obj);
		out.close();
		fileOut.close();
	}
	
	private static Object deserialize(String path) throws Exception {
		FileInputStream fileIn = new FileInputStream(path);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		Object result = in.readObject();
		in.close();
		fileIn.close();
		return result;
	}
	
	public static void loadData(){
		try {
			if(new File("gamedata.tdc").exists()){
				String[] s = ((String) deserialize("gamedata.tdc")).split(",");
				GameData.Global.highScore = Integer.parseInt(s[0]);
				GameData.Global.lowestFloor = Integer.parseInt(s[1]);
			}
			else{
				PrintHandler.println("No save data to load.");
			}
		} catch (Exception e) {
			System.err.println("Failed to load previous game data.");
			e.printStackTrace();
		}
	}
	
	public static void saveData(){
		String s = "";
		if(new File("gamedata.tdc").exists()){
			loadData();
			s += GameData.Global.highScore > GameData.Dungeon.currentScore ? GameData.Global.highScore : GameData.Dungeon.currentScore;
			s += ",";
			s += GameData.Global.lowestFloor > GameData.Dungeon.lowestFloor ? GameData.Global.lowestFloor : GameData.Dungeon.lowestFloor;
		}
		else{
			s += GameData.Dungeon.currentScore;
			s += ",";
			s += GameData.Dungeon.lowestFloor;
		}
		
		try {
			serialize("gamedata.tdc", s);
		} catch (Exception e) {
			System.err.println("Failed to save game data.");
			e.printStackTrace();
		}
	}
	
}