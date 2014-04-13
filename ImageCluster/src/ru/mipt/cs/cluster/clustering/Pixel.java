package ru.mipt.cs.cluster.clustering;

public class Pixel {
	private int red;
	private int green;
	private int blue;
	
	private double[] vector;
	
	public Pixel(int pixel) {
		red = ((pixel >> 16) & 0xff);
		green = ((pixel >> 8) & 0xff);
		blue = ((pixel) & 0xff);
		vector[0] = red;
		vector[1] = green;
		vector[2] = blue;
	}
	
	public int getRed () {
		return red;
	}
	
	public int getGreen () {
		return green;
	}
	
	public int getBlue () {
		return blue;
	}
	
	public double[] getVector () {
		return vector;
	}
}
