package com.enigmamachine.app.ui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class SettingsPanel {
    private JPanel settingsPanel;

    public SettingsPanel() {
        setupPanel();
    }

    private void setupPanel() {
        this.settingsPanel.setLayout(new BoxLayout(this.settingsPanel, BoxLayout.Y_AXIS));
    }
}
