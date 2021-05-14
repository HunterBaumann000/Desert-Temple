package edu.wctc;

import edu.wctc.Enemy.Enemy;
import edu.wctc.Enemy.Snake;
import edu.wctc.EnemyLevelStrategy.GodLevel;
import edu.wctc.EnemyLevelStrategy.LowLevel;
import edu.wctc.EnemyLevelStrategy.StandardLevel;
import edu.wctc.Game.Context;
import edu.wctc.Game.GameMechanics;
import edu.wctc.Player.Player;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class GameMechanicsTest {
    Enemy enemy1 = new Snake(100,100,100,"Test1");
    Context context1 = new Context(new LowLevel());

    Enemy enemy2 = new Snake(100,100,100,"Test2");
    Context context2 = new Context(new GodLevel());

    Player player = new Player(100,100,100,100,true);

    GameMechanics game = new GameMechanics();


    @BeforeEach
    void runIt() {

    }

    @org.junit.jupiter.api.Test
    void getLevelStrategy() {
        context1.LevelStrategy(enemy1);
        assertTrue(enemy1.getHealth() == 90 && enemy1.getDamage() == 95 && enemy1.getResistance() == 95 );

        context2.LevelStrategy(enemy2);
        assertTrue(enemy2.getHealth() == 200 && enemy2.getDamage() == 140 && enemy2.getResistance() == 110 );
    }

    @org.junit.jupiter.api.Test
    void createPlayer() {
        //assertTrue();
    }
}