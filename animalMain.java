package com.company.animal_survival;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class animalMain {

    public static final Scanner input = new Scanner(System.in);
    public static final NumberFormat percent = NumberFormat.getPercentInstance();
    public static final Random rand = new Random();
    public static boolean easyMode;
    public static boolean mediumMode;
    public static boolean hardMode;
    public static String userName;
    public static boolean ratDead = false, bunnyDead = false;
    public static int dayNumber, infectedHumans;
    
    public static void main(String[]args){
        boolean flag = true;

        System.out.println("\n\nWelcome to the Animal Simulator, where you will be attempting to acheive world" +
             " domination through the use of animals. \nHit enter to continue.");
            input.nextLine();
            System.out.println("Let's get started by having you enter your name. What should we call you? ");
            userName = input.nextLine();

        while(flag){
            System.out.println("\nGreetings, " + userName + "! Would you like to simulate the rat or the bunny?");
            String choice = input.nextLine();
            //+ check for invalid choice

            chooseDifficulty();

            if(choice.equalsIgnoreCase("rat")){
                if(easyMode){
                    Rat rat1 = new Rat();
                    ratGamePlay(rat1);
                }

                else if(mediumMode){
                    Rat rat1 = new Rat(20, 70, 60, 55);
                    ratGamePlay(rat1);
                }

                else if(hardMode){
                    Rat rat1 = new Rat(15, 40, 35, 40);
                    ratGamePlay(rat1);
                }
                
                if(ratDead){
                    System.out.println("\nIn just " + dayNumber + " day(s), you were able to infect " + infectedHumans + 
                    " humans, or " + percent.format(infectedHumans/10000000) + " of Italy's population.");
                    System.out.println("\nYour rat's legacy will be remembered for centuries to come!\n\nWould you like to play again? Please type 'yes' or 'no'.");
                    String keepPlaying = input.nextLine();
                    
                    if(keepPlaying.equalsIgnoreCase("no")){
                        flag = false;
                    }

                    else if(keepPlaying.equalsIgnoreCase("yes")){
                        System.out.println("\nGood choice!");
                    }

                    while(!keepPlaying.equalsIgnoreCase("yes") || !keepPlaying.equalsIgnoreCase("no")){
                        System.out.println("\nThat's not a valid option. Please type 'yes' or 'no'. ");
                        keepPlaying = input.nextLine();
                    }  

                    
                    
                }

                else if(choice.equalsIgnoreCase("bunny")){
                
                }
                // + invalid choice for rat vs bunny
            }

        }

        /****FINAL GOODBYE MESSAGE */
        System.out.println("\n\nBYE");
    }
    

    public static void chooseDifficulty(){
        easyMode = false;
        mediumMode = false;
        hardMode = false;

        System.out.println("\nWhat difficulty level would you like to play? Enter 1 for easy, 2 for medium, and 3 for hard.");
        String choice = input.nextLine();

        if(choice.equals("1")){
            easyMode = true;
        }

        else if(choice.equals("2")){
            mediumMode = true;
        }

        else if(choice.equals("3")){
            hardMode = true;
        }
        //add the invalid option
    }

    public static void ratGamePlay(Rat rat1){
        boolean gameGoing = true;
        ratDead = false;
        rat1.ratStoryLine();

        System.out.println("\nHere are your current stats. Make sure to not get too hungry, thirsty, or cold by keeping your stats as high as possible.\n\nGood luck soldier.");
        
        while(gameGoing){
            
            if(rat1.ratDead){ //if the rat isn't alive anymore
                ratDead = true; 
                gameGoing = false;
                dayNumber = rat1.dayNumber;
                infectedHumans = (int) rat1.infectedHumans;
                
            }

            if(!rat1.ratDead){
                rat1.dayNumber++;
                System.out.println("\n\nHit enter to see your stats, and a menu of options.");
                input.nextLine();
                System.out.println(rat1.toString() + "\n\n" + rat1.menu());
                System.out.print("Choice: ");
                String option = input.nextLine();
                System.out.println();

                if(option.equals("1")){ // attempt to get food
                    rat1.randomFoodEvent();
                }
                
                else if(option.equals("2")){  //attempt to get water
                    rat1.randomWaterEvent();
                }
                
                else if(option.equals("3")){ //stay in shelter
                    rat1.randomShelterEvent();
                }
                
                else if(option.equals("4")){ //commit suicide 
                    ratDead = true;
                    rat1.ratDead = true;
                }
                
                else if(option.equals("5")){ //grow colony
                    rat1.growColony();
                }
                
                else if(option.equals("6")){ //infect human 
                    rat1.infectHumans();
                }   

                else{
                    //invalid option chosen
                }
                
            }
            
        }
    }
}
