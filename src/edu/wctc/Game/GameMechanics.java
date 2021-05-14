package edu.wctc.Game;

import edu.wctc.Enemy.*;
import edu.wctc.EnemyLevelStrategy.*;
import edu.wctc.Player.Player;

import java.util.Scanner;

public class GameMechanics{

    Scanner keyboard = new Scanner(System.in);
    private double max = 100;
    private double min = 0;
    private double range = max - min + 1;


    public Enemy createRandomBaseEnemy(){

        double percent = (Math.floor(Math.random() * range) + min);

        if(percent < 5) //Mummy - 5%
        {
            Enemy mummy = new Mummy(200,30,10, "Mummy"); //good stats all around

            return mummy;
        }
        else if(percent <= 15) //Scorpion - 10%
        {
            Enemy scorpion = new Scorpion(50,30,20,"Scorpion"); //high damage/resistance

            return scorpion;
        }
        else if(percent < 35) //Spider - 20%
        {
            Enemy spider = new Spider(20,30,5,"Spider"); //low health, high damage

            return spider;
        }
        else if(percent < 60) //Snake - 25%
        {
            Enemy snake = new Snake(60,15,10,"Snake"); // average stats

            return snake;
        }
        else //BeetleSwarm 40% (remaining percent)
        {
            Enemy beetleSwarm = new BeetleSwarm(50,10,5,"Beetle Swarm"); //weaker stats

            return beetleSwarm;
        }
    }

    public void getLevelStrategy(Enemy enemy) {

        double percent = (Math.floor(Math.random() * range) + min);

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

    public Enemy createEnemy(){
       Enemy enemy = createRandomBaseEnemy();
       getLevelStrategy(enemy);

       return enemy;
    }

    public Player createPlayerStats(){

        Player player;
        String userChoice = "";

        System.out.println("What character type do you choose?");
        System.out.println("----------------------------------");
        System.out.println("1) Tank (High Health - Low Base Damage)");
        System.out.println("2) Assassin (Low Health - High Base Damage)");
        System.out.println("3) Knight (High Resistance)");
        System.out.println("4) Adventurer (Average Stats)");

        System.out.print("Choice: ");
        userChoice = keyboard.nextLine();

        switch (userChoice){
            case "1":
                player = new Player(200,10,0,10,true);
                break;
            case "2":
                player = new Player(80,40,0,5,true);
                break;
            case "3":
                player = new Player(120,20,0,20,true);
                break;
            default:
                player = new Player(100,20,0,10,true);
                break;
        }
        return player;
    }

    public void createPlayerWeapon(Player player){

        double percent = (Math.floor(Math.random() * range) + min);

        System.out.println("");
        System.out.println("Now for your weapon, play it safe or gamble?");
        System.out.println(" 1) Stick with basic weapon. ");
        System.out.println(" 2) Gamble for random weapon. ");

        System.out.print("Choice: ");
        String userChoice = keyboard.nextLine();

        switch (userChoice){
            case "1":
                player.setWeaponDamage(player.getWeaponDamage() + 20);
                System.out.println("Your chosen weapon is a basic sword (20 damage)");
                break;
            case "2":
                if(percent < 1) //1% for stick
                {
                    player.setWeaponDamage(player.getWeaponDamage() + 1);
                    System.out.println("Your chosen weapon is a stick (1 damage) (1% chance)");
                }
                else if(percent < 2) //1% for excalibur
                {
                    player.setWeaponDamage(player.getWeaponDamage() + 50);
                    System.out.println("Your chosen weapon is a Excalibur (50 damage) (1% chance)");

                }
                else if(percent < 20) //18% enchanted sword
                {
                    player.setWeaponDamage(player.getWeaponDamage() + 40);
                    System.out.println("Your chosen weapon is an enchanted sword (40 damage ) (18% chance)");
                }
                else if(percent < 40) // 20% broken sword
                {
                    player.setWeaponDamage(player.getWeaponDamage() + 10);
                    System.out.println("Your chosen weapon is a broken sword (10 damage) (20% chance)");
                }
                else if(percent < 60) // 20% Sharpened sword
                {
                    player.setWeaponDamage(player.getWeaponDamage() + 30);
                    System.out.println("Your chosen weapon is a sharpened sword (30 damage) (20% chance)");
                }
                else //40% basic sword
                {
                    player.setWeaponDamage(player.getWeaponDamage() + 20);
                    System.out.println("Your chosen weapon is a basic sword (20 damage) (40% chance)");
                }
            break;
        }

    }

    public Player createPlayer(){
        Player player = createPlayerStats();
        createPlayerWeapon(player);

        return player;
    }

    public void enemyPlayerInteraction(Player player, Enemy enemy){

        double percent = (Math.floor(Math.random() * range) + min);

        do{
            System.out.println("");
            System.out.println("What will you do?");
            System.out.println("1) Basic Attack");
            System.out.println("2) Power Attack (Recoil)");
            System.out.println("3) Run Away");

            System.out.println("Choice: ");
            String userChoice = keyboard.nextLine();


            switch(userChoice){
                case "1":
                    enemy.setHealth(
                            enemy.getHealth() - ((player.getBaseDamage() + player.getWeaponDamage()) - enemy.getResistance())
                    );
                    break;
                case "2":

                    if(percent > 60){
                        enemy.setHealth(
                                enemy.getHealth() - ((player.getBaseDamage() + player.getWeaponDamage() * 1.5) - enemy.getResistance())
                        );

                        System.out.println("Your attack did " +
                                (player.getBaseDamage() + player.getWeaponDamage() * 1.5)
                                +" damage");

                    } else {
                        System.out.println("Your Attack Missed");
                    }
                    break;

                case "3":
                    System.out.println("You ran away..");
                    break;

                default:

                    break;
            }

            if(percent < 70)
            {
                player.setHealth(player.getHealth() - (enemy.MainMove() - player.getResistance()));

                if(enemy.MainMove() - player.getResistance() < 0) {
                    System.out.println("Their attack didnt even leave a scratch!");
                } else {
                    System.out.println("You took: " + (enemy.MainMove() - player.getResistance()) + "damage");
                }
            }
            else
            {
                enemy.SecondaryMove();
            }

            if(player.getHealth() < 0) {player.setAlive(false);}

            System.out.println("");
            System.out.println(enemy.toString());
            System.out.println(player.toString());

        } while(enemy.getHealth() < 0 || !player.isAlive());


    }
}
