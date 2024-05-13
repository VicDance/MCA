package com.mca.data.mapper;

import com.mca.infrastructure.model.VideoGameEntity;
import com.mca.infrastructure.model.videoGame.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "title", source = "entity.name")
    Game transformToDTO(VideoGameEntity entity);
}
