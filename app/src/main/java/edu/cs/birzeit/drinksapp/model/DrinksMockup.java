package edu.cs.birzeit.drinksapp.model;

import java.util.ArrayList;

public class DrinksMockup {

    private ArrayList<Drink> drinks = new ArrayList<>();

    public DrinksMockup(){
        drinks.add(new Drink("Cold Drinks", "Sprite",
                5));

        drinks.add(new Drink("Hot Drinks", "Coffee",
                15));
        drinks.add(new Drink("Hot Drinks", "Tea",
                12));
        drinks.add(new Drink("Cookies", "Browni",
                5));

    }

    public ArrayList<Drink> getDrinks(String cat){

        ArrayList<Drink> result = new ArrayList<>();

        for (Drink d : drinks){
            if(d.getCategory().equals(cat)){
                result.add(d);
            }

        }

        return result;

    }

    public String[] getCategories(){
        String[] cats = {"Cold Drinks", "Hot Drinks", "Cookies", "Fresh Juice"};

        return cats;
    }


}
