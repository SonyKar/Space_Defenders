class Level1 extends Levels {
    Level1() {
        super();

        enemy = new Enemy[10];
        for(int i = 0; i < 10; i++) {
            enemy[i] = new Enemy(1, 5);
            enemy[i].setLocation(i * 70, 20);
            this.add(enemy[i]);
        }

        enemy[0].moveEnemy(enemy, 10);
    }
}
