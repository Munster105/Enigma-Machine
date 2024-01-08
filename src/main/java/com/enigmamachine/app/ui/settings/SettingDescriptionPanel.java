package com.enigmamachine.app.ui.settings;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SettingDescriptionPanel extends JPanel {

    public SettingDescriptionPanel(String settingTitleText, String settingDescriptionText) {
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());

        GridBagConstraints constraint = new GridBagConstraints();
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridy = 0;
        this.add(generateSettingTitle(settingTitleText), constraint);

        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridy = 1;
        constraint.weighty = 1;
        this.add(generateSettingDesc(settingDescriptionText), constraint);
    }

    private JFormattedTextField generateSettingTitle(String settingTitleText) {
        JFormattedTextField settingTitle =  new JFormattedTextField(settingTitleText);

        settingTitle.setHorizontalAlignment(JTextField.CENTER);
        settingTitle.setFocusable(false);
        settingTitle.setEditable(false);

        settingTitle.setFont(new Font(Font.SERIF, Font.BOLD, 80));

        return settingTitle;
    }

    private JTextArea generateSettingDesc(String settingDescriptionText) {
        JTextArea settingDesc = new JTextArea(settingDescriptionText, 1, 40);

        settingDesc.setFocusable(false);
        settingDesc.setEditable(false);
        settingDesc.setWrapStyleWord(true);
        settingDesc.setLineWrap(true);

        settingDesc.setFont(new Font(Font.SERIF, Font.PLAIN, 20));

        return settingDesc;
    }
}
