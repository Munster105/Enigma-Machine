package com.enigmamachine.app.ui.settings;

import javax.swing.JToolBar;
import javax.swing.JPanel;

public interface SettingInterface {
    abstract JPanel generateSettingEditorPanel();
    abstract SettingDescriptionPanel generateSettingDescriptionPanel();
    abstract JToolBar generateToolBar();
}
