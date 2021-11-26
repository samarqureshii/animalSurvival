package com.company.animal_survival;

import java.text.NumberFormat;
import java.util.Random;

public class Animal {
    protected int happiness, warmth, hunger, thirst, dayNumber; 
    public static final NumberFormat percent = NumberFormat.getPercentInstance();

    public Animal(){
        happiness = 30;
        warmth = 90;
        hunger = 90;
        thirst = 90;
        dayNumber = 1;
    }

    public Animal(int ha, int w, int h, int t){ //overloaded constructor for different game modes
        happiness = ha;
        warmth = w;
        hunger = h;
        thirst = t;
    }

    public void setHappiness(int newHappiness){
        happiness = newHappiness;
    }   

    public int getHappiness(){
        return happiness;
    }

    public void setWarmth(int newWarmth){
        warmth = newWarmth;
    }   

    public int getWarmth(){
        return warmth;
    }

    public void setHunger(int newHunger){
        hunger = newHunger;
    }   

    public int getHunger(){
        return hunger;
    }

    public void setThirst(int newThirst){
        thirst = newThirst;
    }   

    public int getThirst(){
        return thirst;
    }

    public String toString(){
        return "\n\n==========DAY " + (dayNumber) + "==========\n\n" +
        "Happiness: " + percent.format((double)happiness/100) + 
        "\nWarmth: " + percent.format((double)warmth/100) + 
        "\nHunger: " + percent.format((double)hunger/100) +
        "\nThirst: " + percent.format((double)thirst/100);
    }

    public void changeHappiness(int min, int max){
        if(happiness < 100 && happiness > 0){
            happiness += randomNumber(min, max);

            if(happiness >= 100){
                happiness = 100;
            }

            else if(happiness <= 0){
                happiness = 0;
            }
            
        }
        
    }

    public void changeWarmth(int min, int max){
        if(warmth < 100 && warmth > 0){
            warmth += randomNumber(min, max);

            if(warmth >= 100){
                warmth = 100;
            }

            else if(warmth <= 0){
                warmth = 0;
            }
        }
    }

    public void changeHunger(int min, int max){
        if(hunger < 100 && hunger > 0){
            hunger += randomNumber(min, max);

            if(hunger >= 100){
                hunger = 100;
            }

            else if(hunger <= 0){
                hunger = 0;
            }
        }
    }

    public void changeThirst(int min, int max){
        if(thirst < 100 && thirst > 0){
            thirst += randomNumber(min, max);

            if(thirst >= 100){
                thirst = 100;
            }

            else if(thirst <= 0){
                thirst = 0;
            }
        }

    }

    public void causeOfDeath(){
        if(hunger <= 0){
            System.out.println("It appears that you got too hungry and starved to death.");
        }

        else if(thirst <= 0){
            System.out.println("Your body went into multi-system organ failure due to dehydration!");
        }

        else if(warmth <= 0){
            System.out.println("It seems that your body was too cold to function correctly, and you died of hypothermia.");
        }

        else if(happiness <= 0){
            System.out.println("After struggling with long-term depression, you were able to pass away. Even animals have to be happy!");
        }
    }

    public String menu(){ 
        //menu is standard across all animals
        return "==========What would you like to do today, boss?========== \n\n1. Find food\n2. Find water\n3. Stay in Shelter \n4. Commit suicide";
    }

    public int randomNumber(int min, int max){
        Random rand = new Random();
        return (min + rand.nextInt(Math.abs(max-min+1)));
    }

}
