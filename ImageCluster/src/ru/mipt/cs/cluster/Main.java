package ru.mipt.cs.cluster;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ru.mipt.cs.cluster.kmeans.*;
import ru.mipt.cs.cluster.io.*;

public class Main {
	public static void main (String args[]) throws IOException {
		ClusterisationInput input = new ClusterisationInput();
		ClusterisationOutput output = new ClusterisationOutput();
		
		input.setAlgorithm(1);
		input.setConvergence(0.5);
		input.setInputImage("/Users/jangnur/Pictures/white_prince_anndr.jpg");
		input.setNumOfClusters(10);
		
		KMeans kmeans = new KMeans();
		
		output = kmeans.calculate(input);
		
		File file = new File("/Users/jangnur/Pictures/dogs_1.jpg");
		ImageIO.write(output.getOutputImage(), "jpg", file);
		
	}
}
