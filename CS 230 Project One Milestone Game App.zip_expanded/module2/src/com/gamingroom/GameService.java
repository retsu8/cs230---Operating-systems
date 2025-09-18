package com.gamingroom;
import java.util.ArrayList;
import java.util.List;

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
		// Check the name, make sure its not a duplicate
		for (int i = 0; i < games.size(); i++) {
			if (games.get(i).getName().equals( name )) {
				// Return if its a duplicate.
				game = games.get(i);
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
		for (int i = 0; i < games.size(); i++) {
			if (games.get(i).getId() == id) {
				// If found return the game
				return games.get(i);
			}
		}

		return game;
	}
	
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
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// Get games based on names, then return when found
		for (int i = 0; i < games.size(); i++) {
			if (games.get(i).getName().equals(name)) {
				return games.get(i);
			}
		}

		// If no games are found return null
		return game;
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
