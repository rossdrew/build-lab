package com.roxoft.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Mutable entity on a {@link com.roxoft.lib.Coord2D} co-ordinate system which retains a movement history.
 */
public final class Movable2DEntity {
    /** The history of {@link com.roxoft.lib.Coord2D} visited by this {@link Movable2DEntity}. */
    private List<Coord2D> locationHistory;
    /** This {@link Movable2DEntity}s current {@link com.roxoft.lib.Coord2D} location. */
    private Coord2D location;

    private Movable2DEntity(final Coord2D currentLocation) {
        location = currentLocation;
        locationHistory = new ArrayList<>();
        locationHistory.add(currentLocation);
    }

    public static Movable2DEntity at(final Coord2D startLocation){
        return new Movable2DEntity(startLocation);
    }

    /**
     * Move this {@link Movable2DEntity}s {@link com.roxoft.lib.Coord2D} location Up/North one space.
     *
     * @return the new {@link com.roxoft.lib.Coord2D} location.
     */
    public Coord2D moveUp() {
        return move(Coord2D.of(location.getX(), location.getY() - 1));
    }

    /**
     * Move this {@link Movable2DEntity}s {@link com.roxoft.lib.Coord2D} location Down/South one space.
     *
     * @return the new {@link com.roxoft.lib.Coord2D} location.
     */
    public Coord2D moveDown() {
        return move(Coord2D.of(location.getX(), location.getY() + 1));
    }

    /**
     * Move this {@link Movable2DEntity}s {@link com.roxoft.lib.Coord2D} location Left/West one space.
     *
     * @return the new {@link com.roxoft.lib.Coord2D} location.
     */
    public Coord2D moveLeft() {
        return move(Coord2D.of(location.getX() - 1, location.getY()));
    }

    /**
     * Move this {@link Movable2DEntity}s {@link com.roxoft.lib.Coord2D} location Right/East one space.
     *
     * @return the new {@link com.roxoft.lib.Coord2D} location.
     */
    public Coord2D moveRight() {
        return move(Coord2D.of(location.getX() + 1, location.getY()));
    }

    /**
     * @param newLocation a {@link com.roxoft.lib.Coord2D} to move this {@link Movable2DEntity} to.
     *
     * @return the new {@link com.roxoft.lib.Coord2D} location.
     */
    private Coord2D move(final Coord2D newLocation) {
        locationHistory.add(newLocation);
        location = newLocation;
        return newLocation;
    }

    /**
     * @return this {@link Movable2DEntity}s {@link com.roxoft.lib.Coord2D} location.
     */
    public Coord2D location() {
        return location;
    }

    /**
     * @return this {@link Movable2DEntity}s history of {@link com.roxoft.lib.Coord2D} location.
     */
    public List<Coord2D> locationHistory(){
        return locationHistory;
    }
}