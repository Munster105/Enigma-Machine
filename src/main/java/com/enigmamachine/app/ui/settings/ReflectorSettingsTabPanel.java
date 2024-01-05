package com.enigmamachine.app.ui.settings;

import javax.swing.JToolBar;

import java.awt.GridBagConstraints;

import javax.swing.JPanel;

public class ReflectorSettingsTabPanel extends SettingTabPanel implements SettingInterface {
    private String settingsDescription = "You must have 13 pairs for this section.\n"
            + "Each letter should only have 1 pairing as well";

    public ReflectorSettingsTabPanel() {
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
        return new SettingDescriptionPanel("Reflector", settingsDescription);
    }

    @Override
    public JToolBar generateToolBar() {
        return new SettingToolBar(false);
    }
}
