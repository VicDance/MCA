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
public class SagaController implements GameSagaApiDelegate{

    @Override
    public ResponseEntity<Set<String>> getGameSagaRelatedSagas(String gameId) {
        return GameSagaApiDelegate.super.getGameSagaRelatedSagas(gameId);
    }
}
