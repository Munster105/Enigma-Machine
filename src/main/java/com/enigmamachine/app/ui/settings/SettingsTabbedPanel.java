package com.enigmamachine.app.ui.settings;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.enigmamachine.app.core.EnigmaMachine;

public class SettingsTabbedPanel extends JTabbedPane {
    private JPanel reflectorSettings, plugBoardSettings, rotorSettings;

    public SettingsTabbedPanel(EnigmaMachine enigmaMachine) {
        this.reflectorSettings = new ReflectorSettingsTabPanel(enigmaMachine.getReflector());
        this.plugBoardSettings = new PlugBoardSettingsTabPanel(enigmaMachine.getPlugBoard());
        this.rotorSettings = new RotorSettingsTabPanel(enigmaMachine.getRotors());

        this.addTab("Plug Board", this.plugBoardSettings);
        this.addTab("Rotors", this.rotorSettings);
        this.addTab("Reflector", this.reflectorSettings);
    }
}
