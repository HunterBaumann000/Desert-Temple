package edu.wctc.Player;

/**
 * Player class responsible for holding player data
 */
public class Player {

    public static Player INSTANCE;
    private double health;
    private double baseDamage;
    private double weaponDamage;
    private double resistance;
    private boolean isAlive;

    public Player(double health, double baseDamage, double weaponDamage, double resistance, boolean isAlive) {
        this.health = health;
        this.baseDamage = baseDamage;
        this.weaponDamage = weaponDamage;
        this.resistance = resistance;
        this.isAlive = isAlive;
    }

    public static Player Player() {
        if(INSTANCE == null) {
            INSTANCE = new Player(Player().getHealth(),
                                  Player().getBaseDamage(),
                                  Player().getWeaponDamage(),
                                  Player().getResistance(),
                                  Player().isAlive() );
        }
        return INSTANCE;
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    @Override
    public String toString() {
        return "Your Stats: " +
                "Health: " + health +
                ", Total Damage: " + (baseDamage + weaponDamage) +
                ", Resistance: " + resistance + ".";
    }

    public void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(double weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
