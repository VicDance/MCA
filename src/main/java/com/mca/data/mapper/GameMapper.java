package com.mca.data.mapper;

import com.mca.infrastructure.model.VideoGameEntity;
import com.mca.infrastructure.model.videoGame.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GameMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "title", source = "entity.name")
    Game transformToDTO(VideoGameEntity entity);
}
