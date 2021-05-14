package edu.wctc.Game;

import edu.wctc.Enemy.Enemy;
import edu.wctc.EnemyLevelStrategy.EnemyLevelStrategy;

public class Context {
    private final EnemyLevelStrategy strategy;

    public Context(EnemyLevelStrategy strategy) {
        this.strategy = strategy;
    }

    public void LevelStrategy(Enemy enemy) {
         strategy.LevelStrategy(enemy);
    }
}
