package com.enigmamachine.app.core;

import java.util.HashMap;
import java.util.Map;

public class PlugBoard {
    private HashMap<Character, Character> board;

    public PlugBoard(HashMap<Character, Character> board) {
        initDefaultBoard();
    }

    private void initDefaultBoard() {
        this.board = new HashMap<>();
        this.board.put('a', 'z');
        this.board.put('b', 'y');
        this.board.put('c', 'x');
        this.board.put('d', 'w');
        this.board.put('e', 'v');
        this.board.put('f', 'u');
        this.board.put('g', 't');
        this.board.put('h', 's');
        this.board.put('i', 'r');
        this.board.put('j', 'q');
        this.board.put('k', 'p');
        this.board.put('l', 'o');
        this.board.put('m', 'n');
    }

    public void setBoard(HashMap<Character, Character> plugBoardSettings) {
        this.board = plugBoardSettings;
    }

    public Character getPlugValue(Character c) {
        if (board.get(c) == null) {
            return c;
        } else
            return board.get(c);
    }
}
