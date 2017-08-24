package me.laurence.dungeonCrawler.items;

public enum EquipType {
	// Armour
	HEAD,
	CHEST,
	LEGS,
	FEET,
	HAND,
	// Weapons
	LEFTHOLD,
	RIGHTHOLD,
	// Misc
	NECK,
	FINGER1,   // For the current Equip system, there is a definitive difference between fingers. I might be able to work around this somewhere else so it's not an issue.
	FINGER2,
	QUIVER,
	NONE
}
