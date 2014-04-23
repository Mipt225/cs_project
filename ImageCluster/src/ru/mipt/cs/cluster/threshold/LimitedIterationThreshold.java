package ru.mipt.cs.cluster.threshold;

import ru.mipt.cs.cluster.kmeans.Cluster;

public class LimitedIterationThreshold implements Threshold {
	/* Total number of iterations */
	private final int iter;
	/* Number of current iteration */
	private int currentIter = 0;
	
	public LimitedIterationThreshold (int iter) {
		this.iter = iter;
	}
	
	public boolean jobDone (Cluster[] clusters) {
		currentIter++;
		return (currentIter >= iter);
	}
}
