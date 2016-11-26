package Arknoid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;



public class Board extends JPanel implements Commons {
    private Timer timer;
    private String message = "Game Over";
    private String message1 = "Score = ";
    private Ball ball;
    private ArrayList<Ball> balls;
    private Paddle paddle;
    private Brick bricks[];
    private boolean ingame = true;
    private int stage = 4;
    private int n, count = 0;
    private int nball;
    private Item item;
    private int paddleX;
    private int item4, item5;
    private ATK atk[];
    private int randomatk;
    private ImageIcon ii;
    private BackgroundPanel background;
    private wizard wizard;
    private Boss boss;
    private int bossatk,rebrick;
    private int N_OF_BRICKS;
    private int  score = 0;
    private boolean confirm ;
    private Prince prince;
    private Prinsess prinsess;

    public Board() {
        initBoard();
    }


    private void initBoard() {
        if (stage >= 1 ){
            confirm = true;
        }else confirm = false;
        if (stage == 4){
            N_OF_BRICKS = 182;
        }else if (stage == 1 || stage == 2 || stage == 3 || stage == -1){
            N_OF_BRICKS = 140;
        }
        addKeyListener(new TAdapter());
        setFocusable(true);
        gameInit(0);
        /*bricks = new Brick[N_OF_BRICKS];
        paddle = new Paddle();
        paddle.setCheckpass(0);
        background = new BackgroundPanel(1);
        balls = new ArrayList<>();
        atk = new ATK[N_OF_BRICKS];
        bricks = new Brick[N_OF_BRICKS];
        background = new BackgroundPanel(1);
        wizard = new wizard();
        boss = new Boss();*/
        setDoubleBuffered(true);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), DELAY, PERIOD);
    }


    private void nextStage() {
        gameInit(stage);
    }

    @Override
    public void addNotify() {
        //img = Toolkit.getDefaultToolkit().createImage("background.png");

        super.addNotify();
        gameInit(stage);
    }


    private void gameInit(int stage) {
     /*   balls = new ArrayList<>();
        //N_OF_BRICKS = 140;
        balls.add(new Ball());
        balls.add(new Ball(500));
        //nball = 1;
        paddle = new Paddle();
        nball = balls.size()-1;

        item = new Item();*/
        if (stage == 0){
            confirm = false;
            this.stage = 0;
            paddle = new Paddle();
            paddle.setCheckpass(0);
            background = new BackgroundPanel(0);
            prince = new Prince();

        }

        if (stage == -1){
            confirm = false;
            this.stage = -1;
            paddle = new Paddle();
            paddle.setCheckpass(0);
            background = new BackgroundPanel(0);
            prinsess = new Prinsess();
        }


        if (stage == 5){
            confirm = false;
            this.stage = 5;
            paddle = new Paddle();
            paddle.setCheckpass(0);
            background = new BackgroundPanel(5);
        }
        if (stage == 6){
            confirm = false;
            this.stage = 6;
            paddle = new Paddle();
            paddle.setCheckpass(0);
            background = new BackgroundPanel(6);
        }

        int k = 0;
        if (stage == 4){
            boss.setBoss(true);
        }
        bricks = new Brick[N_OF_BRICKS];

        if (stage == 1){
            this.stage = 1;
            N_OF_BRICKS = 140;
            paddle = new Paddle();
            paddle.setCheckpass(1);
            balls = new ArrayList<>();
            balls.add(new Ball());
            balls.add(new Ball(500));
            atk = new ATK[N_OF_BRICKS];;
            nball = balls.size()-1;
            bricks = new Brick[N_OF_BRICKS];
            background = new BackgroundPanel(1);
            wizard = new wizard();
            boss = new Boss();
            item = new Item();
            confirm = true;

            for (int i = 0; i < 10; i++) {
                if (i == 0 || i == 3 || i == 6 || i == 9) {
                    n = 1;
                    for (int j = 0; j < 14; j++) {
                        bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                        atk[k] = new ATK();
                        k++;
                    }
                } else if (i == 1 || i == 4 || i == 7) {
                    n = 0;
                    for (int j = 0; j < 14; j++) {
                        bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                        atk[k] = new ATK();
                        k++;
                    }
                } else if (i == 2 || i == 5 || i == 8) {
                    n = 2;
                    for (int j = 0; j < 14; j++) {
                        bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                        atk[k] = new ATK();
                        k++;
                    }
                }
            }

        }else if (stage == 2){
            this.stage = 2;
            paddle.setCheckpass(1);
            balls = new ArrayList<>();
            for (int i=0;i<nball;i++){
                balls.add(new Ball());
            }
            balls.add(new Ball(500));
            paddle.setX(0);

            for (int i = 0; i < 10; i++) {
                if (i == 0) {
                    n = 5;
                    for (int j = 0; j < 14; j++) {
                        bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                        atk[k] = new ATK();
                        k++;

                    }
                }else if (i == 9) {
                    n = 0;
                    for (int j = 0; j < 14; j++) {
                        bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                        atk[k] = new ATK();
                        k++;

                    }
                } else {
                    for (int j = 0; j < 14; j++) {
                        if (j == 0 || j == 13){
                            n = 0;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        }
                        else {
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, (k%4)+1);
                            atk[k] = new ATK();
                            k++;
                        }


                    }
                }
            }
        }else if (stage == 3) {
            this.stage = 3;
            paddle.setCheckpass(1);
            balls = new ArrayList<>();
            for (int i=0;i<nball;i++){
                balls.add(new Ball());
            }
            balls.add(new Ball(500));
            paddle.setX(0);
            for (int i = 0; i < 10; i++) {
                if (i == 0) {
                    for (int j = 0; j < 14; j++) {
                        if (j == 0 || j == 3 || j == 4 || j == 5 || j == 8 || j == 9 || j == 10 || j == 13) {
                            n = 7;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else {
                            n = 1;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        }
                    }
                } else if (i == 2) {
                    for (int j = 0; j < 14; j++) {
                        if (j == 6 || j == 7) {
                            n = 2;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else if (j == 0 || j == 13) {
                            n = 3;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else {
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, (k%6));
                            atk[k] = new ATK();
                            k++;
                        }
                    }
                } else if (i == 1) {
                    for (int j = 0; j < 14; j++) {
                        if (j == 0 || j == 3 || j == 4 || j == 5 || j == 8 || j == 9 || j == 10 || j == 13) {
                            n = 3;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else {

                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, (k%6));
                            atk[k] = new ATK();
                            k++;
                        }
                    }
                } else if (i == 3) {
                    for (int j = 0; j < 14; j++) {
                        if (j == 0 || j == 13) {
                            n = 3;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else {

                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, (k%6));
                            atk[k] = new ATK();
                            k++;
                        }
                    }
                } else if (i == 4 || i == 5) {
                    for (int j = 0; j < 14; j++) {
                        if (j == 0 || j == 13) {
                            n = 7;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else if (j == 1 || j == 12) {
                            n = 2;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else {

                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, (k%6));
                            atk[k] = new ATK();
                            k++;
                        }
                    }
                } else if (i == 6) {
                    for (int j = 0; j < 14; j++) {
                        if (j == 0 || j == 1 || j == 12 || j == 13) {
                            n = 7;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else if (j == 2 || j == 11) {
                            n = 1;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else {
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, (k%6));
                            atk[k] = new ATK();
                            k++;
                        }
                    }
                } else if (i == 7) {
                    for (int j = 0; j < 14; j++) {
                        if (j == 0 || j == 1 || j == 12 || j == 13) {
                            n = 7;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else if (j == 2 || j == 3 || j == 10 || j == 11) {
                            n = 1;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else {
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, (k%6));
                            atk[k] = new ATK();
                            k++;
                        }
                    }
                } else if (i == 8) {
                    for (int j = 0; j < 14; j++) {
                        if (j == 0 || j == 1 || j == 2 || j == 3 || j == 10 || j == 11 || j == 12 || j == 13) {
                            n = 7;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else if (j == 4 || j == 5 || j == 8 || j == 9) {
                            n = 1;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else {
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50,(k%5));
                            atk[k] = new ATK();
                            k++;
                        }
                    }
                } else if (i == 9) {
                    for (int j = 0; j < 14; j++) {
                        if (j == 6 || j == 7) {
                            n = 1;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else if (j == 0 || j == 1 || j == 12 || j == 13) {
                            n = 5;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        } else {
                            n = 7;
                            bricks[k] = new Brick(j * 51 + 30, i * 21 + 50, n);
                            atk[k] = new ATK();
                            k++;
                        }
                    }
                }
            }
        }else if (stage == 4){
            this.stage = 4;
            paddle.setCheckpass(1);
            N_OF_BRICKS = 182;
            bricks = new Brick[N_OF_BRICKS];
            atk = new ATK[N_OF_BRICKS];
            balls = new ArrayList<>();
            for (int i=0;i<nball;i++){
                balls.add(new Ball());
            }
            balls.add(new Ball(500));
            paddle.setX(0);
                for (int i = 0; i < 13; i++) {
                    if (i == 0) {
                        for (int j = 0; j < 14; j++) {
                            n = 7;
                            bricks[k] = new Brick(j * 51 + 30, i * 45 + 110, n);
                            atk[k] = new ATK();
                            k++;
                        }
                    } else if (i == 1) {
                        for (int j = 0; j < 14; j++) {
                            if (j == 6 || j == 7 ) {
                                n = 5;
                                bricks[k] = new Brick(j * 51 + 30, i * 45 + 75, n);
                                atk[k] = new ATK();
                                k++;
                            } else {
                                n = 7;
                                bricks[k] = new Brick(j * 51 + 30, i * 45 + 75, n);
                                atk[k] = new ATK();
                                k++;
                            }
                        }
                    } else if (i == 2) {
                        for (int j = 0; j < 14; j++) {
                            if (j == 5 || j == 6 || j == 7 || j == 8) {

                                bricks[k] = new Brick(j * 51 + 30, i * 45 + 51, (k%4)+1);
                                atk[k] = new ATK();
                                k++;
                            } else {
                                n = 7;
                                bricks[k] = new Brick(j * 51 + 30, i * 45 + 65, n);
                                atk[k] = new ATK();
                                k++;
                            }
                        }
                    } else if (i == 3) {
                        for (int j = 0; j < 14; j++) {
                            if (j == 4 || j == 5 || j == 6 || j == 7 || j == 8 || j == 9) {
                                bricks[k] = new Brick(j * 51 + 30, i * 44 + 30, (k%5));
                                atk[k] = new ATK();
                                k++;
                            } else {
                                n = 7;
                                bricks[k] = new Brick(j * 51 + 30, i * 45 + 65, n);
                                atk[k] = new ATK();
                                k++;
                            }
                        }
                    }else if (i == 4) {
                        for (int j = 0; j < 14; j++) {
                            if (j == 3 || j == 4 || j == 5 || j == 6 || j == 7 || j == 8 || j == 9 || j == 10) {
                                bricks[k] = new Brick(j * 51 + 30, i * 30 + 64, (k%5));
                                atk[k] = new ATK();
                                k++;
                            }else {
                                n = 7;
                                bricks[k] = new Brick(j * 51 + 30, i * 45 + 65, n);
                                atk[k] = new ATK();
                                k++;
                            }
                        }
                    }else if (i == 5) {
                        for (int j = 0; j < 14; j++) {
                            if (j == 2|| j == 3 || j == 4 || j == 5 || j == 6 || j == 7 || j == 8 || j == 9 || j == 10 || j == 11) {
                                bricks[k] = new Brick(j * 51 + 30, i * 30 + 56, (k%5));
                                atk[k] = new ATK();
                                k++;
                            }else {
                                n = 7;
                                bricks[k] = new Brick(j * 51 + 30, i * 45 + 65, n);
                                atk[k] = new ATK();
                                k++;
                            }
                        }
                    }else if (i == 6) {
                        for (int j = 0; j < 14; j++) {
                            if (j == 1 || j == 2|| j == 3 || j == 4 || j == 5 || j == 6 || j == 7 || j == 8 || j == 9 || j == 10 || j == 11 || j ==12) {
                                n = 2;
                                bricks[k] = new Brick(j * 51 + 30, i * 30 + 50, n);
                                atk[k] = new ATK();
                                k++;
                            }else {
                                n = 7;
                                bricks[k] = new Brick(j * 51 + 30, i * 45 + 65, n);
                                atk[k] = new ATK();
                                k++;
                            }
                        }
                    }else if (i == 7) {
                        for (int j = 0; j < 14; j++) {
                            n = 3;
                            bricks[k] = new Brick(j * 51 + 30, i * 30 + 45, n);
                            atk[k] = new ATK();
                            k++;
                        }
                    }else if (i == 8) {
                        for (int j = 0; j < 14; j++) {
                            n = 4;
                            bricks[k] = new Brick(j * 51 + 30, i * 30 + 38, n);
                            atk[k] = new ATK();
                            k++;
                        }
                    }else if (i == 9) {
                        n = 5;
                        for (int j = 0; j < 14; j++) {
                            bricks[k] = new Brick(j * 51 + 30, i * 30 + 30, n);
                            atk[k] = new ATK();
                            k++;
                        }
                    }else if (i == 10) {
                        n = 1;
                        for (int j = 0; j < 14; j++) {
                            bricks[k] = new Brick(j * 51 + 30, i * 30 + 26, n);
                            atk[k] = new ATK();
                            k++;
                        }
                    }else if (i == 11) {
                        n = 1;
                        for (int j = 0; j < 14; j++) {
                            bricks[k] = new Brick(j * 51 + 30, i * 30 + 30, n);
                            atk[k] = new ATK();
                            k++;
                        }
                    }else if (i == 12) {
                        n = 5;
                        for (int j = 0; j < 14; j++) {
                            bricks[k] = new Brick(j * 51 + 30, i * 30 + 32, n);
                            atk[k] = new ATK();
                            k++;
                        }
                    }
                }
            }
    }


    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
         if (ingame ) {
            drawObjects(g2d);
        } else {
            gameFinished(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics2D g2d) {

        if (background.getIsBackground()){
            g2d.drawImage(background.getImage(), background.getX(), background.getY(),
                    background.getWidth(), background.getHeight(), this);
        }
        if (stage == -1) {
            if (prinsess.getPrinsess()) {
                g2d.drawImage(prinsess.getImage(), prinsess.getX(), prinsess.getY(),
                        prinsess.getWidth(), prinsess.getHeight(), this);
            }
        }


        if (stage == 0){
        if (prince.getPrince()) {
            g2d.drawImage(prince.getImage(), prince.getX(), prince.getY(),
                    prince.getWidth(), prince.getHeight(), this);
        }

        Font font = new Font("Verdana", Font.BOLD, 18);
            g2d.setColor(Color.white);
            g2d.setFont(font);
            g2d.drawString("Once upon a time ...", 20, Commons.WIDTH - 740 );
            g2d.drawString("The world is full of the magic and brave princess was perpetrated captured.", 22, Commons.WIDTH - 709 );
            g2d.drawString("He is a brave man who will aim to eliminate perpetrated.", 20, Commons.WIDTH - 674 );
            g2d.drawString("And help to free the princess.", 20, Commons.WIDTH - 647 );
            g2d.drawString("But .... We have a big problem in a way that ...", 20, Commons.WIDTH - 615 );
            g2d.drawString("This was a brave man. ... I do not hold a sword cut it in!", 20, Commons.WIDTH - 587 );
            g2d.drawString("Here 'Eric' the brave protagonist of this game.", 20, Commons.WIDTH - 380 );
            g2d.drawString("Okay, to be a little arduous. But we have to root for him a little better.", 20, Commons.WIDTH - 350);
            g2d.drawString("-> -> -> Presse Right Control -> -> ->", 380, Commons.WIDTH - 270 );

        }else if (stage == -1){
            Font font = new Font("Verdana", Font.BOLD, 18);
            g2d.setColor(Color.white);
            g2d.setFont(font);
            g2d.drawString("Until then the adventure....", 20, Commons.WIDTH - 740 );
            g2d.drawString("The need to rescue the princess castle perpetrated it out to be.",20,Commons.WIDTH - 709);
            g2d.drawString("Her name is Adelina",20,Commons.WIDTH - 674);
            g2d.drawString("-> -> -> Presse Right Control To Start Game -> -> -> ", 280, Commons.WIDTH - 270 );
        }else if (stage == 5){
            Font font = new Font("Verdana", Font.BOLD, 18);
            g2d.setColor(Color.white);
            g2d.setFont(font);
            g2d.drawString("After killing perpetrated successfully.", 20, Commons.WIDTH - 740 );
            g2d.drawString("It takes a brave princess castle return safely and happily together.",20,Commons.WIDTH - 709);
            g2d.drawString("-> -> -> Presse Right Control -> -> ->", 380, Commons.WIDTH - 270 );
        }

        g2d.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
                paddle.getWidth(), paddle.getHeight(), this);

        if (stage >=1 && confirm ) {

            for (Ball numball : balls) {
                if (numball.getIsBall()) {
                    g2d.drawImage(numball.getImage(), numball.getX(), numball.getY(),
                            numball.getWidth(), numball.getHeight(), this);
                }
            }

            if (wizard.getWizard()) {
                g2d.drawImage(wizard.getImage(), wizard.getX(), wizard.getY(),
                        wizard.getWidth(), wizard.getHeight(), this);
            }

            for (int i = 0; i < N_OF_BRICKS; i++) {
                if (!bricks[i].isDestroyed()) {
                    g2d.drawImage(bricks[i].getImage(), bricks[i].getX(),
                            bricks[i].getY(), bricks[i].getWidth(),
                            bricks[i].getHeight(), this);
                }

                if (boss.getBoss()) {
                    g2d.drawImage(boss.getImage(), boss.getX(), boss.getY(),
                            boss.getWidth(), boss.getHeight(), this);
                }

                if (atk[i].getIsAtk()) {
                    g2d.drawImage(atk[i].getImage(), atk[i].getX(),
                            atk[i].getY(), atk[i].getWidth(),
                            atk[i].getHeight(), this);
                }

                if (item.isItem()) {
                    if (item.getX() != 0 && item.getY() != 0) {
                        g2d.drawImage(item.getImage(), item.getX(), item.getY(),
                                item.getWidth(), item.getHeight(), this);
                    }
                }
            }
        }
    }


    private void newGame() {
        Akanoid game = new Akanoid();
        game.setVisible(true);
        ball.move();
        paddle.move();
        checkCollision();
        repaint();
    }


    private void gameFinished(Graphics2D g2d) {
        //JOptionPane.showMessageDialog(null, message);
        Font font = new Font("Verdana", Font.BOLD, 50);
        FontMetrics metr = this.getFontMetrics(font);

        g2d.setColor(Color.black);
        g2d.setFont(font);
        if (nball <= 0) {
            g2d.drawString(message,
                    (Commons.WIDTH - metr.stringWidth(message)) / 2,
                    Commons.WIDTH - 600);
            g2d.drawString(message1,
                    Commons.WIDTH - metr.stringWidth(message) - 430,
                    Commons.WIDTH - 480);
            String Score = Integer.toString(score);
            g2d.drawString(Score,
                    Commons.WIDTH - metr.stringWidth(message) - 80,
                    Commons.WIDTH - 480);
        }else if (){
            g2d.drawString(message,
                    (Commons.WIDTH - metr.stringWidth(message)) / 2,
                    Commons.WIDTH - 600 );
            g2d.drawString(message1,
                    Commons.WIDTH - metr.stringWidth(message)-430,
                    Commons.WIDTH - 480 );
            String Score = Integer.toString(score);
            g2d.drawString(Score,
                    Commons.WIDTH - metr.stringWidth(message)-80,
                    Commons.WIDTH - 480 );
        }
       // endGame();
        //message = "New Game";
        //JOptionPane.showMessageDialog(null, message);
        //newGame();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            paddle.keyPressed(e);
        }
    }


    public void endGame() {
        setVisible(false);
    }


    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            if (stage >= 1 && confirm  && stage != 5 && stage != 6) {
                randomatk = (int) Math.random() * 2;
                for (Ball numBall : balls) {
                    if (numBall.getIsBall())
                        numBall.move();
                }

                for (ATK iatk : atk) {
                    if (iatk.getIsAtk())
                        iatk.move();
                }
                if (boss.getBoss())
                    boss.move();
                item.move();
                checkCollision();
            }else if (stage <= 0 || stage == 5 ){
                check();
            }
            paddle.move();
            repaint();
        }

    }

    private void stopGame() {

        ingame = false;
        timer.cancel();

    }


    private void checkCollision() {

        System.out.println(score);
        if (item.getY() > Commons.BOTTOM_EDGE) {
            item.setisItem();
        }

        if (boss.getHp() <= 0){
           // message = "Victory";
            //JOptionPane.showMessageDialog(null, message);
            //System.out.println(score);
            confirm = false;
            stage = 5;
            //nextStage();
            //stopGame();
        }



        if (item.getWidth() != 0 && item.getHeight() != 0) {
            if ((item.getRect()).intersects(paddle.getRect()) && item.isItem()) {
                if (item.getType() == 1) {
                    paddle.setState(paddle.getState() + 1);
                    paddle.setItem();
                } else if (item.getType() == 2) {
                    paddle.setMoveSpeed(paddle.getMoveSpeed() + 1);
                } else if (item.getType() == 3) {
                    Ball newBall = new Ball(nball);
                    balls.add(newBall);
                    nball++;
                    System.out.println(nball);
                } else if (item.getType() == 4) {
                    if (item4 >= 1) item4 = 1;
                    else item4++;
                } else if (item.getType() == 5) {
                    item5 = 1;
                }
                item.setisItem();
                wizard.setWizard(true);
            }
        }

        for (int i = 0, j = 0; i < N_OF_BRICKS; i++) {


            if (bricks[i].isDestroyed() ) {
                j++;
            }

            if (j == N_OF_BRICKS) {

                if (stage >= 0) {
                 /*   String[] button = {"OK"};
                  int n =  JOptionPane.showOptionDialog(null, "Next Stage","",JOptionPane.OK_CANCEL_OPTION,
                          JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    if ( n == JOptionPane.OK_OPTION )
                    {*/
                        stage++;
                        nextStage();
                 //  }
                }

            }
        }
        for (Ball numBall : balls) {
            if (numBall.getRect().getMaxY() > Commons.BOTTOM_EDGE) {
                if (item4 >= 1 && !(numBall.getNumber() == 500)) {
                    int random = (int) Math.random() * 2;
                    numBall.setXDir(0);
                    numBall.setYDir(-1);
                    item4--;
                } else if (numBall.getIsBall()) {
                    numBall.setIsBall(false);
                    if (numBall.getNumber() == 500) {
                        nball++;
                        item5 = 0;
                    }
                    nball--;
                    System.out.println(nball + " " + nball);
                }


                if (nball <= 0) stopGame();
            }

            if (item5 >= 1) {
                if (numBall.getNumber() == 500)
                    if (!numBall.getIsBall()) {
                        numBall.setY(INIT_BALL_Y);
                        numBall.setX(0);
                        numBall.setXDir(1);
                        numBall.setYDir(-1);
                        numBall.setIsBall(true);
                    }
            } else if (item5 < 0 && numBall.getNumber() == 500)
                numBall.setIsBall(false);


            if ((numBall.getRect()).intersects(paddle.getRect())) {
                if (numBall.getNumber() == 500 && numBall.getIsBall()) {
                    if (item5 == 1)
                        item5 = 0;
                    else if (item5 == 0)
                        item5 = -1;
                    ;
                }
                int paddleLPos = (int) paddle.getRect().getMinX();
                int ballLPos = (int) numBall.getRect().getMinX();

                int first = paddleLPos + 8;
                int second = paddleLPos + 16;
                int third = paddleLPos + 24;
                int fourth = paddleLPos + 32;

                if (ballLPos < first) {
                    numBall.setXDir(-1);
                    numBall.setYDir(-1);
                }

                if (ballLPos >= first && ballLPos < second) {
                    numBall.setXDir(-1);
                    numBall.setYDir(-1 * numBall.getYDir());
                }

                if (ballLPos >= second && ballLPos < third) {
                    numBall.setXDir(0);
                    numBall.setYDir(-1);
                }

                if (ballLPos >= third && ballLPos < fourth) {
                    numBall.setXDir(1);
                    numBall.setYDir(-1 * numBall.getYDir());
                }

                if (ballLPos > fourth) {
                    numBall.setXDir(1);
                    numBall.setYDir(-1);
                }
            }
        }


        for (int i = 0; i < N_OF_BRICKS; i++) {

            if (bricks[i].isDestroyed() && bricks[i].getType() != 7){
                if (boss.getBoss()){
                    int random2 = (int) (Math.random()*30000)+1;
                    if (random2%13 == 0 && bossatk == 2 && (rebrick > 0 && rebrick < 6)) {
                        System.out.println("555");
                        rebrick--;
                        if (rebrick == 0){
                            bossatk = 0;
                            rebrick = 1;
                        }
                        System.out.println("bossatk  " + rebrick);
                        bricks[i].setBoss();
                    }
                }
            }
            if (atk[i].getWidth() != 0 && atk[i].getHeight() != 0) {
                if ((paddle.getRect()).intersects(atk[i].getRect()) && atk[i].getIsAtk()) {
                    if (atk[i].getType() == 3) {
                        paddle.setState(paddle.getState() - 1);
                        paddle.setItem();
                        atk[i].setIsAtk();
                        System.out.println(item.getType());
                    } else if (atk[i].getType() == 4) {
                        paddle.setMoveState(paddle.getMoveState() + 1);
                        atk[i].setIsAtk();
                        System.out.println("move " + paddle.getMoveState());
                    } else if (atk[i].getType() == 1) {
                        paddle.setMoveSpeed(paddle.getMoveSpeed() - 1);
                        atk[i].setIsAtk();
                        System.out.println("moveSpeed " + paddle.getMoveSpeed());
                    }
                    wizard.setWizard(false);
                    if (stage != 4) {
                        stage++;
                        nextStage();
                    }
                }
            }

            for (Ball numBall : balls) {

                if (boss.getBoss()) {
                    if ((numBall.getRect()).intersects(boss.getRect())) {
                        bossatk++;
                        boss.setHp(boss.getHp()-1);
                        System.out.println("bosshp " + boss.getHp());
                        System.out.println("bosshit " + bossatk);
                        if (bossatk == 2) rebrick = 1;
                        int paddleLPos = (int) boss.getRect().getMinX();
                        int ballLPos = (int) numBall.getRect().getMinX();

                        int first = paddleLPos + 8;
                        int second = paddleLPos + 16;
                        int third = paddleLPos + 24;
                        int fourth = paddleLPos + 32;

                        if (ballLPos < first) {
                            numBall.setXDir(-1);
                            numBall.setYDir(-1);
                        }

                        if (ballLPos >= first && ballLPos < second) {
                            numBall.setXDir(-1);
                            numBall.setYDir(-1 * numBall.getYDir());
                        }

                        if (ballLPos >= second && ballLPos < third) {
                            numBall.setXDir(0);
                            numBall.setYDir(-1);
                        }

                        if (ballLPos >= third && ballLPos < fourth) {
                            numBall.setXDir(1);
                            numBall.setYDir(-1 * numBall.getYDir());
                        }

                        if (ballLPos > fourth) {
                            numBall.setXDir(1);
                            numBall.setYDir(-1);
                        }
                    }
                }


                if (!bricks[i].isDestroyed()) {
                        int random1 = (int) (Math.random() * 50000) + 1;
                        if ((random1 == 1 || random1 == 3 || random1 == 4) && random1 == bricks[i].getType()) {
                            atk[i] = new ATK(random1);
                            System.out.println("atk  is  " + atk[i].getType());
                            atk[i].setXDir(bricks[i].getX());
                            atk[i].setYDir(bricks[i].getY());
                        }


                        if ((numBall.getRect()).intersects(bricks[i].getRect())) {
                            if (item5 >= 0 && numBall.getNumber() == 500) {
                                bricks[i].overDestroyed();
                            }
                            wizard.setWizard(false);

                            int ballLeft = (int) numBall.getRect().getMinX();
                            int ballHeight = (int) numBall.getRect().getHeight();
                            int ballWidth = (int) numBall.getRect().getWidth();
                            int ballTop = (int) numBall.getRect().getMinY();

                            Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                            Point pointLeft = new Point(ballLeft - 1, ballTop);
                            Point pointTop = new Point(ballLeft, ballTop - 1);
                            Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

                            if (!bricks[i].isDestroyed()) {
                                if (bricks[i].getRect().contains(pointRight)) {
                                    numBall.setXDir(-1);
                                } else if (bricks[i].getRect().contains(pointLeft)) {
                                    numBall.setXDir(1);
                                }

                                if (bricks[i].getRect().contains(pointTop)) {
                                    numBall.setYDir(1);
                                } else if (bricks[i].getRect().contains(pointBottom)) {
                                    numBall.setYDir(-1);
                                }
                                bricks[i].setDestroyed();
                            }
                            if (bricks[i].isDestroyed()) {
                                if (bricks[i].getType() == 0) score += 100;
                                else if (bricks[i].getType() == 1) score += 150;
                                else if (bricks[i].getType() == 2) score += 300;
                                else if (bricks[i].getType() == 3) score += 350;
                                else if (bricks[i].getType() == 4) score += 250;
                                else if (bricks[i].getType() == 5) score += 500;
                                else if (bricks[i].getType() == 6) score += 400;
                                if (!item.isItem()) {
                                    int random = (int) (Math.random() * 20) + 1;
                                    item = new Item(random);
                                    item.itemType(item.getType());
                                    item.setXDir(bricks[i].getX());
                                    item.setYDir(bricks[i].getY());
                                }

                            }
                        }
                    }
                }
            }
        }

    private void check(){
        if (paddle.getX() >= 700) {
            if (stage == 0)
                gameInit(-1);
            else if (stage == -1) {
                gameInit(1);
                confirm = true;
            } else if (stage == 5) {
                gameInit(6);
            } else if (stage == 6) {
                message = "Victory";
                stopGame();
            }
        }
    }
}