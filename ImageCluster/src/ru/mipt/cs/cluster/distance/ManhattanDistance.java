package ru.mipt.cs.cluster.distance;
import ru.mipt.cs.cluster.clustering.Pixel;

public class ManhattanDistance implements Distance {
	
	/* Calculate Manhattan distance
	*/
	
	public double calculate (Pixel first, Pixel second) {
		double distance = 0;
		
		distance += Math.abs(first.getRed() - second.getRed());
		distance += Math.abs(first.getGreen() - second.getGreen());
		distance += Math.abs(first.getBlue() - second.getBlue());
		
		return distance;
	}
}
