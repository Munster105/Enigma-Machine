package ui;

import constants.Constants;
import constants.JTextFieldLimit;
import core.EnigmaMachine;
import core.Rotor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaMachineUI {
    private Dimension screenSize;
    private JFrame frame, settingsScreen;
    private JMenuBar menuBar;
    private JMenu settings;
    private JMenuItem changeSettings;
    private JPanel mainPanel, rotorsPanel, bottomPanel;
    private JPanel rotor1Panel, rotor2Panel, rotor3Panel;
    private JLabel rotor1Label, rotor2Label, rotor3Label;
    private JButton rotor1Up, rotor1Down, rotor2Up, rotor2Down, rotor3Up, rotor3Down;
    private Integer rotor1Position = 1, rotor2Position = 1, rotor3Position = 1;
    private JTextField input;
    private JLabel output;

    private EnigmaMachine em;

    public EnigmaMachineUI(EnigmaMachine enigmaMachine){
        //Setting up vars used for other functionality
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        em = enigmaMachine;

        //Setting up the frame
        frame = new JFrame();
        frame.setTitle("Enimga Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setAutoRequestFocus(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Initializing the main panel that will house all panels for the main screen
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(600, 600));

        setUpSettingsFrame();
        setUpMenuBar();
        setUpRotorsPanel();
        setUpBottomPanel();

        rotorsPanel.setPreferredSize(new Dimension(600,500));
        bottomPanel.setPreferredSize(new Dimension(600, 500));

        //Main content panel houses the rotorPanel and bottomPanel to enable more customizability to the layout of the panels
        mainPanel.add(rotorsPanel, Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(bottomPanel, Component.CENTER_ALIGNMENT);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(mainPanel);
        frame.setMinimumSize(new Dimension(700, 700));
        frame.setVisible(true);
    }

    public void setUpSettingsFrame(){
        settingsScreen = new JFrame();
        settingsScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        settingsScreen.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Testing 1");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Testing 2");
            }

            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        settingsScreen.setVisible(true);
    }

    public void setUpMenuBar(){
        //Setting up menuBar
        menuBar = new JMenuBar();
        settings = new JMenu("Settings");
        settingsScreen = new JFrame();

        changeSettings = new JMenuItem("Change Settings");

        settings.add(changeSettings);
        menuBar.add(settings);

        changeSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public void setUpRotorsPanel(){
        rotorsPanel = new JPanel();
        rotorsPanel.setLayout(new BoxLayout(rotorsPanel, BoxLayout.X_AXIS));
        rotorsPanel.setBorder(BorderFactory.createTitledBorder("Rotors"));

        //Rotor1
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
            rotor1Position = (rotor1Position + 1 > Constants.numLetters) ? 1 : (rotor1Position + 1);
            em.getRotors().get(0).spinRotor();
            for(Rotor r : em.getRotors()){
                r.setNumSpins(0);
                r.setPrevNumSpins(0);
            }
            rotor1Label.setText(String.valueOf(rotor1Position));
        });

        rotor1Down = new JButton();
        rotor1Down.setText("\\/");
        rotor1Down.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        rotor1Down.addActionListener(e -> {
            rotor1Position = (rotor1Position - 1 < 1) ? Constants.numLetters : (rotor1Position - 1);
            em.getRotors().get(0).reverseRotor();
            for(Rotor r : em.getRotors()){
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

        //Rotor 2
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
            rotor2Position = (rotor2Position + 1 > Constants.numLetters) ? 1 : (rotor2Position + 1);
            em.getRotors().get(1).spinRotor();
            for(Rotor r : em.getRotors()){
                r.setNumSpins(0);
                r.setPrevNumSpins(0);
            }
            rotor2Label.setText(String.valueOf(rotor2Position));
        });

        rotor2Down = new JButton();
        rotor2Down.setText("\\/");
        rotor2Down.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        rotor2Down.addActionListener(e -> {
            rotor2Position = (rotor2Position - 1 < 1) ? Constants.numLetters : (rotor2Position - 1);
            em.getRotors().get(1).reverseRotor();
            for(Rotor r : em.getRotors()){
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

        //Rotor 3
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
            rotor3Position = (rotor3Position + 1 > Constants.numLetters) ? 1 : (rotor3Position + 1);
            em.getRotors().get(2).spinRotor();
            for(Rotor r : em.getRotors()){
                r.setNumSpins(0);
                r.setPrevNumSpins(0);
            }
            rotor3Label.setText(String.valueOf(rotor3Position));
        });

        rotor3Down = new JButton();
        rotor3Down.setText("\\/");
        rotor3Down.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        rotor3Down.addActionListener(e -> {
            rotor3Position = (rotor3Position - 1 < 1) ? Constants.numLetters : (rotor3Position - 1);
            em.getRotors().get(2).reverseRotor();
            for(Rotor r : em.getRotors()){
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

        rotor1Panel.setPreferredSize(new Dimension(300,300));
        rotor2Panel.setPreferredSize(new Dimension(300,300));
        rotor3Panel.setPreferredSize(new Dimension(300,300));

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
    }

    public void setUpBottomPanel(){
        //Bottom panel intialization
        bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Bottom Panel"));
        bottomPanel.setLayout(new GridLayout(1, 2));

        //Need an input field for inputting characters to encode
        input = new JTextField();
        input.setFont(new Font(Font.SERIF, Font.BOLD, 200));
        input.setHorizontalAlignment(JTextField.CENTER);
        input.setBorder(BorderFactory.createTitledBorder("Input: "));
        input.setDocument(new JTextFieldLimit(1));
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z') {
                    input.setText(String.valueOf(e.getKeyChar()));
                    output.setText(em.useMachine(e.getKeyChar()).toString());
                    rotor1Position = (rotor1Position + 1 > Constants.numLetters) ? 1 : (rotor1Position + 1);
                    //Checking if the rotor has spun
                    if (em.getRotors().get(1).getNumSpins() > em.getRotors().get(1).getPrevNumSpins())
                        rotor2Position = (rotor2Position + 1 > Constants.numLetters) ? 1 : (rotor2Position + 1);
                    //Checking if the rotor has spun
                    if (em.getRotors().get(2).getNumSpins() > em.getRotors().get(2).getPrevNumSpins())
                        rotor3Position = (rotor3Position + 1 > Constants.numLetters) ? 1 : (rotor3Position + 1);
                    rotor1Label.setText(String.valueOf(rotor1Position));
                    rotor2Label.setText(String.valueOf(rotor2Position));
                    rotor3Label.setText(String.valueOf(rotor3Position));
                }
            }

            @Override public void keyReleased(KeyEvent e) {}
            @Override public void keyTyped(KeyEvent e) {}
        });

        //Need an output field for outputting encoded letters
        output = new JLabel("", SwingConstants.CENTER);
        output.setFont(new Font(Font.SERIF, Font.BOLD, 200));
        output.setHorizontalTextPosition(JLabel.CENTER);
        output.setBorder(BorderFactory.createTitledBorder("Output: "));

        bottomPanel.add(output);
        bottomPanel.add(input);
    }
}
