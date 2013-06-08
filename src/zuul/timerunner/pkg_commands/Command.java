package zuul.timerunner.pkg_commands;import zuul.timerunner.pkg_others.Player;/** * This class is part of the "World of Zuul" application.  * "World of Zuul" is a very simple, text based adventure game.   * * This class holds information about a command that was issued by the user. * A command currently consists of two parts: a CommandWord and a string * (for example, if the command was "take map", then the two parts * are TAKE and "map"). *  * The way this is used is: Commands are already checked for being valid * command words. If the user entered an invalid command (a word that is not * known) then the CommandWord is UNKNOWN. * * If the command had only one word, then the second word is <null>. *  * @author  Michael Kolling and David J. Barnes * @author  ASTIER Naji & ROBIN Yohann * @version 25/03/2013 */public abstract class Command{    private String aSecondWord;    private String aThirdWord;    /**     * Create a command object. First and second words must be supplied, but     * the second may be null.     */    public Command ()    {        this.aSecondWord = null;        this.aThirdWord = null;    }        /**     * @return The second word of this command. Returns null if there was no     * second word.     */    public String getSecondWord()    {        return this.aSecondWord;    }        /**     * @return true if the command has a second word.     */    public boolean hasSecondWord()    {        return (this.aSecondWord != null);    }         /**     * Define the second word of this command (the word     * entered after the command word). Null indicates that      * there was no second word.     */    public void setSecondWord(final String secondWord)    {        this.aSecondWord = secondWord;    }        /**     * Execute this command. A flag is returned indicating whether     * the game is over as a result of this command.     *      */    public abstract void execute(Player player);        public String getThirdWord()    {        return this.aThirdWord;    }        /**     * @return true if the command has a second word.     */    public boolean hasThirdWord()    {        return (this.aThirdWord != null);    }         /**     * Define the second word of this command (the word     * entered after the command word). Null indicates that      * there was no second word.     */    public void setThirdWord(final String thirdWord)    {        this.aThirdWord = thirdWord;    }}