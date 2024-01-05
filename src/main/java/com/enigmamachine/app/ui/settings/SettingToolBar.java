package com.enigmamachine.app.ui.settings;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

public class SettingToolBar extends JToolBar {
    JButton defaultSettings, reset, random, save;
    JComboBox rotorSelector;
    
    public SettingToolBar(boolean rotorSettings) {
        defaultSettings = generateDefaultSettingsButton();
        reset = generateResetButton();
        random = generateRandomButton();
        save = generateSaveButton();

        add(defaultSettings);
        add(reset);
        add(random);
        add(save);

        if (rotorSettings) {
            rotorSelector = generateRotorSelector();
            add(rotorSelector);
        }

        this.setBackground(Color.BLUE);
        this.setFloatable(false);
    }

    private JComboBox generateRotorSelector() {
        return new JComboBox<>(new String[] { "1", "2", "3" });
    }

    private JButton generateDefaultSettingsButton() {
        return new JButton("default");
    }

    private JButton generateResetButton() {
        return new JButton("reset");
    }

    private JButton generateRandomButton() {
        return new JButton("random");
    }

    private JButton generateSaveButton() {
        return new JButton("save");
    }
}
