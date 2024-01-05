package com.enigmamachine.app.ui.settings;

import java.awt.Color;
import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class SettingDescriptionPanel extends JFormattedTextField {

    public SettingDescriptionPanel(String settingTitle, String settingDescription) {
        this.setBackground(Color.BLACK);
        this.setFormatter(generateTextFieldFormatter());
        this.setValue(settingDescription);
    }

    private AbstractFormatter generateTextFieldFormatter() {
        AbstractFormatter formatter = new AbstractFormatter() {
            @Override
            public Object stringToValue(String text) throws ParseException {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'stringToValue'");
            }

            @Override
            public String valueToString(Object value) throws ParseException {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'valueToString'");
            }
            
        };
        
        return formatter; 
    }
}
