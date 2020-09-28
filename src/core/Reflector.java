package core;

import java.util.HashMap;

//DONE!
public class Reflector {
    private HashMap<Character, Character> reflector;

    public Reflector(HashMap<Character, Character> reflector){
        this.reflector = reflector;
    }

    public Character getReflectorVal(Character c){
        return reflector.get(c);
    }
}
