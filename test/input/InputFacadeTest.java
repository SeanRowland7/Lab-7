/**
* Tests for the InputFacade class
*
* @author Michael Leiby, Sean Rowland
* @date date
*/

package input;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

//import input.builder.AbstractMap;
import input.builder.GeometryBuilder;
//import input.builder.GeometryBuilderTest;
//import input.builder.Integer;
//import input.builder.String;
//import input.builder.StringBuilder;
import geometry_objects.points.*;
import geometry_objects.segments.Segment;
import input.components.ComponentNode;
import input.components.FigureNode;
import input.parser.JSONParser;
import input.visitor.UnparseVisitor;

class InputFacadeTest {

	@Test
	void testExtractFigure() 
	{
		//A----B-----C--D-----E----------F

		String figureStr = utilities.io.FileUtilities.readFileFilterComments("collinear_line_segments.json");
			
		ComponentNode node = InputFacade.extractFigure(figureStr);

		assertTrue(node instanceof FigureNode);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor(); 
		
		unparser.visitFigureNode((FigureNode)node, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		System.out.println(sb.toString());
	
	}
	@Test
	void testToGeometryRepresentation() 
	{
		PointDatabase expectedPoints = new PointDatabase();
		expectedPoints.put("A", 0, 0);
		expectedPoints.put("B", 4, 0);
		expectedPoints.put("C", 9, 0);
		expectedPoints.put("D", 11, 0);
		expectedPoints.put("E", 16, 0);
		expectedPoints.put("F", 26, 0);
		
		LinkedHashSet<Segment> expectedSegments = new LinkedHashSet<Segment>();
		Point pointA = new Point("A", 0, 0);
		Point pointB = new Point("B", 4, 0);
		Point pointC = new Point("C", 9, 0);
		Point pointD = new Point("D", 11, 0);
		Point pointE = new Point("E", 16, 0);
		Point pointF = new Point("F", 26, 0);
		
		expectedSegments.add(new Segment(pointA, pointB));
		expectedSegments.add(new Segment(pointB, pointC));
		expectedSegments.add(new Segment(pointC, pointD));
		expectedSegments.add(new Segment(pointD, pointE));
		expectedSegments.add(new Segment(pointE, pointF));

		
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("collinear_line_segments.json");
		ComponentNode node = InputFacade.extractFigure(figureStr);
		PointDatabase actualPoints = InputFacade.toGeometryRepresentation((FigureNode) node).getKey();
		Set<Segment> actualSegments = InputFacade.toGeometryRepresentation((FigureNode) node).getValue();
		
		
		
		assertEquals(expectedSegments, actualSegments);
		assertEquals(expectedPoints.getPoints(), actualPoints.getPoints());
	}
	
	

	
	
}