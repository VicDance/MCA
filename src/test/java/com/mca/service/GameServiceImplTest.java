package com.mca.service;

import com.mca.data.repository.GameRepository;
import com.mca.infrastructure.model.VideoGameEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GameServiceImplTest {

    private GameServiceImpl service;

    @Autowired
    private GameRepository repository;

    @BeforeEach
    public void setUp() {
        service = new GameServiceImpl();
        service.repository = repository;
    }

    @Test
    void should_return200_when_validId() {
        // Given
        String gameId = "1";

        // When
        Optional<VideoGameEntity> entity = service.getById(gameId);

        // Then
        Assertions.assertEquals(entity.get().getId(), gameId);
    }

    @Test
    void should_return400_when_invalidId() {
        // Given
        String expectedMessage = "400 BAD_REQUEST: Id cannot be null";

        // When
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> service.getById(null));
        String actualMessage = exception.getMessage();

        // Then
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void should_return400_when_idLessThanZero() {
        // Given
        String expectedMessage = "400 BAD_REQUEST: Id cannot be less than 0";

        // When
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> service.getById("-2"));
        String actualMessage = exception.getMessage();

        // Then
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void should_return404_when_noGameFound() {
        // Given
        String expectedMessage = "404 NOT_FOUND: Id not found";

        // When
        NoSuchElementException exception = Assertions.assertThrows(NoSuchElementException.class, () -> service.getById("102"));
        String actualMessage = exception.getMessage();

        // Then
        assertEquals(actualMessage, expectedMessage);
    }
}