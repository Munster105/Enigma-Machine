package com.enigmamachine.app.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.enigmamachine.app.constants.Constants;
import com.enigmamachine.app.constants.JTextFieldLimit;
import com.enigmamachine.app.core.EnigmaMachine;

public class EngimaPanel extends JPanel {
    private JPanel rotorsPanel, inputOutputPanel;
    private ArrayList<RotorPanel> rotors = new ArrayList<>();
    private JTextField input;
    private JLabel output;

    public EngimaPanel() {
        this.setLayout(new GridLayout(2, 1));

        this.rotorsPanel = generateRotorsPanel();
        this.inputOutputPanel = generateInputOutputPanel();

        this.add(rotorsPanel, Component.CENTER_ALIGNMENT);
        this.add(inputOutputPanel, Component.CENTER_ALIGNMENT);
    }

    private JPanel generateRotorsPanel() {
        JPanel rotorsPanel = new JPanel(new GridLayout());

        rotorsPanel.setBorder(BorderFactory.createTitledBorder("Rotors"));
        rotorsPanel.setName("Rotors");

        for (int i = 0; i < Constants.numRotors; i++) {
            rotors.add(new RotorPanel(i + 1));
            rotorsPanel.add(rotors.get(i));
        }

        return rotorsPanel;
    }

    private JPanel generateInputOutputPanel() {
        // inputOutput panel initialization
        JPanel inputOutputPanel = new JPanel();
        inputOutputPanel.setBorder(BorderFactory.createTitledBorder(""));
        inputOutputPanel.setLayout(new GridLayout());

        // Need an input field for inputting characters to encode
        input = new JTextField();
        input.setFont(new Font(Font.SERIF, Font.BOLD, 200));
        input.setHorizontalAlignment(JTextField.CENTER);
        input.setBorder(BorderFactory.createTitledBorder("Input: "));
        input.setDocument(new JTextFieldLimit(1));
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z') {
                    input.setText(String.valueOf(e.getKeyChar()));
                    output.setText(EnigmaMachine.encodeCharacter(e.getKeyChar()).toString());
                    // We can't just get the num spins because that is not always the right value if
                    // the user changes the rotor position
                    // We know that the first rotor should spin on every keypress
                    boolean rotor1Reset, rotor2Reset;
                    rotor1Reset = rotor2Reset = false;

                    rotor1Reset = rotors.get(0).increaseRotorPosition();
                    rotors.get(0).setRotorLabel(String.valueOf(rotors.get(0).getRotorPosition()));
                    // Checking if the rotor has spun
                    if (rotor1Reset) {
                        rotor2Reset = rotors.get(1).increaseRotorPosition();
                        rotors.get(1).setRotorLabel(String.valueOf(rotors.get(1).getRotorPosition()));
                    }

                    // Checking if the rotor has spun
                    if (rotor2Reset) {
                        rotors.get(2).increaseRotorPosition();
                        rotors.get(2).setRotorLabel(String.valueOf(rotors.get(2).getRotorPosition()));
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });

        // Need an output field for outputting encoded letters
        output = new JLabel("", SwingConstants.CENTER);
        output.setFont(new Font(Font.SERIF, Font.BOLD, 200));
        output.setHorizontalTextPosition(JLabel.CENTER);
        output.setBorder(BorderFactory.createTitledBorder("Output: "));

        inputOutputPanel.add(output);
        inputOutputPanel.add(input);

        return inputOutputPanel;
    }

}
