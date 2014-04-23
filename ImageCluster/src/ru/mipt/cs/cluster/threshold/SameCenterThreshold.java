package ru.mipt.cs.cluster.threshold;

import ru.mipt.cs.cluster.kmeans.Cluster;
import ru.mipt.cs.cluster.kmeans.Pixel;

/* Stops after getting the same set of centers */

public class SameCenterThreshold implements Threshold {
	/* Remember the last partition */
	private Cluster[] lastClusters = new Cluster[255];
	/* Comparison error (= 1 - convergence) default = 0.05 */
	private double comparisonError = 0.05;
	
	public SameCenterThreshold (double comparisonError) {
		this.comparisonError = comparisonError;
		for (int i = 0; i < lastClusters.length; i++) {
			lastClusters[i] = new Cluster(0, new Pixel(0));
		}
	}
	
	public boolean jobDone(Cluster[] clusters) {
		// job done checker
		for (int i = 0; i < clusters.length; i++) {

			Pixel lastCenter = lastClusters[i].getCentral();
			Pixel newCenter = clusters[i].getCentral();
			
			comparisonError *= clusters[i].getPixelCount();
			
			if (Math.abs(lastCenter.getRed() - newCenter.getRed()) > comparisonError) {
				lastClusters = clusters;
				return false;
			}
			
			if (Math.abs(lastCenter.getRed() - newCenter.getRed()) > comparisonError) {
				lastClusters = clusters;
				return false;
			}
			
			if (Math.abs(lastCenter.getRed() - newCenter.getRed()) > comparisonError) {
				lastClusters = clusters;
				return false;
			}
		}
		
		lastClusters = clusters;
		return true;
	}
}
