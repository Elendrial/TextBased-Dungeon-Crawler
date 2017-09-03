package me.laurence.dungeonCrawler.inventory;

import java.util.ArrayList;

import me.laurence.dungeonCrawler.items.Item;

public class Inventory {
	
	protected int maxSize;
	protected ArrayList<Item> contents = new ArrayList<Item>();
	protected String name;
	
	public Inventory(){}
	public Inventory(Inventory i){
		this.maxSize = i.maxSize;
		this.name = i.name;
		
		for(Item it : this.contents){
			this.contents.add(it.clone());
		}
	}
	
	public boolean addItem(Item i){
		if(contents.size() < maxSize){ 
			contents.add(i);
			return true;
		}
		return false;
	}
	
	public Inventory addUncheckedItem(Item i){
		if(contents.size() < maxSize){ 
			contents.add(i);
		}
		return this;
	}
	
	public Item getItem(String s){
		for(Item i : contents){
			if(i.getName().equals(s)){
				return i;
			}
		}
		return null;
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

	public Inventory setMaxSize(int maxSize) {
		this.maxSize = maxSize;
		return this;
	}

	public String getName() {
		return name;
	}

	public Inventory setName(String name) {
		this.name = name;
		return this;
	}
	
	public ArrayList<Item> getContents(){
		return this.contents;
	}

	public Inventory clone(){
		return new Inventory(this);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + maxSize;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (maxSize != other.maxSize)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
