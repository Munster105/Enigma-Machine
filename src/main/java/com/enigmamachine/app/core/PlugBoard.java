package com.enigmamachine.app.core;

import java.util.HashMap;
import java.util.Map;

public class PlugBoard {
    private HashMap<Character, Character> plugBoard;

    public PlugBoard(HashMap<Character, Character> plugBoard) {
        this.plugBoard = initDefaultplugBoard();
    }

    private HashMap<Character, Character> initDefaultplugBoard() {
        plugBoard = new HashMap<Character, Character>();
        plugBoard.put('a', 'z');
        plugBoard.put('b', 'y');
        plugBoard.put('c', 'x');
        plugBoard.put('d', 'w');
        plugBoard.put('e', 'v');
        plugBoard.put('f', 'u');
        plugBoard.put('g', 't');
        plugBoard.put('h', 's');
        plugBoard.put('i', 'r');
        plugBoard.put('j', 'q');
        plugBoard.put('k', 'p');
        plugBoard.put('l', 'o');
        plugBoard.put('m', 'n');

        // Have to create the inverses of above
        HashMap<Character, Character> plugInverse = new HashMap<Character, Character>();
        for (Map.Entry<Character, Character> entry : plugBoard.entrySet()) {
            plugInverse.put(entry.getValue(), entry.getKey());
        }

        plugBoard.putAll(plugInverse);

        return plugBoard;
    }

    public void setplugBoard(HashMap<Character, Character> plugBoardSettings) {
        this.plugBoard = plugBoardSettings;
    }

    public Character getPlugValue(Character c) {
        if (plugBoard.get(c) == null) {
            return c;
        } else
            return plugBoard.get(c);
    }
}
