package com.proszek;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {

    private List<Piece> pieces;
    private List<Piece> deadPieces;
    private String name;
    private String time;
    private boolean white;
    private King king;

    public Player(String name, String time, boolean white){
        this.white = white;
        deadPieces = null;
        this.name = name;
        this.time = time;
    }

    public boolean move(String move, Map<String, Field> board){
        return false;
    }


    public void setUpPieces(Map<String, Field> board){
        List<Piece> pieces = new ArrayList<>();
        int whichLine;
        if(white){
            whichLine = 1;
        }
        else{
            whichLine = 8;
        }
        king = new King("e" + whichLine, this.white);

        pieces.add(board.get("e" + whichLine).setAndReturn(king));
        pieces.add(board.get("d" + whichLine).setAndReturn(new Queen("d" + whichLine, this.white)));

        pieces.add(board.get("a" + whichLine).setAndReturn(new Rook("a" + whichLine, this.white)));
        pieces.add(board.get("h" + whichLine).setAndReturn(new Rook("h" + whichLine, this.white)));

        pieces.add(board.get("b" + whichLine).setAndReturn(new Knight( "b" + whichLine, this.white)));
        pieces.add(board.get("g" + whichLine).setAndReturn(new Knight( "g" + whichLine, this.white)));

        pieces.add(board.get("c" + whichLine).setAndReturn(new Bishop("c" + whichLine,  this.white)));
        pieces.add(board.get("f" + whichLine).setAndReturn(new Bishop( "f" + whichLine, this.white)));


        this.pieces = pieces;
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
