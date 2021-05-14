package edu.wctc.Enemy;

public class Scorpion extends Enemy{

    public Scorpion(double health, double damage, double resistance, String name) {
        super(health, damage, resistance, name);
    }
    @Override
    public double MainMove(){
        return getDamage() + randomNumber(10,20);
    }

    @Override
    public void SecondaryMove(){
        System.out.println("The " + getName() + " fortified its shell, +2 resistance");
        setResistance(getResistance() + 2);
    }
}
