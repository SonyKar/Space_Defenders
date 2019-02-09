class Level1 extends Levels {
    Level1() {
        super();

        Enemy enemy[] = new Enemy[10];
        for(int i = 0; i < 10; i++) {
            enemy[i] = new Enemy(1, 50, 50);
            enemy[i].setBounds(i * 70, 20, 50, 50);
            this.add(enemy[i]);
        }

        enemy[0].moveEnemy(enemy, 10);
    }
}
