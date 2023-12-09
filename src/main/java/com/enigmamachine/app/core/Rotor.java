package com.enigmamachine.app.core;

import com.enigmamachine.app.constants.Constants;
import java.util.*;

public class Rotor {
    private List<Character> inputSide;
    private List<Character> outputSide;
    private int rotorNum;
    private int prevNumSpins, numSpins;

    public Rotor(int rotorNum, ArrayList<Character> inputSide) {
        this.inputSide = initInputSide();
        this.outputSide = Arrays.asList(getOutputList(inputSide));
        this.rotorNum = rotorNum;
        this.numSpins = 0;
    }

    private List<Character> initInputSide() {
        inputSide = new ArrayList<Character>(List.of('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));

        return inputSide;
    }

    private Character[] getOutputList(List<Character> input) {
        Character[] outputSide = new Character[input.size()];
        for (int i = 0; i < input.size(); i++) {
            Character newChar = (Character) (char) (i + 'a');
            int index = Character.getNumericValue(inputSide.get(i)) - 10;
            outputSide[index] = newChar;
        }
        return outputSide;
    }

    public Character getInputSideRotorValue(int charVal) {
        return this.inputSide.get(charVal);
    }

    public Character getOutputSideRotorValue(int charVal) {
        return this.outputSide.get(charVal);
    }

    public void spinRotor() {
        List<Character> buffer = new ArrayList<>(this.inputSide);
        System.out.println("Spinning rotor num: " + this.rotorNum);
        for (int i = 0; i < this.inputSide.size(); i++) {
            int index = ((i - 1) + Constants.numLetters) % Constants.numLetters;
            Character temp = this.inputSide.get(index);
            if (temp == Constants.lastLetter) {
                temp = 'a';
            } else {
                temp = (char) (temp + 1);
            }
            buffer.set(i, temp);
        }
        Collections.copy(this.inputSide, buffer);
        this.outputSide = Arrays.asList(getOutputList(inputSide));
        System.out.println("Input side: " + this.inputSide);
        System.out.println("Output side: " + this.outputSide);
    }

    public void reverseRotor() {
        List<Character> buffer = new ArrayList<>(this.inputSide);
        System.out.println("Spinning rotor num: " + this.rotorNum);
        for (int i = 0; i < this.inputSide.size(); i++) {
            int index = ((i + 1) % Constants.numLetters);
            Character temp = this.inputSide.get(index);
            if (temp == Constants.firstLetter) {
                temp = 'z';
            } else {
                temp = (char) (temp - 1);
            }
            buffer.set(i, temp);
        }
        Collections.copy(this.inputSide, buffer);
        this.outputSide = Arrays.asList(getOutputList(inputSide));
        System.out.println("Input side: " + this.inputSide);
        System.out.println("Output side: " + this.outputSide);
    }

    public int getNumSpins() {
        return this.numSpins;
    }

    public void setNumSpins(int numSpins) {
        this.numSpins = numSpins;
    }

    public int getPrevNumSpins() {
        return this.prevNumSpins;
    }

    public void setPrevNumSpins(int prevNumSpins) {
        this.prevNumSpins = prevNumSpins;
    }

    public List<Character> getInputSide() {
        return this.inputSide;
    }

    public List<Character> getOutputSide() {
        return this.outputSide;
    }

    public int getRotorNum() {
        return this.rotorNum;
    }
}
