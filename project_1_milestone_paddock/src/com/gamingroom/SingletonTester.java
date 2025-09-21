package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		// Obtained a local reference to the descriptor
		GameService service = GameService.getInstance();

		for (int i = 0; i < service.getGameCount(); i++) {
			Game game = service.getGame(i);
			System.out.println(game);
			Team team = game.addTeam(i + " Random Shark");
			System.out.println(team);
			Player player = team.addPlayer("Tiger Shark");
			System.out.println(player);
			player = team.addPlayer("White Shark");
			System.out.println(player);
			player = team.addPlayer("Whale Shark");
			System.out.println(player);
		}

	}
	
}
