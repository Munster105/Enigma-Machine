package com.enigmamachine.app.ui.settings;

import javax.swing.JToolBar;

import java.awt.GridBagConstraints;

import javax.swing.JPanel;

public class RotorSettingsTabPanel extends SettingTabPanel implements SettingInterface {
    // placeholder text
    private String settingsDescription = "You must have 13 pairs for this section.\n"
            + "Each letter should only have 1 pairing as well";

    public RotorSettingsTabPanel() {
        super();
        settingEditorPanel = generateSettingEditorPanel();
        settingsDescPanel = generateSettingDescriptionPanel();
        toolBar = generateToolBar();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(toolBar, constraints);
        add(settingEditorPanel);
        add(settingsDescPanel);
    }

    @Override
    public JPanel generateSettingEditorPanel() {
        return new JPanel();
    }

    @Override
    public SettingDescriptionPanel generateSettingDescriptionPanel() {
        return new SettingDescriptionPanel("Rotor", settingsDescription);
    }

    @Override
    public JToolBar generateToolBar() {
        return new SettingToolBar(true);
    }
}
