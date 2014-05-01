package ru.mipt.cs.cluster.threshold;

import java.util.ArrayList;

import ru.mipt.cs.cluster.kmeans.Cluster;
import ru.mipt.cs.cluster.kmeans.Pixel;

public class LimitedIterationThreshold implements Threshold {
	/* Total number of iterations */
	private final int iter;
	/* Number of current iteration */
	private int currentIter = 0;
	
	public LimitedIterationThreshold (int iter) {
		
		this.iter = iter;
	}
	
	
	public void split(Cluster splitCluster, Cluster emptyCluster) {
		
		ArrayList<Pixel> list = splitCluster.getPixels();
		for (int i = 0; i < splitCluster.getPixelCount() / 2; i++) {
			
			Pixel p = list.get(list.size());
			splitCluster.removePixel(p);
			emptyCluster.addPixel(p);
		}
	}
	
	public boolean jobDone (Cluster[] clusters) {
		
		for (int i = 0; i < clusters.length; i++) {
			
			if (clusters[i].getPixelCount() < 1000) {
				
				int notEmpty = 0;
				for (int j = 0; j < clusters.length; j++) {
					
					if (clusters[j].getPixelCount() > 1000)
						notEmpty = j;
				}
				split(clusters[i], clusters[notEmpty]);
			}
		}
		
		currentIter++;
		return (currentIter >= iter);
	}
}
