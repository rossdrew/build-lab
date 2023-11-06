package com.roxoft.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Mutable entity on a {@link Coord2D} co-ordinate system which retains a movement history.
 */
public final class Movable2DEntity {
    /** The history of {@link Coord2D} visited by this {@link Movable2DEntity}. */
    private List<Coord2D> locationHistory;
    /** This {@link Movable2DEntity}s current {@link Coord2D} location. */
    private Coord2D location;

    private Movable2DEntity(final Coord2D currentLocation) {
        location = currentLocation;
        locationHistory = new ArrayList<>();
        locationHistory.add(currentLocation);
    }

    /**
     * @param startLocation indicates a start location for this {@link Movable2DEntity}
     * @return a new {@link Movable2DEntity} at the specified {@link Coord2D} location
     */
    public static Movable2DEntity at(final Coord2D startLocation) {
        return new Movable2DEntity(startLocation);
    }

    /**
     * Move this {@link Movable2DEntity}s {@link Coord2D} location Up/North one space.
     */
    public void moveUp() {
        move(Coord2D.of(location.getX(), location.getY() - 1));
    }

    /**
     * Move this {@link Movable2DEntity}s {@link Coord2D} location Down/South one space.
     */
    public void moveDown() {
        move(Coord2D.of(location.getX(), location.getY() + 1));
    }

    /**
     * Move this {@link Movable2DEntity}s {@link Coord2D} location Left/West one space.
     */
    public void moveLeft() {
        move(Coord2D.of(location.getX() - 1, location.getY()));
    }

    /**
     * Move this {@link Movable2DEntity}s {@link Coord2D} location Right/East one space.
     */
    public void moveRight() {
        move(Coord2D.of(location.getX() + 1, location.getY()));
    }

    /**
     * @param newLocation a {@link Coord2D} to move this {@link Movable2DEntity} to.
     */
    private void move(final Coord2D newLocation) {
        locationHistory.add(newLocation);
        location = newLocation;
    }

    /**
     * @return this {@link Movable2DEntity}s {@link Coord2D} location.
     */
    public Coord2D location() {
        return location;
    }

    /**
     * @return this {@link Movable2DEntity}s history of {@link Coord2D} location.
     */
    public List<Coord2D> locationHistory() {
        return locationHistory;
    }
}
