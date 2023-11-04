package com.roxoft.aoc.y2015.Day3;

import com.roxoft.aoc.UnexpectedSolutionException;
import com.roxoft.lib.Coord2D;

import java.util.ArrayList;
import java.util.List;

public final class Day3 {
    /** List of instructions to follow. */
    private final String instructions;
    /** The {@link List} of {@link Santa}s that will be visiting houses. */
    private final List<Santa> santas;
    /** Which {@link Santa} is receiving the next instruction. **/
    private int santaFocus = 0;

    //This should possibly be a class with a private constructor
    public final class Santa {
        /** The history of {@link com.roxoft.lib.Coord2D} visited by this {@link Santa}. */
        private List<Coord2D> locationHistory;
        /** This {@link Santa}s current {@link com.roxoft.lib.Coord2D} location. */
        private Coord2D location;

        private Santa(final Coord2D currentLocation) {
            location = currentLocation;
            locationHistory = new ArrayList<>();
            locationHistory.add(currentLocation);
        }

        /**
         * Move this {@link Santa}s {@link com.roxoft.lib.Coord2D} location Up/North one space.
         *
         * @return the new {@link com.roxoft.lib.Coord2D} location.
         */
        public Coord2D moveUp() {
            return move(Coord2D.of(location.getX(), location.getY() - 1));
        }

        /**
         * Move this {@link Santa}s {@link com.roxoft.lib.Coord2D} location Down/South one space.
         *
         * @return the new {@link com.roxoft.lib.Coord2D} location.
         */
        public Coord2D moveDown() {
            return move(Coord2D.of(location.getX(), location.getY() + 1));
        }

        /**
         * Move this {@link Santa}s {@link com.roxoft.lib.Coord2D} location Left/West one space.
         *
         * @return the new {@link com.roxoft.lib.Coord2D} location.
         */
        public Coord2D moveLeft() {
            return move(Coord2D.of(location.getX() - 1, location.getY()));
        }

        /**
         * Move this {@link Santa}s {@link com.roxoft.lib.Coord2D} location Right/East one space.
         *
         * @return the new {@link com.roxoft.lib.Coord2D} location.
         */
        public Coord2D moveRight() {
            return move(Coord2D.of(location.getX() + 1, location.getY()));
        }

        /**
         * @param newLocation a {@link com.roxoft.lib.Coord2D} to move this {@link Santa} to.
         *
         * @return the new {@link com.roxoft.lib.Coord2D} location.
         */
        private Coord2D move(final Coord2D newLocation) {
            locationHistory.add(newLocation);
            location = newLocation;
            return newLocation;
        }

        /**
         * @return this {@link Santa}s {@link com.roxoft.lib.Coord2D} location.
         */
        public Coord2D location() {
            return location;
        }
    }

    /**
     * @param santaNumber the number of the desired {@link Santa}.
     * @return The {@link Santa} identified by the provided santaNumber
     */
    public Santa getSanta(final int santaNumber) {
        return santas.get(santaNumber);
    }

    private Day3(final String instructionSequence) {
        instructions = instructionSequence;
        santas = new ArrayList<>();
    }

    private Day3(final String instructionSequence, final List<Santa> predefinedSantas) {
        instructions = instructionSequence;
        santas = predefinedSantas;
    }

    /**
     * @param instructionSequence A {@link String} representing a series of instructions
     *
     * @return A {@link Day3} object ready for solving the problem.
     */
    public static Day3 of(final String instructionSequence) {
        return new Day3(instructionSequence);
    }

    /**
     * @return A new {@link Day3} object that is a clone of this one with an additional {@link Santa} at {@link Coord2D} (0,0)
     */
    public Day3 withNewSanta() {
        return withASantaAt(Coord2D.of(0, 0));
    }

    /**
     * @param location the {@link Coord2D} location of the new {@link Santa}
     *
     * @return A new {@link Day3} object that is a clone of this one with an additional {@link Santa} at the provided {@link Coord2D} location
     */
    public Day3 withASantaAt(final Coord2D location) {
        final List<Santa> newSantaList = santas;
        newSantaList.add(new Santa(location));
        return new Day3(
                instructions,
                newSantaList
        );
    }

    /**
     * @return The number of unique houses visited by all {@link Santa}s currently
     */
    public long getNumberOfVisitedHouses() {
        return santas
                .stream()
                .map(santa -> santa.locationHistory)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    /**
     * @return An updated {@link Day3} object where all instructions have been followed
     */
    public Day3 followInstructions() {
        Day3 intermediateStep = this;
        for (int i = 0; i < instructions.length(); i++) {
            intermediateStep = intermediateStep.followInstruction(i);
        }
        return intermediateStep;
    }

    /**
     * @param i the instruction index to follow
     * @return An updated {@link Day3} object where the indicated instruction has been followed
     */
    public Day3 followInstruction(final int i) {
        final Santa nextSanta = santas.get(santaFocus);

        switch (instructions.charAt(i)) {
            case '^': nextSanta.moveUp(); break;
            case 'v': nextSanta.moveDown(); break;
            case '>': nextSanta.moveRight(); break;
            case '<': nextSanta.moveLeft(); break;
            default: throw new UnexpectedSolutionException("Unexpected instruction '" + instructions.charAt(0) + "'");
        }

        santaFocus = (santaFocus + 1) < santas.size() ? (santaFocus + 1) : 0;
        return this;
    }

    /**
     * @return An updated {@link Day3} object where the next instruction has been followed
     */
    public Day3 followNextInstruction() {
        return followInstruction(0);
    }
}
