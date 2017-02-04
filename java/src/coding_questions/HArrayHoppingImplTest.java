package coding_questions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Odin on 2017-02-01.
 */
public class HArrayHoppingImplTest {
    HArrayHopping hop;

    @Before
    public void setUp() throws Exception {
        hop = new HArrayHoppingImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    //[]->[-1]
    @Test
    public void testHopEmpty() throws Exception {
        List<Integer> entry = new ArrayList<Integer>();
        List<String> sol = new ArrayList<String>(Arrays.asList("out"));

        assertEquals(sol, hop.getHops(entry));
    }

    //[1]->[0,-1]
    @Test
    public void testHopOne() throws Exception {
        List<Integer> entry = new ArrayList<Integer>(Arrays.asList(1));
        List<String> sol = new ArrayList<String>(Arrays.asList("0", "out"));

        assertEquals(sol, hop.getHops(entry));
    }

    //[0]->["failure"]
    @Test
    public void testHopOneWithZero() throws Exception {
        List<Integer> entry = new ArrayList<Integer>(Arrays.asList(0));
        List<String> sol = new ArrayList<String>(Arrays.asList("failure"));

        assertEquals(sol, hop.getHops(entry));
    }

    //[1,1,1,1]->[0,1,2,3,-1]
    @Test
    public void testHopSingles() throws Exception {
        List<Integer> entry = new ArrayList<Integer>(Arrays.asList(1,1,1,1));
        List<String> sol = new ArrayList<String>(Arrays.asList("0", "1", "2", "3", "out"));

        List<String> hops = hop.getHops(entry);
        assertEquals(sol,hops);
    }


    //[1,1,0,1]->[0,1, failure]
    @Test
    public void testHopSinglesWithZero() throws Exception {
        List<Integer> entry = new ArrayList<Integer>(Arrays.asList(1,1,0,1));
        List<String> sol = new ArrayList<String>(Arrays.asList("failure"));

        List<String> hops = hop.getHops(entry);
        assertEquals(sol, hops);
    }


    //[4,0,3,2,1]->[0,2,-1]
    @Test
    public void testHopMultipleValid() throws Exception {
        List<Integer> entry = new ArrayList<Integer>(Arrays.asList(4,0,3,2,1));
        List<String> sol = new ArrayList<String>(Arrays.asList("0", "2", "out"));

        List<String> hops = hop.getHops(entry);
        assertEquals(sol, hops);
    }

    //[4,0,4,2,1,1]->[0,2,-1]
    @Test
    public void testHopEarlyPick() throws Exception {
        List<Integer> entry = new ArrayList<Integer>(Arrays.asList(4,0,4,2,1,1));
        List<String> sol = new ArrayList<String>(Arrays.asList("0", "2", "out"));

        assertEquals(sol, hop.getHops(entry));
    }

    //[4,0,4,2,0,1,4,5,2,0,0,2,4,1]->[0,2,6,7,12,-1]
    @Test
    public void testHopLots() throws Exception {
        List<Integer> entry = new ArrayList<Integer>(Arrays.asList(4,0,4,2,0,1,4,5,2,0,0,2,4,1));
        List<String> sol = new ArrayList<String>(Arrays.asList("0", "2", "6", "7", "12", "out"));

        assertEquals(sol, hop.getHops(entry));
    }


    //[4,99,4,2,0,1,4,5,2,0,0,2,4,1]->[0,1,-1]
    @Test
    public void testBigHop() throws Exception {
        List<Integer> entry = new ArrayList<Integer>(Arrays.asList(4,99,4,2,0,1,4,5,2,0,0,2,4,1));
        List<String> sol = new ArrayList<String>(Arrays.asList("0", "1", "out"));

        assertEquals(sol, hop.getHops(entry));
    }

    @Test
    public void testGetNextHop() throws Exception {
        List<Integer> entry = new ArrayList<Integer>(Arrays.asList(0, 0, 3, 9, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        int sol = 3;
        int actual = ((HArrayHoppingImpl) hop).getNextHop(entry, 2);
        assertEquals(sol, actual);

        entry = new ArrayList<Integer>(Arrays.asList(0, 0, 9, 4, 5));
        sol = -1;
        actual = ((HArrayHoppingImpl) hop).getNextHop(entry, 2);
        assertEquals(sol, actual);

    }
}