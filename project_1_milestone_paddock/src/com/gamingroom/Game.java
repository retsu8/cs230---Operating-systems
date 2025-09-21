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
public class Game extends Entity implements Iterable<Team> {
	// Build the game engine
	
	private static List<Team> teams = new ArrayList<Team>();

	// Implment iterator into teams for iteration
	@Override
	public java.util.Iterator<Team> iterator(){
		return teams.iterator();
	}
	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}
	
	public Team addTeam(String name){
		Team new_team = null;
		GameService service = GameService.getInstance();
		for(Team team : teams){
			if (team.getName() == name){
				return team;
			}
		}
		if(new_team == null) {
			long new_team_id = service.getNextTeamId();
			System.out.println(new_team_id);
			new_team = new Team(new_team_id, name);
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
