package com.proszek;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class King extends Piece{

    boolean isChecked;

    King(String position, boolean isItWhite){
        super(position, isItWhite);
        super.setName("King");
        super.setPoints(0);
        this.isChecked = false;

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
        int helper1, helper2;


        for(int i = -1; i < 2; i++){
            helper1 = i;
            for(int j = - 1; j < 2; j++){
                helper2 = j;
                move = (char) (column + helper1) + "" + (row + helper2);
                if(checkIfMoveIsLegal(move)){
                    if(board.get(move).getPiece() != null){
                        if(board.get(move).getPiece().getColor().compareToIgnoreCase(super.getColor()) != 0){
                            possibleMoves.add(move);
                        }
                    }else{
                        possibleMoves.add(move);
                    }
                }

            }
        }

        return possibleMoves;
    }
}
