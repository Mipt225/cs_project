package ru.mipt.cs.cluster.output;

import java.awt.Color;

public class ClusterisationOutput {
	private String outputImage;
	private int[] clusterDistribution;
	private Color[] clusterColor;
	/* For reference:
	 * The Color class is used to encapsulate colors in the default sRGB color space or 
	 * colors in arbitrary color spaces identified by a ColorSpace. Every color has an 
	 * implicit alpha value of 1.0 or an explicit one provided in the constructor. 
	 * The alpha value defines the transparency of a color and can be represented by 
	 * a float value in the range 0.0 - 1.0 or 0 - 255. An alpha value of 1.0 or 255 
	 * means that the color is completely opaque and an alpha value of 0 or 0.0 means 
	 * that the color is completely transparent. When constructing a Color with an explicit
	 * alpha or getting the color/alpha components of a Color, the color components 
	 * are never premultiplied by the alpha component.
	 */
	
	public void setOutputImage (String s) {
		outputImage = s;
	}
	
	public void setClusterDistribution (int[] a) {
		clusterDistribution = a;
	}
	
	public void setClusterColor (Color[] c) {
		clusterColor = c;
	}
	
	public String getOutputImage () {
		return outputImage;
	}
	
	public int[] getClusterDistribution () {
		return clusterDistribution;
	}
	
	public Color[] getClusterColor () {
		return clusterColor;
	}
}
