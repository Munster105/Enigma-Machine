package com.enigmamachine.app.ui;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;

public class SettingDescriptionPanel extends JPanel {
    JFormattedTextField settingsTitleField;

    public SettingDescriptionPanel(String settingsTitle, String settingsDescription) {
        settingsTitleField = new JFormattedTextField(settingsTitle);
    }
}
