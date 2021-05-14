package edu.wctc.Game;

import edu.wctc.Enemy.*;
import edu.wctc.EnemyLevelStrategy.*;
import edu.wctc.Player.Player;
import edu.wctc.SystemOutput;

import java.util.Scanner;


/**
 * @author Hunter Baumann
 * This class is comprised of the gameplay mechanics in order to run the Game class
 *
 * Extends SystemOutput
 * @see edu.wctc.SystemOutput general output and ASCII
 */
public class GameMechanics extends SystemOutput {

    private final Scanner keyboard = new Scanner(System.in);


    /**
     * used for determining randomness of game mechanics.
     *
    @return returns random number ranging from 0 to 100; double.
    */
    private double getRandomRange0to100(){
        double max = 100;
        double min = 0;
        double range = max - min + 1;

        return (Math.floor(Math.random() * range) + min);
    }


    /**
     * creates random enemy from the Enemy-subclasses.
     *
     @return returns enemy
     */
    private Enemy createRandomBaseEnemy(){

        double percent = getRandomRange0to100();

        if(percent < 5) //Mummy - 5%
        {
            return new Mummy(200,30,10, "Mummy");
        }
        else if(percent <= 15) //Scorpion - 10%
        {
            return new Scorpion(50,30,20,"Scorpion");
        }
        else if(percent < 35) //Spider - 20%
        {
            return new Spider(20,30,5,"Spider");
        }
        else if(percent < 60) //Snake - 25%
        {
            return new Snake(60,15,10,"Snake");
        }
        else //BeetleSwarm 40% (remaining percent)
        {
            return new BeetleSwarm(50,10,5,"Beetle Swarm");
        }
    }


    /**
     * Adds level variants to enemy when passed through as a parameter
     *
     @param enemy takes in enemy object and assigns levelStrategy to it.
     */
    private void getLevelStrategy(Enemy enemy) {

        double percent = getRandomRange0to100();

        if(percent < 1) //1% God-Level
        {
            Context context = new Context(new GodLevel());
            context.LevelStrategy(enemy);
        }
        else if(percent < 15) //15% high-level
        {
            Context context = new Context(new HighLevel());
            context.LevelStrategy(enemy);
        }
        else if(percent < 75) //60% standard-Level
        {
            Context context = new Context(new StandardLevel());
            context.LevelStrategy(enemy);
        }
        else //25% low-level (remaining percent)
        {
            Context context = new Context(new LowLevel());
            context.LevelStrategy(enemy);
        }
    }


    /**
     * User input will determine which stats are assigned to player
     *
     @return returns player with varying stats depending on input; Player.
     */
    private Player createPlayerStats(){

        Player player;
        String userChoice = "";

        chooseCharacterMenu();
        userChoice = keyboard.nextLine();

        player = switch (userChoice) {
            case "1" -> new Player(200, 10, 0, 10, true);
            case "2" -> new Player(80, 40, 0, 5, true);
            case "3" -> new Player(120, 20, 0, 20, true);
            default -> new Player(100, 20, 0, 10, true);
        };
        return player;
    }


    /**
     @param player takes in player and assigns a weaponDamage value to object.
     */
    private void createPlayerWeapon(Player player){

        double percent = getRandomRange0to100();

        weaponMenu();
        String userChoice = keyboard.nextLine();

        if ("2".equals(userChoice)) {
            if (percent < 1) //1% for stick
            {
                player.setWeaponDamage(player.getWeaponDamage() + 1);
                out("Your chosen weapon is a stick (1 damage) (1% chance)");
            }
            else if (percent < 2) //1% for excalibur
            {
                player.setWeaponDamage(player.getWeaponDamage() + 50);
                out("Your chosen weapon is a Excalibur (50 damage) (1% chance)");

            }
            else if (percent < 20) //18% enchanted sword
            {
                player.setWeaponDamage(player.getWeaponDamage() + 40);
                out("Your chosen weapon is an enchanted sword (40 damage ) (18% chance)");
            }
            else if (percent < 40) // 20% broken sword
            {
                player.setWeaponDamage(player.getWeaponDamage() + 10);
                out("Your chosen weapon is a broken sword (10 damage) (20% chance)");
            }
            else if (percent < 60) // 20% Sharpened sword
            {
                player.setWeaponDamage(player.getWeaponDamage() + 30);
                out("Your chosen weapon is a sharpened sword (30 damage) (20% chance)");
            }
            else //40% basic sword
            {
                player.setWeaponDamage(player.getWeaponDamage() + 20);
                out("Your chosen weapon is a basic sword (20 damage) (40% chance)");
            }
        } else
            {
            player.setWeaponDamage(player.getWeaponDamage() + 20);
            out("Your chosen weapon is a basic sword (20 damage)");
        }

    }


    /**
     * Creates finished enemy using createRandomBaseEnemy() and getLevelStrategy()
     * createRandomBaseEnemy() + getLevelStrategy() --> Enemy
     *
     @return returns final Enemy
     */
    public Enemy createEnemy(){
        Enemy enemy = createRandomBaseEnemy();
        getLevelStrategy(enemy);

        return enemy;
    }


    /**
     * Creates finished player using createPlayerStats() and createPlayerWeapon()
     * createPlayerStats() + createPlayerWeapon() --> Player
     *
     @return returns final player
     */
    public Player createPlayer(){
        Player player = createPlayerStats();
        createPlayerWeapon(player);

        return player;
    }


    /**
     * This method is responsible for the battle sequence between a player and enemy
     *
     @param player takes in the current player.
     @param enemy takes in current enemy object.
     @param floorNum takes current floor number from Game\PlayGame method.
     */
    public void enemyPlayerInteraction(Player player, Enemy enemy, int floorNum){

        double percent = getRandomRange0to100();

        out("");
        out("A "+enemy.getName() + " Has appeared on floor " + floorNum );
        //here
        do{

            battleOptionsMenu();
            String userChoice = keyboard.nextLine();


            switch(userChoice){
                case "1":
                    enemy.setHealth(
                            enemy.getHealth() - ((player.getBaseDamage() + player.getWeaponDamage()) - enemy.getResistance())
                    );

                    out("Your attack did " +
                            (player.getBaseDamage() + player.getWeaponDamage())
                            +" damage");

                    break;
                case "2":

                    if(percent > 60){
                        enemy.setHealth(
                                enemy.getHealth() - ((player.getBaseDamage() + player.getWeaponDamage() * 1.5) - enemy.getResistance())
                        );

                        out("Your attack did " +
                                (player.getBaseDamage() + player.getWeaponDamage() * 1.5)
                                +" damage");

                    } else {
                        out("Your Attack Missed");
                    }
                    break;

                case "3":

                    if(percent < 40){
                        out("You ran away Successfully");
                        enemy.setHealth(0);
                    } else {
                        out("You failed to run away");
                    }
                    break;

                default:
                    break;
            }

            if(percent < 70)
            {
                player.setHealth(player.getHealth() - (enemy.MainMove() - player.getResistance()));

                if(enemy.MainMove() - player.getResistance() < 0) {
                    out("Their attack didnt even leave a scratch on you!");
                } else {
                    out("You took: " + (enemy.MainMove() - player.getResistance()) + " damage");
                }
            }
            else
            {
                enemy.SecondaryMove();
            }

            if(player.getHealth() < 0) {player.setAlive(false);}

            out("");
            out(enemy.toString());
            out(player.toString());

        } while(enemy.getHealth() > 0 && player.isAlive());


    }
}
