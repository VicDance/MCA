package com.mca.controller;

import com.mca.data.mapper.GameMapper;
import com.mca.data.repository.GameRepository;
import com.mca.data.service.GameService;
import com.mca.infrastructure.model.VideoGameEntity;
import com.mca.infrastructure.model.videoGame.Game;
import com.mca.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class GameController implements GameApiDelegate{

    @Autowired
    private GameServiceImpl gameService;

    private final GameMapper mapper = new GameMapper();

    @Override
    public ResponseEntity<Set<Game>> getGameSaga(String gameId) {
        Optional<VideoGameEntity> entity = gameService.getById(gameId);
        return ResponseEntity.ok(Set.of(mapper.toDTO(entity.get())));
    }
}
