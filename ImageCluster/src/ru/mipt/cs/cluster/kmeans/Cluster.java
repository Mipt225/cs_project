package ru.mipt.cs.cluster.kmeans;


import java.util.ArrayList;
import ru.mipt.cs.cluster.distance.Distance;

public class Cluster {
	
	private int id; 
    private int pixelCount; 
    private Pixel central = new Pixel(0); 
    private int reds; 
    private int greens; 
    private int blues; 
    private ArrayList<Pixel> pixels = new ArrayList<Pixel>();
     
    public Cluster (int id, Pixel pixel) { 
        this.id = id; 
        addPixel(pixel); 
        calculateCentral();
    } 
     
    public void clear () { 
    	central.setRed(0);
    	central.setBlue(0);
    	central.setGreen(0);
    	reds = 0; 
        greens = 0; 
        blues = 0; 
        pixelCount = 0; 
    } 
     
    public int getId () { 
        return id; 
    } 
    
    public int getPixelCount () {
    	return pixelCount;
    }
    
    public Pixel getCentral () {
    	return central;
    }
    
    public int getRGB () { 
        int r = reds / pixelCount; 
        int g = greens / pixelCount; 
        int b = blues / pixelCount; 
        return 0xff000000 | r << 16 | g << 8 | b; 
    } 
    
    public ArrayList<Pixel> getPixels () {
    	return pixels;
    }
    
    public void addPixel (Pixel pixel) { 
    	
        reds += pixel.getRed(); 
        greens += pixel.getGreen(); 
        blues += pixel.getBlue(); 
        pixelCount++; 
        pixels.add(pixel);
    } 
     
    public void removePixel (Pixel pixel) { 
         
    	reds -= pixel.getRed(); 
        greens -= pixel.getGreen(); 
        blues -= pixel.getBlue(); 
        pixelCount++;
        pixels.remove(pixel);
    } 
    
    public void calculateCentral() {
    	
    	central.setRed (reds/pixelCount); 
        central.setGreen (greens/pixelCount);
        central.setBlue (blues/pixelCount);
    }
     
    int distance (Distance distance, Pixel pixel) { 
        
    	int d = (int) distance.calculate(central, pixel);
        return d; 
    } 

}
