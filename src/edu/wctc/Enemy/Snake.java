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
        setDamage(getDamage() + 10);
    }
}
