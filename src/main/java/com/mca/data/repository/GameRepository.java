package com.mca.data.repository;

import com.mca.infrastructure.model.VideoGameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<VideoGameEntity, String> {
}
