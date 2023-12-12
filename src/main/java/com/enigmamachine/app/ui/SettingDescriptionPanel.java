package com.enigmamachine.app.ui;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;

public class SettingDescriptionPanel {
    private JPanel settingDescriptionPanel = new JPanel();

    public SettingDescriptionPanel(String settingsTitle, String settingsDescription) {
        setupSettingDescriptionPanel(settingsTitle, settingsDescription);
    }

    private void setupSettingDescriptionPanel(String settingsTitle, String settingsDescription) {
        JFormattedTextField settingsTitleField = new JFormattedTextField(settingsTitle);
    }    
}
