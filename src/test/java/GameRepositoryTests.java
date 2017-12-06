import com.JohnJasonFisher.kid.App;
import com.JohnJasonFisher.kid.entity.Game;
import com.JohnJasonFisher.kid.repository.GameRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GameRepositoryTests {
    @Autowired
    private GameRepository gameRepo;

    @Test
    public void testFindGameBytitle() {
        List<Game> results = gameRepo.findGamesByTitle("%mario%");
        Assert.assertEquals(3, results.size());
    }

    @Test
    public void testfindAllGames() {
        List<Game> results = gameRepo.findAllGames();
        Assert.assertEquals(8, results.size());
    }

    @Test
    public void testfindGameById() {
        Game result = gameRepo.findGameById(1L);
        Assert.assertEquals("Super Mario Bros", result.getTitle());
    }
}
