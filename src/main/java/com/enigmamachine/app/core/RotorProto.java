package com.enigmamachine.app.core;

import com.enigmamachine.app.constants.Constants;
import java.util.*;

public class RotorProto {
    private List<Integer> rotor;
    private int rotorNum;
    private int prevNumSpins, numSpins;

    public RotorProto(int rotorNum) {
        this.rotor = initInputSide();
        this.rotorNum = rotorNum;
        this.numSpins = 0;
    }

    private List<Integer> initInputSide() {
        List<Integer> rotor = new ArrayList<Integer>();
        for(int i = 0; i < Constants.alphabetLength; i++){
            rotor.add(i);
        }

        return rotor;
    }

    public Character getRotorValue(int charVal) {
        return null;
    }


    public void spinRotor() {
    }

    public void reverseRotor() {
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

    public List<Integer> getRotor() {
        return this.rotor;
    }

    public int getRotorNum() {
        return this.rotorNum;
    }
}
