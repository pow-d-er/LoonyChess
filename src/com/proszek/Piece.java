package com.proszek;

import java.util.List;
import java.util.Map;

public abstract class Piece {
    private int points;

    private String name;
    private String color;
    private String position;

    abstract List<String> move();
    abstract List<String> calculateAvailableMoves(Map<String, Field> board);

    Piece(String position, boolean isItWhite){
        this.position = position;
        if(isItWhite) this.color = "White";
        else this.color = "Black";
    }

    protected boolean checkIfMoveIsLegal(String move){

        System.out.println(Color.ANSI_PURPLE + move);
        if(move.charAt(0) >= 'a' && move.charAt(0) <= 'h'){
            if(Character.getNumericValue(move.charAt(1)) > 0
                    && Character.getNumericValue(move.charAt(1)) < 9){
                return true;
            }
        }
        return false;
    }

    protected void setPoints(int points) {
        this.points = points;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getColor() {
        return color;
    }



    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return this.color + " " + this.name;
    }
}
