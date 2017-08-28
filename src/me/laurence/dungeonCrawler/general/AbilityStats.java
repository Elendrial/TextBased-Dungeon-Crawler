package me.laurence.dungeonCrawler.general;

public class AbilityStats { // Name is temporary.
	
	public int maxHealth;
	public int moveRange;
	public int attackRange;
	public int def, atk, satk, sdef;
	
	public int getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	public int getMoveRange() {
		return moveRange;
	}
	public void setMoveRange(int moveRange) {
		this.moveRange = moveRange;
	}
	public int getAttackRange() {
		return attackRange;
	}
	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getSatk() {
		return satk;
	}
	public void setSatk(int satk) {
		this.satk = satk;
	}
	public int getSdef() {
		return sdef;
	}
	public void setSdef(int sdef) {
		this.sdef = sdef;
	}
	
	public AbilityStats clone(){
		AbilityStats s = new AbilityStats();
		s.maxHealth = this.maxHealth;
		s.moveRange = this.moveRange;
		s.attackRange = this.attackRange;
		s.def = this.def;
		s.atk = this.atk;
		s.satk = this.satk;
		s.sdef = this.sdef;
		return s;
	}
	
}
