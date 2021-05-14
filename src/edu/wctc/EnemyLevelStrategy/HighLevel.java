package edu.wctc.EnemyLevelStrategy;

import edu.wctc.Enemy.Enemy;

public class HighLevel implements EnemyLevelStrategy{
    @Override
    public void LevelStrategy(Enemy enemy) {
        enemy.setHealth(enemy.getHealth() + 50);
        enemy.setDamage(enemy.getDamage() + 20);
        enemy.setResistance(enemy.getResistance() + 5);
    }
}
