package com.mca.controller;

import com.mca.data.mapper.GameMapper;
import com.mca.data.repository.GameRepository;
import com.mca.data.service.GameService;
import com.mca.infrastructure.model.VideoGameEntity;
import com.mca.infrastructure.model.videoGame.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class GameController implements GameApiDelegate{

    @Autowired
    private GameService service;

    private final GameMapper mapper = new GameMapper();

    @Override
    public ResponseEntity<Set<Game>> getGameSaga(String gameId) {
        VideoGameEntity entity = VideoGameEntity.builder().build();
        try {
            entity = service.getById(gameId).orElseThrow(() -> new Exception(HttpStatus.NOT_FOUND + ": Id not found"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(Set.of(mapper.toDTO(entity)));
    }
}
