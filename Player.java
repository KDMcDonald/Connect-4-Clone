/**
 * A Player has a name and pawn that is entered by the user, and number of wins.
 * 
 * @authors James McCarter, Kain McDonald, and Sam Ruiz
 * @id MBK897, NZK963, BVL818
 * @assignment Final Project
 * @version 1
 * @date 04/06/2020
 * @purpose To supply the constructed player info for the statistics page later.
 *
 */


public class Player {
	
	private String name;
	private char pawn;
	private int wins;
	
	/**
	 * Constructs a Player with initial values.
	 */
	public Player() {
		name = "";
		pawn = ' ';
		wins = 0;
	}
	
	/**
	 * Constructs a Player with user input values.
	 * @param name the player's name
	 * @param pawnType the player's pawn character
	 */
	public Player(String name, char pawnType) {
		this.name = name;
		pawn = pawnType;
		wins = 0;
	}
	
	/**
	 * Gets the player's name.
	 * @return the player's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the player's pawn character.
	 * @return the player's pawn
	 */
	public char getPawn() {
		return pawn;
	}
	
	/**
	 * Gets the number of wins.
	 * @return the number of wins
	 */
	public int getWins() {
		return wins;
	}
	
	/**
	 * Sets the player's name.
	 * @param name the player's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets player's number of wins.
	 * @param wins the player's number of wins
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	/**
	 * Sets the player's pawnType.
	 * @param pawnType player's pawnType
	 */
	public void setPawn(char pawnType) {
		pawn = pawnType;
	}
	
	/**
	 * Adds a win to player's wins.
	 * 
	 */
	public void addWin() {
		wins = wins+1;
	}
}
