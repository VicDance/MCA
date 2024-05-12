package com.mca.data.mapper;

import com.mca.infrastructure.model.VideoGameEntity;
import com.mca.infrastructure.model.videoGame.Game;

public class GameMapper {

    //TODO: change to implement mapstruct

    public Game toDTO(VideoGameEntity entity) {
        Game game = new Game();
        game.setId(entity.getId());
        game.setTitle(entity.getName());

        return game;
    }
}
