package me.laurence.dungeonCrawler.general;

public class AbilityStats { // Name is temporary.
	
	public int maxHealth = 100;
	public int moveRange = 1;
	public int attackRange = 1;
	public int def = 0, atk = 1, satk = 0, sdef = 0;
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + atk;
		result = prime * result + attackRange;
		result = prime * result + def;
		result = prime * result + maxHealth;
		result = prime * result + moveRange;
		result = prime * result + satk;
		result = prime * result + sdef;
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
		AbilityStats other = (AbilityStats) obj;
		if (atk != other.atk)
			return false;
		if (attackRange != other.attackRange)
			return false;
		if (def != other.def)
			return false;
		if (maxHealth != other.maxHealth)
			return false;
		if (moveRange != other.moveRange)
			return false;
		if (satk != other.satk)
			return false;
		if (sdef != other.sdef)
			return false;
		return true;
	}
	
}
