package com.hangman.service;

import com.hangman.dao.GameDao;
import com.hangman.entity.CustomError;
import com.hangman.entity.Game;
import com.hangman.entity.Guess;
import com.hangman.entity.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service
public class GameService {

    @Autowired
    @Qualifier("HangmanData") //Specify which DAO
    private GameDao gameDao;
    
    public Game newGame(){
    	return this.gameDao.newGame();
    }
    
    public Response makeGuess(Guess guessObj){
    	Game gameObj = gameDao.getGame(guessObj.getGameId());
    	
    	//Initialize within Guess function, so these JSON variables don't show for newgame()
    	gameObj.ifStatusNull();
    	gameObj.ifIncorrectNull();
    	
    	try{
    		if(gameObj.getStatus().equals("WON") || gameObj.getStatus().equals("LOST"))
    			return new CustomError("Game is already complete");
    	}catch(NullPointerException e){
    		return new CustomError("GameId is invalid");
    	}
    	
    	String originalWord = gameObj.getWord();
    	String shownWord = gameObj.getCurrentWord().toString();
    	String guess = guessObj.getGuessedLetter().toLowerCase();
    	if(guess.length() != 1)
    		return new CustomError("Input letter needs to be a single character");
    	
    	
    	//If char exists in word and hasn't already been found, apply following operations
    	if(originalWord.contains(guess) && !shownWord.contains(guess)){
    		int index = originalWord.indexOf(guess);
    		char guessChar = guess.charAt(0);
    		while (index >= 0) {
    			StringBuilder newCurrent = gameObj.getCurrentWord();
    			newCurrent.setCharAt(index, guessChar);
    			gameObj.setCurrentWord(newCurrent);
    		    index = originalWord.indexOf(guess, index + 1);
    		}
    		
    		//If originalWord and the currentWord are equal, user has won!
    		if(gameObj.getWord().equals(gameObj.getCurrentWord().toString()))
    			gameObj.setStatus("WON");
    				
    	}
    	
    	//Char doesn't exist or has already been checked for
    	else{
    		gameObj.incrementWrong();
    		if(gameObj.getIncorrect() == 7)
    			gameObj.setStatus("LOST");
    	}
    	return gameObj;
    }
}
