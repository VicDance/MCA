package com.mca.service;

import com.mca.data.repository.GameRepository;
import com.mca.data.service.GameService;
import com.mca.infrastructure.model.VideoGameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    public GameRepository repository;

    @Override
    public Optional<VideoGameEntity> getById(String id) {
        if (id == null) {
            throw new IllegalArgumentException(HttpStatus.BAD_REQUEST + ": Id cannot be null");
        }
        if (Integer.parseInt(id) < 0) {
            throw new IllegalArgumentException(HttpStatus.BAD_REQUEST + ": Id cannot be less than 0");
        }
        return Optional.of(repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(HttpStatus.NOT_FOUND + ": Id not found")));
    }
}
