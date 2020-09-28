import core.EnigmaMachine;
import ui.EnigmaMachineUI;
//DONE
//TODO: Add in ui bits when all logic is figured out
public class EnigmaApp {
    public static void main(String[] args){
        EnigmaMachine em = new EnigmaMachine();
        EnigmaMachineUI emUI = new EnigmaMachineUI(em);
    }
}
