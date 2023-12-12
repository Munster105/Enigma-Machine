package com.enigmamachine.app.core;

import java.util.HashMap;
import java.util.Map;

public class PlugBoard {
    private HashMap<Character, Character> plugBoard;

    public PlugBoard() {
        this.plugBoard = initDefaultplugBoard();
    }

    private HashMap<Character, Character> initDefaultplugBoard() {
        // Default plugboard should be no encryption
        plugBoard = new HashMap<Character, Character>();

        return plugBoard;
    }

    public HashMap<Character, Character> getPlugboard() {
        return this.plugBoard;
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
