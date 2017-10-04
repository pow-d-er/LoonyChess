package com.proszek;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pawn extends Piece {

    private boolean possibilityOfRightEnPassant;

    private boolean possibilityOfLeftEnPassant;

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


        //moves one field forward
        Pawn neighbourPawn;

        if (board.get(column + "" + (row + toAdd)).getPiece() == null){

            move = column + "" + (row + toAdd);
            if (checkIfMoveIsLegal(move)) possibleMoves.add(move);

            //move two fields forward

            if (row == colorNumber) {
                if (board.get(column + "" + (row + toAdd*2)).getPiece() == null){
                    move = column + "" + (row + toAdd * 2);
                    if (checkIfMoveIsLegal(move)) possibleMoves.add(move);

                    //Es passant

                    for(int i = -1; i < 2; i += 2) {
                        move = (char) (column + i) + "" + (row + toAdd * 2);
                        if (checkIfMoveIsLegal(move)) {
                            if (row + toAdd * 2 == 4 || row + toAdd * 2 == 5) {
                                if (board.get(move).getPiece().getClass().getSimpleName().equals("Pawn")) {
                                    neighbourPawn = (Pawn) board.get(move).getPiece();
                                    neighbourPawn.setPossibilityOfEsPassant(i);
                                }
                            }
                        }
                    }


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
//        2. promotion

        return possibleMoves;
    }

    public void setPossibilityOfEsPassant(int i){
        switch(i){
            case -1:
                setPossibilityOfLeftEnPassant(true);
                break;
            case 1:
                setPossibilityOfRightEnPassant(true);
                break;
            default:
                break;
        }
    }

    private void setPossibilityOfRightEnPassant(boolean possibilityOfRightEnPassant) {
        this.possibilityOfRightEnPassant = possibilityOfRightEnPassant;
    }

    private void setPossibilityOfLeftEnPassant(boolean possibilityOfLeftEnPassant) {
        this.possibilityOfLeftEnPassant = possibilityOfLeftEnPassant;
    }

}
