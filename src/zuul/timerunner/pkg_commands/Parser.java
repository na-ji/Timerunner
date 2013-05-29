package zuul.timerunner.pkg_commands;import java.util.Scanner;/** * This class is part of the "World of Zuul" application.  * "World of Zuul" is a very simple, text based adventure game.   *  * This parser reads user input and tries to interpret it as an "Adventure" * command. Every time it is called it reads a line from the terminal and * tries to interpret the line as a two-word command. It returns the command * as an object of class Command. * * The parser has a set of known command words. It checks user input against * the known commands, and if the input is not one of the known commands, it * returns a command object that is marked as an unknown command. *  * @author  Michael Kolling and David J. Barnes * @author  ASTIER Naji & ROBIN Yohann * @version 25/03/2013 */public class Parser {	// holds all valid command words    private CommandWords aCommands;        /**     * Create a parser to read from the terminal window.     */    public Parser()     {        this.aCommands = new CommandWords();    }        /**     * @param pInputLine the input line     * @return The next command from the user.     */    public Command getCommand(final String pInputLine)     {        String vWord1 = null;        String vWord2 = null;        String vWord3 = null;         // Find up to two words on the line.        Scanner vTokenizer = new Scanner(pInputLine);        if(vTokenizer.hasNext())         {        	// get first word            vWord1 = vTokenizer.next();                 if(vTokenizer.hasNext())             {            	// get second word                vWord2 = vTokenizer.next();                     // note: we just ignore the rest of the input line.                 if(vTokenizer.hasNext())                 {                	// get third word                     vWord3 = vTokenizer.next();                 }            }        }        vTokenizer.close();                Command vCommand = aCommands.getCommand(vWord1);        if(vCommand != null) {            vCommand.setSecondWord(vWord2);            vCommand.setThirdWord(vWord3);        }        return vCommand;    }        /**     * Return the list of valid command words.     */    public String showCommands()    {        return this.aCommands.showAll();    }}