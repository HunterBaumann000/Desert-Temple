package edu.wctc.Enemy;

public class Snake extends Enemy{
    public Snake(double health, double damage, double resistance, String name) {
        super(health, damage, resistance, name);
    }
    @Override
    public double MainMove(){
        return getDamage() + randomNumber(0,5);
    }

    @Override
    public void SecondaryMove(){
        System.out.println("The " + getName() + " sharpened its fang, giving it +10 attack.");
        setDamage(getDamage() + 10);
    }
}
