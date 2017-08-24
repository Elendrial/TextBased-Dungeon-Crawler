package me.laurence.dungeonCrawler.inventory;

import java.util.ArrayList;

import me.laurence.dungeonCrawler.items.Item;

public abstract class Inventory {
	
	protected int maxSize;
	protected ArrayList<Item> contents = new ArrayList<Item>();
	protected String name;
	
	public boolean addItem(Item i){
		if(contents.size() < maxSize){ 
			contents.add(i);
			return true;
		}
		return false;
	}
	
	public boolean removeItem(Item i){
		if(contents.contains(i)){
			contents.remove(i);
			return true;
		}
		return false;
	}
	
	public boolean removeItem(String s){
		for(Item i : contents){
			if(i.getName().equals(s)){
				contents.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean containsItem(Item i){
		return contents.contains(i);
	}
	
	public boolean containsItem(String s){
		for(Item i : contents){
			if(i.getName().equals(s)){
				return true;
			}
		}
		return false;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
