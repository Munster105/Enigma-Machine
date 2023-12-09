package com.enigmamachine.app.core;

import java.util.HashMap;
import java.util.Map;

public class Reflector {
    private HashMap<Character, Character> reflector;

    public Reflector(HashMap<Character, Character> reflector){
        this.reflector = initDefaultReflector();
    }

    private HashMap<Character, Character> initDefaultReflector() {
        HashMap<Character, Character> reflector = new HashMap<>();
        // Defines the characters that are initially paired up
        // i.e. 'a' outputs 'z' and 'z' outputs 'a'
        reflector.put('a', 'z');
        reflector.put('b', 'y');
        reflector.put('c', 'x');
        reflector.put('d', 'w');
        reflector.put('e', 'v');
        reflector.put('f', 'u');
        reflector.put('g', 't');
        reflector.put('h', 's');
        reflector.put('i', 'r');
        reflector.put('j', 'q');
        reflector.put('k', 'p');
        reflector.put('l', 'o');
        reflector.put('m', 'n');

        // Have to create the inverses of above
        HashMap<Character, Character> reflectorInverse = new HashMap<>();
        for (Map.Entry<Character, Character> entry : reflector.entrySet()){
            reflectorInverse.put(entry.getValue(), entry.getKey());
        }

        reflector.putAll(reflectorInverse);

        return reflector;
    }

    public void setReflector(HashMap<Character, Character> reflectorSettings) {
        this.reflector = reflectorSettings;
    }

    public Character getReflectorVal(Character c){
        return reflector.get(c);
    }
}
