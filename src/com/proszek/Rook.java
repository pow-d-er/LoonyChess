package com.proszek;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Rook extends Piece {

    Rook(String position, boolean isItWhite) {
        super(position, isItWhite);
        super.setName("Rook");
        super.setPoints(5);
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
        int helper;

        for(int i = -1; i < 2; i += 2){
            helper = 0;
            for(;;){
                helper += i;
                move = (char) (column + helper) + "" + row;
                if(!checkIfMoveIsLegal(move)){
                    break;
                }
                if(board.get(move).getPiece() != null){
                    if(!board.get(move).getPiece().getColor().equals(super.getColor())){
                        possibleMoves.add(move);
                    }
                    break;
                }else{
                    possibleMoves.add(move);
                }
            }
            helper = 0;
            for(;;){
                helper += i;
                move = column + "" + (row  + helper);
                if(!checkIfMoveIsLegal(move)){
                    break;
                }
                if(board.get(move).getPiece() != null){
                    if(!board.get(move).getPiece().getColor().equals(super.getColor())){
                        possibleMoves.add(move);
                    }
                    break;
                }else{
                    possibleMoves.add(move);
                }
            }
        }

        return possibleMoves;
    }
}
