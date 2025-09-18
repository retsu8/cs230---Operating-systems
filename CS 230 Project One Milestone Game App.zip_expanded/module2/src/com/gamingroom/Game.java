package com.gamingroom;

import java.util.*;

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
	private static long nextTeamId = 0;
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
	
	public Team addTeam(String name){
		Team new_team = null;
		Iterator<Team> iter = teams.iterator();
		while (iter.hasNext()){
			Team team = iter.next();
			if (team.getName() == name){
				new_team = team;
				break;
			}
		}	
		if(new_team == null) {
			new_team = new Team(nextTeamId++, name);
			teams.add(new_team);
		}
		return new_team;
	}
	/**
	 * @return the game id and name for print
	 */
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
