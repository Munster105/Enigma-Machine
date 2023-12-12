package com.enigmamachine.app.ui;

import com.enigmamachine.app.constants.Constants;
import com.enigmamachine.app.constants.JTextFieldLimit;
import com.enigmamachine.app.core.EnigmaMachine;
import com.enigmamachine.app.core.Rotor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaMachineUI {
    private Dimension screenSize;
    private JFrame frame;
    private JMenuBar menuBar;
    private JPanel mainPanel, rotorsPanel, bottomPanel;
    private JPanel rotor1Panel, rotor2Panel, rotor3Panel;
    private JLabel rotor1Label, rotor2Label, rotor3Label;
    private JButton rotor1Up, rotor1Down, rotor2Up, rotor2Down, rotor3Up, rotor3Down;
    private Integer rotor1Position = 1, rotor2Position = 1, rotor3Position = 1;
    private JTextField input;
    private JLabel output;

    public EnigmaMachineUI() {
        // Setting up vars used for other functionality
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Setting up the frame
        this.frame = new JFrame("Enigma Machine");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BorderLayout());
        this.frame.setAutoRequestFocus(true);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Initializing the main panel that will house all panels for the main screen
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.mainPanel.setPreferredSize(new Dimension(600, 600));

        setUpRotorsPanel();
        setUpBottomPanel();
        setupMenuBar();

        // Main content panel houses the rotorPanel and bottomPanel to enable a more
        // customisable layout of the panels
        this.mainPanel.add(rotorsPanel, Component.CENTER_ALIGNMENT);
        this.mainPanel.add(Box.createVerticalGlue());
        this.mainPanel.add(bottomPanel, Component.CENTER_ALIGNMENT);

        this.frame.setJMenuBar(this.menuBar);
        this.frame.getContentPane().add(mainPanel);
        this.frame.setMinimumSize(new Dimension(700, 700));
        this.frame.setVisible(true);
    }

    private void setupMenuBar() {
        this.menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");

        JMenuItem settingsItem = new JMenuItem("Settings");
        settingsItem.addActionListener(new ActionListener() {
            // TODO: Add in open settings panel
        });
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(new ActionListener() {
            // TODO: Add dialog explaining some simple details about project, motivations, etc.
        });

        menu.add(settingsItem);
        menu.add(aboutItem);

        this.menuBar.add(menu);
    }

    private void setUpRotorsPanel() {
        rotorsPanel = new JPanel();
        rotorsPanel.setLayout(new BoxLayout(rotorsPanel, BoxLayout.X_AXIS));
        rotorsPanel.setBorder(BorderFactory.createTitledBorder("Rotors"));

        // Rotor1
        rotor1Panel = new JPanel();
        rotor1Panel.setLayout(new BoxLayout(rotor1Panel, BoxLayout.Y_AXIS));
        rotor1Panel.setBorder(BorderFactory.createTitledBorder("Rotor 1"));

        rotor1Label = new JLabel();
        rotor1Label.setText(rotor1Position.toString());
        rotor1Label.setFont(new Font(Font.SERIF, Font.BOLD, 100));

        rotor1Up = new JButton();
        rotor1Up.setText("/\\");
        rotor1Up.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        rotor1Up.addActionListener(e -> {
            rotor1Position = (rotor1Position + 1 > Constants.alphabetLength) ? 1 : (rotor1Position + 1);
            EnigmaMachine.getRotors().get(0).spinRotor();
            for (Rotor r : EnigmaMachine.getRotors()) {
                r.setNumSpins(0);
                r.setPrevNumSpins(0);
            }
            rotor1Label.setText(String.valueOf(rotor1Position));
        });

        rotor1Down = new JButton();
        rotor1Down.setText("\\/");
        rotor1Down.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        rotor1Down.addActionListener(e -> {
            rotor1Position = (rotor1Position - 1 < 1) ? Constants.alphabetLength : (rotor1Position - 1);
            EnigmaMachine.getRotors().get(0).reverseRotor();
            for (Rotor r : EnigmaMachine.getRotors()) {
                r.setNumSpins(0);
                r.setPrevNumSpins(0);
            }
            rotor1Label.setText(String.valueOf(rotor1Position));
        });

        rotor1Panel.add(rotor1Up);
        rotor1Panel.add(Box.createVerticalGlue());
        rotor1Panel.add(rotor1Label);
        rotor1Panel.add(Box.createVerticalGlue());
        rotor1Panel.add(rotor1Down);

        // Rotor 2
        rotor2Panel = new JPanel();
        rotor2Panel.setLayout(new BoxLayout(rotor2Panel, BoxLayout.Y_AXIS));
        rotor2Panel.setBorder(BorderFactory.createTitledBorder("Rotor 2"));

        rotor2Label = new JLabel();
        rotor2Label.setText(rotor2Position.toString());
        rotor2Label.setFont(new Font(Font.SERIF, Font.BOLD, 100));
        rotor2Label.setHorizontalTextPosition(JLabel.CENTER);

        rotor2Up = new JButton();
        rotor2Up.setText("/\\");
        rotor2Up.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        rotor2Up.addActionListener(e -> {
            rotor2Position = (rotor2Position + 1 > Constants.alphabetLength) ? 1 : (rotor2Position + 1);
            EnigmaMachine.getRotors().get(1).spinRotor();
            for (Rotor r : EnigmaMachine.getRotors()) {
                r.setNumSpins(0);
                r.setPrevNumSpins(0);
            }
            rotor2Label.setText(String.valueOf(rotor2Position));
        });

        rotor2Down = new JButton();
        rotor2Down.setText("\\/");
        rotor2Down.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        rotor2Down.addActionListener(e -> {
            rotor2Position = (rotor2Position - 1 < 1) ? Constants.alphabetLength : (rotor2Position - 1);
            EnigmaMachine.getRotors().get(1).reverseRotor();
            for (Rotor r : EnigmaMachine.getRotors()) {
                r.setNumSpins(0);
                r.setPrevNumSpins(0);
            }
            rotor2Label.setText(String.valueOf(rotor2Position));
        });

        rotor2Panel.add(rotor2Up);
        rotor2Panel.add(Box.createVerticalGlue());
        rotor2Panel.add(rotor2Label);
        rotor2Panel.add(Box.createVerticalGlue());
        rotor2Panel.add(rotor2Down);

        // Rotor 3
        rotor3Panel = new JPanel();
        rotor3Panel.setLayout(new BoxLayout(rotor3Panel, BoxLayout.Y_AXIS));
        rotor3Panel.setBorder(BorderFactory.createTitledBorder("Rotor 3"));

        rotor3Label = new JLabel();
        rotor3Label.setText(rotor3Position.toString());
        rotor3Label.setFont(new Font(Font.SERIF, Font.BOLD, 100));
        rotor3Label.setHorizontalTextPosition(JLabel.CENTER);

        rotor3Up = new JButton();
        rotor3Up.setText("/\\");
        rotor3Up.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        rotor3Up.addActionListener(e -> {
            rotor3Position = (rotor3Position + 1 > Constants.alphabetLength) ? 1 : (rotor3Position + 1);
            EnigmaMachine.getRotors().get(2).spinRotor();
            for (Rotor r : EnigmaMachine.getRotors()) {
                r.setNumSpins(0);
                r.setPrevNumSpins(0);
            }
            rotor3Label.setText(String.valueOf(rotor3Position));
        });

        rotor3Down = new JButton();
        rotor3Down.setText("\\/");
        rotor3Down.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        rotor3Down.addActionListener(e -> {
            rotor3Position = (rotor3Position - 1 < 1) ? Constants.alphabetLength : (rotor3Position - 1);
            EnigmaMachine.getRotors().get(2).reverseRotor();
            for (Rotor r : EnigmaMachine.getRotors()) {
                r.setNumSpins(0);
                r.setPrevNumSpins(0);
            }
            rotor3Label.setText(String.valueOf(rotor3Position));
        });

        rotor3Panel.add(rotor3Up);
        rotor3Panel.add(Box.createVerticalGlue());
        rotor3Panel.add(rotor3Label);
        rotor3Panel.add(Box.createVerticalGlue());
        rotor3Panel.add(rotor3Down);

        rotor1Panel.setPreferredSize(new Dimension(300, 300));
        rotor2Panel.setPreferredSize(new Dimension(300, 300));
        rotor3Panel.setPreferredSize(new Dimension(300, 300));

        rotor1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        rotor1Up.setAlignmentX(Component.CENTER_ALIGNMENT);
        rotor1Down.setAlignmentX(Component.CENTER_ALIGNMENT);
        rotor2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        rotor2Up.setAlignmentX(Component.CENTER_ALIGNMENT);
        rotor2Down.setAlignmentX(Component.CENTER_ALIGNMENT);
        rotor3Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        rotor3Up.setAlignmentX(Component.CENTER_ALIGNMENT);
        rotor3Down.setAlignmentX(Component.CENTER_ALIGNMENT);

        rotorsPanel.add(rotor1Panel);
        rotorsPanel.add(Box.createHorizontalGlue());
        rotorsPanel.add(rotor2Panel);
        rotorsPanel.add(Box.createHorizontalGlue());
        rotorsPanel.add(rotor3Panel);

        rotorsPanel.setPreferredSize(new Dimension(600, 500));
    }

    private void setUpBottomPanel() {
        // Bottom panel initialization
        bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createTitledBorder(""));
        bottomPanel.setLayout(new GridLayout(1, 2));

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
                    output.setText(EnigmaMachine.useMachine(e.getKeyChar()).toString());
                    // We can't just get the num spins because that is not always the right value if
                    // the user changes the rotor position
                    // We know that the first rotor should spin on every keypress
                    rotor1Position = (rotor1Position + 1 > Constants.alphabetLength) ? 1 : (rotor1Position + 1);
                    // Checking if the rotor has spun
                    if (EnigmaMachine.getRotors().get(1).getNumSpins() != EnigmaMachine.getRotors().get(1)
                            .getPrevNumSpins())
                        // If so, then set the rotorPosition "tag" to the new tag.
                        rotor2Position = (rotor2Position + 1 > Constants.alphabetLength) ? 1 : (rotor2Position + 1);
                    // Checking if the rotor has spun
                    if (EnigmaMachine.getRotors().get(2).getNumSpins() != EnigmaMachine.getRotors().get(2)
                            .getPrevNumSpins())
                        rotor3Position = (rotor3Position + 1 > Constants.alphabetLength) ? 1 : (rotor3Position + 1);
                    rotor1Label.setText(String.valueOf(rotor1Position));
                    rotor2Label.setText(String.valueOf(rotor2Position));
                    rotor3Label.setText(String.valueOf(rotor3Position));
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

        bottomPanel.add(output);
        bottomPanel.add(input);

        bottomPanel.setPreferredSize(new Dimension(600, 500));
    }
}
