package com.enigmamachine.app.ui.settings;

import java.util.ArrayList;

import com.enigmamachine.app.core.Rotor;

public class RotorSettingsTabPanel extends SettingTabPanel implements SettingInterface {

    ArrayList<Rotor> rotors;

    public RotorSettingsTabPanel(ArrayList<Rotor> rotors) {
        super();
        this.settingEditorPanel = generateSettingEditorPanel();
        this.settingsDescPanel = generateSettingDescriptionPanel(generateSettingTitle(), generateSettingDesc());
        this.toolBar = generateToolBar();

        this.rotors = rotors;
        add(toolBar, getToolBarConstraints());
        add(settingEditorPanel, getSettingEditorPanelConstraints());
        add(settingsDescPanel, getSettingsDescPanelConstraints());
    }

    @Override
    public ComboBoxSettingEditorPanel generateSettingEditorPanel() {
        return new ComboBoxSettingEditorPanel();
    }

    @Override
    public String generateSettingTitle() {
        return "Rotors";
    }

    @Override
    public String generateSettingDesc() {
        // TODO: Update the description
        return "This is the plug board setting. \n" 
        + "You can select up to 13 pairs of letters denoted by the matching colors under each letter. \n"
        + "Click a blank letter to start a pair and click a second letter to complete the match.\n"
        + "Click a non-blank letter to clear the pair. \n"
        + "Each letter DOES NOT have to have a pair.\n"
        + "The toolbar has additional tools. \n"
        + "The default button will revert the settings to the application default. (Not currently working)\n"
        + "The reset button will clear ALL settings currently set. (Not currently working)\n"
        + "The random button will set a random set of settings. (Not currently working)\n"
        + "The save button will save your currently selected settings. (Not currently working)";
    }
}
