class Level1 extends Levels {
    Level1() {
        super();

        for(int i = 0; i < 10; i++) {
            enemy.add(new Enemy(1, 5));
            enemy.get(i).setLocation(i * 70, 20);
            this.add(enemy.get(i));
        }

        moveEnemy();
    }
}
