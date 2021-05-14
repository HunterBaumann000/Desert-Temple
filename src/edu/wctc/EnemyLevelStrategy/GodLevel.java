package edu.wctc.EnemyLevelStrategy;

import edu.wctc.Enemy.Enemy;

public class GodLevel implements EnemyLevelStrategy{

    @Override
    public void LevelStrategy(Enemy enemy) {
        enemy.setHealth(enemy.getHealth() + 100);
        enemy.setDamage(enemy.getDamage() + 40);
        enemy.setResistance(enemy.getResistance() + 10);
    }
}
