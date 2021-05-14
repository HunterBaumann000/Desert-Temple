package edu.wctc.Enemy;

public class Mummy extends Enemy{

    public Mummy(double health, double damage, double resistance, String name) {
        super(health, damage, resistance, name);
    }

    @Override
    public double MainMove(){
        return getDamage() + randomNumber(10,20);
    }

    @Override
    public void SecondaryMove(){
        setResistance(getResistance() + 2);
        setHealth(getHealth() + 10);
    }
}
