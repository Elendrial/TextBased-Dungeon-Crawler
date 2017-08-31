package me.laurence.dungeonCrawler.entities;

import java.util.HashMap;

import me.laurence.dungeonCrawler.DungeonCrawler;
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
		EntityGenericHostile weakSkeleton =    (EntityGenericHostile) new EntityGenericHostile().setPreferredDifficulty(1).setBaseAtk(2).setHealth(1).setBaseAttackRange(1).setBaseDef(0).setBaseSatk(0).setBaseSdef(2).setCanPassThrough(false).setCharCode('s').setName("weak skeleton");
		EntityGenericHostile warriorSkeleton = (EntityGenericHostile) new EntityGenericHostile().setPreferredDifficulty(2).setBaseAtk(3).setHealth(2).setBaseAttackRange(1).setBaseDef(2).setBaseSatk(0).setBaseSdef(5).setCanPassThrough(false).setCharCode('s').setName("warrior skeleton");
		EntityGenericHostile archerSkeleton =  (EntityGenericHostile) new EntityGenericHostile().setPreferredDifficulty(2).setBaseAtk(2).setHealth(2).setBaseAttackRange(3).setBaseDef(0).setBaseSatk(0).setBaseSdef(2).setCanPassThrough(false).setCharCode('s').setName("archer skeleton");
		EntityGenericHostile zombie =          (EntityGenericHostile) new EntityGenericHostile().setPreferredDifficulty(3).setBaseAtk(3).setHealth(2).setBaseAttackRange(1).setBaseDef(1).setBaseSatk(0).setBaseSdef(2).setCanPassThrough(false).setCharCode('z').setName("zombie");
		EntityGenericHostile ghost =           (EntityGenericHostile) new EntityGenericHostile().setPreferredDifficulty(5).setBaseAtk(5).setHealth(1).setBaseAttackRange(1).setBaseDef(0).setBaseSatk(6).setBaseSdef(10).setCanPassThrough(true).setCharCode('g').setName("ghost");
		EntityGenericHostile dragon =          (EntityGenericHostile) new EntityGenericHostile().setPreferredDifficulty(10).setBaseAtk(10).setHealth(20).setBaseAttackRange(3).setBaseDef(24).setBaseSatk(17).setBaseSdef(14).setCanPassThrough(false).setCharCode('d').setName("dragon");
		
		
		addToEntityList(new EntityPlayer());
		addToEntityList(weakSkeleton);
		addToEntityList(warriorSkeleton);
		addToEntityList(archerSkeleton);
		addToEntityList(zombie);
		addToEntityList(ghost);
		addToEntityList(dragon);
		
		
		addToEntityList(new EntityWall());
		addToEntityList(new EntityStairs());
	}
	
	public static void addToEntityList(Entity e){
		if(e instanceof EntityLiving) livingEntities.put(e.name, (EntityLiving) e);
		if(e instanceof EntityStatic) staticEntities.put(e.name, (EntityStatic) e);
	}

	private static HashMap<Float, HashMap<EntityLiving, Float>> chancesList = new HashMap<Float, HashMap<EntityLiving, Float>>();
	public static EntityLiving getRandomEntityLiving(float difficulty) {
		
		if(!chancesList.containsKey(difficulty)){
			HashMap<EntityLiving, Float> chances = new HashMap<EntityLiving, Float>();
			float total = 0, f;
			for(String s : livingEntities.keySet()){
				f= livingEntities.get(s).getSpawnChance(difficulty);
				
				chances.put(livingEntities.get(s), f);
				total = f;
			}
			
			for(EntityLiving e : chances.keySet()){
				chances.put(e, chances.get(e)/total);
			}
			
			chancesList.put(difficulty, chances);
		}
		
		final float f = DungeonCrawler.rand.nextFloat();
		float count = 0;
		for(EntityLiving e : chancesList.get(difficulty).keySet()){
			count += chancesList.get(difficulty).get(e);
			if(count >= f) return e.clone();
		}
		System.err.println("No entity found.");
		return null;
	}
	
}
