// Assignment #: 5
//         Name: Joel Hudgens
//    StudentID: 1224491216
//      Lecture: T, Th 10:30 AM

import java.text.NumberFormat; //for NumberFormat


//Fighter Hero which inherits PlayerEntity
public class Fighter extends PlayerEntity {
	private double armor;
	private int maxAttack;
	private boolean isRanged;
	NumberFormat percentFormat = NumberFormat.getPercentInstance();

	public Fighter(double health, String name, int stamina, int attack, String weapon, boolean isRanged) {
		super(health, name, stamina, attack, weapon);
		this.isRanged = isRanged;

		if (isRanged == true) {
			armor = 0.25;
			maxAttack = 125;
		} else {
			armor = 0.5;
			maxAttack = 100;
		}
	}

	//computes combat power
	public void computeCombatPower() {
		if (maxAttack <= attack) {
			combatPoints = (int) ((maxAttack + health) * (1 - armor));
		} else {
			combatPoints = (int) ((attack + health) * (1 - armor));
		}

		if ((weapon.toUpperCase().equals("ROCK")) && (isRanged == true)) {
			combatPoints += 50;
		}

		else if ((weapon.toUpperCase().equals("SWORD")) && (isRanged == false)) {
			combatPoints *= 2;
		}

	}
	
	//overwrites PlayerEntity.toString()
	public String toString() {
		String output = "\nFighter Hero:\t\t";

		if (isRanged == true) {
			output += "Ranged Type\n";
		} else {
			output += "Melee Type\n";
		}

		output += super.toString();
		output += "Armor:\t\t\t" + percentFormat.format(armor);

		return output;
	}
}
