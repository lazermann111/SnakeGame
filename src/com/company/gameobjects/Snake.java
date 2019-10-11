package com.company.gameobjects;


public class Snake extends GameObject {
    private final static char SNAKE_CELL ='Y';

    public Snake(int x, int y) {
        super(x, y);
    }

    private void addSegment()
    {

    }

    public void applyCollisionEffect(GameObject collider)
    {
        if(collider instanceof Food)
        {
            addSegment();
        }
        else if(collider instanceof Wall)
        {
            System.out.println("GAME OVER!");
            System.exit(0);
        }
        else if(collider instanceof Snake) //shouldn't happen yet
        {
            System.out.println("Snake collides with itself??");
        }
    }


    @Override
    public char getSymbol() {
        return SNAKE_CELL;
    }


    public void moveLeft(Screen screen, Snake snake) {
        snake.setX(getX() - 1);
    }

    public void moveRight(Screen screen, Snake snake) {
        snake.setX(getX() + 1);
    }

    public void moveUp(Screen screen, Snake snake) {
        snake.setY(getY() - 1);
    }

    public void moveDown(Screen screen, Snake snake) {
        snake.setY(getY() + 1);
    }

}
