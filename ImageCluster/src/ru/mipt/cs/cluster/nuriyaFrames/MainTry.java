package ru.mipt.cs.cluster.nuriyaFrames;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ru.mipt.cs.cluster.kmeans.*;
import ru.mipt.cs.cluster.io.*;

public class MainTry {
	public static void main (String args[]) throws IOException {
		ClusterisationInput input = new ClusterisationInput();
		ClusterisationOutput output = new ClusterisationOutput();
		
		input.setAlgorithm(1);
		input.setConvergence(0.5);
		input.setInputImage("/Users/jangnur/Pictures/black_widow.jpg");
		input.setNumOfClusters(10);
		
		KMeans kmeans = new KMeans();
		
		output = kmeans.calculate(input);
		
		File file = new File("/Users/jangnur/Pictures/black_widow_1.jpg");
		ImageIO.write(output.getOutputImage(), "jpg", file);
		
	}
	
	/*public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				FirstFrame takeOne = new FirstFrame();
				takeOne.setSize(400, 200);
				takeOne.setVisible(true);
			}
		});
	}*/


}

