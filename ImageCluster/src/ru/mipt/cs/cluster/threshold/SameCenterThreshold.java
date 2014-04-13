package ru.mipt.cs.cluster.threshold;
import ru.mipt.cs.cluster.clustering.Partition;

/* Stops after getting the same set of centers */

public class SameCenterThreshold implements Threshold {
	/* Remember the last partition */
	private Partition[] lastPartitions = null;
	/* Comparison error (= 1 - convergence) default = 0.05 */
	private double comparisonError = 0.05;
	
	public SameCenterThreshold (double comparisonError) {
		this.comparisonError = comparisonError;
	}
	
	public boolean jobDone(Partition[] partitions) {
		for (int i = 0; i < partitions.length; i++) {
			double[] lastCenter = lastPartitions[i].getCenter();
			double[] newCenter = partitions[i].getCenter();
			
			for (int j = 0; j < newCenter.length; j++) {
				if (Math.abs(lastCenter[j] - newCenter[j]) > comparisonError) {
					lastPartitions = partitions;
					return false;
				}
			}
		}
		
		lastPartitions = partitions;
		return true;
	}
}
