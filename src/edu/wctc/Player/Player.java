package edu.wctc.Player;

public class Player {

    public static Player instance;
    private double health;
    private double baseDamage;
    private double weaponDamage;
    private double resistance;
    private boolean isAlive;

    public static Player getInstance() {
        if (instance == null) {
            instance =  new Player(getInstance().getHealth(),
                                   getInstance().getBaseDamage(),
                                   getInstance().getWeaponDamage(),
                                   getInstance().getResistance(),
                                   getInstance().isAlive());
        }
        return instance;
    }

    public Player(double health, double baseDamage, double weaponDamage, double resistance, boolean isAlive) {
        this.health = health;
        this.baseDamage = baseDamage;
        this.weaponDamage = weaponDamage;
        this.resistance = resistance;
        this.isAlive = isAlive;
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    @Override
    public String toString() {
        return "Player stats: " +
                "health= " + health +
                ", baseDamage= " + baseDamage +
                ", weaponDamage= " + weaponDamage +
                ", resistance= " + resistance +
                '}';
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
