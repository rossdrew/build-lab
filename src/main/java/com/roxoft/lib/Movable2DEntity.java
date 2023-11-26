package com.roxoft.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Mutable entity on a {@link IntegerCoord2D} co-ordinate system which retains a movement history.
 */
public final class Movable2DEntity {
    /** The history of {@link IntegerCoord2D} visited by this {@link Movable2DEntity}. */
    private final List<IntegerCoord2D> locationHistory;
    /** This {@link Movable2DEntity}s current {@link IntegerCoord2D} location. */
    private IntegerCoord2D location;

    private Movable2DEntity(final IntegerCoord2D currentLocation) {
        location = currentLocation;
        locationHistory = new ArrayList<>();
        locationHistory.add(currentLocation);
    }

    /**
     * @param startLocation indicates a start location for this {@link Movable2DEntity}
     * @return a new {@link Movable2DEntity} at the specified {@link IntegerCoord2D} location
     */
    public static Movable2DEntity at(final IntegerCoord2D startLocation) {
        return new Movable2DEntity(startLocation);
    }

    /**
     * Move this {@link Movable2DEntity}s {@link IntegerCoord2D} location Up/North one space.
     */
    public void moveUp() {
        move(IntegerCoord2D.of(location.getX(), location.getY() - 1));
    }

    /**
     * Move this {@link Movable2DEntity}s {@link IntegerCoord2D} location Down/South one space.
     */
    public void moveDown() {
        move(IntegerCoord2D.of(location.getX(), location.getY() + 1));
    }

    /**
     * Move this {@link Movable2DEntity}s {@link IntegerCoord2D} location Left/West one space.
     */
    public void moveLeft() {
        move(IntegerCoord2D.of(location.getX() - 1, location.getY()));
    }

    /**
     * Move this {@link Movable2DEntity}s {@link IntegerCoord2D} location Right/East one space.
     */
    public void moveRight() {
        move(IntegerCoord2D.of(location.getX() + 1, location.getY()));
    }

    /**
     * @param newLocation a {@link IntegerCoord2D} to move this {@link Movable2DEntity} to.
     */
    private void move(final IntegerCoord2D newLocation) {
        locationHistory.add(newLocation);
        location = newLocation;
    }

    /**
     * @return this {@link Movable2DEntity}s {@link IntegerCoord2D} location.
     */
    public IntegerCoord2D location() {
        return location;
    }

    /**
     * @return this {@link Movable2DEntity}s history of {@link IntegerCoord2D} location.
     */
    public List<IntegerCoord2D> locationHistory() {
        return locationHistory;
    }
}
