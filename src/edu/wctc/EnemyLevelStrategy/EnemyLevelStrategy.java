package edu.wctc.EnemyLevelStrategy;

import edu.wctc.Enemy.Enemy;
/**
 * Strategy Pattern responsible for assigning a level to each enemy thats created
 */
public interface EnemyLevelStrategy {
    public void LevelStrategy(Enemy enemy);
}
