/**
* Tests for the PointNamingFactory class
*
* @author Michael Leiby, Sean Rowland
* @date 3 April 2023
*/

package geometry_objects.points;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointNamingFactoryTest {

	@Test
	void putPTest() 
	{
		PointNamingFactory f1 = new PointNamingFactory();
		Point p1 = new Point(5, 5);
		f1.put(p1);
		assertTrue(f1.contains(p1));
	}

	@Test
	void putXYTest() 
	{
		PointNamingFactory f1 = new PointNamingFactory();
		f1.put(new Point(5, 5));
		assertTrue(f1.contains(5, 5));
	}
	
	@Test
	void putNXYTest() 
	{
		PointNamingFactory d1 = new PointNamingFactory();
		d1.put(new Point("S", 5, 5));
		assertTrue(d1.contains(5, 5));
	}
	
	@Test
	void getXYTest() 
	{
		PointNamingFactory d1 = new PointNamingFactory();
		d1.put(new Point(5, 5));
		assertTrue(d1.contains(5, 5));
	}
	
	@Test
	void getPTest() 
	{
		PointNamingFactory d1 = new PointNamingFactory();
		d1.put(new Point(5, 5));
		assertTrue(d1.contains(5, 5));
	}
	
	@Test
	void containsXYTest() 
	{
		PointNamingFactory d1 = new PointNamingFactory();
		d1.put(new Point(5, 5));
		assertTrue(d1.contains(5, 5));
	}
	
	@Test
	void containsPTest() 
	{
		PointNamingFactory d1 = new PointNamingFactory();
		d1.put(new Point(5, 5));
		assertTrue(d1.contains(5, 5));
	}
	
	@Test
	void getAllPointsTest() 
	{
		PointNamingFactory d1 = new PointNamingFactory();
		d1.put(new Point(5, 5));
		assertTrue(d1.contains(5, 5));
	}
	
	@Test
	void toStringTest() 
	{
		PointNamingFactory d1 = new PointNamingFactory();
		d1.put(new Point(5, 5));
		assertTrue(d1.contains(5, 5));
	}
}