package edu.wctc.Enemy;

public class BeetleSwarm extends Enemy{

    public BeetleSwarm(double health, double damage, double resistance, String name) {
        super(health, damage, resistance, name);


    }

    @Override
    public double MainMove() {
        return getDamage() + randomNumber(0,5);
    }

    @Override
    public void SecondaryMove(){
        double healthIncrease = randomNumber(5, 30);
        setHealth(getHealth() + healthIncrease);

        System.out.println("The swarm of beetles collectively shed their membranes, healing " + healthIncrease + " health.");
    }
}
