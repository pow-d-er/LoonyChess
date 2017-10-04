package com.proszek;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pawn extends Piece {



    Pawn(String position, boolean isItWhite){
        super(position, isItWhite);
        super.setName("Pawn");
        super.setPoints(1);
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
        int colorNumber;
        int toAdd;

        if (super.getColor().compareToIgnoreCase("white") == 0) {
            colorNumber = 2;
            toAdd = 1;
        } else {
            colorNumber = 7;
            toAdd = -1;
        }


        //moves one and two forward
        if (board.get(column + "" + (row + toAdd)).getPiece() == null){

            move = column + "" + (row + toAdd);
            if (checkIfMoveIsLegal(move)) possibleMoves.add(move);

            if (row == colorNumber) {
                if (board.get(column + "" + (row + toAdd*2)).getPiece() == null){
                    move = column + "" + (row + toAdd * 2);
                    if (checkIfMoveIsLegal(move)) possibleMoves.add(move);
                }
            }
        }

        //the moves in which pawn is beating another piece

            move = (char) (column + 1) + "" + (row + toAdd);
            if(checkIfMoveIsLegal(move)){
                if(board.get(move).getPiece() != null){
                    if(!board.get(move).getPiece().getColor().equals(super.getColor())){
                        possibleMoves.add(move);
                    }
                }
            }

            move = (char) (column - 1) + "" + (row + toAdd);
            if(checkIfMoveIsLegal(move)){
                if(board.get(move).getPiece() != null)
                    if(!board.get(move).getPiece().getColor().equals(super.getColor())) {
                        possibleMoves.add(move);
                    }
            }

//        TO DO:
//        1. en passant
//        2. promotion

        return possibleMoves;
    }


}
