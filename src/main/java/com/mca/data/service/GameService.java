package com.mca.data.service;

import com.mca.infrastructure.model.VideoGameEntity;

import java.util.Optional;

public interface GameService {
    Optional<VideoGameEntity> getById(String id);
}
