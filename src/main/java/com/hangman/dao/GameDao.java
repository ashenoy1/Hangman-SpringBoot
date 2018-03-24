package com.hangman.dao;

import com.hangman.entity.Game;

public interface GameDao {

    Game newGame();
    Game getGame(String gameId);

}
