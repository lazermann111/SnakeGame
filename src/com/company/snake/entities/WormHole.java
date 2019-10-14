package com.company.snake.entities;

public class WormHole extends GameObject {

    private WormHole adjacent;

    public WormHole(int x, int y) {
        super(x, y);
    }

    public void passWormHole(Snake s)
    {
        s.getHead().setPosition(adjacent.position);
    }

    public void setAdjacent(WormHole adjacent) {
        this.adjacent = adjacent;
    }

    @Override
    public char getSymbol() {
        return adjacent != null ? '@' : 'x';
    }
}
