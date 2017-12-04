import com.JohnJasonFisher.kid.App;
import com.JohnJasonFisher.kid.entity.Comment;
import com.JohnJasonFisher.kid.entity.Game;
import com.JohnJasonFisher.kid.repository.CommentRepository;
import com.JohnJasonFisher.kid.repository.GameRepository;
import com.JohnJasonFisher.kid.service.CommentService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class CommentServiceTest {

    @Autowired
    private GameRepository gameRepo;

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private CommentService commentService;

    @After
    public void tearDown(){
        commentRepo.deleteAll();
    }

    @Test
    public void testCreateAndFindComment() throws Exception {
        List<Game> allGames = gameRepo.findAll();
        List<Comment> gameComments = new ArrayList<Comment>();
        Comment newComment = new Comment();
        newComment.setAuthor("Dayna");
        newComment.setText("This is a cool game.");
        Comment created = null;
        if (allGames.size() > 0) {
            created = commentService.createGameComment(newComment, allGames.get(0).getId());
            gameComments = commentService.searchCommentsByGameId(allGames.get(0).getId());
        }
        Assert.assertNotNull(created);
        Assert.assertTrue(gameComments.size() > 0);
    }


}
