package me.laurence.dungeonCrawler.handlers;

import java.awt.Point;

public class PositionHandler {
	
	public static Point clone(Point p){
		return new Point(p.x, p.y);
	}
	
}
