import com.JohnJasonFisher.kid.App;
import com.JohnJasonFisher.kid.entity.Game;
import com.JohnJasonFisher.kid.repository.GameRepository;
import com.JohnJasonFisher.kid.service.GameService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GameServiceTests {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepo;

    @Before
    public void setUp() {
        Game game1 = new Game();
        game1 .setTitle("Super Mario Bros");
        game1 .setDescription("Platformer");
        gameRepo.save(game1);

        Game game2 = new Game();
        game2.setTitle("Super Mario Bros 2");
        game2.setDescription("Platformer");
        gameRepo.save(game2);

        Game game3 = new Game();
        game3.setTitle("Donkey Kong Country");
        game3.setDescription("Platformer");
        Game savedGame = gameRepo.save(game3);
    }

    @After
    public void tearDown(){
        gameRepo.deleteAll();
    }

    // GameRepo Tests

    @Test
    public void testFindGameById() {
        Game game = new Game();
        game.setId(666L);
        game.setTitle("Mario 64");
        game.setDescription("Platformer");
        Game created = gameRepo.save(game);

        Game result = gameRepo.findGameById(created.getId());

        Assert.assertEquals( "Mario 64", result.getTitle());
    }

    @Test
    public void testFindGamesByTitle() {
        List<Game> results = gameRepo.findGamesByTitle("%mario%");
        Assert.assertEquals(2, results.size());
    }

    @Test
    public void testFindAllGames() {
        List<Game> results = gameRepo.findAllGames();
        Assert.assertEquals(3, results.size());
    }

    @Test
    public void testSearchGamesByTitle() {
        List<Game> results = gameService.searchGamesByTitle("mario");
        Assert.assertEquals(2, results.size());
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
