package com.enigmamachine.app.ui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class SettingsPanel extends JTabbedPane {
    private JPanel reflectorSettings, plugBoardSettings, rotorSettings;

    public SettingsPanel() {
        this.setLayout(new GridLayout());
        this.reflectorSettings = new JPanel();
        this.plugBoardSettings = new JPanel();
        this.rotorSettings = new JPanel();

        this.addTab("Reflector", this.reflectorSettings);
        this.addTab("Plug Board", this.plugBoardSettings);
        this.addTab("Rotors", this.rotorSettings);
    }
}
