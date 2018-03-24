package com.hangman.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hangman.entity.Game;

import java.util.*;

@Repository
@Qualifier("HangmanData")
public class HangmanWordDaoImpl implements GameDao {

    private static Map<String, Game> games;
    private static List<String> dictionary;

    static {

        games = new HashMap<String, Game>();
        dictionary = Arrays.asList("popular", "hangman", "words","to","use","with","my","software"); 
    }
    
    @Override
    public Game newGame(){
    	Game game = generateRandomGame();
    	games.put(game.getId(),game);
    	return this.games.get(game.getId());
    }
    
	@Override
	public Game getGame(String gameId) {
		return this.games.get(gameId);
		// TODO Auto-generated method stub	
	}
	
	public Game generateRandomGame(){
		Random r = new Random();
		int Low = 97;  //ASCII value of 'a'
		int High = 122; //ASCII value of 'z'
		StringBuilder randomId = new StringBuilder();
		for (int i = 0; i < 5; i++) {
            char letter = (char)(r.nextInt(High-Low) + Low);
            randomId.append(letter);
        }
		String word = dictionary.get(r.nextInt(dictionary.size()));
		return new Game(randomId.toString(),word);	
	}


}
