package me.laurence.dungeonCrawler.entities;

import java.util.HashMap;

import me.laurence.dungeonCrawler.DungeonCrawler;
import me.laurence.dungeonCrawler.entities.living.EntityGenericHostile;
import me.laurence.dungeonCrawler.entities.living.EntityLiving;
import me.laurence.dungeonCrawler.entities.living.EntityPlayer;
import me.laurence.dungeonCrawler.entities.stationary.EntityChest;
import me.laurence.dungeonCrawler.entities.stationary.EntityStairs;
import me.laurence.dungeonCrawler.entities.stationary.EntityStatic;
import me.laurence.dungeonCrawler.entities.stationary.EntityWall;


public class EntityList {
	
	public static HashMap<String, EntityLiving> livingEntities = new HashMap<String, EntityLiving>();
	public static HashMap<String, EntityStatic> staticEntities = new HashMap<String, EntityStatic>(); 
	
	public static void initList(){
		EntityGenericHostile weakSkeleton =    (EntityGenericHostile) new EntityGenericHostile().setPreferredDifficulty(1).setScore(2).setBaseAtk(2).setHealth(1).setBaseAttackRange(1).setBaseDef(0).setBaseSatk(0).setBaseSdef(2).setCanPassThrough(false).setCharCode('s').setName("weak skeleton");
		EntityGenericHostile warriorSkeleton = (EntityGenericHostile) new EntityGenericHostile().setPreferredDifficulty(2).setScore(4).setBaseAtk(3).setHealth(2).setBaseAttackRange(1).setBaseDef(2).setBaseSatk(0).setBaseSdef(5).setCanPassThrough(false).setCharCode('s').setName("warrior skeleton");
		EntityGenericHostile archerSkeleton =  (EntityGenericHostile) new EntityGenericHostile().setPreferredDifficulty(2).setScore(4).setBaseAtk(2).setHealth(2).setBaseAttackRange(3).setBaseDef(0).setBaseSatk(0).setBaseSdef(2).setCanPassThrough(false).setCharCode('s').setName("archer skeleton");
		EntityGenericHostile zombie =          (EntityGenericHostile) new EntityGenericHostile().setPreferredDifficulty(3).setScore(6).setBaseAtk(3).setHealth(2).setBaseAttackRange(1).setBaseDef(1).setBaseSatk(0).setBaseSdef(2).setCanPassThrough(false).setCharCode('z').setName("zombie");
		EntityGenericHostile ghost =           (EntityGenericHostile) new EntityGenericHostile().setPreferredDifficulty(5).setScore(8).setBaseAtk(5).setHealth(1).setBaseAttackRange(1).setBaseDef(0).setBaseSatk(6).setBaseSdef(10).setCanPassThrough(true).setCharCode('g').setName("ghost");
		EntityGenericHostile dragon =          (EntityGenericHostile) new EntityGenericHostile().setPreferredDifficulty(10).setScore(30).setBaseAtk(10).setHealth(20).setBaseAttackRange(3).setBaseDef(24).setBaseSatk(17).setBaseSdef(14).setCanPassThrough(false).setCharCode('d').setName("dragon");
		
		
		addToEntityList(new EntityPlayer());
		addToEntityList(weakSkeleton);
		addToEntityList(warriorSkeleton);
		addToEntityList(archerSkeleton);
		addToEntityList(zombie);
		addToEntityList(ghost);
		addToEntityList(dragon);
		
		
		addToEntityList(new EntityWall());
		addToEntityList(new EntityStairs());
		addToEntityList(new EntityChest());
	}
	
	public static void addToEntityList(Entity e){
		if(e instanceof EntityLiving) livingEntities.put(e.name, (EntityLiving) e);
		if(e instanceof EntityStatic) staticEntities.put(e.name, (EntityStatic) e);
	}

	private static HashMap<Float, HashMap<EntityLiving, Float>> lChancesList = new HashMap<Float, HashMap<EntityLiving, Float>>();
	private static HashMap<Float, HashMap<EntityStatic, Float>> sChancesList = new HashMap<Float, HashMap<EntityStatic, Float>>();
	
	public static EntityLiving getRandomEntityLiving(float difficulty) {
		if(!lChancesList.containsKey(difficulty)){
			HashMap<EntityLiving, Float> chances = new HashMap<EntityLiving, Float>();
			float total = 0, f;
			for(String s : livingEntities.keySet()){
				f= livingEntities.get(s).getSpawnChance(difficulty);
				
				chances.put(livingEntities.get(s), f);
				total += f;
			}
			
			for(EntityLiving e : chances.keySet()){
				chances.put(e, chances.get(e)/total);
			}
			
			lChancesList.put(difficulty, chances);
		}
		
		final float f = DungeonCrawler.rand.nextFloat();
		float count = 0;
		for(EntityLiving e : lChancesList.get(difficulty).keySet()){
			count += lChancesList.get(difficulty).get(e);
			if(count >= f) return e.clone();
		}
		
		System.err.println("No entity found.");
		return null;
	}
	
	public static EntityStatic getRandomEntityStatic(float difficulty) {
		if(!lChancesList.containsKey(difficulty)){
			HashMap<EntityStatic, Float> chances = new HashMap<EntityStatic, Float>();
			float total = 0, f;
			for(String s : staticEntities.keySet()){
				f= staticEntities.get(s).getSpawnChance(difficulty);
				
				chances.put(staticEntities.get(s), f);
				total += f;
			}
			
			for(EntityStatic e : chances.keySet()){
				chances.put(e, chances.get(e)/total);
			}
			
			sChancesList.put(difficulty, chances);
		}
		
		final float f = DungeonCrawler.rand.nextFloat();
		float count = 0;
		for(EntityStatic e : sChancesList.get(difficulty).keySet()){
			count += sChancesList.get(difficulty).get(e);
			if(count >= f) return e.clone();
		}
		
		System.err.println("No entity found.");
		return null;
	}
	
}
