package com.proszek;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bishop extends Piece {

    Bishop(String position, boolean isItWhite) {
        super(position, isItWhite);
        super.setName("Bishop");
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
        int helper1, helper2;

        for(int i = -1; i < 2; i += 2){
            for(int j = - 1; j < 2; j += 2){
                helper1 = 0;
                helper2 = 0;
                for(;;){
                    helper1 += i;
                    helper2 += j;
                    move = (char) (column + helper1) + "" + (row + helper2);
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
        }

        return possibleMoves;
    }
}
