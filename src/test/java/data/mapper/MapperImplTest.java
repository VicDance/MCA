package data.mapper;

import com.mca.data.mapper.GameMapper;
import com.mca.data.mapper.GameMapperImpl;
import com.mca.infrastructure.model.VideoGameEntity;
import com.mca.infrastructure.model.videoGame.Game;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = GameMapperImpl.class)
public class MapperImplTest {

    @Autowired
    private GameMapper mapper;

    @Test
    public void should_returnNull_when_nullEntity() {
        // When
        Game game = mapper.transformToDTO(null);

        // Then
        assertNull(game);
    }

    @Test
    public void should_returnDTO_when_validEntity() {
        // Given
        Game expectedGame = new Game("1", "Star Wars", null, null);
        VideoGameEntity entity = VideoGameEntity.builder().id("1").name("Star Wars").build();

        // When
        Game game = mapper.transformToDTO(entity);

        // Then
        assertEquals(expectedGame, game);
    }

    @Test
    public void should_returnEmptyDTO_when_emptyEntity() {
        // When
        Game game = mapper.transformToDTO(VideoGameEntity.builder().build());

        // Then
        assertTrue(Objects.isNull(game.getId()));
        assertTrue(Objects.isNull(game.getTitle()));
    }
}
