package com.gamingroom;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author william.paddock@snhu.edu
 *
 */
public class Game extends Entity {
	// Build the game engine
	
	private static List<Team> teams = new ArrayList<Team>();
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	private Game() {
	}

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}
	
	public addTeam(String name){
		Iterator<Team> iter = teams.iterator();
		while (iter.hasNext()){
			Team team = iter.next();
			if (team.getName() == name){
				return;
			}
		}	
	}
	/**
	 * @return the game id and name for print
	 */
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
