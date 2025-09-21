package com.gamingroom;

import java.util.*;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author william.paddock@snhu.edu
 *
 */
public class Team extends Entity implements Iterable<Player> {
	// Player list for the team.
	private List<Player> players = new ArrayList<Player>();

	// Implment iterator into Player list
	@Override
	public java.util.Iterator<Player> iterator(){
		return players.iterator();
	}
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}
	
	public Player addPlayer(String name) {
		Player new_player = null;
		GameService service = GameService.getInstance();
		for(Player player: players){
			if (player.getName().equals(name)){
				return player;
			}
		}	
		if(new_player == null) {
			new_player = new Player(service.getNextPlayerId(), name);
			players.add(new_player);
		}
		return new_player;
	}
	/*
	 *  @return the team id and name
	 */
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
