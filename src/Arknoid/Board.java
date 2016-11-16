package Arknoid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Board extends JPanel implements Commons {
    private Timer timer;
    private String message = "Game Over";
    private Ball ball;
    private ArrayList<Ball> balls;
    private Paddle paddle;
    private Brick bricks[];
    private Brick1 bricks1[];
    private boolean ingame = true;
    private int stage = 0;
    private int n,count = 0;
    private int nball;
    private Item item;



    public Board() {
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);

        balls = new ArrayList<>();
        bricks = new Brick[N_OF_BRICKS];
        bricks1 = new Brick1[N_OF_BRICKS];
        setDoubleBuffered(true);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), DELAY, PERIOD);

    }

    private void nextStage() {


        gameInit2();
    }

    @Override
    public void addNotify() {

        super.addNotify();
        gameInit();
    }

    private void gameInit() {

        balls.add(new Ball());
        balls.add(new Ball());

        item = new Item();
        paddle = new Paddle();

        nball = balls.size();
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                bricks[k] = new Brick(j * 100 + 100, i * 40 + 50, 3);
                k++;
            }
        }
    }

    private void gameInit2() {


        ball = new Ball();
        paddle = new Paddle();
        count++;
        int k = 0;
        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            n = rand.nextInt(count)+1;


            for (int j = 0; j < 6; j++) {

                bricks[k] = new Brick(j * 100 + 100, i * 40 + 50, k%n);
                k++;
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

        if (ingame) {
            drawObjects(g2d);
        }else {
            gameFinished();
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics2D g2d) {
            for (Ball numball : balls) {
                g2d.drawImage(numball.getImage(), numball.getX(), numball.getY(),
                        numball.getWidth(), numball.getHeight(), this);
            }
            g2d.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
                    paddle.getWidth(), paddle.getHeight(), this);

            for (int i = 0; i < N_OF_BRICKS; i++) {
                if (!bricks[i].isDestroyed()) {
                    g2d.drawImage(bricks[i].getImage(), bricks[i].getX(),
                            bricks[i].getY(), bricks[i].getWidth(),
                            bricks[i].getHeight(), this);
                }

                if (item.isItem()){
                    if (item.getX() != 0 && item.getY() != 0) {
                        g2d.drawImage(item.getImage(), item.getX(), item.getY(),
                                item.getWidth(), item.getHeight(), this);
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

    private void gameFinished() {
        JOptionPane.showMessageDialog(null, message);
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

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            for (Ball numBall : balls){
                numBall.move();
            }
            //ball.move();
            item.move();
            paddle.move();
            checkCollision();
            repaint();
        }
    }

    private void stopGame() {

        ingame = false;
        timer.cancel();
    }


    private void checkCollision() {

        if (nball <= 0) stopGame();

        if (item.getY() > Commons.BOTTOM_EDGE ){
            item.setisItem();
        }

        if(item.getWidth() != 0 && item.getHeight() != 0){
            if((item.getRect()).intersects(paddle.getRect())) {
                paddle.setItem();
                item.setisItem();
            }
        }

        for (int i = 0, j = 0; i < N_OF_BRICKS; i++) {

            if (bricks[i].isDestroyed()) {
                j++;
            }

            if (j == N_OF_BRICKS) {
                stage++;
                if (stage<=2){
                    JOptionPane.showMessageDialog(null, "Next Stage");
                    nextStage();
                }else {
                    message = "Victory";
                    stopGame();

                }

            }
        }
        for (Ball numBall : balls) {
            if (numBall.getRect().getMaxY() > Commons.BOTTOM_EDGE) {
                if (numBall.getIsBall()) {
                    numBall.setIsBall();
                    nball--;
                }
            }

            if ((numBall.getRect()).intersects(paddle.getRect())) {

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
            for (Ball numBall : balls) {
            if (!bricks[i].isDestroyed()) {
                if ((numBall.getRect()).intersects(bricks[i].getRect())) {
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
                    }
                    if (bricks[i].isDestroyed()){
                        if (!item.isItem()) {
                            int random = (int) (Math.random() * 3) + 1;
                        if (random == 1){
                            paddle.setState(paddle.getState()+1);
                        }else if (random == 2){
                            paddle.setState(paddle.getState()-1);
                        }else if (random == 3){
                            //nums++;
                        }
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