package ru.mipt.cs.cluster.distance;
import ru.mipt.cs.cluster.kmeans.Pixel;

public interface Distance {
	
	/* Calculate distance between two pixels
	 */
	
	public double calculate (Pixel first, Pixel second);
}
