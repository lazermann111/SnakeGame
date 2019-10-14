package com.company.gameobjects;


import java.util.ArrayList;
import java.util.List;

public class Snake extends GameObject {
    private final static char SNAKE_CELL = 'Y';

    private Point2D head;
    private List<Point2D> tail;

    public Snake(int x, int y) {
        super(x, y);
        head = new Point2D(x, y);
        tail = new ArrayList<>();
    }

    private void addSegment() {

    }

    public void draw(Screen screen) {
        screen.draw(head.getX(), head.getY(), getSymbol());
        // tail.forEach(a -> screen.draw(a.x, a.y, getSymbol()));
        for (Point2D s : tail) {
            screen.draw(s.getX(), s.getY(), getSymbol());
        }
    }

    public void applyCollisionEffect(GameObject collider) {
        if (collider instanceof Food) {
            addSegment();
        } else if (collider instanceof Wall) {
            System.out.println("GAME OVER!");
            System.exit(0);
        } else if (collider instanceof Snake) //shouldn't happen yet
        {
            System.out.println("Snake collides with itself??");
        }
    }


    @Override
    public char getSymbol() {
        return SNAKE_CELL;
    }

    private void moveTail() {
        if(tail.isEmpty()) return;

        tail.get(0).setPosition(head);
        for (int i = 1; i < tail.size() - 1; i++) {
            tail.get(i).setPosition(tail.get(i + 1));
        }
    }

    public void moveLeft(Screen screen, Snake snake) {
        snake.setX(getX() - 1);
        moveTail();
    }

    public void moveRight(Screen screen, Snake snake) {
        snake.setX(getX() + 1);
        moveTail();
    }

    public void moveUp(Screen screen, Snake snake) {
        snake.setY(getY() - 1);
        moveTail();
    }

    public void moveDown(Screen screen, Snake snake) {
        snake.setY(getY() + 1);
        moveTail();
    }

}
