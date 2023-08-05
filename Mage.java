// Assignment #: 5
//         Name: Joel Hudgens
//    StudentID: 1224491216
//      Lecture: T, Th 10:30 AM

//Fighter Hero which inherits PlayerEntity
import java.text.NumberFormat; //for NumberFormat


public class Mage extends PlayerEntity{
	private double mana;
	NumberFormat percentFormat = NumberFormat.getPercentInstance();
	
	
	public Mage(double health, String name, int stamina, int attack, String weapon, double mana) {
		super(health,name,stamina,attack,weapon);
		
		this.mana = mana;
	}
	//computes combat power
	public void computeCombatPower() {
		combatPoints = (int) ((attack + health) * (1 + mana));
		
		if (weapon.toUpperCase().equals("STAFF")) {
			combatPoints += 30;
		}
	}
	
	//overwrites PlayerEntity.toString()
	public String toString() {
		String output = "\nMage Hero:\n";
		output += super.toString();
		output += "Mana:\t\t\t" + percentFormat.format(mana);
		
		return output;
	}
	
}
