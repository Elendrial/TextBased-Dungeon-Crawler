package me.laurence.dungeonCrawler.entities;

import java.util.HashMap;

import me.laurence.dungeonCrawler.entities.living.EntityGenericHostile;
import me.laurence.dungeonCrawler.entities.living.EntityLiving;
import me.laurence.dungeonCrawler.entities.living.EntityPlayer;
import me.laurence.dungeonCrawler.entities.stationary.EntityStairs;
import me.laurence.dungeonCrawler.entities.stationary.EntityStatic;
import me.laurence.dungeonCrawler.entities.stationary.EntityWall;


public class EntityList {
	/*
	public static HashMap<Class<? extends EntityLiving>, Boolean> livingEntities = new HashMap<Class<? extends EntityLiving>, Boolean>();
	public static HashMap<Class<? extends EntityStatic>, Boolean> staticEntities = new HashMap<Class<? extends EntityStatic>, Boolean>(); 
	
	// List as false if it should not be spawned in the normal way, true if it should.
	public static void initList(){
		livingEntities.put(EntityPlayer.class, false);
		livingEntities.put(EntityBat.class, true);
		
		staticEntities.put(EntityWall.class, false);
		staticEntities.put(EntityStairs.class, false);
	}
	*/
	
	public static HashMap<String, EntityLiving> livingEntities = new HashMap<String, EntityLiving>();
	public static HashMap<String, EntityStatic> staticEntities = new HashMap<String, EntityStatic>(); 
	
	public static void initList(){
		EntityGenericHostile warriorSkeleton = (EntityGenericHostile) new EntityGenericHostile().setBaseAtk(3).setHealth(2).setBaseAttackRange(1).setBaseDef(2).setBaseSatk(0).setBaseSdef(5).setCanPassThrough(false).setCharCode('s').setName("warrior skeleton");
		EntityGenericHostile archerSkeleton = (EntityGenericHostile) new EntityGenericHostile().setBaseAtk(2).setHealth(2).setBaseAttackRange(3).setBaseDef(0).setBaseSatk(0).setBaseSdef(2).setCanPassThrough(false).setCharCode('s').setName("archer skeleton");
		EntityGenericHostile zombie = (EntityGenericHostile) new EntityGenericHostile().setBaseAtk(3).setHealth(2).setBaseAttackRange(1).setBaseDef(1).setBaseSatk(0).setBaseSdef(2).setCanPassThrough(false).setCharCode('z').setName("zombie");
		
		
		addToEntityList(new EntityPlayer());
		addToEntityList(warriorSkeleton);
		addToEntityList(archerSkeleton);
		addToEntityList(zombie);
		
		addToEntityList(new EntityWall());
		addToEntityList(new EntityStairs());
	}
	
	public static void addToEntityList(Entity e){
		if(e instanceof EntityLiving) livingEntities.put(e.name, (EntityLiving) e);
		if(e instanceof EntityStatic) staticEntities.put(e.name, (EntityStatic) e);
	}
	
}
