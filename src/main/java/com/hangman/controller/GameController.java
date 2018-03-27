package com.hangman.controller;

import com.hangman.entity.Game;
import com.hangman.entity.Guess;
import com.hangman.entity.Response;
import com.hangman.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(method = RequestMethod.GET)
    public Response newGame(){
        return gameService.newGame();
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
    public Response makeGuess(@RequestBody Guess guess){ 
        return gameService.makeGuess(guess);
    }
}
