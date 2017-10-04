package com.proszek;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Queen extends Piece {

    Queen(String position, boolean isItWhite){
        super(position, isItWhite);
        super.setName("Queen");
        super.setPoints(9);
    }


    @Override
    List<String> move() {
        return null;
    }

    @Override
    List<String> calculateAvailableMoves(Map<String, Field> board) {
        List<String> possibleMoves = new ArrayList<>();

        possibleMoves.addAll(rookMoves(board));
        possibleMoves.addAll(bishopMoves(board));

        return possibleMoves;
    }

    List<String> rookMoves(Map<String, Field> board){
        boolean isItWhite = false;
        if(super.getColor().compareToIgnoreCase("white") == 0) {
            isItWhite = true;
        }
        Piece helper = new Rook(super.getPosition(), isItWhite);

        return helper.calculateAvailableMoves(board);
    }


    List<String> bishopMoves(Map<String, Field> board){
        boolean isItWhite = false;
        if(super.getColor().compareToIgnoreCase("white") == 0) {
            isItWhite = true;
        }
        Piece helper = new Bishop(super.getPosition(), isItWhite);

        return helper.calculateAvailableMoves(board);
    }
}

