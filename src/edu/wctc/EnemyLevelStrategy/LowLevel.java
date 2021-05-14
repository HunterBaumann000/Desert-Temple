package edu.wctc.EnemyLevelStrategy;

import edu.wctc.Enemy.Enemy;

public class LowLevel implements EnemyLevelStrategy{
    @Override
    public void LevelStrategy(Enemy enemy){
        enemy.setHealth(enemy.getHealth() - 10);
        enemy.setDamage(enemy.getDamage() - 5);
        enemy.setResistance(enemy.getResistance() - 5);
    }
}
