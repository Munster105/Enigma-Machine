package core;

import constants.Constants;
import java.util.*;

//DONE
public class Rotor {
    //Changes need to be made!!
    private List<Character> InputSide;
    private List<Character> OutputSide;
    private int rotorNum;
    private int prevNumSpins, numSpins;

    public Rotor(int rotorNum, ArrayList<Character> inputSide){
        this.InputSide = inputSide;
        this.OutputSide = Arrays.asList(getOutputList(InputSide));
        this.rotorNum = rotorNum;
        this.numSpins = 0;
//        System.out.println("Input side: " + InputSide);
//        System.out.println("Output side: " + OutputSide);
//        System.out.println("NumSpins: " + numSpins);
    }

    private Character[] getOutputList(List<Character> input){
        Character[] temp = new Character[input.size()];
        for(int i = 0; i < input.size(); i++){
            Character newChar = (Character)(char)(i+'a');
            int index = Character.getNumericValue(InputSide.get(i)) - 10;
            temp[index] = newChar;
        }
        return temp;
    }

    public Character getInputSideRotorValue(int charVal){
        return this.InputSide.get(charVal);
    }
    public Character getOutputSideRotorValue(int charVal){
        return this.OutputSide.get(charVal);
    }

    public void spinRotor(){
        List<Character> buffer = new ArrayList<>(this.InputSide);
        System.out.println("Spinning rotor num: " + this.rotorNum);
        for(int i = 0; i < this.InputSide.size(); i++){
            int index = ((i-1)+ Constants.numLetters)% Constants.numLetters;
            Character temp = this.InputSide.get(index);
            if(temp == Constants.lastLetter){
                temp = 'a';
            }
            else{
                temp = (char)(temp + 1);
            }
            buffer.set(i, temp);
        }
        Collections.copy(this.InputSide, buffer);
        this.OutputSide = Arrays.asList(getOutputList(InputSide));
        System.out.println("Input side: " + this.InputSide);
        System.out.println("Output side: " + this.OutputSide);
    }

    public void reverseRotor(){

        List<Character> buffer = new ArrayList<>(this.InputSide);
        System.out.println("Spinning rotor num: " + this.rotorNum);
        for(int i = 0; i < this.InputSide.size(); i++){
            int index = ((i + 1) % Constants.numLetters);
            Character temp = this.InputSide.get(index);
            if(temp == Constants.firstLetter){
                temp = 'z';
            }
            else{
                temp = (char)(temp - 1);
            }
            buffer.set(i, temp);
        }
        Collections.copy(this.InputSide, buffer);
        this.OutputSide = Arrays.asList(getOutputList(InputSide));
        System.out.println("Input side: " + this.InputSide);
        System.out.println("Output side: " + this.OutputSide);
    }

    public int getNumSpins(){
        return this.numSpins;
    }
    public void setNumSpins(int numSpins){
        this.numSpins = numSpins;
    }
    public int getPrevNumSpins() { return this.prevNumSpins; }
    public void setPrevNumSpins(int prevNumSpins){ this.prevNumSpins = prevNumSpins; }
    public List<Character> getInputSide(){
        return this.InputSide;
    }
    public List<Character> getOutputSide(){
        return this.OutputSide;
    }
    public int getRotorNum(){
        return this.rotorNum;
    }
}
