/**
* Description
*
* <p>Bugs: 
*
* @author Michael Leiby, Sean Rowland
* @date date
*/

package input;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import geometry_objects.points.Point;
import geometry_objects.points.PointDatabase;
import geometry_objects.segments.Segment;
import input.builder.GeometryBuilder;
import input.components.ComponentNode;
import input.components.FigureNode;
import input.components.point.PointNode;
import input.components.point.PointNodeDatabase;
import input.components.segment.SegmentNode;
import input.components.segment.SegmentNodeDatabase;
import input.parser.JSONParser;

public class InputFacade
{
	/**
	 * A utility method to acquire a figure from the given JSON file:
	 *     Constructs a parser
	 *     Acquries an input file string.
	 *     Parses the file.
     *
	 * @param filepath -- the path/name defining the input file
	 * @return a FigureNode object corresponding to the input file.
	 */
	public static FigureNode extractFigure(String filepath)
	{
        // TODO
	}
	
	/**
	 * 1) Convert the PointNode and SegmentNode objects to a Point and Segment objects 
	 *    (those classes have more meaningful, geometric functionality).
	 * 2) Return the points and segments as a pair.
     *
	 * @param fig -- a populated FigureNode object corresponding to a geometry figure
	 * @return a point database and a set of segments
	 */
	public static Map.Entry<PointDatabase, Set<Segment>> toGeometryRepresentation(FigureNode fig) {
		Map<PointDatabase, Set<Segment>> figure = new HashMap<>();
		
		PointNodeDatabase p = fig.getPointsDatabase();	
		Set<PointNode> pn = p.getPoints();
		
		PointDatabase pd = new PointDatabase();
		for (PointNode ptnd : pn) {
			pd.put(ptnd.getName(), ptnd.getX(), ptnd.getY());
		}
		
		
		SegmentNodeDatabase s = fig.getSegments();
		Map<PointNode, Set<PointNode>> MapPN = s.getAdjList();
		
		Set<Segment> seg = new HashSet<Segment>();
		for ()
			
			
		
	}

    //	
	// TODO: implement other support methods to facilitate the toGeometryRepresentation method
	//
}