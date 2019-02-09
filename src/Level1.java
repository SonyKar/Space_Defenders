class Level1 extends Levels {
    Level1() {
        super();

        Enemy[] enemy = new Enemy[10];
        for(int i = 0; i < 10; i++) {
            enemy[i] = new Enemy(1, 50, 50, 5);
            enemy[i].setBounds(i * 70, 20, 50, 50);
            this.add(enemy[i]);
        }
//        LaserBeam laser = new LaserBeam(1);
//        laser.setLocation(new Point(40, 20));
//        System.out.println(LaserBeam.checkHit(laser, enemy[0]));

        enemy[0].moveEnemy(enemy, 10);
    }
}
