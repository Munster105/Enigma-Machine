package com.enigmamachine.app.ui.settings;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class SettingsTabbedPanel extends JTabbedPane {
    private JPanel reflectorSettings, plugBoardSettings, rotorSettings;

    public SettingsTabbedPanel() {
        this.reflectorSettings = new ReflectorSettingsTabPanel();
        this.plugBoardSettings = new PlugBoardSettingsTabPanel();
        this.rotorSettings = new RotorSettingsTabPanel();

        this.addTab("Plug Board", this.plugBoardSettings);
        this.addTab("Rotors", this.rotorSettings);
        this.addTab("Reflector", this.reflectorSettings);
    }
}
