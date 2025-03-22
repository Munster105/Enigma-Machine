package com.enigmamachine.app;

import com.enigmamachine.app.ui.ApplicationUI;
import com.enigmamachine.app.core.EnigmaMachine;

public class EnigmaController {
    public static void main(String[] args){
        EnigmaMachine enigmaMachine = new EnigmaMachine();
        ApplicationUI emUI = new ApplicationUI(enigmaMachine);
    }
}
