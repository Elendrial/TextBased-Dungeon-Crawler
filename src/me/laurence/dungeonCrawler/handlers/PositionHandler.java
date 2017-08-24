package me.laurence.dungeonCrawler.handlers;

import java.awt.Point;

public class PositionHandler {
	// TODO: Get rid of this, extend Point into a position class and add additional methods there.
	public static Point clone(Point p){
		return new Point(p.x, p.y);
	}
	
}
