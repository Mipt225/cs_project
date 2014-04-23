package ru.mipt.cs.cluster.kmeans;


public class Pixel {
	private int red;
	private int green;
	private int blue;
	
	public Pixel(int pixel) {
		red = (pixel >> 16 & 0x000000ff);
		green = (pixel >> 8 & 0x000000ff);
		blue = (pixel & 0x000000ff);
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
	
	public void setRed (int red) {
		this.red = red;
	}
	
	public void setGreen (int green) {
		this.green = green;
	}
	
	public void setBlue (int blue) {
		this.blue = blue;
	}
	
	public boolean equals (Object obj) {
		
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pixel other = (Pixel) obj;
        if (red != other.red)
            return false;
        if (green != other.green)
            return false;
 
        return true;
	}
	
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        result = prime * result + red;
        result += prime * result + green;
        result += prime * result + blue;
        return result;
	}
}
