package ru.mipt.cs.cluster.distance;
import ru.mipt.cs.cluster.kmeans.Pixel;

public class EuclidianSquareDistance implements Distance {
	
	/* Calculate Euclidian square distance 
	*/
	
	public double calculate (Pixel first, Pixel second) {
		double squareDistance = 0;
		double temporary;
		
		temporary = first.getRed() - second.getRed();
		temporary *= temporary;
		squareDistance += temporary;
		temporary = first.getGreen() - second.getGreen();
		temporary *= temporary;
		squareDistance += temporary;
		temporary = first.getBlue() - second.getBlue();
		temporary *= temporary;
		squareDistance += temporary;
		
		return squareDistance;
	}
}
