package ru.mipt.cs.cluster.distance;
import ru.mipt.cs.cluster.kmeans.Pixel;

public class EuclidianDistance implements Distance {
	
	/* Calculate Euclidian distance
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
		
		return Math.sqrt(squareDistance / 3);
	}
}
