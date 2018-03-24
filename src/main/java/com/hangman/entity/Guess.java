package com.hangman.entity;


public class Guess {

    private String gameId;
    private String guessedLetter;


	public String getGameId() {
		return gameId;
	}
	
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	
	public String getGuessedLetter() {
		return guessedLetter;
	}
	
	public void setGuessedLetter(String guessedLetter) {
		this.guessedLetter = guessedLetter;
	}
    
    
    
    
}
