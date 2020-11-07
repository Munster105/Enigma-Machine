package core;

import java.util.HashMap;

public class PlugBoard {
    private HashMap<Character, Character> board;

    public PlugBoard(HashMap<Character, Character> board){
        this.board = board;
    }

    public Character getPlugValue(Character c){
        if(board.get(c) == null){
            return c;
        }
        else
            return board.get(c);
    }
}
