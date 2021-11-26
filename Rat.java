package com.company.animal_survival;

import java.util.Scanner;

public class Rat extends Animal{
    private static final Scanner input = new Scanner(System.in);
    long infectedHumans;
    private long colonySize;
    boolean ratDead;
    public Rat(){
        super();
        infectedHumans = 0;
        colonySize = 1;
        ratDead = false;
    }

    public Rat(int a, int b, int c, int d){
        super(a,b,c,d);
        infectedHumans = 0;
        colonySize = 1;
        ratDead = false;
    }

    public String menu(){
        return super.menu() + "\n5. Grow colony \n6. Infect human with the plague"; 

    }

    public void randomFoodEvent(){ //option 1
        int random = super.randomNumber(1,50);
        if(random == 1){ //rat dies 1
            System.out.println("\nWhile scurrying around in the streets of Venice, you were struck and killed by a wagon!");
            ratDead = true;
        }

        else if(random == 2){
            System.out.println("\nA rat from another colony stole all your food and you starved to death!");
            hunger = 0;
            ratDead = true;
        }

        else if(random >= 3 && random <= 9){
            System.out.println("\nWhile out looking for food, you befriended a mouse instead!");
            changeHappiness(5, 18);
            changeHunger(-5,0);
            changeThirst(-5,0);
        }

        else if(random >= 10 && random <= 20){ //rat actually finds food
            System.out.println("\nYou managed to find some dried berries and nuts!");
            changeHunger(1, 20);
            changeThirst(-5,0);
            changeHappiness(10, 30);
        }
        else if(random >=21 && random <= 30){
            System.out.println("\nAlthough you were looking for food, you found an abundance of water.");
            changeThirst(1,30);
            changeHunger(-5,0);
            changeHappiness(10, 30);
        }

        else if(random >=31 && random <= 35){
            System.out.println("\nYou managed to find both food and water! Lucky you!");
            changeHunger(5,15);
            changeThirst(5,15);
            changeHappiness(30, 45);
        }
        else if(random == 36){
            System.out.println("Y\nour mate has left you. You are heartbroken. Keep your head up, soldier.");
            changeHappiness(-30, -5);
            changeHunger(-5,0);
            changeThirst(-5,0);
        }
        else if(random > 36){
            System.out.println("\nYou were not able to find food nor water. Sucks for you.");
            changeHunger(-5,0);
            changeThirst(-5,0);
            changeHappiness(-5, 0);
        }

        if(hunger <= 1 || thirst <= 1 || warmth <= 1 || happiness <= 1){
            ratDead = true;
            super.causeOfDeath();
        }

        if(!ratDead){
            System.out.println("\nYou also lost some warmth.");
            changeWarmth(-15, -1);
        }
    }

    public void randomWaterEvent(){ //option 2
        int random = randomNumber(1,50);
        if(random == 1){ //rat dies 1
            System.out.println("\nYou were impaled after an angry human threw a wine bottle at you! Fly high soldier.");
            ratDead = true;
        }

        else if(random >= 2 && random <= 9){
            System.out.println("\nWhile out looking for water, you fell in love with a mouse instead. Forbidden romance!");
            changeHappiness(5, 20);
            changeHunger(-5,0);
            changeThirst(-5,0);
        }

        else if(random >= 10 && random <= 20){ //rat actually finds water
            System.out.println("\nYou managed to find a body of water to drink from!");
            changeThirst(1, 5);
            changeHunger(-5,0);
            changeHappiness(10, 15);
        }
        else if(random >=21 && random <= 30){
            System.out.println("\nAlthough you were looking for water, you found some human remains to munch on.");
            changeHunger(1,13);
            changeThirst(-5,0);
            changeHappiness(10, 15);
        }

        else if(random >=31 && random <= 35){
            System.out.println("\nYou managed to find both food and water! Lucky you!");
            changeHunger(5,10);
            changeThirst(5,10);
            changeHappiness(10, 35);
        }
        else if(random == 36){
            System.out.println("\nYou got into a fight with another rat who bit your tail off. That's pretty unfortunate.");
            changeHappiness(-30, -5);
            changeHunger(-5,0);
            changeThirst(-5,0);
        }
        else if(random > 36){
            System.out.println("\nYou were not able to find food nor water. Sucks for you.");
            changeHunger(-5,0);
            changeThirst(-5,0);
            changeHappiness(-5, 0);
        }

        if(hunger <= 1 || thirst <= 1 || warmth <= 1 || happiness <= 1){
            ratDead = true;
            super.causeOfDeath();
        }

        if(!ratDead){
            System.out.println("\nYou also lost some warmth.");
            changeWarmth(-15, -1);
        }
        
        random = randomNumber(1,50);
    }

    public void randomShelterEvent(){ //option 3
        int random = super.randomNumber(1, 40);
        if(random >=10 && random <= 15){
            System.out.println("\nUh oh. You were discovered by a human, who decided to chop you up to use for rat stew. Better luck next time!");
            ratDead = true;
        }
        
        else if(random >= 21 && random <= 26){
            System.out.println("\nYou walked into a mouse trap and were impaled! Rest easy soldier.");
            ratDead = true;
        }

        if(hunger <= 0 || thirst <= 0 || warmth <= 0 || happiness <= 0){
            ratDead = true;
            super.causeOfDeath();
        }  
        
        if(!ratDead){
            System.out.println("\nGood choice by staying inside. You got to warm up a bit, but you're feeling a bit hungry and thirsty.");
            changeHappiness(3, 10);
            changeThirst(-10, -1);
            changeHunger(-10,-1);
            changeWarmth(10,30);
        }
    }

    public void growColony(){ //option 5
        if(happiness >= 80){
            if(super.randomNumber(1,3) == 1){ //random num was 1
                colonySize += randomNumber(1,2)*colonySize;
                System.out.println("\nYou were only able to grow your colony a bit. Try harder next time.");
                super.changeHappiness(1,5);
            }
            else if(super.randomNumber(1,3) == 2){ //random num was 2
                colonySize += randomNumber(2,3)*colonySize;
                System.out.println("\nYou managed to fall in love and find your true mate. Colony size has moderately increased.");
                super.changeHappiness(15,25);
            }
            else if(super.randomNumber(1,3) == 3){ //random num was 3
                colonySize += randomNumber(4,6)*colonySize;
                System.out.println("\nAbsolutely devious work solider! Your colony size has vastly increased.");
                super.changeHappiness(10,30);
            }
            super.changeWarmth(-10,-5);
            super.changeThirst(-10,-5);
            super.changeHunger(-10,-5);

            if(hunger <= 1 || thirst <= 1 || warmth <= 1 || happiness <= 1){
                ratDead = true;
                super.causeOfDeath();
            }
        }

        else {
            System.out.println("\nYou aren't happy enough to grow your colony! Get your happiness to at least 80%."); //you need more happiness!
        }
    }

    public void infectHumans(){ //option 6
        if(colonySize >= 300){
            if(super.randomNumber(1,3) == 1){ //random num was 1
                infectedHumans += randomNumber(1,3)*(colonySize/3);
                System.out.println("\nThe humans are quaking! Keep up the good work.");
                super.changeHappiness(1,5);
            }
            else if(super.randomNumber(1,3) == 2){ //random num was 2
                infectedHumans += randomNumber(4,6)*(colonySize/2);
                System.out.println("\nExcellent work soldier. You were able to infect a modest amount of humans due to the help of your colony.");
                super.changeHappiness(15,25);
            }
            else if(super.randomNumber(1,3) == 3){ //random num was 3
                infectedHumans += randomNumber(7,9)*(colonySize);
                System.out.println("\nYou, my friend, are an absolute menace to the human race. Europe doesn't stand a chance against your colony!");
                super.changeHappiness(10,30);
            }
            super.changeWarmth(-10,-5);
            super.changeThirst(-10,-5);
            super.changeHunger(-10,-5);

            if(hunger <= 0 || thirst <= 0 || warmth <= 0 || happiness <= 0){
                ratDead = true;
                super.causeOfDeath();
            }
        }

        else {
            System.out.println("Your colony is too small to infect humans with the plague! Get your colony to at least 300 demonic rats."); 
        }
    }

    public String toString(){
        return super.toString() + "\nColony size: " + colonySize + "\nInfected humans: " + infectedHumans;
    }

    public void ratStoryLine(){
        System.out.println("\n==========Hit enter after each line to continue==========\n\n\nThe year is 1347, when 12 ships docked at the Sicilian port of Messina.");
        input.nextLine();
        System.out.println("\nAs you lurked in the shadows, out came the humans, sickly, and covered in black boils.");
        input.nextLine();
        System.out.println("\nThe remainder of them were dead already, to everyone's horror.");
        input.nextLine();
        System.out.println("\nSicilian authorities ordered the fleet of these death ships, but it was too late. It had already begun. " + 
        "\n\nThe worst was yet to come.");
        input.nextLine();
        System.out.println("Your goal? To grow your colony and infect as many humans as possible.");
        input.nextLine();
    }


}
