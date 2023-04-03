/**
* Tests for the PointDatabase class
*
* @author Michael Leiby, Sean Rowland
* @date 4/2/2023
*/

package geometry_objects.points;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointDatabaseTest {

	@Test
	void testPut() {
		PointDatabase pd = new PointDatabase();
		
		pd.put("A", 0, 0);
		assertTrue(pd._factory.contains(0, 0));
		
		pd.put("B", 1, 2);
		assertTrue(pd._factory.contains(1, 2));
		
		pd.put("C", 0, 1);
		assertTrue(pd._factory.contains(0, 1));
		
		pd.put("D", 5, 5);
		assertTrue(pd._factory.contains(5, 5));
	}

	@Test
	void testGetName() {
		PointDatabase pd = new PointDatabase();
		
		pd.put("A", 0, 0);
		pd.put("B", 1, 2);
		pd.put("C", 0, 1);
		pd.put("D", 5, 5);
		pd.put("E", 2, 2);
		pd.put("F", 3, 4);
		pd.put("G", 6, 9);
		
		assertEquals("A", pd.getName(0, 0));
		assertEquals("C", pd.getName(0, 1));
		assertEquals("E", pd.getName(2, 2));
		assertEquals("G", pd.getName(6, 9));
		
		assertEquals("B", pd.getName(new Point("B", 1, 2)));
		assertEquals("D", pd.getName(new Point("D", 5, 5)));
		assertEquals("F", pd.getName(new Point("F", 3, 4)));
	}
	
	@Test
	void testGetPoint() {
		PointDatabase pd = new PointDatabase();
		
		pd.put("A", 0, 0);
		pd.put("B", 1, 2);
		pd.put("C", 0, 1);
		pd.put("D", 5, 5);
		pd.put("E", 2, 2);
		pd.put("F", 3, 4);
		pd.put("G", 6, 9);
		
		assertEquals(new Point("A", 0, 0), pd.getPoint("A"));
		assertEquals(new Point("C", 0, 1), pd.getPoint("C"));
		assertEquals(new Point("E", 2, 2), pd.getPoint("E"));
		assertEquals(new Point("G", 6, 9), pd.getPoint("G"));
		
		assertEquals(new Point("B", 1, 2), pd.getName(new Point("B", 1, 2)));
		assertEquals(new Point("D", 5, 5), pd.getName(new Point("D", 5, 5)));
		assertEquals(new Point("F", 3, 4), pd.getName(new Point("F", 3, 4)));
		
		assertEquals(new Point("A", 0, 0), pd.getPoint(0, 0));
		assertEquals(new Point("D", 5, 5), pd.getPoint(5, 5));
		assertEquals(new Point("G", 6, 9), pd.getPoint(6, 9));
	}
}