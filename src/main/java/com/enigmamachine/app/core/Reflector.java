package com.enigmamachine.app.core;

import java.util.HashMap;

public class Reflector {
    private HashMap<Character, Character> reflector;

    public Reflector(HashMap<Character, Character> reflector){
        initDefaultReflector();
    }

    private void initDefaultReflector() {
        this.reflector = new HashMap<>();
        this.reflector.put('a', 'z');
        this.reflector.put('b', 'y');
        this.reflector.put('c', 'x');
        this.reflector.put('d', 'w');
        this.reflector.put('e', 'v');
        this.reflector.put('f', 'u');
        this.reflector.put('g', 't');
        this.reflector.put('h', 's');
        this.reflector.put('i', 'r');
        this.reflector.put('j', 'q');
        this.reflector.put('k', 'p');
        this.reflector.put('l', 'o');
        this.reflector.put('m', 'n');
    }

    public void setReflector(HashMap<Character, Character> reflectorSettings) {
        this.reflector = reflectorSettings;
    }

    public Character getReflectorVal(Character c){
        return reflector.get(c);
    }
}
