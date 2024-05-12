package com.mca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class SagaController implements GameSagaApiDelegate{

    // Where are the relates games?
    @Override
    public ResponseEntity<Set<String>> getGameSagaRelatedSagas(String gameId) {
        return null;
    }
}
