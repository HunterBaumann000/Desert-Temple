package edu.wctc.Enemy;

public class Spider extends Enemy{
    public Spider(double health, double damage, double resistance, String name) {
        super(health, damage, resistance, name);
    }
    @Override
    public double MainMove(){
        return getDamage() + randomNumber(0,30);
    }

    @Override
    public void SecondaryMove(){
        setDamage(getDamage() + 5);
        setHealth(getHealth() + 5);
    }
}
