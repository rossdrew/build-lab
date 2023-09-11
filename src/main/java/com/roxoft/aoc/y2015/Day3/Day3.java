package com.roxoft.aoc.y2015.Day3;

import com.roxoft.aoc.UnexpectedSolutionException;
import com.roxoft.lib.Coord2D;

import java.util.ArrayList;
import java.util.List;

public class Day3 {
    private final String instructions;
    private final Coord2D location;
    private final List<Coord2D> locationHistory;

    private Day3(final String instructionSequence,
                 final Coord2D santasStartingLocation,
                 final List<Coord2D> history) {
        instructions = instructionSequence;
        location = santasStartingLocation;
        locationHistory = history;

    }

    public static Day3 of(final String instructionSequence) {
        final Coord2D startLocation = Coord2D.of(0, 0);
        return new Day3(
                instructionSequence,
                startLocation,
                new ArrayList<>(List.of(startLocation))
        );
    }

    public Coord2D getLocation() {
        return location;
    }

    public long getNumberOfVisitedHouses() {
        return locationHistory.stream().distinct().count();
    }

    public Day3 followInstructions(){
        Day3 intermediateStep = this;
        for (int i = 0; i < instructions.length(); i++){
            intermediateStep = intermediateStep.followInstruction();
        }
        return intermediateStep;
    }

    public Day3 followInstruction(){
        switch (instructions.charAt(0)){
            case '^': {
                final Coord2D newLocation = Coord2D.of(location.getX(), location.getY() + 1);
                locationHistory.add(newLocation);
                return new Day3(instructions.substring(1), newLocation, locationHistory);
            }
            case 'v': {
                final Coord2D newLocation = Coord2D.of(location.getX(), location.getY() - 1);
                locationHistory.add(newLocation);
                return new Day3(instructions.substring(1), newLocation, locationHistory);
            }
            case '>': {
                final Coord2D newLocation = Coord2D.of(location.getX() + 1, location.getY());
                locationHistory.add(newLocation);
                return new Day3(instructions.substring(1), newLocation, locationHistory);
            }
            case '<': {
                final Coord2D newLocation = Coord2D.of(location.getX() - 1, location.getY());
                locationHistory.add(newLocation);
                return new Day3(instructions.substring(1), newLocation, locationHistory);
            }

            default: throw new UnexpectedSolutionException("Unexpected instruction '" + instructions.charAt(0) + "'");
        }
    }
}
