package me.laurence.dungeonCrawler;

public class GameData {
	public static class Dungeon{
		public static float difficulty; // Recommend : 0.6f for easy, 1f for normal, 1.5f for hard.
		public static int floor;
		public static int lowestFloor;
		public static int currentScore;
	}
	
	public static class Global{
		public static boolean debug = true;
		public static int highScore;
		public static int lowestFloor;
	}
}
