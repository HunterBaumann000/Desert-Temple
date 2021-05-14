package edu.wctc;

import edu.wctc.Enemy.Enemy;
import edu.wctc.Enemy.Snake;
import edu.wctc.EnemyLevelStrategy.GodLevel;
import edu.wctc.EnemyLevelStrategy.LowLevel;
import edu.wctc.Game.Context;
import edu.wctc.Player.Player;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class JUnitTests {
    Enemy enemy1;
    Context context1;

    Enemy enemy2;
    Context context2;

    Player player;


    @BeforeEach
    void runIt() {
        enemy1 = new Snake(100,100,100,"Test1");
        context1 = new Context(new LowLevel());

        enemy2 = new Snake(100,100,100,"Test2");
        context2 = new Context(new GodLevel());

        player = new Player(100,100,100,100,true);
    }

    @org.junit.jupiter.api.Test
    void getGodLevelStrategyTest() {

        context2.LevelStrategy(enemy2);
        assertTrue(enemy2.getHealth() == 200 && enemy2.getDamage() == 140 && enemy2.getResistance() == 110 );

    }

    @org.junit.jupiter.api.Test
    void getLowLevelStrategyTest() {

        context1.LevelStrategy(enemy1);
        assertTrue(enemy1.getHealth() == 90 && enemy1.getDamage() == 95 && enemy1.getResistance() == 95 );

    }

    @org.junit.jupiter.api.Test
    void createPlayer() {
        assertNotNull(Player.INSTANCE);
    }

}