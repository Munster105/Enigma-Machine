package com.enigmamachine.app.ui;

import javax.swing.*;
import java.awt.*;

public class ApplicationUI extends JFrame{
    private JTabbedPane mainPane;

    public ApplicationUI() {
        super("Enigma Machine");
        // Setting up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setAutoRequestFocus(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        mainPane = new JTabbedPane();
        mainPane.addTab("Enigma Machine", generateEnigmaPanel());
        mainPane.addTab("Settings", generateSettingPanel());
        mainPane.addTab("About", generateAboutPanel());
        
        this.add(mainPane);
        this.setMinimumSize(new Dimension(700, 700));
        this.pack();
        this.setVisible(true);
    }

    private SettingsPanel generateSettingPanel() {
        return new SettingsPanel();
    }

    private JPanel generateAboutPanel() {
        return new JPanel();
    }

    private EngimaPanelUI generateEnigmaPanel() {
        return new EngimaPanelUI();
    }
}
