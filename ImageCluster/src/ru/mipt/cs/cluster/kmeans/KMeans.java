package ru.mipt.cs.cluster.kmeans;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import ru.mipt.cs.cluster.distance.Distance;
import ru.mipt.cs.cluster.distance.EuclidianDistance;
import ru.mipt.cs.cluster.distance.EuclidianSquareDistance;
import ru.mipt.cs.cluster.distance.ManhattanDistance;
import ru.mipt.cs.cluster.io.ClusterisationInput;
import ru.mipt.cs.cluster.io.ClusterisationOutput;
import ru.mipt.cs.cluster.threshold.LimitedIterationThreshold;
import ru.mipt.cs.cluster.threshold.SameCenterThreshold;
import ru.mipt.cs.cluster.threshold.Threshold;

public class KMeans {
	
    private Cluster[] clusters; 
    
	public Cluster[] createClusters (BufferedImage image, int k) { 
        
        Cluster[] result = new Cluster[k]; 
        int x = 0; 
        int y = 0; 
        int dx = image.getWidth() / k; 
        int dy = image.getHeight() / k; 
        for (int i = 0; i < k; i++) { 
        	Pixel pixel = new Pixel(image.getRGB(x, y));
            result[i] = new Cluster(i, pixel); 
      
            x += dx; 
            y += dy; 
        } 
        
        return result; 
    }
	
	public Cluster findMinimalCluster(Distance distance, Pixel pixel) { 
        Cluster cluster = null; 
        int min = Integer.MAX_VALUE; 
        for (int i = 0; i < clusters.length; i++) { 
            int dist = clusters[i].distance(distance, pixel); 
            if (dist < min) { 
                min = dist; 
                cluster = clusters[i]; 
            } 
        } 
        return cluster; 
    } 
	
	public ClusterisationOutput calculate (ClusterisationInput input) throws IOException {
		
		BufferedImage image = null;
		image = ImageIO.read(new File(input.getInputImage()));
		
		double convergence = input.getConvergence();
		int iterations = 0;
		
		Distance distanceAlgorithm = null;
		if (input.getAlgorithm() == 0) {
			distanceAlgorithm = new EuclidianDistance();
		}
		else if (input.getAlgorithm() == 1) {
			distanceAlgorithm = new EuclidianSquareDistance();
		}
		else if (input.getAlgorithm() == 2) {
			distanceAlgorithm = new ManhattanDistance();
		}
		
		int width = image.getWidth();
		int height = image.getHeight();
 
		// create clusters 
		clusters = createClusters (image, input.getNumOfClusters()); 
		// create clusters table 
		int[] tableOfPixels = new int[width * height]; 
		Arrays.fill(tableOfPixels, -1); 
		
		Threshold threshold = null;
		if (convergence >= 1) {
			iterations = (int) convergence;
			threshold = new LimitedIterationThreshold(iterations);
		}
		else if (convergence < 1) {
			threshold = new SameCenterThreshold(1 - convergence);
		}
		
		while (!threshold.jobDone(clusters)) {
			
			for (int y = 0; y < height; y++) {
				
				for (int x = 0; x < width; x++){
					
					Pixel pix = new Pixel(image.getRGB(x, y));
					Cluster cluster = findMinimalCluster(distanceAlgorithm, pix);
					
					if (tableOfPixels[width * y + x] != cluster.getId()) {
						
						if (tableOfPixels[width * y + x] != -1) { 
							 // remove from possible previous  
							 // cluster 
							 clusters[tableOfPixels[width * y + x]].removePixel(pix); 
							 clusters[tableOfPixels[width * y + x]].calculateCentral();
						} 
						// add pixel to cluster 
						cluster.addPixel(pix);
						cluster.calculateCentral();
					} 
					//update table
					tableOfPixels[width*y+x] = cluster.getId(); 
				}
			}
			
		}
		
		BufferedImage result = new BufferedImage (width, height, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int clusterId = tableOfPixels[width * y + x];
				result.setRGB(x, y, clusters[clusterId].getRGB());
			}
		}
		
		ClusterisationOutput output = new ClusterisationOutput();
		
		int clustersSize[] = new int[input.getNumOfClusters()];
		for (int i = 0; i < input.getNumOfClusters(); i++) {
			clustersSize[i] = clusters[i].getPixelCount();
		}

		Color[] clustersColor = new Color[input.getNumOfClusters()];
		for (int i = 0; i < input.getNumOfClusters(); i++) {
			clustersColor[i] = new Color(clusters[i].getRGB());
		}
		
		output.setClusterColor(clustersColor);
		output.setClusterDistribution(clustersSize);
		output.setOutputImage(result);
		
		return output;
	}

}