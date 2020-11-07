package ui;

import constants.Constants;
import constants.JTextFieldLimit;
import core.EnigmaMachine;
import core.Rotor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class EnigmaMachineUI {
    private Dimension screenSize;
    private JFrame frame;
    private JPanel mainPanel, rotorsPanel, bottomPanel;
    private JPanel rotor1Panel, rotor2Panel, rotor3Panel;
    private JLabel rotor1Label, rotor2Label, rotor3Label;
    private JButton rotor1Up, rotor1Down, rotor2Up, rotor2Down, rotor3Up, rotor3Down;
    private Integer rotor1Position = 1, rotor2Position = 1, rotor3Position = 1;
    private JTextField input;
    private JLabel output;

    private EnigmaMachine em;
    private ArrayList<ArrayList<Character>> rotorSettings;
    private HashMap<Character, Character> reflectorSettings;
    private HashMap<Character, Character> pbSettings;

    public EnigmaMachineUI(){
        // Set up enigma machine logic
        setUpMachine();

        //Setting up vars used for other functionality
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //Setting up the frame
        frame = new JFrame();
        frame.setTitle("Enigma Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setAutoRequestFocus(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Initializing the main panel that will house all panels for the main screen
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(600, 600));

        setUpRotorsPanel();
        setUpBottomPanel();

        rotorsPanel.setPreferredSize(new Dimension(600,500));
        bottomPanel.setPreferredSize(new Dimension(600, 500));

        //Main content panel houses the rotorPanel and bottomPanel to enable a more customisable layout of the panels
        mainPanel.add(rotorsPanel, Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(bottomPanel, Component.CENTER_ALIGNMENT);

        frame.getContentPane().add(mainPanel);
        frame.setMinimumSize(new Dimension(700, 700));
        frame.setVisible(true);
    }

    public void setUpMachine(){
        rotorSettings = new ArrayList<>();
        reflectorSettings = new HashMap<>();
        pbSettings = new HashMap<>();

        try {
            File file = new File("settings.txt");
            Scanner input = new Scanner(file);

            String temp;
            // First three lines will be added to the rotors settings
            for(int i = 0; i < 3 && input.hasNextLine(); i++){
                ArrayList<Character> tempRotor = new ArrayList<>();
                temp = input.nextLine();
                temp = temp.substring(1, temp.length() - 1);

                for(Character c : temp.toCharArray()){
                    if(tempRotor.contains(c)){
                        JOptionPane.showMessageDialog(frame, "You have a duplicate letter in rotor: " + (i + 1));
                        System.exit(0);
                    }
                    else if(!c.equals(',')) {
                        tempRotor.add(c);
                    }
                }
                if(tempRotor.size() != Constants.numLetters){
                    JOptionPane.showMessageDialog(frame, "You either have too many or not enough letters in rotor: " + (i + 1));
                    System.exit(0);
                }
                rotorSettings.add(tempRotor);
            }

            // Next line is the reflector
            temp = input.nextLine();
            temp = temp.substring(1, temp.length()-1);
            String pairTemp = "";
            for(Character c : temp.toCharArray()){
                // Add the character pairs
                if(c.equals(')')){
                    if(reflectorSettings.keySet().contains(pairTemp.charAt(0)) ||
                        reflectorSettings.keySet().contains(pairTemp.charAt(1))){
                        JOptionPane.showMessageDialog(frame, "The reflector settings has a duplicate value. Make sure that "
                                + pairTemp.charAt(0) + " and " + pairTemp.charAt(1) + " only has one pairing each.");
                        System.exit(0);
                    }
                    reflectorSettings.put(pairTemp.charAt(0), pairTemp.charAt(1));
                    reflectorSettings.put(pairTemp.charAt(1), pairTemp.charAt(0));
                    pairTemp = "";
                }
                else if(!c.equals('(') && !c.equals(',')){
                    pairTemp += c;
                }
            }
            if(reflectorSettings.keySet().size() != Constants.numLetters){
                JOptionPane.showMessageDialog(frame, "The reflector setting has either too many or not enough settings." +
                        " Make sure you have 13 pairs of characters with no repeating characters.");
                System.exit(0);
            }

            // Last line is the plugboard
            temp = input.nextLine();
            temp = temp.substring(1, temp.length() - 1);
            for(Character c : temp.toCharArray()){
                // Add the character pairs
                if(c.equals(')')){
                    if(pbSettings.keySet().contains(pairTemp.charAt(0)) ||
                        pbSettings.keySet().contains(pairTemp.charAt(1))){
                        JOptionPane.showMessageDialog(frame, "The plug board settings has a duplicate value. Make sure "
                                + pairTemp.charAt(0) + " and " + pairTemp.charAt(1) + " only has one pairing each.");
                        System.exit(0);
                    }
                    pbSettings.put(pairTemp.charAt(0), pairTemp.charAt(1));
                    pbSettings.put(pairTemp.charAt(1), pairTemp.charAt(0));
                    pairTemp = "";
                }
                else if(!c.equals('(') && !c.equals(',')){
                    pairTemp += c;
                }
            }
            if(pbSettings.keySet().size() > Constants.numLetters){
                JOptionPane.showMessageDialog(frame, "The plug board setting has too many settings." +
                        " Make sure that you have, at most, 13 pairs of characters with no repeating characters.");
                System.exit(0);
            }

        }
        catch(FileNotFoundException e){
            // This outputs the current directory for testing purposes
            System.out.println(System.getProperty("user.dir"));
            // Alert the user that the settings file wasn't found
            JOptionPane.showMessageDialog(frame, "There was an error trying to find the settings file. Please make sure" +
                    " it is in the correct directory.");
            System.exit(0);
        }

        em = new EnigmaMachine(rotorSettings, pbSettings, reflectorSettings);
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
        //Bottom panel initialization
        bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createTitledBorder(""));
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
                    // We can't just get the num spins because that is not always the right value if the user changes the rotor position
                    // We know that the first rotor should spin on every keypress
                    rotor1Position = (rotor1Position + 1 > Constants.numLetters) ? 1 : (rotor1Position + 1);
                    //Checking if the rotor has spun
                    if (em.getRotors().get(1).getNumSpins() != em.getRotors().get(1).getPrevNumSpins())
                        // If so, then set the rotorPosition "tag" to the new tag.
                        rotor2Position = (rotor2Position + 1 > Constants.numLetters) ? 1 : (rotor2Position + 1);
                    //Checking if the rotor has spun
                    if (em.getRotors().get(2).getNumSpins() != em.getRotors().get(2).getPrevNumSpins())
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
