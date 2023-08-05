// Assignment #: 5
//         Name: Joel Hudgens
//    StudentID: 1224491216
//      Lecture: T, Th 10:30 AM

//This Class contains one method that determines which type of player entity needs
//to be created based off the input, then creates it
public class PlayerParser {

	
	public static PlayerEntity parseNewPlayer(String lineToParse) {
		
		String[] heroVariables = lineToParse.split("/");
		
		double health = Double.parseDouble(heroVariables[1]);
        int stamina = Integer.parseInt(heroVariables[3]);
        int attack = Integer.parseInt(heroVariables[4]);
  
        if (heroVariables[0].toUpperCase().equals("FIGHTER")) {
        	
        	boolean isRanged;	
        	if ((heroVariables[6].toUpperCase()).equals("RANGE")) {
        		isRanged = true;
        	}
        	else if (heroVariables[6].toUpperCase().equals("MELEE")) {
        		isRanged = false;
        	}
        	else {
        		isRanged = true;
        	}
        	
        	return new Fighter(health, heroVariables[2],stamina,attack,heroVariables[5],isRanged);
        }
        	
        else if ((heroVariables[0].toUpperCase()).equals("MAGE")) {
        	double mana = Double.parseDouble(heroVariables[6]);
        	
        	return new Mage(health, heroVariables[2],stamina,attack,heroVariables[5],mana);
        
        	}
        return null;
	}
}
