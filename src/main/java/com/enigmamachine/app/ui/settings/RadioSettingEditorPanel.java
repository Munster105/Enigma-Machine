package com.enigmamachine.app.ui.settings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.enigmamachine.app.constants.Constants;

public class RadioSettingEditorPanel extends JPanel {
    ArrayList<Color> colors = new ArrayList<Color>(){
        {
            add(new Color(255, 102, 102)); // Light Red
            add(new Color(255, 0, 0)); // Red
            add(new Color(51, 204, 255)); // Very light blue
            add(Color.BLUE);
            add(new Color(102, 255, 102)); // Very light green
            add(Color.GREEN);
            add(new Color(255, 255, 204)); // Very light yellow
            add(Color.YELLOW);
            add(new Color(255, 153, 0)); // Light orange
            add(Color.ORANGE);
            add(Color.LIGHT_GRAY);
            add(Color.GRAY);
            add(new Color(102, 0, 153)); // Purple
        }
    };

    // Used to determine when a pair is being made or needs to be made
    Color prevColor = null;
    JToggleButton prevSelected = null;
    
    HashMap<Character, Character> pairs;
    ArrayList<JToggleButton> letterButtons = new ArrayList<>();

    public RadioSettingEditorPanel(HashMap<Character, Character> pairs) {
        this.setBackground(Color.PINK);
        this.setLayout(new GridBagLayout());
        // Refine this size when finished creating panel
        this.setPreferredSize(new Dimension(900, 900));

        // Still need to process if letters are already paired from the incoming hashmap
        // and mark each pair accordingly
        this.pairs = pairs;

        int firstThirdRowCount = Math.ceilDiv(Constants.alphabetLength, 4);
        int secondFourthRowCount = Math.floorDiv(Constants.alphabetLength, 4);

        int letTracker = 0;
        int rowTracker = 0;
        for (int i = 0; i < 4; i++) {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            if (i%2 == 0) {
                for (int j = letTracker; j < firstThirdRowCount + letTracker; j++) {
                    constraints.gridy = rowTracker;
                    this.add(generateLetterRadio(Constants.alphabet[j]), constraints);
                }
                letTracker += firstThirdRowCount;
            }
            else {
                for (int j = letTracker; j < secondFourthRowCount + letTracker; j++) {
                    constraints.gridy = rowTracker;
                    this.add(generateLetterRadio(Constants.alphabet[j]), constraints);
                }
                letTracker += secondFourthRowCount;
            }
            rowTracker++;
        }
    }

    private JToggleButton generateLetterRadio(char letter) {
        JToggleButton letterButton = new JToggleButton(String.valueOf(letter));
        letterButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();

                if (state == ItemEvent.SELECTED) {
                    System.out.println("SELECTED");
                    // This should mean there is no letter waiting to be paired
                    if (prevColor == null) {
                        prevColor = colors.getLast();
                        prevSelected = letterButton;
                        letterButton.setBackground(prevColor);
                        colors.removeLast();
                    }
                    // Here we have just hit a pair
                    else {
                        if (prevSelected == null) {
                            System.out.println("Something went terribly wrong when trying to determine a pair: prevSelected=" + prevSelected.getText() + " curSelected=" + letterButton.getText());
                            letterButton.setSelected(false);
                            letterButton.setBackground(Color.WHITE);
                        }
                        else {
                            letterButton.setBackground(prevColor);
                            pairs.put(prevSelected.getText().charAt(0), letterButton.getText().charAt(0));
                        }

                        // Reset so we know we don't have a pair waiting
                        prevColor = null;
                        prevSelected = null;
                    }
                }
                else if (state == ItemEvent.DESELECTED) {
                    System.out.println("DESELECTED");
                    if (pairExists(letterButton.getText().charAt(0))) {
                        for (JToggleButton tButton : letterButtons) {
                            if (tButton.getBackground() == letterButton.getBackground()) {
                                tButton.setSelected(false);
                                tButton.setBackground(Color.WHITE);
                                break;
                            }
                        }
                    }
                    prevColor = null;
                    if (prevSelected != null) {
                        System.out.println("You deselected before making a pair. Deselecting pending pair letter");
                        prevSelected.setSelected(false);
                        prevSelected.setBackground(Color.WHITE);
                    }
                    prevSelected = null;
                    letterButton.setBackground(Color.WHITE);
                }
            }
        });

        return letterButton;
    }

    private boolean pairExists(Character letter) {
        if (this.pairs.get(letter) == null) {
            return false;
        }
        return true;
    }
}
