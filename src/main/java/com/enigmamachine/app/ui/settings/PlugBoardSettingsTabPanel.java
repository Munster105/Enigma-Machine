package com.enigmamachine.app.ui.settings;


import javax.swing.JToolBar;
import javax.swing.JPanel;

public class PlugBoardSettingsTabPanel extends SettingTabPanel implements SettingInterface {
    private String settingsDescription = "You must have 13 pairs for this section.\n"
            + "Each letter should only have 1 pairing as well";

    public PlugBoardSettingsTabPanel() {
        super();
        settingEditorPanel = generateSettingEditorPanel();
        settingsDescPanel = generateSettingDescriptionPanel();
        toolBar = generateToolBar();

        add(toolBar, getToolBarConstraints());
        add(settingEditorPanel, getSettingEditorPanelConstraints());
        add(settingsDescPanel, getSettingsDescPanelConstraints());
    }

    @Override
    public JPanel generateSettingEditorPanel() {
        return new RadialEditorPanel();
    }

    @Override
    public SettingDescriptionPanel generateSettingDescriptionPanel() {
        return new SettingDescriptionPanel("Plug Board", settingsDescription);
    }

    @Override
    public JToolBar generateToolBar() {
        return new SettingToolBar(false);
    }
}
