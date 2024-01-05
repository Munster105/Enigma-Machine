package com.enigmamachine.app.ui.settings;

import java.awt.Color;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;

public class SettingDescriptionPanel extends JPanel {
    JFormattedTextField settingDescriptionText;

    public SettingDescriptionPanel(String settingTitle, String settingDescription) {
        this.setBackground(Color.BLACK);
        this.settingDescriptionText = generateSettingsTextField(settingTitle, settingDescription);

        this.add(this.settingDescriptionText);
    }

    private JFormattedTextField generateSettingsTextField(String settingTitle, String settingDescription) {
        return new JFormattedTextField(settingDescription);
    }
}
