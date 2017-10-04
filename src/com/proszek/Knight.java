package com.proszek;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Knight extends Piece {

    Knight(String position, boolean isItWhite){
        super(position, isItWhite);
        super.setName("Knight");
        super.setPoints(3);
    }


    @Override
    List<String> move() {
        return null;
    }

    @Override
    List<String> calculateAvailableMoves(Map<String, Field> board) {
        char column = super.getPosition().charAt(0);
        int row = Character.getNumericValue(super.getPosition().charAt(1));
        List<String> possibleMoves = new ArrayList<>();
        String move;

        move = (char)(column + 1) + "" + (row + 2);
        if(checkIfMoveIsLegal(move)) possibleMoves.add(move);
        move = (char)(column - 1) + "" + (row + 2);
        if(checkIfMoveIsLegal(move)) possibleMoves.add(move);

        move = (char)(column + 1) + "" + (row - 2);
        if(checkIfMoveIsLegal(move)) possibleMoves.add(move);
        move = (char)(column - 1) + "" + (row - 2);
        if(checkIfMoveIsLegal(move)) possibleMoves.add(move);

        move = (char)(Character.getNumericValue(column) + 2) + "" + (row + 1);
        if(checkIfMoveIsLegal(move)) possibleMoves.add(move);
        move = (char)(Character.getNumericValue(column) - 2) + "" + (row + 1);
        if(checkIfMoveIsLegal(move)) possibleMoves.add(move);

        move = (char)(Character.getNumericValue(column) + 2) + "" + (row - 1);
        if(checkIfMoveIsLegal(move)) possibleMoves.add(move);
        move = (char)(Character.getNumericValue(column) - 2) + "" + (row - 1);
        if(checkIfMoveIsLegal(move)) possibleMoves.add(move);


        return possibleMoves;
    }

}
