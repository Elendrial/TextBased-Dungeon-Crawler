package me.laurence.dungeonCrawler.general;

public class AbilityStats { // Name is temporary.
	
	protected int maxHealth = 100;
	protected int moveRange = 1;
	protected int attackRange = 1;
	protected int def = 0, atk = 1, satk = 0, sdef = 0;
	protected int luck = 0;
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public AbilityStats setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
		return this;
	}
	
	public int getMoveRange() {
		return moveRange;
	}
	
	public AbilityStats setMoveRange(int moveRange) {
		this.moveRange = moveRange;
		return this;
	}
	
	public int getAttackRange() {
		return attackRange;
	}
	
	public AbilityStats setAttackRange(int attackRange) {
		this.attackRange = attackRange;
		return this;
	}
	
	public int getDef() {
		return def;
	}
	
	public AbilityStats setDef(int def) {
		this.def = def;
		return this;
	}
	
	public int getAtk() {
		return atk;
	}
	
	public AbilityStats setAtk(int atk) {
		this.atk = atk;
		return this;
	}
	
	public int getSatk() {
		return satk;
	}
	
	public AbilityStats setSatk(int satk) {
		this.satk = satk;
		return this;
	}
	
	public int getSdef() {
		return sdef;
	}
	
	public AbilityStats setSdef(int sdef) {
		this.sdef = sdef;
		return this;
	}
	
	public int getLuck() {
		return luck;
	}

	public AbilityStats setLuck(int luck) {
		this.luck = luck;
		return this;
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
		s.luck = this.luck;
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
