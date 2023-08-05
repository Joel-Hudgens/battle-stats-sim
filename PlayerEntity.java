// Assignment #: 5
//         Name: Joel Hudgens
//    StudentID: 1224491216
//      Lecture: T, Th 10:30 AM

//This Class is a a parent class for Fighter and Mage to Inherit
abstract class PlayerEntity {
	
	protected double health;
	protected String entityName;
	protected int stamina;
	protected int attack;
	protected int combatPoints;
	protected String weapon;
	
	//constructor
	public PlayerEntity(double health, String entityName, int stamina, int attack, String weapon) {
		this.health = health;
		this.entityName = entityName;
		this.stamina = stamina;
		this.attack = attack;
		this.weapon = weapon;
		combatPoints = 0;
	}
	//getter
	public int getCombatPoints() {
		return combatPoints;
	}
	
	//Returns a formatted string of all player info data
	public String toString() {
		String output = "Hero name:\t\t" + entityName + "\n";
		output += "Current Health:\t\t" + health + "\n";
		output += "Stamina:\t\t" + stamina + "\n";
		output += "Attack Damage:\t\t" + attack +"\n";
		output += "Weapon:\t\t\t" + weapon + "\n";
		output += "Current Combat Points:\t" + combatPoints + "\n";
		
		return output;
	}
	//All child classes must have a version of this method
	public abstract void computeCombatPower();
}


