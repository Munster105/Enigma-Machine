package core;

import constants.Constants;

import java.util.*;

//DONE
public class EnigmaMachine {
    private PlugBoard pb;
    private Reflector reflector;
    private ArrayList<Rotor> rotors;

    public EnigmaMachine(){
        initComponents();
    }

    private void initComponents(){
        //Here we can set the value of what the pb should be then pass this hashmap to the initalization function
        //Yes we can just pull this into one class and make a hashmap called pb, but I wanted to work with more classes.
        HashMap<Character, Character> pbTemp = new HashMap<>()
        {
            {
                put('a', 'b');
                put('b', 'a');
            }
        };

        pb = new PlugBoard(pbTemp);

        //Same thing but for reflector
        HashMap<Character, Character> reflectorTemp = new HashMap<>(){
            {
                put('a', 'z');
                put('b', 'y');
                put('c', 'x');
                put('d', 'w');
                put('e', 'v');
                put('f', 'u');
                put('g', 't');
                put('h', 's');
                put('i', 'r');
                put('j', 'q');
                put('k', 'p');
                put('l', 'o');
                put('m', 'n');
                put('n', 'm');
                put('o', 'l');
                put('p', 'k');
                put('q', 'j');
                put('r', 'i');
                put('s', 'h');
                put('t', 'g');
                put('u', 'f');
                put('v', 'e');
                put('w', 'd');
                put('x', 'c');
                put('y', 'b');
                put('z', 'a');
            }
        };
        reflector = new Reflector(reflectorTemp);

        //Left side of rotors
        ArrayList<Character> inputSideTemp1 = new ArrayList<>(){
            {
                add('d');
                add('j');
                add('x');
                add('p');
                add('i');
                add('w');
                add('z');
                add('f');
                add('r');
                add('m');
                add('q');
                add('h');
                add('k');
                add('b');
                add('g');
                add('e');
                add('t');
                add('l');
                add('o');
                add('n');
                add('y');
                add('s');
                add('v');
                add('a');
                add('u');
                add('c');
            }
        };

        ArrayList<Character> inputSideTemp2 = new ArrayList<>(){
            {
                add('w');
                add('e');
                add('d');
                add('m');
                add('h');
                add('y');
                add('u');
                add('v');
                add('b');
                add('q');
                add('k');
                add('a');
                add('o');
                add('j');
                add('l');
                add('z');
                add('r');
                add('i');
                add('x');
                add('c');
                add('t');
                add('f');
                add('p');
                add('n');
                add('s');
                add('g');
            }
        };

        ArrayList<Character> inputSideTemp3 = new ArrayList<>(){
            {
                add('x');
                add('g');
                add('b');
                add('y');
                add('v');
                add('w');
                add('q');
                add('p');
                add('i');
                add('j');
                add('z');
                add('c');
                add('h');
                add('o');
                add('t');
                add('r');
                add('s');
                add('k');
                add('e');
                add('l');
                add('a');
                add('d');
                add('m');
                add('n');
                add('u');
                add('f');
            }
        };

        rotors = new ArrayList<>();
        Rotor rotor1 = new Rotor(1, inputSideTemp1);
        Rotor rotor2 = new Rotor(2, inputSideTemp2);
        Rotor rotor3 = new Rotor(3, inputSideTemp3);
        rotors.add(rotor1);
        rotors.add(rotor2);
        rotors.add(rotor3);
    }

    public Character useMachine(Character input){
        //Get input to start the while loop
        Character c = input;
        System.out.println("Rotors: ");
        for(Rotor r : rotors){
            System.out.println("\tCore.Rotor num: " + r.getRotorNum() + " with " + r.getNumSpins() + " spins");
            System.out.println("\tInput side: " + r.getInputSide());
            System.out.println("\tOutput side: " + r.getOutputSide());
            System.out.println();
        }
        System.out.println("Input: " + c);
        c = pb.getPlugValue(c);

        System.out.println("First plugboard output: " + c);
        c = getInputRotorsVal(Character.getNumericValue(c) - 10);

        System.out.println("First rotors output: " + c);
        c = reflector.getReflectorVal(c);

        System.out.println("Core.Reflector output: " + c);
        c = getOutputRotorsVal(Character.getNumericValue(c) - 10);

        System.out.println("Second rotors output: " + c);
        c = pb.getPlugValue(c);

        System.out.println("Second plugboard output: " + c);
        System.out.println("Output: " + c);

        //We now have to spin the rotors with the first one needed to complete a full rotation before the second one starts to move
        boolean prevComplete = true;
        for(Rotor r : rotors){
            r.setPrevNumSpins(r.getNumSpins());
            //If the previous rotor is done rotating
            if(prevComplete) {
                //Rotate yourself
                r.spinRotor();
                r.setNumSpins(r.getNumSpins() + 1);
                //Then evaluate if you're done rotating
                prevComplete = r.getNumSpins() >= Constants.numLetters;
                System.out.println(prevComplete);
                //If so, reset spin counter and prevComplete = true
                if(prevComplete){
                    r.setNumSpins(0);
                }
            }
            System.out.println("Rotor num: " + r.getRotorNum() + " w/: " + r.getNumSpins());
        }

        return c;
    }

    private Character getInputRotorsVal(int c){
        Character ret = 'a';
        for(int i = 0; i < rotors.size(); i++){
            ret = rotors.get(i).getInputSideRotorValue(c);
            c = Character.getNumericValue(ret) - 10;
            System.out.println("Output from rotor: " + i + " ---- " + ret);
        }

        return ret;
    }

    private Character getOutputRotorsVal(int c){
        Character ret = 'a';
        for(int i = (rotors.size() - 1); i > -1; i--){
            ret = rotors.get(i).getOutputSideRotorValue(c);
            c = Character.getNumericValue(ret) - 10;
            System.out.println("Output from rotor: " + i + " ---- " + ret);
        }

        return ret;
    }

    public ArrayList<Rotor> getRotors(){
        return this.rotors;
    }
}
