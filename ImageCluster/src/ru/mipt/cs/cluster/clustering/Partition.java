package ru.mipt.cs.cluster.clustering;
import java.util.ArrayList;

/* Partition includes cluster center and array of pixels which belong
 * to this cluster
 */

public class Partition {
	
	private double[] center;
	private ArrayList<Pixel> pixels = new ArrayList<Pixel>();
	
	public Partition (double[] center) {
		this.center = center;
	}
	
	public double[] getCenter() {
		return center;
	}
	
	public ArrayList<Pixel> getPixels() {
		return pixels;
	}
	
	public void addPixel (Pixel pixel) {
		pixels.add(pixel);
	}
	
	/* Calculate new center of a group
	 * 
	 */
	public void calculateCenter() {
		int size = pixels.get(0).getVector().length;
		for (Pixel pixel : pixels) {
			double[] temp = pixel.getVector();
			for (int i = 0; i < size; i++) {
				center[i] += temp[i];
			}
		}
		for (int i = 0; i < size; i++) {
			center[i] /= pixels.size(); 
		}
	}
	
	/* Clear the group
	 * 
	 */
	public void clear() {
		pixels.clear();
	}
}
