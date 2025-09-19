package com.gamingroom;
import java.util.*;

/**
 * A singleton service for the game engine
 * 
 * @author william.paddock@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	
	// Fixing for static array for better looping
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	private static GameService single_instance = null;
	
	
	// Create or find the current game service instance
	// This singleton instance handles the game server making sure only one server is available at at time.
	public static synchronized GameService getInstance()
    {
        if (single_instance == null) {
        	// Make it thread safe here
	        synchronized (GameService.class)
	        {
	            // check again as multiple threads
	            // can reach above step
	            if (single_instance == null) {
	 	           single_instance = new GameService();
	            }
	        }
        }
        return single_instance;
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
		Iterator<Game> i = games.iterator();
		while (i.hasNext()) {
			Game thisGame = i.next();
			if (thisGame.getName().equals( name )) {
				// Found the game, return it instad of adding it.
				game = thisGame;
				break;
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
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
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
		Iterator<Game> i = games.iterator();
		while (i.hasNext()) {
			Game thisGame = i.next();			
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
		Iterator<Game> i = games.iterator();
		while (i.hasNext()) {
			Game thisGame = i.next();
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
	private long nextPlayerId(long player_id) {
		for(int i = 0; i < games.size(); i++) {
			Game game = games.get(i);
			long id = game.getId();
			if (id == player_id) {
				if(games.contains(i++)) {
					return player_id++;
				} 
			}
		}
		return -1;
	}
	
	/** 
	 * Get the next game id currently running or return -1 for no game
	 * @param game_id
	 * @return Next game currently running
	 */
	private long nextGameId(long game_id) {
		for(int i = 0; i < games.size(); i++) {
			Game game = games.get(i);
			long id = game.getId();
			if (id == game_id) {
				if(games.contains(i++)) {
					return game_id++;
				} 
			}
		}
		return -1;
	}
	/** 
	 * Get the next team id assocaited to the game
	 * @param game_id
	 * @return Next game currently running
	 */
	private long nextTeamId(long team_id) {
		// Assuming last game for team ids
		for(int i = 0; i < games.size(); i++) {
			
		}
		for(int i = 0; i < games.size(); i++) {
			Game game = games.get(i);
			long id = game.getId();
			if (id == team_id) {
				if(games.contains(i++)) {
					return team_id++;
				} 
			}
		}
		return -1;
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
