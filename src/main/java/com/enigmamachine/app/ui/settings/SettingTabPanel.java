package com.enigmamachine.app.ui.settings;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class SettingTabPanel extends JPanel {
    protected JPanel settingEditorPanel;
    protected SettingDescriptionPanel settingsDescPanel;
    protected JToolBar toolBar;

    protected GridBagConstraints constraints = new GridBagConstraints();

    protected SettingTabPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.GRAY);
    }

    protected GridBagConstraints getToolBarConstraints() {
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 2;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 0;

        return constraints;
    }

    protected GridBagConstraints getSettingEditorPanelConstraints() {
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;

        return constraints;
    }

    protected GridBagConstraints getSettingsDescPanelConstraints() {
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 1;
        constraints.weightx = 0;
        constraints.weighty = 1;
        constraints.gridx = 1;
        constraints.gridy = 1;

        return constraints;
    }
}
