package edu.wctc.Enemy;

/**
 * High level Enemy class that will be inherited by enemies
 */
public abstract class Enemy {
    private double health;
    private double damage;
    private double resistance;

    private String name;

    public Enemy(double health, double damage, double resistance, String name) {
        this.health = health;
        this.damage = damage;
        this.resistance = resistance;
        this.name = name;
    }

    public double MainMove(){
        return 0;
    }

    public void SecondaryMove(){
        System.out.println("move has failed");
    }

    public double randomNumber(double min, double max){
        return (double)Math.floor(Math.random()*(max-min+1)+min);
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public double getResistance() {
        return resistance;
    }

    public String getName() {
        return name;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Creature: " + name +
                ", Health: " + health +
                ", Damage: " + damage +
                ", Resistance: " + resistance + ".";
    }
}
