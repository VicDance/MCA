package com.mca.controller;

import com.mca.data.mapper.GameMapper;
import com.mca.data.repository.GameRepository;
import com.mca.infrastructure.model.videoGame.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class GameController implements GameApiDelegate{

    @Autowired
    private GameRepository repository;

    private GameMapper mapper = new GameMapper();

    @Override
    public ResponseEntity<Set<Game>> getGameSaga(String gameId) {
        System.out.println("Funciona");
        Set<Game> gameSet = Stream.of(repository.getReferenceById(gameId)).map(game -> mapper.toDTO(game)).collect(Collectors.toSet());
        return ResponseEntity.ok(gameSet);
    }
}
