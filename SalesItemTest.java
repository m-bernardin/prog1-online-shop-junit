import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }
    
    @Test
    public void testDuplicateAuthor()
    {
        SalesItem salesIte = new SalesItem("How to Play Guitar With Long Nails, Vol 8", 200000);
        salesIte.addComment("Brisk Man", "I still can't play :(", 1);
        assertEquals(false, salesIte.addComment("Brisk Man", "I still can't play :(", 1));
    }
    
    @Test
    public void testOverRatingBoundary()
    {
        SalesItem salesIte = new SalesItem("The Complete Works of Dingus, revised Edition",19999);
        assertEquals(false, salesIte.addComment("Wayde Borkus", "Amazing collection, Dingus is truly one of the greats of our time.", 6)); 
    }
    
    @Test
    public void testUnderRatingBoundary()
    {
        SalesItem salesIte = new SalesItem("The Complete Works of Borkus, revised Edition",19999);
        assertEquals(false, salesIte.addComment("Wayde Dingus", "Horrible. Borkus has always thought he's better than me.", 0)); 
    }
    
    @Test
    public void testMostHelpfulComment()
    {
        SalesItem salesIte = new SalesItem("Overpriced Fancy Shoes", 100000000);
        salesIte.addComment("John Collector", "Amazing shoes and I trust this seller, I've bought many shoes from them before.", 5);
        Comment mostHelpful = salesIte.findMostHelpfulComment();
        assertEquals("John Collector", mostHelpful.getAuthor());
    }
    
    @Test
    public void testGetNumberOfComments()
    {
        SalesItem salesIte = new SalesItem("Picture of a Banana, oil on canvas, W. Dingus c. 2003", 10000000);
        salesIte.addComment("John Collector", "Another beuatiful work by Mr Dingus", 5);
        assertEquals(1, salesIte.getNumberOfComments());
    }
    
    @Test
    public void testPriceString()
    {
        SalesItem salesIte = new SalesItem("Borkus no. 9, various mediums, W. Borkus c. 2000", 200000000);
        assertEquals("$2000000.00", salesIte.priceString(salesIte.getPrice()));
    }
}
