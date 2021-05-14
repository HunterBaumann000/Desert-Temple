package edu.wctc.Game;

import edu.wctc.Enemy.Enemy;
import edu.wctc.EnemyLevelStrategy.EnemyLevelStrategy;

public class Context {
    private final EnemyLevelStrategy strategy;

    /**
    * @param strategy constructor for EnemyLevelStrategy
    */
    public Context(EnemyLevelStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * determines which strategy pattern will be applied
     */
    public void LevelStrategy(Enemy enemy) {
         strategy.LevelStrategy(enemy);
    }
}
