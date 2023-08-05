// Assignment #: 5
//         Name: Joel Hudgens
//    StudentID: 1224491216
//      Lecture: T, Th 10:30 AM
//  Description: This Assignment has a playerEntity, and two child classes of PlayerEntity
//The player parser creates objects of the correct type based on the input
//The Main method has a switch case which interacts with the classes to create certain functionalities

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList

//This class has a switch statement to create a main menu
//This menu allows user to choose different functions to do with their heroes
public class Assignment5 {
    public static void main(String[] args){
        char input;
        String line;
        String inputInfo;

        // ArrayList used to store the hero objects
        ArrayList<PlayerEntity> playerList = new ArrayList<>();

        try{
            System.out.println("Welcome to the battle stats simulator!");
            printMenu();

            // create a BufferedREader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do{
                System.out.println("\nWhat action would you like to perform?");
                line = stdin.readLine().trim();
                input = line.charAt(0);
                input = Character.toUpperCase(input);
                if(line.length() == 1){
                    switch (input){
                    
                        case 'A': // add hero to the guild
                            System.out.println("Please enter your hero stats:");
                            inputInfo = stdin.readLine().trim();
                            /*************************************************************************************************
                            **  ADD code here to create a hero object (child of PlayerEntity) and add it to the player list **
                            **************************************************************************************************/
                            PlayerEntity hero;
                            hero = PlayerParser.parseNewPlayer(inputInfo);
                            playerList.add(hero);
                            
                            break;

                        case 'C': // calculate combat points
                            /**************************************************************************
                            **  ADD code here to compute the combat power for all heroes in the list **
                            ***************************************************************************/
                        	for (int i = 0; i < playerList.size(); i++) {
                        		playerList.get(i).computeCombatPower();
                        	}
                            System.out.println("Combat points computed");
                            break;

                        case 'D': // how many heroes have combat points equal to or larger than a user-defined value
                            System.out.print("Please enter a minimum combat points you want to calculate:\n");
                            inputInfo = stdin.readLine().trim();
                            int min = Integer.parseInt(inputInfo);
                            int count = 0;
                            /********************************************************************************************************
                            **  ADD code here to count how many heroes in the list have combat points equal to or larger than input**
                            *********************************************************************************************************/
                            for (int i = 0; i < playerList.size();  i++) {
                            	if (playerList.get(i).combatPoints > min) {
                            		count++;
                            	}
                            }
                            
                            System.out.println("The number of heroes with " + min
                                    + " combat points or more is: " + count);
                            break;

                        case 'L': // list heroes
                            /***********************************************************
                            **  ADD code here to print all heroes in the list 
                            **  If the list is empty print "No heroes in guild yet.\n"
                            ************************************************************/
                        	if(playerList.size() == 0) {
                        		System.out.println("No heroes in guild yet.\n");
                        	}
                        	else {
                        		for (int i = 0; i < playerList.size(); i++) {
                        			System.out.println(playerList.get(i).toString());
                            	}
                        	}
                        	
                            break;

                        case 'Q':
                            break;

                        case '?':
                            printMenu();
                            break;

                        default:
                            System.out.print("Unknown action\n");
                            break;
                    }
                }
                else
                    System.out.println("Unknown action");

            }while (input != 'Q');
            System.out.println("Thanks for playing!");
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
    }


    public static void printMenu(){
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd Hero\n" +
                "C\t\tCompute Combat Points\n" +
                "D\t\tCount Heroes with Minimum Combat Points\n" +
                "L\t\tList Heroes\n" +
                "Q\t\tQuit\n" +
                "?\t\tDisplay Help\n\n");
    }
}
