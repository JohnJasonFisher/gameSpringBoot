import com.JohnJasonFisher.kid.App;
import com.JohnJasonFisher.kid.entity.Game;
import com.JohnJasonFisher.kid.repository.GameRepository;
import com.JohnJasonFisher.kid.service.GameService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GameServiceTests {

    // By autowiring in our game repository, we will have access to all of it's public methods
    @Autowired
    private GameRepository gameRepo;

    @Test
    public void testFindGameBytitle() {
        // We want to find all games with a title like "mario"
        List<Game> results = gameRepo.findGamesByTitle("%mario%");
        Assert.assertEquals(3, results.size());
    }

    @Autowired
    private GameService gameService;

    @Test
    public void testSearchGamesByTitle() {
        List<Game> results = gameService.searchGamesByTitle("kong");
        Assert.assertEquals(1, results.size());
    }

    @Test
    public void testInsertGame() throws Exception {
        Game game = new Game();
        game.setTitle("A Link to the Past");
        game.setDescription("Action-adventure");
        Game created = gameService.insertGame(game);
        Assert.assertNotNull(created.getId());
    }

}
