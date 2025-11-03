import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testUpvote()
    {
        Comment comment = new Comment("Ash", "Cool", 4);
        comment.upvote();
        assertEquals(1, comment.getVoteCount()); 
    }
    
    @Test
    public void testDownvote()
    {
        Comment comment = new Comment("Ash", "Cool", 4);
        comment.downvote();
        assertEquals(-1, comment.getVoteCount()); 
    }
    
    @Test
    public void testRating()
    {
        Comment comment = new Comment("Ash", "Cool", 4);
        comment.upvote();
        assertEquals(4, comment.getRating()); 
    }
}
