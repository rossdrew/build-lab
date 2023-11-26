package com.roxoft.aoc.y2015.Day3;

import com.roxoft.aoc.UnexpectedSolutionException;
import com.roxoft.lib.IntegerCoord2D;
import com.roxoft.lib.Movable2DEntity;

import java.util.ArrayList;
import java.util.List;

public final class Day3 {
    /** List of instructions to follow. */
    private final String instructions;
    /** The {@link List} of {@link Movable2DEntity}s that will be visiting houses. */
    private final List<Movable2DEntity> santas;
    /** Which {@link Movable2DEntity} is receiving the next instruction. **/
    private int santaFocus = 0;

    /**
     * @param santaNumber the number of the desired {@link Movable2DEntity}.
     * @return The {@link Movable2DEntity} identified by the provided santaNumber
     */
    public Movable2DEntity getSanta(final int santaNumber) {
        return santas.get(santaNumber);
    }

    private Day3(final String instructionSequence) {
        instructions = instructionSequence;
        santas = new ArrayList<>();
    }

    private Day3(final String instructionSequence, final List<Movable2DEntity> predefinedSantas) {
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
     * @return A new {@link Day3} object that is a clone of this one with an additional {@link Movable2DEntity} at {@link IntegerCoord2D} (0,0)
     */
    public Day3 withNewSanta() {
        return withASantaAt(IntegerCoord2D.of(0, 0));
    }

    /**
     * @param location the {@link IntegerCoord2D} location of the new {@link Movable2DEntity}
     *
     * @return A new {@link Day3} object that is a clone of this one with an additional {@link Movable2DEntity} at the provided {@link IntegerCoord2D} location
     */
    public Day3 withASantaAt(final IntegerCoord2D location) {
        final List<Movable2DEntity> newSantaList = santas;
        newSantaList.add(Movable2DEntity.at(location));
        return new Day3(
                instructions,
                newSantaList
        );
    }

    /**
     * @return The number of unique houses visited by all {@link Movable2DEntity}s currently
     */
    public long getNumberOfVisitedHouses() {
        return santas
                .stream()
                .map(Movable2DEntity::locationHistory)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    /**
     * @return An updated {@link Day3} object where all instructions have been followed
     */
    public Day3 followInstructions() {
        for (int i = 0; i < instructions.length(); i++) {
            followInstruction(i);
        }
        return this;
    }

    /**
     * @param i the instruction index to follow
     * @return An updated {@link Day3} object where the indicated instruction has been followed
     */
    public Day3 followInstruction(final int i) {
        final Movable2DEntity nextSanta = santas.get(santaFocus);

        switch (instructions.charAt(i)) {
            case '^': nextSanta.moveUp(); break;
            case 'v': nextSanta.moveDown(); break;
            case '>': nextSanta.moveRight(); break;
            case '<': nextSanta.moveLeft(); break;
            default: throw new UnexpectedSolutionException("Unexpected instruction '" + instructions.charAt(0) + "'");
        }

        //Cycle through Santas
        santaFocus = (santaFocus + 1) < santas.size() ? (santaFocus + 1) : 0;
        return this; //XXX: Immutable classes would probably be better.
    }

    /**
     * @return An updated {@link Day3} object where the next instruction has been followed
     */
    public Day3 followNextInstruction() {
        return followInstruction(0);
    }
}
