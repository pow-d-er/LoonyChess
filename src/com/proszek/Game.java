package com.proszek;


import java.util.HashMap;
import java.util.Map;

public class Game {
    private Player white;
    private Player black;
    private Map<String, Field> board;

    public Game(String whiteName, String whiteTime,
                String blackName, String blackTime){
        this.white = new Player(whiteName, whiteTime, true);
        this.black = new Player(blackName, blackTime, false);
    }

    public void startGame(){
        this.board = initializeBoard();
        white.setUpPieces(board);
        black.setUpPieces(board);
        displayBoard();
        System.out.println(Color.ANSI_BLUE + white.getPieces().get(0).toString() + "'s list of moves: ");
        for(String move : white.getPieces().get(0).calculateAvailableMoves(board)){
            System.out.println(Color.ANSI_BLUE + move);
        }
    }

    private void displayBoard(){

        for(Map.Entry<String, Field> entry : board.entrySet()){
            System.out.println(entry.getKey() + entry.getValue().toString());
        }
    }

    private Map<String, Field> initializeBoard(){
        Map<String, Field> initializedBoard = new HashMap<>();

        boolean isItWhite = false;
        for(int i = 0; i < 8; i ++){
            isItWhite = !isItWhite;
            for(char c = 'a'; c < 'i'; c++){
                isItWhite = !isItWhite;
                initializedBoard.put("" + c + (i+1), new Field(isItWhite));
            }
        }

        return initializedBoard;
    }
}
