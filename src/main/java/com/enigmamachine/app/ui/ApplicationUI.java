package com.enigmamachine.app.ui;

import javax.swing.*;

import com.enigmamachine.app.ui.settings.SettingsTabbedPanel;

public class ApplicationUI extends JFrame {
    private JTabbedPane mainPane;

    public ApplicationUI() {
        super("Enigma Machine");

        mainPane = new JTabbedPane();
        mainPane.addTab("Enigma Machine", generateEnigmaPanel());
        mainPane.add("Settings", generateSettingPanel());
        mainPane.add("About", generateAboutPanel());

        this.add(mainPane);

        // Setting up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAutoRequestFocus(true);
        this.pack();
        // Stops it from being able to be sized down from it's initial size.
        // This allows us to essentally have a minsize based on the other components
        // in the application, namely we don't want to be able to size the editor panel
        // down too much
        this.setMinimumSize(this.getSize());

        this.setVisible(true);
    }

    private SettingsTabbedPanel generateSettingPanel() {
        return new SettingsTabbedPanel();
    }

    private JPanel generateAboutPanel() {
        return new JPanel();
    }

    private EngimaPanel generateEnigmaPanel() {
        return new EngimaPanel();
    }
}
