package com.hangman.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@JsonInclude(Include.NON_NULL)
public class Game implements Response{

    private String gameId;
    
    @JsonIgnore
    private String word;
    
    private StringBuilder currentWord;
    private String status;
    private Integer incorrect;
    private String response;


	public Game(String gameId, String word) {
    	//this.status = "";
        this.gameId = gameId;
        this.word = word;
        currentWord = new StringBuilder();
        for(int i = 0; i <word.length();i++){
        	currentWord.append("_");
        }
    }

    public Game(){}

    public String getId() {
        return gameId;
    }

    public void setId(String gameId) {
        this.gameId = gameId;
    }
    
	public Integer getIncorrect() {
		return incorrect;
	}

	public void setIncorrect(Integer incorrect) {
		this.incorrect = incorrect;
	}
	
	public void ifIncorrectNull() {
	    if(this.incorrect == null){
	    	this.incorrect = new Integer(0);
	    }
	}
	
	public void incrementWrong(){
		this.incorrect++;
	}

	public StringBuilder getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(StringBuilder initialWord) {
		this.currentWord = initialWord;
	}

	public void ifStatusNull() {
	    if(this.status == null){
	    	this.status = "ACTIVE";
	    }
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	 public String getResponse() {
			return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
    
    
}
