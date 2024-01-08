package com.enigmamachine.app.ui.settings;

import javax.swing.JPanel;

public interface SettingInterface {
    abstract JPanel generateSettingEditorPanel();
    abstract String generateSettingTitle();
    abstract String generateSettingDesc();
}
