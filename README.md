# Enigma-Machine
## Desription:
### The famous enigma machine was used by Nazi Germany to encode and decode their secret messages, during World War 2. The machine usually used a series of three rotors, a plugboard, and a reflector in order to encode and decode their messages. The plugboard and reflector were rather simple in that they just took an incoming signal, or letter, and changed it into another. The rotors did something similar, however, the rotors would rotate with each letter that was entered, with a rotor not turning until the previous rotor had completed a full rotation, excluding the first rotor that would spin with every letter regardless of the other rotors. Additionally, the rotors could be spun to different settings without having to enter any letters. This means that anyone who wanted to decode this message would have to have an enimga machine, but they would also have to know what settings the machine was set to in order to be able to decode any intercepted messages. This, of course, was by passed by Alan Turner and his briliant collegues who noticed a flaw and exploited it heavily. More information can be found at the links at the bottom and various sources on YouTube.
### This code aims to emulate the enigma machine. It is still a work in progress, but has the core functionality is present. So far, the program creates a simple GUI that allows the user to spin the rotors to specific settings. The user can also input letters and get the encoded letter back and vice versa. As I go on, I hope to add a settings menu to allow the user to change the rotor wirings, reflector wirings, and plugbord settings for the machine. These settings are currently hardcoded in the EnigmaMachine.java file in the initComponent() method. I also plan to make the program easier to run by potentially making it into a maven project or some other form that allows for a single command to run the program.

## How to use:
### -Must have JDK 13 or higher
### -Must have the Java Swing and Java AWT Libraries
### -If you enjoy Intellij, download all files and open the project there. You can then run the program with in the IDE and use the machine that way
### -Otherwise, you can download just the folders titled "constants", "core", and "ui" and compile and run the contained code in whatever way you like.

## More information:
### https://en.wikipedia.org/wiki/Alan_Turing
### https://www.iwm.org.uk/history/how-alan-turing-cracked-the-enigma-code
### https://www.theguardian.com/technology/2014/nov/14/how-did-enigma-machine-work-imitation-game
### https://en.wikipedia.org/wiki/Enigma_machine
