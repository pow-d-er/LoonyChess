package com.proszek;

public class Field {
    private boolean isItWhite;
    private Piece piece;

    public Field(boolean white){
        this.isItWhite = white;
        this.piece = null;
    }

    public Piece setAndReturn(Piece piece){

        this.piece = piece;
        return this.piece;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        String color;
        String message;
        if(isItWhite) color = "white";
        else color = "black";

        message = " field is " + color;

        if(this.piece == null) message += Color.ANSI_RED + " : nothing stands on it." + Color.ANSI_RESET;
        else message += Color.ANSI_GREEN + " : " + this.piece.toString() + " stands here." + Color.ANSI_RESET;

        return message;
    }
}
