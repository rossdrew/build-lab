package com.roxoft.lib;

import java.util.Objects;

public class Coord2D {
    private final int xCoordinate;
    private final int yCoordinate;

    private Coord2D(final int x,
                    final int y){
        xCoordinate = x;
        yCoordinate = y;
    }

    public static Coord2D of(final int x, final int y){
        return new Coord2D(x, y);
    }

    public int getX(){
        return xCoordinate;
    }

    public int getY(){
        return yCoordinate;
    }

    @Override
    public String toString() {
        return "Loc (" + xCoordinate +
                ", " + yCoordinate +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord2D coord2D = (Coord2D) o;
        return xCoordinate == coord2D.xCoordinate && yCoordinate == coord2D.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
