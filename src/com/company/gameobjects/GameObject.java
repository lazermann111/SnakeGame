package com.company.gameobjects;


public abstract class GameObject {
    protected Point2D position;
    public abstract char getSymbol();

    public GameObject(int x, int y) {
        position = new Point2D(x,y);
    }

    public int getX() {
        return position.getX();
    }

    public void setX(int x) {
        this.position.setX(x);
    }

    public int getY() {
        return position.getY();
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    public boolean collides(GameObject other)
    {
        return this.position.getX() == other.position.getX()
                && this.position.getY() == other.position.getY();
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }
}
