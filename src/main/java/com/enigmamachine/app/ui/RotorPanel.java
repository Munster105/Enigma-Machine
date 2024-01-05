package com.enigmamachine.app.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.enigmamachine.app.constants.Constants;
import com.enigmamachine.app.core.EnigmaMachine;
import com.enigmamachine.app.core.Rotor;

public class RotorPanel extends JPanel {
    private Integer rotorPosition = 1;
    private JLabel rotorLabel;

    public RotorPanel(Integer rotorNum) {
        initRotorPanel(rotorNum);
    }

    public boolean increaseRotorPosition() {
        if (this.rotorPosition + 1 > Constants.alphabetLength) {
            this.rotorPosition = 1;
            return true;
        }
        this.rotorPosition += 1;
        return false;
    }

    private void initRotorPanel(Integer rotorNum) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Rotor " + rotorNum.toString()));

        rotorLabel = new JLabel();
        rotorLabel.setText(rotorPosition.toString());
        rotorLabel.setFont(new Font(Font.SERIF, Font.BOLD, 100));

        JButton rotorUp = new JButton();
        rotorUp.setText("/\\");
        rotorUp.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        rotorUp.addActionListener(e -> {
            rotorPosition = (rotorPosition + 1 > Constants.alphabetLength) ? 1 : (rotorPosition + 1);
            EnigmaMachine.getRotors().get(0).spinRotor();
            for (Rotor r : EnigmaMachine.getRotors()) {
                r.setNumSpins(0);
                r.setPrevNumSpins(0);
            }
            rotorLabel.setText(String.valueOf(rotorPosition));
        });

        JButton rotorDown = new JButton();
        rotorDown.setText("\\/");
        rotorDown.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        rotorDown.addActionListener(e -> {
            rotorPosition = (rotorPosition - 1 < 1) ? Constants.alphabetLength : (rotorPosition - 1);
            EnigmaMachine.getRotors().get(0).reverseRotor();
            for (Rotor r : EnigmaMachine.getRotors()) {
                r.setNumSpins(0);
                r.setPrevNumSpins(0);
            }
            rotorLabel.setText(String.valueOf(rotorPosition));
        });

        this.add(rotorUp);
        this.add(Box.createVerticalGlue());
        this.add(rotorLabel);
        this.add(Box.createVerticalGlue());
        this.add(rotorDown);

        this.setPreferredSize(new Dimension(300, 300));

        rotorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rotorUp.setAlignmentX(Component.CENTER_ALIGNMENT);
        rotorDown.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public Integer getRotorPosition() {
        return this.rotorPosition;
    }
    public void setRotorLabel(String rotorLabel) {
        this.rotorLabel.setText(rotorLabel);
    }
}
