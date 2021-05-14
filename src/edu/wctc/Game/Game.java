package edu.wctc.Game;

import edu.wctc.Enemy.Enemy;
import edu.wctc.Player.Player;

import java.util.Scanner;

/**
 * @author Hunter Baumann
 * This class utilizes the gameMechanics class to initiate the game
 *
 * Extends GameMechanics
 * @see edu.wctc.Game.GameMechanics for general mechanics
 */
public class Game extends GameMechanics {
    private final Scanner keyboard = new Scanner(System.in);

    /**
     * This method create a player, then loop through enemyPlayerInteraction() until the player dies.
     *
     * The goal is to reach the highest floor you can until you die, the enemies will continue to spawn
     */
    public void PlayGame(){
        int floorNum = 1;
        SystemOutput o = new SystemOutput();
        Player player = createPlayer();

        out("");
        out("Press Any Key to Begin");
        String placeHolder = keyboard.nextLine();

        desert();
        out("              " +
                "  You Walk Towards The Entrance");

        while(player.isAlive()){

            Enemy enemy = createEnemy();
            enemyPlayerInteraction(player, enemy, floorNum);

            if(player.isAlive()){
                out("");
                out("Enemy has been defeated");
            } else {
                out("");
                skull();
                out("   You have been slain by "+enemy.getName()+ " on floor: " + floorNum);

            }
            floorNum++;
        }

    }

}
