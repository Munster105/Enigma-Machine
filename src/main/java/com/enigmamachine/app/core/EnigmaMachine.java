package com.enigmamachine.app.core;

import com.enigmamachine.app.constants.Constants;

import java.util.ArrayList;

public class EnigmaMachine {
    private PlugBoard pb = null;
    private Reflector reflector = null;
    private ArrayList<Rotor> rotors = null;

    public EnigmaMachine() {
        this.pb = new PlugBoard();
        this.reflector = new Reflector();
        this.rotors = new ArrayList<Rotor>() {
            {
                add(new Rotor(1));
                add(new Rotor(2));
                add(new Rotor(3));
            }
        };
    }

    public Character encodeCharacter(Character input) {
        Character c = input;
        System.out.println("Rotors: ");
        for (Rotor r : rotors) {
            System.out.println("\tCore.Rotor num: " + r.getRotorNum() + " with " + r.getNumSpins() + " spins");
            System.out.println("\tInput side: " + r.getInputSide());
            System.out.println("\tOutput side: " + r.getOutputSide());
            System.out.println();
        }
        System.out.println("Input: " + c);
        Character plugVal = pb.getPlugValue(c);

        System.out.println("First plugboard output: " + plugVal);
        Character rotorVal = getInputRotorsVal(Character.getNumericValue(plugVal) - 10);

        System.out.println("First rotors output: " + rotorVal);

        Character reflectorVal = reflector.getReflectorVal(rotorVal);
        if (reflectorVal == null) {
            return null;
        }

        System.out.println("Core.Reflector output: " + c);
        c = getOutputRotorsVal(Character.getNumericValue(c) - 10);

        System.out.println("Second rotors output: " + c);
        c = pb.getPlugValue(c);

        System.out.println("Second plugboard output: " + c);
        System.out.println("Output: " + c);

        // We now have to spin the rotors with the first one needed to complete a full
        // rotation before the second one starts to move
        boolean prevComplete = true;
        for (Rotor r : rotors) {
            r.setPrevNumSpins(r.getNumSpins());
            // If the previous rotor is done rotating
            if (prevComplete) {
                // Rotate yourself
                r.spinRotor();
                r.setNumSpins(r.getNumSpins() + 1);
                // Then evaluate if you're done rotating
                prevComplete = r.getNumSpins() >= Constants.alphabetLength;
                System.out.println(prevComplete + "////////////////////////////////////////////");
                // If so, reset spin counter and prevComplete = true
                if (prevComplete) {
                    r.setNumSpins(0);
                }
            }
            System.out.println("Rotor num: " + r.getRotorNum() + " w/: " + r.getNumSpins());
        }

        return c;
    }

    private Character getInputRotorsVal(int c) {
        Character ret = 'a';
        for (int i = 0; i < rotors.size(); i++) {
            ret = rotors.get(i).getInputSideRotorValue(c);
            c = Character.getNumericValue(ret) - 10;
            System.out.println("Output from rotor: " + i + " ---- " + ret);
        }

        return ret;
    }

    private Character getOutputRotorsVal(int c) {
        Character ret = 'a';
        for (int i = (rotors.size() - 1); i > -1; i--) {
            ret = rotors.get(i).getOutputSideRotorValue(c);
            c = Character.getNumericValue(ret) - 10;
            System.out.println("Output from rotor: " + i + " ---- " + ret);
        }

        return ret;
    }

    public ArrayList<Rotor> getRotors() {
        return rotors;
    }

    public PlugBoard getPlugBoard() {
        return pb;
    }

    public Reflector getReflector() {
        return reflector;
    }
}
