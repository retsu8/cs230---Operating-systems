package com.gamingroom;
import java.util.*;

/**
 * A singleton service for the game engine
 * 
 * @author william.paddock@snhu.edu
 */
public final class GameService implements Iterable<Game> {	
	// Implment iterator into game list
	@Override
	public java.util.Iterator<Game> iterator(){
		return games.iterator();
	}
	/**
	 * A list of the active games
	 */

	// Fixing for static array for better looping
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	private static long nextPlayerId = 1;
	private static long nextTeamId = 1;

	private static GameService service = null;

	private GameService() {}

	// Create or find the current game service instance
	// This singleton instance handles the game server making sure only one server is available at at time.
	public static GameService getInstance()
	{
		if (service == null) {
			// Make it thread safe here
			synchronized (GameService.class)
			{
				// check again as multiple threads
				// can reach above step
				if (service == null) {
					service = new GameService();
				}
			}
		}
		return service;
	}

	public Game getGame(int id){
		return games.get(id);
	}
	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// Iterate though the games to find the one with the right name
		for(Game thisGame : games){
			if (thisGame.getName().equals( name )) {
				// Found the game, return it instad of adding it.
				return thisGame;
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {
		// a local game instance
		Game game = null;

		// Get games based on ids, then return when found
		for (Game thisGame : games) {
			if (thisGame.getId() == id) {
				return thisGame;
			}

		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// Get games based on names, then return when found
		for (Game thisGame : games) {
			// Return the game when the name is found
			if (thisGame.getName().equals(name)) {
				return thisGame;
			}

		}

		// If no games are found return null
		return game;
	}
	/** 
	 * Get the next player id currently running game or -1 for no player or game
	 * @param game_id
	 * @return Next player id in game
	 */
	public long getNextPlayerId() {
		return nextPlayerId++;
	}

	/** 
	 * Get the next game id currently running or return -1 for no game
	 * @param team_id
	 * @return Next team_id to be used
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}
	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
