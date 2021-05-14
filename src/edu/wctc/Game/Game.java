package edu.wctc.Game;

import edu.wctc.Enemy.Enemy;
import edu.wctc.Player.Player;

public class Game extends GameMechanics {

    public void PlayGame(){
        Player player = createPlayer();

        while(player.isAlive()){

            Enemy enemy = createEnemy();

            enemyPlayerInteraction(player, enemy);

            System.out.println("Enemy has been defeated");



        }


    }

}
