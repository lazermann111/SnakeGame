package com.company.gameobjects;


import java.util.ArrayList;
import java.util.List;

public class Snake extends GameObject {
    private final static char SNAKE_CELL = 'Y';
    private final static char SNAKE_TAIL = '$';

    private Point2D head;
    private List<Point2D> tail;

    public Snake(int x, int y) {
        super(x, y);
        head = new Point2D(x, y);
        tail = new ArrayList<>();
    }

    private void addSegment() {
        if (tail.isEmpty()) {
            tail.add(new Point2D(head.getX(), head.getY()));
        } else {
            Point2D last = tail.get(tail.size() - 1);
            tail.add(new Point2D(last));
        }
    }

    public void draw(Screen screen) {
        screen.draw(head.getX(), head.getY(), getSymbol());
        // tail.forEach(a -> screen.draw(a.x, a.y, getSymbol()));
        for (Point2D s : tail) {
            screen.draw(s.getX(), s.getY(), SNAKE_TAIL);
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

    public void checkTailCollisions() {
        //if(tail.stream().anyMatch(a -> a.equals(head)))
        for (Point2D t : tail)
        {
            if (t.equals(head))
            {
                System.out.println("GAME OVER!");
                System.exit(0);
            }
        }
    }

    @Override
    public char getSymbol() {
        return SNAKE_CELL;
    }

    private void moveTail() {
        if (tail.isEmpty()) return;
        tail.get(0).setPosition(head);
        for (int i = tail.size() - 1; i > 0; i--) {
            tail.get(i).setPosition(tail.get(i - 1));
        }
    }

    public void moveLeft(Screen screen, Snake snake) {
        moveTail();
        snake.head.setX(getX() - 1);
    }

    public void moveRight(Screen screen, Snake snake) {
        moveTail();
        snake.head.setX(getX() + 1);
    }

    public void moveUp(Screen screen, Snake snake) {
        moveTail();
        snake.head.setY(getY() - 1);
    }

    public void moveDown(Screen screen, Snake snake) {
        moveTail();
        snake.head.setY(getY() + 1);
    }

    @Override
    public int getX() {
        return head.getX();
    }

    @Override
    public int getY() {
        return head.getY();
    }

    @Override
    public boolean collides(GameObject other) {
        return this.head.getX() == other.position.getX()
                && this.head.getY() == other.position.getY();
    }
}
