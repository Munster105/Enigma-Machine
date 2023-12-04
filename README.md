# Enigma-Machine
### Desription:
The famous enigma machine was used by Nazi Germany to encode and decode their secret messages during World War 2. The machine usually used a series of three rotors, a plugboard, and a reflector in order to encode and decode their messages. The plugboard and reflector were rather simple in that they just took an incoming signal, or letter, and changed it into another. The rotors did something similar, however, the rotors would rotate with each letter that was entered, with a rotor not turning until the previous rotor had completed a full rotation, excluding the first rotor that would spin with every letter regardless of the other rotors. Additionally, the rotors could be spun to different settings without having to enter any letters. This means that anyone who wanted to decode a message would not only have to have an enimga machine, but they would also have to know what settings the rotors, plugboard, and reflectors had as well as the positioning of each rotor within the machine in order to be able to decode any intercepted message. This, of course, was bypassed by Alan Turner and his briliant collegues who noticed a flaw and exploited it heavily. More information can be found at the links below and various sources on YouTube.

This code aims to emulate the enigma machine. When run, the program allows the user to input letters and outputs the encoded letter. The user is also able to manually rotate the rotors to allow for decoding messages as well. All of this is contained in a minimalistic GUI. The rotor, reflector, and plugboard settings can be edited within the settings.txt file. See how to use for more information.

# NEEDS UPDATES
# Let's make this a maven project so people can easily clone and build the repo for easy use
### How to use:
1. Must have JDK installed. (JDK 21 was most recently used on this project)
2. Must have Maven installed. (Maven 3.9.6 was most recently used on this project)
3. Clone repo down to desired location
4. In the base folder of cloned repo:
    1. Run 'mvn clean package'. This will create a ~/Enigma-Machine/target directory where a Enigma-Machine-2.0.jar will be generated.
5. Run 'java -jar <path to Enigma-Machine>/target/Enigma-Machine-2.0.jar'
6. Updating the settings file
    * The settings file is preloaded with random settings which you can use without editing, if you'd like. If you'd like to edit these settings, however, the following form for the settings.txt file must be followed
    * Settings.txt form:
    * rotor 1 - Ex) <a,b,c,d,...> (You should have no spaces between commas and letters)
    * rotor 2 - Same as rotor 1
    * rotor 3 - Same as rotor 1
    * reflector - Ex) <(a,b),(c,d),...> (You must have 13 pairs for this section. Each letter should only have 1 pairing as well.)
    * plugboard - Same as reflector, however, you can have anywhere from 0 to 13 pairs.
    * The program must be recompiled in order to use your most recent updates to the settings.txt file. It is planned to make this more dynamic so this is not required.
 
### More information:
* https://en.wikipedia.org/wiki/Alan_Turing
* https://www.iwm.org.uk/history/how-alan-turing-cracked-the-enigma-code
* https://www.theguardian.com/technology/2014/nov/14/how-did-enigma-machine-work-imitation-game
* https://en.wikipedia.org/wiki/Enigma_machine
