package ru.mipt.cs.cluster.input;

public class ClusterisationInput {
	private int numOfClusters;
	private int convergence;
	private String inputImage;
	private int algorithm;
	/* algorithm number 0 - kmeans 
	 * the others to be added later*/
	
	public void setNumOfClusters (int a) {
		numOfClusters = a;
	}
	
	public void setConvergence (int a) {
		convergence = a;
	}
	
	public void setInputImage (String s) {
		inputImage = s;
	}
	
	public void setAlgorithm (int a) {
		algorithm = a;
	}
	
	public int getNumOfClusters () {
		return numOfClusters;
	}
	
	public int getConvergence () {
		return convergence;
	}
	
	public String getInputImage () {
		return inputImage;
	}
	
	public int getAlgorithm () {
		return algorithm;
	}
}
